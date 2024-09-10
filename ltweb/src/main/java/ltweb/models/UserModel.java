package ltweb.models;

import java.io.Serializable;

public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String fullname;
	private String phone;
	private String image;
	private String password;
	private String email;

	public UserModel(int id, String fullname, String phone, String image, String password, String email) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phone = phone;
		this.image = image;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", fullname=" + fullname + ", phone=" + phone + ", image="
				+ image + ", password=" + password + ", getId()=" + getId() + ", getEmail()=" + getEmail()
				+ ", getFullname()=" + getFullname() + ", getPhone()=" + getPhone() + ", getImage()=" + getImage()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
