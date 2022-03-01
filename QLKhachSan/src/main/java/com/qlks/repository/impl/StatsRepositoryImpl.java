/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.ChiTietDichVu;
import com.qlks.pojos.ChiTietPhong;
import com.qlks.pojos.DichVu;
import com.qlks.pojos.HoaDonDat;
import com.qlks.pojos.LoaiPhong;
import com.qlks.pojos.Phong;
import com.qlks.pojos.User;
import com.qlks.repository.StatsRepository;
import java.util.ArrayList;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> loaiStats(){
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootP = q.from(Phong.class);
        Root rootL = q.from(LoaiPhong.class);
        
        q.where(b.equal(rootP.get("loaiPhong"), rootL.get("id")));
        
        q.multiselect(rootL.get("id"), rootL.get("loai"),
                b.count(rootP.get("id")));
        q.groupBy(rootL.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> phongStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootP = q.from(Phong.class);
        Root rootH = q.from(HoaDonDat.class);
        Root rootC = q.from(ChiTietPhong.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("phong"), rootP.get("id")));
        predicates.add(b.equal(rootC.get("hoaDonDat"), rootH.get("id")));
        
        q.multiselect(rootP.get("id"), rootP.get("soPhong"), 
                b.sum(b.prod(rootC.get("donGia").as(Long.class), 1)));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootP.get("loaiPhong").get("loai"), String.format("%%%s%%", kw)));
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootH.get("ngayDat"), fromDate));
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootH.get("ngayDat"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rootP.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> phongMonthStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootP = q.from(Phong.class);
        Root rootH = q.from(HoaDonDat.class);
        Root rootC = q.from(ChiTietPhong.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("phong"), rootP.get("id")));
        predicates.add(b.equal(rootC.get("hoaDonDat"), rootH.get("id")));
        
        q.multiselect(b.function("MONTH", Integer.class, rootH.get("ngayDat")), 
                b.function("YEAR", Integer.class, rootH.get("ngayDat")),
                b.sum(rootC.get("donGia").as(Long.class)));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootP.get("loaiPhong").get("loai"), String.format("%%%s%%", kw)));
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootH.get("ngayDat"), fromDate));
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootH.get("ngayDat"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(b.function("MONTH", Integer.class, rootH.get("ngayDat")), 
                b.function("YEAR", Integer.class, rootH.get("ngayDat")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> MonthStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootH = q.from(HoaDonDat.class);
        Root rootU = q.from(User.class);
        
        q.where(b.equal(rootH.get("user"), rootU.get("id")));
        
        q.multiselect(b.function("MONTH", Integer.class, rootH.get("ngayDat")), 
                b.function("YEAR", Integer.class, rootH.get("ngayDat")),
                b.sum(rootH.get("tongTien").as(Long.class)));
        q.groupBy(b.function("MONTH", Integer.class, rootH.get("ngayDat")), 
                b.function("YEAR", Integer.class, rootH.get("ngayDat")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> dichVuStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootD = q.from(DichVu.class);
        Root rootH = q.from(HoaDonDat.class);
        Root rootC = q.from(ChiTietDichVu.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("dichVu"), rootD.get("id")));
        predicates.add(b.equal(rootC.get("hoaDonDat"), rootH.get("id")));
        
        q.multiselect(rootD.get("id"), rootD.get("ten"), 
                b.sum(b.prod(rootC.get("gia").as(Long.class), rootC.get("soDvu").as(Integer.class))));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootD.get("ten"), String.format("%%%s%%", kw)));
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootH.get("ngayDat"), fromDate));
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootH.get("ngayDat"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rootD.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
    @Override
    public List<Object[]> dichVuMonthStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootD = q.from(DichVu.class);
        Root rootH = q.from(HoaDonDat.class);
        Root rootC = q.from(ChiTietDichVu.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("dichVu"), rootD.get("id")));
        predicates.add(b.equal(rootC.get("hoaDonDat"), rootH.get("id")));
        
        q.multiselect(b.function("MONTH", Integer.class, rootH.get("ngayDat")), 
                b.function("YEAR", Integer.class, rootH.get("ngayDat")),
                b.sum(b.prod(rootC.get("gia").as(Long.class), rootC.get("soDvu").as(Integer.class))));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootD.get("ten"), String.format("%%%s%%", kw)));
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootH.get("ngayDat"), fromDate));
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootH.get("ngayDat"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(b.function("MONTH", Integer.class, rootH.get("ngayDat")), 
                b.function("YEAR", Integer.class, rootH.get("ngayDat")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> KhachHangStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootP = q.from(Phong.class);
        Root rootH = q.from(HoaDonDat.class);
        Root rootC = q.from(ChiTietPhong.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("phong"), rootP.get("id")));
        predicates.add(b.equal(rootC.get("hoaDonDat"), rootH.get("id")));
        
        q.multiselect(b.function("MONTH", Integer.class, rootC.get("checkout")), 
                b.function("YEAR", Integer.class, rootC.get("checkout")),
                b.sum(rootC.get("soLuongKhach").as(Long.class)));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootP.get("loaiPhong").get("loai"), String.format("%%%s%%", kw)));
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootC.get("checkout"), fromDate));
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootC.get("checkout"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(b.function("MONTH", Integer.class, rootC.get("checkout")), 
                b.function("YEAR", Integer.class, rootC.get("checkout")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> KhachHangPhongStats(String kw, Date toDate, Date fromDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootP = q.from(Phong.class);
        Root rootH = q.from(HoaDonDat.class);
        Root rootC = q.from(ChiTietPhong.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootC.get("phong"), rootP.get("id")));
        predicates.add(b.equal(rootC.get("hoaDonDat"), rootH.get("id")));
        
        q.multiselect(rootP.get("id"), rootP.get("soPhong"), 
                b.sum(rootC.get("soLuongKhach").as(Long.class)));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootP.get("loaiPhong").get("loai"), String.format("%%%s%%", kw)));
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootC.get("checkout"), fromDate));
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootC.get("checkout"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rootP.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
