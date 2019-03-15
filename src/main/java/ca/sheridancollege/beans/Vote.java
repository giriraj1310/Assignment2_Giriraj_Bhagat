package ca.sheridancollege.beans;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String votes;
	
	@Transient
	String[] parties = { "Liberal Party", "Conservative Party", "New Democratic Party", "Bloc Quebecois",
	"Green Party" };
	
	public Vote(String votes) {
		this.votes = votes;
	}

	@OneToOne (cascade = {CascadeType.ALL})
	private Voter voter;

}
