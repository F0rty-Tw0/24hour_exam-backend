package backend.vote.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
  uniqueConstraints = {
    @UniqueConstraint(
      name = "UniqueCandidateIdAndDate",
      columnNames = { "candidate_id", "date" }
    ),
  },
  name = "elections",
  schema = "vote"
)
public class Election {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @OneToOne
  private Candidate candidate;

  private int votes;

  private LocalDate date;

  public Election(Candidate candidate, LocalDate date) {
    this.candidate = candidate;
    this.date = date;
  }
}
