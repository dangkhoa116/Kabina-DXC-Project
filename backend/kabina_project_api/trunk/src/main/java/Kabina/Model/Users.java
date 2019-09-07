package Kabina.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(generator = "userId", strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;

	@NotBlank
	@Column(name = "userShortName")
	private String userShortName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	public Users() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserShortName() {
		return userShortName;
	}

	public void setUserShortName(String userShortName) {
		this.userShortName = userShortName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Users(String userName, String userShortName) {
		this.userName = userName;
		this.userShortName = userShortName;
	}

}
