package com.citi.tradedemo.service.impl;

import com.citi.tradedemo.dao.TradeDao;
import com.citi.tradedemo.entity.Account;
import com.citi.tradedemo.entity.Trade;
import com.citi.tradedemo.service.AccountService;
import com.citi.tradedemo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private AccountService accountService;

    public void setTradeDao(TradeDao tradeDao) {
        this.tradeDao = tradeDao;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Trade getTrade(String tradeId) {
        Trade trade = tradeDao.getTrade(tradeId);
        Optional.ofNullable(trade).ifPresent(data -> {
            String accountId = data.getAccount().getId();
            Account account = accountService.getAccount(accountId);
            data.setAccount(account);
        });
        return trade;
    }
}
