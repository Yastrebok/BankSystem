package com.bank.system.controller;


import com.bank.system.entity.Account;
import com.bank.system.service.AccountService;
import com.bank.system.service.CustomerService;
import com.bank.system.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.bank.system.service.CustomerService.*;
import static com.bank.system.service.TransferService.*;


@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public String getAllTransactional(Model model) {
        model.addAttribute("list", transferService.getAllTransaction());
        return "transferList";
    }

    @GetMapping("/deposit/{id}")
    public String deposit(@PathVariable("id") int accountId, Model model) {
        model.addAttribute("transferDto", transferService.deposit(accountId));
        return "transferDeposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam("customerId") int customerId,
                           @RequestParam("account") int account,
                           @RequestParam("value") double value) {
        transferService.deposit(account, value);
        return "redirect:/account/customer/" + customerId;
    }

    @GetMapping("/withDraw/{id}")
    public String withDraw(@PathVariable("id") int accountId, Model model) {
        model.addAttribute("transferDto", transferService.withDraw(accountId));
        return "transferWithDraw";
    }

    @PostMapping("/withDraw")
    public String withDraw(@RequestParam("customerId") int customerId,
                          @RequestParam("account") int account,
                          @RequestParam("value") double value) {
        return  transferService.withDraw(account, value);
    }

    @GetMapping("/transfer/{id}")
    public String transfer(@PathVariable("id") int accountId, Model model) {
        model.addAttribute("transferDto", transferService.withDraw(accountId));
        model.addAttribute("listAccounts", accountService.getListAccountDto());
        return "transfer";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("customerId") int customerId,
                           @RequestParam("account") int account,
                           @RequestParam("toAccount") int toAccount,
                           @RequestParam("value") double value) {
        transferService.transfer(customerId, account,toAccount, value);
        return "redirect:/customer/list";
    }
}

