package com.citi.tradedemo.service.impl;


import com.citi.tradedemo.dao.TradeDao;
import com.citi.tradedemo.dao.TradeDaoImpl;
import com.citi.tradedemo.entity.Account;
import com.citi.tradedemo.entity.Trade;
import com.citi.tradedemo.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class TradeServiceImplTest{

    private TradeDao tradeDao;
    private AccountService accountService;
    private TradeServiceImpl tradeService;

    @Before
    public void setUp() throws Exception {
        tradeDao = Mockito.mock(TradeDaoImpl.class);
        accountService = Mockito.mock(AccountServiceImpl.class);
        tradeService = new TradeServiceImpl();

        Mockito.when(tradeDao.getTrade("trade1")).thenReturn(mockTrade());
        Mockito.when(accountService.getAccount("1")).thenReturn(mockAccount());

        tradeService.setTradeDao(tradeDao);
        tradeService.setAccountService(accountService);

    }

    private Trade mockTrade() {
        Trade trade = new Trade();
        Account account = new Account();
        account.setId("1");

        trade.setTradeId("trade1");
        trade.setTradeVersion(1);
        trade.setTradeDate(new Date(2020, 2, 14));
        trade.setAccount(account);
        return trade;
    }

    private Account mockAccount() {
        Account account = new Account();

        account.setId("1");
        account.setUserId("1");
        account.setTitle("delectus aut autem");
        account.setCompleted(false);

        return account;
    }

    @Test
    public void testGetTrade() {
        Assert.assertEquals("trade1", tradeService.getTrade("trade1").getTradeId());
        Assert.assertEquals("1", tradeService.getTrade("trade1").getAccount().getId());
        Assert.assertNull(tradeService.getTrade(null));
    }
}