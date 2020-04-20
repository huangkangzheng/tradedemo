package com.citi.tradedemo.dao;

import com.citi.tradedemo.entity.Account;
import com.citi.tradedemo.entity.Trade;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TradeDaoImpl implements TradeDao{
    private Map<String, Trade> mockDBTrades = new HashMap<>();

    @PostConstruct
    public void init() {
        mockDBTrades.put("trade1", mockTrade1());
        mockDBTrades.put("trade2", mockTrade2());
    }

    private Trade mockTrade1() {
        Trade trade = new Trade();
        Account account = new Account();
        account.setId("1");

        trade.setTradeId("trade1");
        trade.setTradeVersion(1);
        trade.setTradeDate(new Date(2020, 2, 14));
        trade.setAccount(account);
        return trade;
    }

    private Trade mockTrade2() {
        Trade trade = new Trade();
        Account account = new Account();
        account.setId("2");

        trade.setTradeId("trade2");
        trade.setTradeVersion(1);
        trade.setTradeDate(new Date(2020, 2, 14));
        trade.setAccount(account);
        return trade;
    }

    @Override
    public Trade getTrade(String tradeId) {
        if (StringUtils.isEmpty(tradeId)) {
            return null;
        }
        Trade trade = mockDBTrades.get(tradeId);
        return trade;
    }
}
