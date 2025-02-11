package cerlace.example.hibernate.service.impl;

import cerlace.example.hibernate.dao.IDAO;
import cerlace.example.hibernate.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
public class BaseTransactionService<T> implements IService<T> {

    private IDAO<T> baseDAO;

//    @Autowired
//    private TransactionTemplate transactionTemplate;


    public BaseTransactionService(IDAO<T> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public T add(T t) {
        return baseDAO.add(t);
    }

    @Override
    public T get(Serializable id) {
        return baseDAO.get(id);
    }

    @Override
    public T update(T t) {
        return baseDAO.update(t);
    }

    @Override
    public void delete(Serializable id) {
        baseDAO.delete(id);

    }
}
