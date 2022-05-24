package com.example.casestudy.controller.service;

import com.example.casestudy.dto.ServiceDto;
import com.example.casestudy.model.service.RentType;
import com.example.casestudy.model.service.Service;
import com.example.casestudy.model.service.ServiceType;
import com.example.casestudy.service.services.IRentTypeService;
import com.example.casestudy.service.services.IServicesService;
import com.example.casestudy.service.services.IServiceTypeService;
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

@RequestMapping("/service")
@Controller
public class ServiceController {


    @Autowired
    private IServicesService serviceService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;


    @GetMapping("/service")
    public String home() {
        return "home";
    }


    @GetMapping("/list")
    public ModelAndView listService(@PageableDefault(value = 3, sort = "idService", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @RequestMapping("/searchByName")
    public ModelAndView searchByName(@RequestParam(name = "search") String name, @PageableDefault(value = 2,
            sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("service/list", "services", serviceService.findByName(name, pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("service/create");
        Page<RentType> rentTypes = rentTypeService.findAll(pageable);
        Page<ServiceType> serviceTypes = serviceTypeService.findAll(pageable);

        modelAndView.addObject("rentTypes", rentTypes);
        modelAndView.addObject("serviceTypes", serviceTypes);

        modelAndView.addObject("serviceDto", new ServiceDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, @PageableDefault(value = 5, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            Page<RentType> rentTypes = rentTypeService.findAll(pageable);
            Page<ServiceType> serviceTypes = serviceTypeService.findAll(pageable);

            model.addAttribute("rentTypes", rentTypes);
            model.addAttribute("serviceTypes", serviceTypes);

            return "service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            redirectAttributes.addFlashAttribute("message", "New service created successfully");
            return "redirect:/service/list";
        }

    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id, Pageable pageable) {
//        Optional<Customer> customer = customerService.findById(id);
        if (serviceService.findById(id) != null) {
            ModelAndView modelAndView = new ModelAndView("service/edit");
            Page<RentType> rentTypes = rentTypeService.findAll(pageable);
            Page<ServiceType> serviceTypes = serviceTypeService.findAll(pageable);

            modelAndView.addObject("rentTypes", rentTypes);
            modelAndView.addObject("serviceTypes", serviceTypes);

            modelAndView.addObject("service", serviceService.findById(id));

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateService(@ModelAttribute("service") Service service, Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        Page<Service> services = serviceService.findAll(pageable);
        model.addAttribute("services", services);
        redirectAttributes.addFlashAttribute("message", "New service edited successfully");
        return "redirect:/service/list";
    }


    @PostMapping("/delete")
    public String deleteService(@RequestParam(name = "id") int id, @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        serviceService.remove(id);
        Page<Service> services = serviceService.findAll(pageable);
        model.addAttribute("services", services);
        model.addAttribute("message", "Customer updated successfully");
        return "redirect:/service/list";
    }
}

