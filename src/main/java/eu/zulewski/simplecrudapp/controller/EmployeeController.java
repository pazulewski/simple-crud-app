package eu.zulewski.simplecrudapp.controller;

import eu.zulewski.simplecrudapp.entity.Employee;
import eu.zulewski.simplecrudapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getCreateForm(ModelMap modelMap) {
        Employee employee = new Employee();
        modelMap.addAttribute("employee", employee);
        return "form";
    }

    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.create(employee);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String getEditForm(@PathVariable Long id, ModelMap modelMap) {
        Employee employee = employeeService.getEmployeeById(id);
        modelMap.addAttribute("employee", employee);
        return "form";
    }

    @PostMapping("/{id}/edit")
    public String update(Employee employee) {
        employeeService.update(employee);
        return "redirect:/";
    }

}
