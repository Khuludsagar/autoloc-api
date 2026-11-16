package tn.esprit.autoloc.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;
    LocalDate dateSignature;
    BigDecimal montantTotal;
    boolean valide;

    // Un contrat est lié à une seule réservation
    @OneToOne
    @JoinColumn(name = "reservation_id", unique = true)
    Reservation reservation;

    // Un contrat peut être réglé par plusieurs paiements
    @OneToMany(mappedBy = "contrat")
    @JsonIgnore
    List<Paiement> paiements;
}
