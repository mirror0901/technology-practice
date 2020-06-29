package com.mirror.transactionpropagation.service;

import com.mirror.transactionpropagation.exception.RollbackException;

/**
 * @author: mirror
 * @date: 2020/6/28 11:08
 * @description:
 */
public interface BarService {

    /**
     * 有事务
     *
     * @throws RollbackException
     */
    void hasTransactional() throws RollbackException;

    /**
     * 无事务
     *
     * @throws RollbackException
     */
    void noTransactional() throws RollbackException;

    void hasTransactionalNoException() throws RollbackException;

}
