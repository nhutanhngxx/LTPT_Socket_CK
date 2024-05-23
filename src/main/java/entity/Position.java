package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Entity
@Table(name = "positions")

@NamedQueries({
		@NamedQuery(name = "Position.listPositions", query = "SELECT p FROM Position p WHERE p.name LIKE :name AND p.salary >= :salaryFrom AND p.salary <= :salaryTo"),
})

@NamedNativeQueries({
//    @NamedNativeQuery(name = "Position.listYearsOfExperienceByPosition",
//    query = "SELECT candidates.candidate_id, positions.position_id, positions.name AS position_name,"
//    		+ "DATEDIFF(YEAR, experiences.from_date, experiences.to_date) AS years_of_experience"
//    		+ "FROM candidates"
//    		+ "JOIN experiences ON candidates.candidate_id = experiences.candidate_id"
//    		+ "JOIN positions ON experiences.position_id = positions.position_id"
//    		+ "WHERE candidates.candidate_id = ?"),
})

public class Position implements Serializable {

	private static final long serialVersionUID = -6179878584621305053L;

	@OneToMany(mappedBy = "positions")
	private List<Candidate> candidates;

	@OneToMany(mappedBy = "positions")
	private List<Experience> experiences;

	@Id
	@Column(name = "position_id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "salary")
	private double salary;

	@Column(name = "number")
	private int number;

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Position(List<Candidate> candidates, List<Experience> experiences, String id, String name, String description, double salary, int number) {
		super();
		this.candidates = candidates;
		this.experiences = experiences;
		this.id = id;
		this.name = name;
		this.description = description;
		this.salary = salary;
		this.number = number;
	}

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name
				+ ", description=" + description + ", salary=" + salary + ", number=" + number + "]";
	}
	
	

}
