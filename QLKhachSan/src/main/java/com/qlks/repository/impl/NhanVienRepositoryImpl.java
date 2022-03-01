/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.NhanVien;
import com.qlks.repository.NhanVienRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class NhanVienRepositoryImpl implements NhanVienRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<NhanVien> getNhanVien(String kw) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = builder.createQuery(NhanVien.class);
        Root root = query.from(NhanVien.class);
        query = query.select(root);
        
        if(kw != null){
            Predicate q = builder.like(root.get("ten").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p = builder.like(root.get("boPhan").get("ten").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(builder.or(q, p));
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();  
    }

    @Override
    public boolean addOrUpdate(NhanVien nhanVien) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.saveOrUpdate(nhanVien);
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
        NhanVien nhanVien = session.byId(NhanVien.class).load(id);
        session.delete(nhanVien);
        return true;
    }

    @Override
    public NhanVien getNhanVienById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(NhanVien.class, id);
    }

    
}
