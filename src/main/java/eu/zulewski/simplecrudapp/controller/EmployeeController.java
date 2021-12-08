package eu.zulewski.simplecrudapp.controller;

import eu.zulewski.simplecrudapp.entity.Employee;
import eu.zulewski.simplecrudapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String showHomePage(ModelMap modelMap) {
        List<Employee> employeeList = employeeService.getAll();
        modelMap.addAttribute("employeeList", employeeList);
        return "index";
    }

    @GetMapping("/add")
    public String getForm(ModelMap modelMap) {
        Employee employee = new Employee();
        modelMap.addAttribute("employee", employee);
        return "add";
    }

    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.create(employee);
        return "redirect:/";
    }

}
