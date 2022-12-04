package com.phongvo.springbootjwt.controllers;

import com.phongvo.springbootjwt.models.Account;
import com.phongvo.springbootjwt.models.Role;
import com.phongvo.springbootjwt.services.AccountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {

        return ResponseEntity.ok().body(accountService.getAccounts());
    }

    @PostMapping("/account/save")
    public ResponseEntity<Account> saveAccounts(@RequestBody Account account) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/account/save").toUriString());
        return ResponseEntity.created(uri).body(accountService.saveAccount(account));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(accountService.saveRole(role));
    }

    @PostMapping("/role/add-role-to-user")
    public ResponseEntity<Role> saveRoleToUserName(@RequestBody RoleToUserForm roleToUserForm) {
        accountService.addRoleToAccount(roleToUserForm.getUserName(), roleToUserForm.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}