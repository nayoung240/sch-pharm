package com.example.schpharm.direction.controller;

import com.example.schpharm.direction.dto.InputDto;
import com.example.schpharm.pharmacy.service.PharmacyRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class FormController {
    private PharmacyRecommendationService pharmacyRecommendationService;

    @GetMapping("/")
    public String main() {
        return "main"; // main.hbs 화면으로 이동
    }

    // ModelAndView : 응답할 view와 값을 저장하여 전달.
    // @ModelAttribute : 사용자가 요청 시 전달하는 값을 오브젝트 형태로 매핑해주는 어노테이션
    @PostMapping("/search")
    public ModelAndView postDirection(@ModelAttribute InputDto inputDto)  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("output"); // output.hbs 화면으로 이동
        modelAndView.addObject("outputFormList",
                pharmacyRecommendationService.recommendPharmacyList(inputDto.getAddress()));

        return modelAndView;
    }
}
