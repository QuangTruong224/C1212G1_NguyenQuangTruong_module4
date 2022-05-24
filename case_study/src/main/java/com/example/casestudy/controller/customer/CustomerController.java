package com.example.casestudy.controller.customer;


import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public ModelAndView listCustomers(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC) org.springframework.data.domain.Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping("/searchByName")
    public ModelAndView searchByName(@RequestParam(name = "search") String name, @PageableDefault(value = 2,
            sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("customer/list", "customers", customerService.findByName(name, pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        Page<CustomerType> customerTypes = customerTypeService.findAll(pageable);
        modelAndView.addObject("customerTypes", customerTypes);
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }


    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, @PageableDefault(value = 5, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            Page<CustomerType> customerTypes = customerTypeService.findAll(pageable);
            model.addAttribute("customerTypes", customerTypes);
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
            return "redirect:/customer/list";
        }

    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id, org.springframework.data.domain.Pageable pageable) {
//        Optional<Customer> customer = customerService.findById(id);
        if (customerService.findById(id)!=null) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            Page<CustomerType> customerTypes = customerTypeService.findAll(pageable);
            modelAndView.addObject("customer", customerService.findById(id));
            modelAndView.addObject("customerTypes", customerTypes);

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customer") Customer customer, org.springframework.data.domain.Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        redirectAttributes.addFlashAttribute("message", "New customer edited successfully");
        return "redirect:/customer/list";
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable int id) {
//        Optional<Customer> customer = customerService.findById(id);
//        if (customer.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("customer/delete");
//            modelAndView.addObject("customer", customer.get());
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "id") int id, @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        customerService.remove(id);
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("message", "Customer updated successfully");
        return "redirect:/customer/list";
    }
}
