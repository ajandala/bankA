package com.convidad.bankA.client;

import com.convidad.bankA.common.dto.Payment;
import com.convidad.bankA.common.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "bankA", url = "localhost:8000")
public interface BankAClient {

    @RequestMapping(method = RequestMethod.POST, value = "/createAccount")
    String createAccount(@RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/getBalance/{accountNumber}")
    BigDecimal getBalance(@PathVariable("accountNumber") String accountNumber);

    @RequestMapping(method = RequestMethod.POST, value = "/transferMoney")
    void transferMoney(@RequestBody Payment payment);
}
