package com.bank.system.controller;

import com.bank.system.service.AccountService;
import com.bank.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public String getAccountByCustomer(@PathVariable("customerId") int customerId, Model model) {
        model.addAttribute("list", accountService.getListAccounts(customerId));
        model.addAttribute("customer", customerService.getCustomer(customerId));
        return "accountList";
    }

    @PostMapping("/add")
    public String addAccount(@RequestParam("customerId") int customerId) {
        accountService.createAccount(customerId);
        return "redirect:/account/customer/" + customerId;
    }
}
