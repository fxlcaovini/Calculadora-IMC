package com.uninter.trabalho.controlador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.uninter.trabalho.entidade.EntidadeIMC;
import com.uninter.trabalho.repositorio.RepositorioIMC;

@Controller
public class ControllerIMC {

    @Autowired
    private RepositorioIMC repositorioimc;

    @GetMapping("/")
    public String index(Model model) {
        List<EntidadeIMC> imcDataList = repositorioimc.findAll();
        
        for (EntidadeIMC pessoa : imcDataList) {
            double imc = pessoa.getPeso() / (pessoa.getAltura() * pessoa.getAltura());
            double imcArredondado = Math.round(imc * 100.0) / 100.0; 
            pessoa.setImc(imcArredondado);
        }
        
        model.addAttribute("imcDataList", imcDataList);
        return "index";
    }

    @PostMapping("/calcular-imc")
    public String calcularIMC(EntidadeIMC pessoa) {
        double imc = pessoa.getPeso() / (pessoa.getAltura() * pessoa.getAltura());
        double imcArredondado = Math.round(imc * 100.0) / 100.0; 
        pessoa.setImc(imcArredondado);
        repositorioimc.save(pessoa);
        return "redirect:/";
    
    }
}
