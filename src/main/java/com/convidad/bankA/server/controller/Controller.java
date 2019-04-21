package com.convidad.bankA.server.controller;

import com.convidad.bankA.common.dto.Payment;
import com.convidad.bankA.common.dto.User;
import com.convidad.bankA.server.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class Controller {

    @Autowired
    private BankService bankService;

    @PostMapping(value = "/createAccount")
    public String createAccount(@RequestBody User user) {
        return bankService.createAccount(user);
    }

    @GetMapping(value = "/getBalance/{accountNumber}")
    public  BigDecimal getBalance(@PathVariable String accountNumber) {
        return bankService.getBalance(accountNumber);
    }

    @PostMapping(value = "/transferMoney")
    public void transferMoney(@RequestBody Payment payment) {
        bankService.transferMoney(payment);
    }


}
