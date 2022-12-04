package com.phongvo.springbootjwt.services;

import com.phongvo.springbootjwt.models.Account;
import com.phongvo.springbootjwt.models.Role;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account account);

    Role saveRole(Role role);

    void addRoleToAccount(String accountName, String roleName);

    Account getAccount(String accountName);

    List<Account> getAccount();

}
