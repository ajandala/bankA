package com.convidad.bankA.server.service;

import com.convidad.bankA.common.dto.Account;
import com.convidad.bankA.common.dto.Payment;
import com.convidad.bankA.common.dto.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class BankService {

    private Map<String, User> userMap = new HashMap<>();
    private Map<String, Account> accountMap = new HashMap<>();

    public synchronized String createAccount(User user) {

        userMap.putIfAbsent(user.getIdCardNumber(), user);

        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(BigDecimal.ZERO);

        accountMap.put(account.getAccountNumber(), account);

        return account.getAccountNumber();
    }

    public BigDecimal getBalance(String accountNumber) {

        return getAccount(accountNumber).getBalance();
    }

    public void transferMoney(Payment payment) {

        Account accountFrom = getAccount(payment.getAccountNumberFrom());
        Account accountTo = getAccount(payment.getAccountNumberTo());

        accountFrom.setBalance(accountFrom.getBalance().subtract(payment.getQuantity()));
        accountTo.setBalance(accountTo.getBalance().add(payment.getQuantity()));
    }

    private Account getAccount(String accountNumber) {

        if (!accountMap.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account number doesn't exist: " + accountNumber);
        }

        return accountMap.get(accountNumber);
    }

}
