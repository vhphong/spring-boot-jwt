package com.phongvo.springbootjwt.repositories;

import com.phongvo.springbootjwt.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountName(String username);
}
