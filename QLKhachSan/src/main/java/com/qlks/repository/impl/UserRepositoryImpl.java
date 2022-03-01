/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.KhachHang;
import com.qlks.pojos.User;
import com.qlks.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.saveOrUpdate(user);
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
//        User u = new User();
//        u.setUser("admin");
//        String mk = "123";
//        String hash = BCrypt.hashpw(mk, BCrypt.gensalt(12));
//        u.setPass(hash);
//        u.setQuyenUser("admin");
//        session.save(u);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        
        if(!username.isEmpty()){
            Predicate p = builder.equal(root.get("user").as(String.class), username);//chỉnh
            Predicate q = builder.equal(root.get("quyenUser").as(String.class), username);
            query = query.where(builder.or(p, q));
        }
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public boolean updateKhachHang(KhachHang kh) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.saveOrUpdate(kh);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
        return true;
    }

    @Override
    public List<KhachHang> getKhachHangs(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = builder.createQuery(KhachHang.class);
        Root root = query.from(KhachHang.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        return q.getResultList();  
    }

    @Override
    public KhachHang getKhachHangById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(KhachHang.class, id);
    }
    
}
