package com.cts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cts.model.CheckupRequest;;


@Entity
@Table(name="doctor_tab")
public class Doctor {
	
	@Id
	@Column(name="ID",length=10)
	String id;
	
	@Column(name="First_Name",length=50)
	String fname;
	
	@Column(name="Last_name",length=50)
	String lname;
	
	@Column(name="Age")
	int age;
	
	@Column(name="Gender",length=10)
	String gender;
	
	@Column(name="DOB",length=10)
	String dob;
	
	@Column(name="Contact_No",length=10)
	String contactno;
	
	@Column(name="Alternate_Contact_No",length=10)
	long altcontactno;
	
	@Column(name="Email",length=50)
	String email;
		
	@Column(name="Password",length=15)
	String password;
	
	@Column(name="Address_Line_1",length=100)
	String address1;
	
	@Column(name="Address_Line_2",length=100)
	String address2;
	
	@Column(name="City",length=50)
	String city;
	
	@Column(name="State",length=50)
	String state;
	
	@Column(name="Zipcode",length=10)
	String zipcode;
	
	@Column(name="Degree",length=50)
	String degree;
	
	@Column(name="Speciality",length=50)
	String speciality;
	
	@Column(name="Work_Hours")
	int workhours;
	
	@Column(name="Hospital_Name",length=100)
	String hospital_name;
	
	@Column(name="Service_ID")
	long service_id;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="did",fetch=FetchType.EAGER)
	private List<CheckupRequest> requests = new ArrayList<>();
	
	public Doctor() {
		super();
	}


	public Doctor(String id, String fname, String lname, int age, String gender, String dob, String contactno,
			long altcontactno, String email, String password, String address1, String address2, String city,
			String state, String zipcode, String degree, String speciality, int workhours, String hospital_name,
			long service_id, List<CheckupRequest> requests) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.contactno = contactno;
		this.altcontactno = altcontactno;
		this.email = email;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.degree = degree;
		this.speciality = speciality;
		this.workhours = workhours;
		this.hospital_name = hospital_name;
		this.service_id = service_id;
		this.requests = requests;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public List<CheckupRequest> getRequests() {
		return requests;
	}


	public void setRequests(List<CheckupRequest> requests) {
		this.requests = requests;
	}


	public String getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	public String getContactno() {
		return contactno;
	}

	public long getAltcontactno() {
		return altcontactno;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getDegree() {
		return degree;
	}

	public String getSpeciality() {
		return speciality;
	}

	public int getWorkhours() {
		return workhours;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public long getService_id() {
		return service_id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public void setAltcontactno(long altcontactno) {
		this.altcontactno = altcontactno;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public void setWorkhours(int workhours) {
		this.workhours = workhours;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public void setService_id(long service_id) {
		this.service_id = service_id;
	}	
	
}
