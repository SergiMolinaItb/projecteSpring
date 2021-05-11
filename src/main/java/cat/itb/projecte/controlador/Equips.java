package cat.itb.projecte.controlador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equips {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String resultat;
    private String regio;
}
