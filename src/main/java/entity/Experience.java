package entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "experiences")

public class Experience {

	@Id
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidates;

	@Id
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position positions;

	@Id
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "from_date")
	private LocalDate fromDate;

	@Column(name = "to_date")
	private LocalDate toDate;

	@Column(name = "description")
	private String description;

}
