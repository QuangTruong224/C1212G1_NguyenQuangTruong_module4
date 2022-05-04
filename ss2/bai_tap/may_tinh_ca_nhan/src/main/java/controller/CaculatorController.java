package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCalculate;
import service.ServiceCalculateImpl;

@Controller
public class CaculatorController {
    ServiceCalculate serviceCalculate=new ServiceCalculateImpl();
//    @Autowired
//    private ServiceCalculate serviceCalculate;
    @RequestMapping("/")
    public String home() {
        return "/home";
    }

    @PostMapping("/caculator")
    public String addition(@RequestParam double first,@RequestParam double second, String calculate, Model model) {

        model.addAttribute("result",this.serviceCalculate.calculate(first,second,calculate));
        return "/home";
    }
}
