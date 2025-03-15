package com.github.lucasdevrj.cadastrodeshinobi.shinobi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("shinobis/ui")
public class ShinobiControllerUi {

    private final ShinobiService shinobiService;

    public ShinobiControllerUi(ShinobiService shinobiService) {
        this.shinobiService = shinobiService;
    }

    @GetMapping("/listar")
    public String listarShinobis(Model model) { //biblioteca com interfaces gráficas
        List<ShinobiDTO> shinobis = shinobiService.listarShinobis();
        model.addAttribute("shinobis", shinobis);
        return "listar-shinobis.html";
    }
}
