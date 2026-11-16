package tn.esprit.autoloc.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipement;
    String libelle;

    // Un équipement peut équiper plusieurs véhicules
    @ManyToMany(mappedBy = "equipements")
    @JsonIgnore
    Set<Vehicule> vehicules;
}
