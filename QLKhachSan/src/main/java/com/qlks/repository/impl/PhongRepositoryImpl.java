/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.Phong;
import com.qlks.repository.PhongRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PhongRepositoryImpl implements PhongRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Phong> getPhong(String kw, int page) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phong> query = builder.createQuery(Phong.class);
        Root root = query.from(Phong.class);
        query = query.select(root);
        
        if(kw != null){   
            int gia = -1;
            Date ngay = new Date(0000,00,00);
            Date ngaySai = new Date(0000,00,00);
            
            //xử lý -1
            if(kw.equals("-1") == false && kw.equals("00/00/0000")==false && kw.equals("00-00-0000") == false)//khác -1
            {
                try{
                    gia = Integer.parseInt(kw.trim());
                }catch(NumberFormatException ex){gia = -1;};
                try{
                    ngay =new SimpleDateFormat("dd-MM-yyyy").parse(kw.trim());
                }catch(ParseException ex){};
                try{
                    ngay =new SimpleDateFormat("dd/MM/yyyy").parse(kw.trim());
                }catch(ParseException ex){};
                
                if(gia != -1)//có thay đổi nghĩa là nhập giá, xuất giá tiền
                {
                    Predicate p1 = builder.lessThanOrEqualTo(root.get("gia").as(Integer.class),gia);
                    query = query.where(p1);
                }
                else// không có thây đổi nghĩa là nhập chuỗi hoặc ngày
                {
                    if(ngay.compareTo(ngaySai) == 0)//không phải ngày
                    {
                        Predicate p = builder.like(root.get("loaiPhong").get("loai").as(String.class),
                                String.format("%%%s%%", kw));
                        query = query.where(p);
                    }
                    else//ngày
                    {
                        Predicate p = builder.equal(root.get("ngay").as(Date.class),ngay);
                        query = query.where(p);
                    }
                }     
            }
            else// nhập -1
            {
                Predicate p = builder.like(root.get("loaiPhong").get("loai").as(String.class),
                    String.format("%%%s%%", kw));
                query = query.where(p);
            }
           
        }
        
        Query q = session.createQuery(query);
        
        int max = 9;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }
    
    @Override
    public boolean addOrUpdate(Phong phong) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.saveOrUpdate(phong);
            
            return true;
        }catch(Exception ex){
            System.err.println("== ADD PHONG ERROR" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public long countPhong() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Phong");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Phong getPhongById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(Phong.class, id);
    }
}
