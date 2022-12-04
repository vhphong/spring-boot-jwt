package com.phongvo.springbootjwt.services;

import com.phongvo.springbootjwt.models.Account;
import com.phongvo.springbootjwt.models.Role;
import com.phongvo.springbootjwt.repositories.AccountRepository;
import com.phongvo.springbootjwt.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {//, UserDetailsService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository) {
//        this.accountRepository = accountRepository;
//        this.roleRepository = roleRepository;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String accountUserName) throws UsernameNotFoundException {
//        Account account = accountRepository.findByAccountUserName(accountUserName);
//
//        if (account == null) {
//            log.error("User not found in the database");
//            throw new UsernameNotFoundException("User not found in the database");
//        } else {
//            log.error("User found in the database: {}", accountUserName);
//        }
//
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        account.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        });
//        return new org.springframework.security.core.userdetails.User(account.getAccountUserName(), account.getAccountPassword(), authorities);

//        return null;
//    }

    @Override
    public Account saveAccount(Account account) {
        log.info("Saving account {} to the database.", account.getAccountName());
        return accountRepository.save(account);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database.", role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToAccount(String accountUserName, String roleName) {
        log.info("Saving new role {} to the account userName {}.", roleName, accountUserName);
        Account account = accountRepository.findByAccountUserName(accountUserName);
        Role role = roleRepository.findByRoleName(roleName);
        account.getRoles().add(role);
    }

    @Override
    public Account getAccount(String accountName) {
        log.info("Fetching account {}.", accountName);
        return accountRepository.findByAccountName(accountName);
    }

    @Override
    public List<Account> getAccounts() {
        log.info("Fetching all accounts.");
        return accountRepository.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
}
