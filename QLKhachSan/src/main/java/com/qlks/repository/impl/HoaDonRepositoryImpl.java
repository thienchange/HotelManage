/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.ChiTietDichVu;
import com.qlks.pojos.ChiTietPhong;
import com.qlks.pojos.HoaDonDat;
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
import com.qlks.repository.HoaDonRepository;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class HoaDonRepositoryImpl implements HoaDonRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<HoaDonDat> getHoaDonDat(String kw) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HoaDonDat> query = builder.createQuery(HoaDonDat.class);
        Root root = query.from(HoaDonDat.class);
        query = query.select(root);
        
        if(kw != null){
            Predicate q = builder.like(root.get("id").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p = builder.like(root.get("user").get("khachHang").get("ten").as(String.class),
                    String.format("%%%s%%", kw));
            
            query = query.where(builder.or(q, p));
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();  
    }

    @Override
    public boolean Update(HoaDonDat hoaDonDat) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.saveOrUpdate(hoaDonDat);
            return true;
        }catch(Exception ex){
            System.err.println("== UPDATE HOA DON ERROR" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        HoaDonDat hoaDonDat = session.byId(HoaDonDat.class).load(id);
        session.delete(hoaDonDat);
        return true;
    }

    @Override
    public HoaDonDat getHoaDonDatById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(HoaDonDat.class, id);
    }

    @Override
    public List<ChiTietPhong> getChiTietPhong(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChiTietPhong> query = builder.createQuery(ChiTietPhong.class);
        Root root = query.from(ChiTietPhong.class);
        query = query.select(root);
        
        if(id != 0){
            Predicate q = builder.equal(root.get("hoaDonDat").get("id").as(Integer.class),
                    Integer.valueOf(id));
            
            query = query.where(q);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();  
    }

    @Override
    public ChiTietPhong getChiTietPhongById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(ChiTietPhong.class, id);
    }

    @Override
    public List<ChiTietDichVu> getChiTietDichVu(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ChiTietDichVu> query = builder.createQuery(ChiTietDichVu.class);
        Root root = query.from(ChiTietDichVu.class);
        query = query.select(root);
        
        if(id != 0){
            Predicate q = builder.equal(root.get("hoaDonDat").get("id").as(Integer.class),
                    Integer.valueOf(id));
            
            query = query.where(q);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList(); 
    }
    
}
