package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

//@SuppressWarnings({ "serial", "serial" })
@Entity
@Table(name = "candidates")

@NamedQueries({
	@NamedQuery(name = "Candidate.listCandidatesByCompanies", query = "SELECT e.candidates, COUNT(DISTINCT e.companyName) FROM Experience e GROUP BY e.candidates"),
//	@NamedQuery(name = "Candidate.listCandidatesWithLongestWorking",
//	query = ""),
})

@NamedNativeQueries({
    @NamedNativeQuery(name = "Candidate.listCandidatesWithLongestWorking",
    query = ""),
})

public class Candidate implements Serializable {

	private static final long serialVersionUID = -6179878584621305053L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	private Position positions;

	@OneToMany(mappedBy = "candidates")
	private List<Experience> experiences;

	@OneToMany(mappedBy = "candidates")
	private List<Certificate> certificates;

	@Id
	@Column(name = "candidate_id")
	private String id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "year_of_birth")
	private int yearOfBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "description")
	private String description;

	public Position getPositions() {
		return positions;
	}

	public void setPositions(Position positions) {
		this.positions = positions;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Candidate(Position positions, List<Experience> experiences, List<Certificate> certificates, String id,
			String fullName, int yearOfBirth, String gender, String email, String phone, String description) {
		super();
		this.positions = positions;
		this.experiences = experiences;
		this.certificates = certificates;
		this.id = id;
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.description = description;
	}

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String id, String fullName) {
		this.id = id;
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return "Candidate [positions=" + positions + ", id=" + id + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", description=" + description + "]";
	}
	
	

}
