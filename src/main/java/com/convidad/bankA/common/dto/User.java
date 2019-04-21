package com.convidad.bankA.common.dto;

import java.util.List;

public class User {

    private String idCardNumber;
    private String name;
    private List<Account> account;

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountList() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
