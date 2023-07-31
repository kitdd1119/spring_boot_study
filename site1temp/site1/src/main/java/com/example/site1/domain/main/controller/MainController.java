package com.example.site1.domain.main.controller;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.domain.main.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    
    @GetMapping("/")
    public String getMainPage(Model model) {

        ResMainDTO dto = mainService.getMainData();
        model.addAttribute("dto", dto);

        return "main";
    }
}
