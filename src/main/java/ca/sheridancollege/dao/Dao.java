package ca.sheridancollege.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.math3.util.Precision;
import org.fluttercode.datafactory.impl.DataFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Vote;
import ca.sheridancollege.beans.Voter;

public class Dao {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	// Method to generate random dummy records
	
	public Boolean validateSinLength(int sin) {

		String num = Integer.toString(sin);

		if (num.length() == 9) {
			return true;
		} else {
			return false;
		}

	}

	// Verifies if a SIN already exists or not
	public boolean verifySin(int sin) {

		boolean flag = false;
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Voter.bySin");
		query.setParameter("sin", sin);

		// Getting list of voters with the "sin" passed as a parameter
		List<Voter> voterList = query.getResultList();

		session.getTransaction().commit();
		session.close();

		// If empty list then return true
		if (voterList.isEmpty()) {
			flag = true;
		}

		// Else if the list is populated then return false meaning there is already a
		// value with the passed sin number and hence it is a duplicate
		else {
			flag = false;
		}
		return flag;
	}

	// Returns list of Voters
	public List<Voter> getVoterList() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Voter> voterList = (List<Voter>) session.createQuery("from Voter").getResultList();

		session.getTransaction().commit();
		session.close();

		return voterList;
	}

	public List<Voter> getVoterBySin(int sin) {

		boolean flag = false;
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Voter.bySin");
		query.setParameter("sin", sin);

		// Getting list of voters with the "sin" passed as a parameter
		List<Voter> voterList = query.getResultList();

		session.getTransaction().commit();
		session.close();

		// If empty list then return true
		if (voterList.isEmpty()) {
			flag = true;
		}

		// Else if the list is populated then return false meaning there is already a
		// value with the passed sin number and hence it is a duplicate
		else {
			flag = false;
		}
		return voterList;
	}
	
	// Update the Voter when he voted 
	public void updateVoter(int sin, String party) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// while anything is open whatever you do here will link directly to the
		// database
		// persistent object
		Voter voter = session.get(Voter.class, sin);
		voter.getVote().setVotes(party);
//		Vote vote = session.get(Vote.class,sin);
//		vote.setVotes(party);
		voter.setVoted("Yes");

		session.getTransaction().commit();
		session.close();

	}

	// getting data based on the student id and the name or any other property
	public String voteDemocratPercent() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVote = (int) session.createQuery("from Vote").getResultList().size();
		Query query = session.createQuery("from Vote where votes=:party");
//		System.out.println(query);
		query.setParameter("party", "New Democratic Party");

		List<Vote> voteList = (List<Vote>) query.getResultList();
		int partySize = voteList.size();

		Double percent = (((double) partySize / (double) totalVote)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String voteLiberalPercent() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVote = (int) session.createQuery("from Vote").getResultList().size();
		Query query = session.createQuery("from Vote where votes=:party");
//		System.out.println(query);
		query.setParameter("party", "Liberal Party");

		List<Vote> voteList = (List<Vote>) query.getResultList();
		int partySize = voteList.size();
		
		Double percent = (((double) partySize / (double) totalVote)) * 100;
		
		
		System.out.println(Precision.round(percent, 1));
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String voteConservativePercent() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVote = (int) session.createQuery("from Vote").getResultList().size();
		Query query = session.createQuery("from Vote where votes=:party");
//		System.out.println(query);
		query.setParameter("party", "Conservative Party");

		List<Vote> voteList = (List<Vote>) query.getResultList();
		int partySize = voteList.size();

		Double percent = (((double) partySize / (double) totalVote)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String voteBlocPercent() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVote = (int) session.createQuery("from Vote").getResultList().size();
		Query query = session.createQuery("from Vote where votes=:party");
//		System.out.println(query);
		query.setParameter("party", "Bloc Quebecois");

		List<Vote> voteList = (List<Vote>) query.getResultList();
		int partySize = voteList.size();

		Double percent = (((double) partySize / (double) totalVote)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String voteGreenPercent() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVote = (int) session.createQuery("from Vote").getResultList().size();
		Query query = session.createQuery("from Vote where votes=:party");
//		System.out.println(query);
		query.setParameter("party", "Green Party");

		List<Vote> voteList = (List<Vote>) query.getResultList();
		int partySize = voteList.size();

		Double percent = (((double) partySize / (double) totalVote)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String eligibleVotersThatDidVote() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVoter = (int) session.createQuery("from Voter").getResultList().size();

		Query query = session.createQuery("from Voter where voted=:option");
		query.setParameter("option", "Yes");

		List<Voter> voteList = (List<Voter>) query.getResultList();
		int votedVoter = voteList.size();

		Double percent = (((double) votedVoter / (double) totalVoter)) * 100;

		// Final result with just 1 decimal place
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String age19() {

		DataFactory df = new DataFactory();

		Date maxDate = df.getDate(1989, 1, 1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVoter = (int) session.createQuery("from Voter").getResultList().size();

		Query query = session.createQuery("from Voter where birthDate >=:option2");

		query.setParameter("option2", maxDate);

		List<Voter> voteList = (List<Voter>) query.getResultList();
		int votedVoter = voteList.size();
		System.out.println(votedVoter);
		Double percent = (((double) votedVoter / (double) totalVoter)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String age45() {

		DataFactory df = new DataFactory();

		// The range for the birthDate between 18-100

		Date maxDate = df.getDate(1989, 1, 1);
		Date minDate = df.getDate(1974, 1, 1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVoter = (int) session.createQuery("from Voter").getResultList().size();

		Query query = session.createQuery("FROM Voter WHERE birthDate BETWEEN :option1 AND :option2 ");
		query.setParameter("option1", minDate);
		query.setParameter("option2", maxDate);

		List<Voter> voteList = (List<Voter>) query.getResultList();
		int votedVoter = voteList.size();
		System.out.println(votedVoter);
		Double percent = (((double) votedVoter / (double) totalVoter)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String age59() {

		DataFactory df = new DataFactory();

		// The range for the birthDate between 18-100

		Date maxDate = df.getDate(1974, 1, 1);
		Date minDate = df.getDate(1959, 1, 1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVoter = (int) session.createQuery("from Voter").getResultList().size();

		Query query = session.createQuery("FROM Voter WHERE birthDate BETWEEN :option1 AND :option2 ");
		query.setParameter("option1", minDate);
		query.setParameter("option2", maxDate);

		List<Voter> voteList = (List<Voter>) query.getResultList();
		int votedVoter = voteList.size();
		System.out.println(votedVoter);
		Double percent = (((double) votedVoter / (double) totalVoter)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public String age60() {

		DataFactory df = new DataFactory();

		// The range for the birthDate between 18-100

		Date maxDate = df.getDate(1959, 1, 1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int totalVoter = (int) session.createQuery("from Voter").getResultList().size();

		Query query = session.createQuery("from Voter where birthDate <:option2");

		query.setParameter("option2", maxDate);

		List<Voter> voteList = (List<Voter>) query.getResultList();
		int votedVoter = voteList.size();
		System.out.println(votedVoter);
		Double percent = (((double) votedVoter / (double) totalVoter)) * 100;
		String returnPercent = String.format("%.1f", percent);

		// ending of the method
		session.getTransaction().commit();
		session.close();

		return returnPercent;
	}

	public boolean ageVerification(Date date) {

		boolean flag = false;

		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; // zero based;
		int day = now.get(Calendar.DAY_OF_MONTH);

		int compareYear = year - 18;

//		System.out.println(year);
//		System.out.println(month);
//		System.out.println(day);
//		System.out.println(now.getTime());

		now.set(compareYear, month, day);
//		System.out.println(now.getTime());
		Date toCompare = now.getTime();

		System.out.println(toCompare);
		System.out.println(date);

		if (date.compareTo(toCompare) < 0) {
			flag = true;
		} else if (date.compareTo(toCompare) > 0) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
//		

	}

	public void addVoter(Voter voter) {

		// beginning of the method
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Vote vote = new Vote();

		// Set the vote to the Voter (could be null or the party)
		voter.setVote(vote);
		// Set the voter to the vote
		vote.setVoter(voter);

		vote.getVoter().setVoted("No");

		// what goes here is the CRUD operations
		session.save(voter);
		session.save(vote);

		// ending of the method
		session.getTransaction().commit();
		session.close();

	}

	public void addVote(Vote vote) {

		// beginning of the method
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// what goes here is the CRUD operations
		session.save(vote);

		// ending of the method
		session.getTransaction().commit();
		session.close();

	}

	public void deleteVoter(int index) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Voter movie = (Voter) session.get(Voter.class, index);
		session.delete(movie);

		session.getTransaction().commit();
		session.close();
	}

	// Method that returns ONE voter with the id passed in the parameter
	public Voter queryByID(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Voter where id=:id");
		query.setParameter("id", id);
		List<Voter> voterList = (List<Voter>) query.getResultList();

		session.getTransaction().commit();
		session.close();

		Voter voter = new Voter();
		if (!voterList.isEmpty()) {
			voter = voterList.get(0);
		}
		return voter;
	}

}
