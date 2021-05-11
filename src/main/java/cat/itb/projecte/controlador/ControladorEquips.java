package cat.itb.projecte.controlador;


import cat.itb.projecte.servei.EquipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorEquips {

    @Autowired
    private EquipsService servei;

    @GetMapping("/equips/listPerName")
    public String llistarPerNom(Model m){
        m.addAttribute("llistaEquips",servei.llistatOrdenatPerNom());
        return "llistat";
    }

    @GetMapping("/equips/list")
    public String llistar(Model m){
        m.addAttribute("llistaEquips",servei.llistat());
        return "llistat";
    }

    @GetMapping("/equips/new")
    public String afegirEmpleat(Model m){
        m.addAttribute("equipsForm",new Equips ());
        return "afegir";
    }

    @GetMapping("/equips/edit")
    public String afegirEmpleat(@RequestParam(value = "id",required = false) int id,@RequestParam(value = "nom",required = false) String nom,@RequestParam(value = "resultat",required = false) String resultat,@RequestParam(value = "regio",required = false) String regio,Model m){
        Equips nou = new Equips();
        nou.setId(id);
        nou.setNom(nom);
        nou.setResultat (resultat);
        nou.setRegio (regio);
        m.addAttribute("equipsForm",nou);
        m.addAttribute("id", id);
        m.addAttribute("nom",nom);
        m.addAttribute("resultat",resultat);
        m.addAttribute("regio",regio);
        return "afegir";
    }

    @PostMapping("/equips/new/submit")
    public String afegirSubmit(@ModelAttribute("equipsForm") Equips eqp){
      servei.afegir(eqp);
      return "redirect:/equips/list";
    }

    @PostMapping("/equips/edit/submit")
    public String editSubmit(@ModelAttribute("equipsForm") Equips eqp){
        servei.substituir(eqp);
        return "redirect:/equips/list";
    }

    @GetMapping("/equips/eliminar")
    public String eliminarEquip(@RequestParam(value = "id",required = false) int id,Model m){
        servei.eliminarPerId(id);
        return "redirect:/equips/list";
    }
}
