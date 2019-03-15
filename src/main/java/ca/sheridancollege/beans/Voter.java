package ca.sheridancollege.beans;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Voter.bySin", query = "from Voter where sin = :sin")
public class Voter implements Serializable {
	
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String address;
	private String voted;
	
	@Id
	private int sin;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Vote vote;
	
	public Voter(String firstName, String lastName, Date birthDate, String address, int sin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.sin = sin;
	}
	
	

}
