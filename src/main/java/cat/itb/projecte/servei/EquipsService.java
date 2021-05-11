package cat.itb.projecte.servei;

import cat.itb.projecte.controlador.Equips;
import cat.itb.projecte.repository.EquipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EquipsService {

    @Autowired
    private EquipRepository repositori;

    public void afegir(Equips e) {
        repositori.save(e);
    }
    public Iterable<Equips> llistat() {
        return repositori.findAll();
    }
    public List<Equips> llistatOrdenatPerNom(){
        List<Equips> equips = repositori.findAll();
        Collections.sort(equips, (e1, e2) -> e1.getNom().compareTo(e2.getNom()));
        return equips;
    }
    public Equips consultaPerId(int id){
        return repositori.findById(id).orElse(null);
    }
    public void eliminarPerId(int id){
        repositori.deleteById(id);
    }
    public void substituir(Equips e){
        repositori.save(e);
    }

    @PostConstruct
    public void init() {
        repositori.saveAll (
                Arrays.asList(
                        new Equips (1, "MAD Lions", "5-1", "LEC" ),
                        new Equips (2, "DamWon KIA", "5-1", "LCK"),
                        new Equips (3, "Royal Never Give Up", "8-0", "LPL")
                )
        );
    }
}
