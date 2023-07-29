package com.example.hr1.domain.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.hr1.domain.emp.dto.EmpDetailDTO;
import com.example.hr1.domain.emp.dto.EmpTableDTO;
import com.example.hr1.domain.emp.service.EmpService;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp")
    // RequestParam - 쿼리스트링을 자바 변수로 받을 수 있다.
    // 꼭 필요한 값이 아니면 required를 false로 설정
    // 값을 받지 않으면 기본적으로 null을 받게 된다.
    // 값을 받지 않았을 때 값을 지정하고 싶으면 defaultValue를 "쏼라" 알아서 설정
    // name="firstName" 이렇게 넣어줘야 하지만 생략 가능함.
    public ModelAndView getEmpTablePage(@RequestParam(name="firstName", required = false, defaultValue = "asdf") String firstName){
        // firstName이 null이면 전체리스트 / 값이 있으면 조건 검색 리스트
        System.out.println(firstName);

        ModelAndView modelAndView = new ModelAndView();
        List<EmpTableDTO> empTableDTOList = empService.getSearchEmpTableData(firstName);
        modelAndView.addObject("empTableDTOList", empTableDTOList);
        modelAndView.setViewName("emp/emp-list");
        return modelAndView;
    }

    @GetMapping("/emp/{employeeId}")
    // employeeId 매개변수를 PathVariable여기에 묶겠다.
    public ModelAndView getEmpDetailPage(@PathVariable Integer employeeId){
        // System.out.println(employeeId);

        ModelAndView modelAndView = new ModelAndView();

        EmpDetailDTO empDetailDTO = empService.getEmpDetailData(employeeId);
        modelAndView.addObject("empDetailDTO", empDetailDTO);

        modelAndView.setViewName("emp/emp-detail");
        return modelAndView;
    }
    
}
