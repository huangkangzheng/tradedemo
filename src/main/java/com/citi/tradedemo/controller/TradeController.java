package com.citi.tradedemo.controller;

import com.citi.tradedemo.entity.Trade;
import com.citi.tradedemo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping(value = "/trade/{tradeId}")
    public Trade getTrade (@PathVariable("tradeId") String tradeId){
        return tradeService.getTrade(tradeId);
    }
}
