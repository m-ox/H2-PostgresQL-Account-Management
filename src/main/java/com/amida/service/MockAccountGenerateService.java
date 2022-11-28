package com.amida.service;

import com.amida.domain.entity.Account;
import com.amida.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MockAccountGenerateService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountIdGenerationService accountIdGenerationService;

    public void generateAccounts() {
        Account account1=  Account.builder()
                .id(accountIdGenerationService.newAccountId())
                .balance(new BigDecimal(100))
                .name("Berkay account")
                .build();
        accountRepository.save(account1);

        Account account2=  Account.builder()
                .id(accountIdGenerationService.newAccountId())
                .balance(new BigDecimal(100))
                .name("Test account")
                .build();

        accountRepository.save(account2);
    }
}