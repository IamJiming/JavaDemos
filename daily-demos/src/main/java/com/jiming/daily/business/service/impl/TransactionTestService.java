package com.jiming.daily.business.service.impl;

import com.jiming.daily.business.service.ITransactionTestService;
import org.springframework.stereotype.Service;

/**
 * 功能：验证mysql的事务特性
 * 说明：ACID、脏读、幻读、不可重复读、事务隔离级别
 * @author Mr.tjm
 * @date 2021-1-15 14:25
 */
@Service
public class TransactionTestService implements ITransactionTestService {

    @Override
//    @Transactional
    public boolean ACID_test(String userId) {
        return false;
    }
}
