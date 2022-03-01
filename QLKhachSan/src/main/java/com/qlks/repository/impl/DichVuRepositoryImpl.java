/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.DichVu;
import com.qlks.repository.DichVuRepository;
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
public class DichVuRepositoryImpl implements DichVuRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<DichVu> getDichVu(String kw) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DichVu> query = builder.createQuery(DichVu.class);
        Root root = query.from(DichVu.class);
        query = query.select(root);
        
        if(!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("ten").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();    
    }
    
    @Override
    public boolean addOrUpdate(DichVu dichVu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.saveOrUpdate(dichVu);
            
            return true;
        }catch(Exception ex){
            System.err.println("== ADD DICH VU ERROR" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        DichVu dichVu = session.byId(DichVu.class).load(id);
        session.delete(dichVu);
        return true;
    }

    @Override
    public DichVu getDichVuById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(DichVu.class, id);
    }
}
