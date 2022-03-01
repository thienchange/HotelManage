/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.ChucVu;
import com.qlks.repository.ChucVuRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class ChucVuRepositoryImpl implements ChucVuRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<ChucVu> getChucVu() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChucVu> query = builder.createQuery(ChucVu.class);
        Root root = query.from(ChucVu.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
