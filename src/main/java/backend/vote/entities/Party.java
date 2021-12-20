package backend.vote.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "parties", schema = "vote")
public class Party {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String slogan;

  @Column(unique = true)
  private String abbreviation;

  @JsonIgnore
  @ManyToMany
  private List<Municipality> municipalities = new ArrayList<>();

  public Party(String name, String abbreviation, String slogan) {
    this.name = name;
    this.abbreviation = abbreviation;
    this.slogan = slogan;
  }
}
