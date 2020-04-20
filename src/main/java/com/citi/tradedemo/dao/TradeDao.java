package com.citi.tradedemo.dao;

import com.citi.tradedemo.entity.Trade;

public interface TradeDao {

    Trade getTrade(String tradeId);
}
