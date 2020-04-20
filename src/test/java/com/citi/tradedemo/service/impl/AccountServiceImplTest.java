package com.citi.tradedemo.service.impl;

import com.citi.tradedemo.entity.Account;
import com.citi.tradedemo.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class AccountServiceImplTest{

    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
        accountService = Mockito.mock(AccountService.class);
        Mockito.when(accountService.getAccount("1")).thenReturn(mockAccount());
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
    public void testGetAccount() {
        Assert.assertNull(accountService.getAccount(null));
        Assert.assertEquals("1", accountService.getAccount("1").getId());
    }
}