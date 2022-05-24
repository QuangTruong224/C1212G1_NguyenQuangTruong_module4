package com.example.casestudy.controller.employee;

import com.example.casestudy.dto.EmployeeDto;
import com.example.casestudy.model.employee.Division;
import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.model.employee.Position;
import com.example.casestudy.service.employee.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;


@RequestMapping("/employee")
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;



    @GetMapping("/employee")
    public String home() {
        return "home";
    }


    @GetMapping("/list")
    public ModelAndView listCustomers(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @RequestMapping("/searchByName")
    public ModelAndView searchByName(@RequestParam(name = "search") String name, @PageableDefault(value = 2,
            sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("employee/list", "employees", employeeService.findByName(name, pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        Page<Division> divisions = divisionService.findAll(pageable);
        Page<Position> positions = positionService.findAll(pageable);
        Page<EducationDegree> educationDegrees = educationDegreeService.findAll(pageable);
        modelAndView.addObject("divisions",divisions);
        modelAndView.addObject("positions",positions);
        modelAndView.addObject("educationDegrees",educationDegrees);

        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveEmployee(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, @PageableDefault(value = 5, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            Page<Division> divisions = divisionService.findAll(pageable);
            Page<Position> positions = positionService.findAll(pageable);
            Page<EducationDegree> educationDegrees = educationDegreeService.findAll(pageable);

            model.addAttribute("divisions",divisions);
            model.addAttribute("positions",positions);
            model.addAttribute("educationDegrees",educationDegrees);
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "New employee created successfully");
            return "redirect:/employee/list";
        }

    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id, Pageable pageable) {
//        Optional<Customer> customer = customerService.findById(id);
        if (employeeService.findById(id)!=null) {
            ModelAndView modelAndView = new ModelAndView("employee/edit");
            Page<Division> divisions = divisionService.findAll(pageable);
            Page<Position> positions = positionService.findAll(pageable);
            Page<EducationDegree> educationDegrees = educationDegreeService.findAll(pageable);
            modelAndView.addObject("divisions",divisions);
            modelAndView.addObject("positions",positions);
            modelAndView.addObject("educationDegrees",educationDegrees);
            modelAndView.addObject("employee",employeeService.findById(id));

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customer") Employee employee, Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        redirectAttributes.addFlashAttribute("message", "New employee edited successfully");
        return "redirect:/employee/list";
    }


    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "id") int id, @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        employeeService.remove(id);
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        model.addAttribute("message", "Customer updated successfully");
        return "redirect:/employee/list";
    }
}
