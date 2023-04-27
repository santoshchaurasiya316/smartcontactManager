package com.API.Login.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
@Table(name = "userlogin")
public class UserLogin {
		
//	Note – Default Fetch type in case of below annotations.
//
//	@OneToOne – Default fetch type is EAGER.
//	@OneToMany – Default fetch type is LAZY.
//	@ManyToOne – Default fetch type is EAGER.
//	@ManyToMany – Default fetch type is LAZY.

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String email;
	private String password;

//	If you have @OneToOne mapping in your class then update the fetch type to LAZY. 
//	Because by default fetch type for OneToOne is EAGER so when we fetch object of main class (WebTree) class
//    it will fetch the object for OneToOne mapped class so when hibernate map the object 
//    it will throw the exception.
//    In Short if you have OneToOne Mapping then replace it with @OneToOne(fetch = FetchType.LAZY)
	
	@JsonManagedReference                                
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "login",fetch = FetchType.LAZY)// we can also use PERSIST to only save data 
	private MobileNo mobileNo;   //automatically and non of the operation'll be performed like-delete 
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userlogin")
	private List<Address> addresses;
}
