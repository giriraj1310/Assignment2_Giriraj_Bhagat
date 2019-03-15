package ca.sheridancollege;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Vote;
import ca.sheridancollege.beans.Voter;
import ca.sheridancollege.dao.Dao;

@Controller
public class HomeController {

	Dao dao = new Dao();

	@RequestMapping("/")
	public String goHome(Model model) {

		return "index";
	}

	@RequestMapping("/addVoterPage")
	public String addVoterPage(Model model) {

		model.addAttribute("voter", new Voter());
		return "AddVoter";
	}

	@RequestMapping("/generateDummy")
	public String generateRandom(Model model) {

		dao.generateRandomVotersAndVotes();
		return "index";
	}

	@RequestMapping("/showStats")
	public String showStats(Model model) {

		// Age variation in voters
		model.addAttribute("age18", dao.age19());
		model.addAttribute("age45", dao.age45());
		model.addAttribute("age59", dao.age59());
		model.addAttribute("age60", dao.age60());

		// Eligible voters that did vote
		model.addAttribute("eligibleVotersThatDidVote", dao.eligibleVotersThatDidVote());

		// Percentage for each party
		model.addAttribute("liberal", dao.voteLiberalPercent());
		model.addAttribute("conservative", dao.voteConservativePercent());
		model.addAttribute("democratic", dao.voteDemocratPercent());
		model.addAttribute("bloc", dao.voteBlocPercent());
		model.addAttribute("green", dao.voteGreenPercent());

		return "ShowStats";
	}

	@RequestMapping(value = "addVoter", method = RequestMethod.POST)
	public String saveVoter(Model model, @ModelAttribute Voter voter, @RequestParam Date birthDate) {
		// This way it does not cause thread interference
		try {
			Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(birthDate.toString());
			voter.setBirthDate(date1);
			synchronized (Voter.class) {
				dao.addVoter(voter);
			}

			Voter v = new Voter();
			model.addAttribute("voter", v);
		} catch (Exception e) {
			model.addAttribute("message", e);
		}

		return "AddVoter";
	}

	@RequestMapping("/viewVoterList")
	public String viewContact(Model model) {

		model.addAttribute("voterList", dao.getVoterList());
		return "viewVoters";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateById(Model model, @PathVariable int id) {

		Voter voter = dao.queryByID(id);
		if (voter.getSin() != 0) {
			dao.deleteVoter(id);
		}
		model.addAttribute("voter", voter);

		return "AddVoter";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable int id) {

		dao.deleteVoter(id);

		model.addAttribute("voterList", dao.getVoterList());
		return "viewVoters";
	}

	@RequestMapping(value = "voteParty", method = RequestMethod.POST)
	public String voteParty(Model model, @RequestParam int sin, @RequestParam String party) {

		dao.updateVoter(sin, party);

		model.addAttribute("voterList", dao.getVoterList());
		return "viewVoters";
	}

	@RequestMapping("/vote")
	public String vote(Model model) {

		model.addAttribute("voter", new Voter());
		return "verifyCanVoter";
	}

	@RequestMapping("/verifySin")
	public String enterSin(Model model, @RequestParam int sin, @ModelAttribute Voter voter) {
		
		model.addAttribute("sin", sin);
		model.addAttribute("voter", dao.queryByID(sin));
		model.addAttribute("vote", dao.queryByID(sin).getVote());
		model.addAttribute("parties", dao.queryByID(sin).getVote().getParties());
		
		return "voting";
	}

	@RequestMapping(value = "selectParty", method = RequestMethod.POST)
	public String verifyCanVote(Model model, @RequestParam int sin) {

		model.addAttribute("sin", sin);
		model.addAttribute("voterList", dao.getVoterBySin(sin));
		return "viewVoters";
	}
	
	@RequestMapping("/updateVoted")
	public String updateVoted(Model model, @RequestParam int sin, @RequestParam String votes) {
		
		dao.updateVoter(sin, votes);
		model.addAttribute("voterList", dao.getVoterList());
		
		return "viewVoters";
	}
	
	

}
