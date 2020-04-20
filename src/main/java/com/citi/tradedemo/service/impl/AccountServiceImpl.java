package com.citi.tradedemo.service.impl;

import com.citi.tradedemo.util.HttpUtil;
import com.citi.tradedemo.entity.Account;
import com.citi.tradedemo.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class AccountServiceImpl implements AccountService {

    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Value("${com.citi.accountURL}")
    private String accountURL;

    @Override
    public Account getAccount(String accountId) {
        Account account = null;
        if (accountURL != null && accountId != null) {
            String result = HttpUtil.doGet(accountURL.concat(accountId));
            logger.info("Account: " + result);
            try {
                account = mapper.readValue(result, Account.class);
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            return account;
        }

        return account;
    }
}
