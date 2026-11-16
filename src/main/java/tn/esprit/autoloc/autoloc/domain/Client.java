package tn.esprit.autoloc.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;
    String nom;
    String prenom;
    String email;
    String telephone;
    String numPermis;
    LocalDate dateInscription;

    // Un client effectue plusieurs réservations
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    List<Reservation> reservations;
}
