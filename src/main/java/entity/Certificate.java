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
@Table(name = "certificates")

public class Certificate {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidates;

	@Id
	@Column(name = "certificate_id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "organization")
	private String organization;

	@Column(name = "issue_date")
	private LocalDate issueDate;

}
