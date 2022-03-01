/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;


import com.qlks.pojos.LoaiPhong;
import com.qlks.repository.LoaiPhongRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class LoaiPhongRepositoryImpl implements LoaiPhongRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<LoaiPhong> getLoaiPhong() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiPhong > query = builder.createQuery(LoaiPhong.class);
        Root root = query.from(LoaiPhong.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        return q.getResultList();    
    }
}
