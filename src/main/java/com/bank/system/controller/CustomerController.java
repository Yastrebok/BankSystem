package com.bank.system.controller;

import com.bank.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("list", customerService.getListCustomers());
        return "customerList";
    }

    @GetMapping("/add")
    public String addCustomer() {
        return "customerAdd";
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam("name") String name,
                              @RequestParam("address") String address,
                              @RequestParam("age") int age) {
        customerService.createCustomer(name, address, age);
        return "redirect:/customer/list";
    }

    @GetMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id));
        return "customerEdit";
    }

    @PostMapping("/update")
    public String updateCustomer(@RequestParam("id") int id,
                                 @RequestParam("name") String name,
                                 @RequestParam("address") String address,
                                 @RequestParam("age") int age) {
        customerService.updateCustomer(id, name, address, age);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/all";
    }

}
