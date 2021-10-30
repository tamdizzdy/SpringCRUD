package com.example.springbootc.controller;

import com.example.springbootc.model.Employee;
import com.example.springbootc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/")
    public String viewHomePage(Model model)
    {
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
