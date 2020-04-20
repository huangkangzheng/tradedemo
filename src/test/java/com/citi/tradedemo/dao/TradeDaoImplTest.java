package com.citi.tradedemo.dao;

import com.citi.tradedemo.entity.Account;
import com.citi.tradedemo.entity.Trade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class TradeDaoImplTest {
    private TradeDao mockDao;

    @Before
    public void setUp() throws Exception {
        mockDao = Mockito.mock(TradeDaoImpl.class);
        Mockito.when(mockDao.getTrade(null)).thenReturn(null);
        Mockito.when(mockDao.getTrade("trade1")).thenReturn(mockTrade());
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

    @Test
    public void testGetTrade() {
        Assert.assertNull(mockDao.getTrade(null));
        Assert.assertEquals("trade1", mockDao.getTrade("trade1").getTradeId());
        Assert.assertEquals("1", mockDao.getTrade("trade1").getAccount().getId());
    }
}