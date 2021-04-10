package com.casabonita.spring.mvc_hibernate.dao;

import com.casabonita.spring.mvc_hibernate.entity.Meter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeterDAOImpl implements MeterDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Meter> getAllMeters() {

        Session session = sessionFactory.getCurrentSession();
        List<Meter> allMeters = session.createQuery("from Meter", Meter.class).getResultList();

        return allMeters;
    }

    @Override
    public void saveMeter(Meter meter) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(meter);
    }

    @Override
    public Meter getMeter(int id) {

        Session session = sessionFactory.getCurrentSession();
        Meter meter = session.get(Meter.class, id);

        return meter;
    }

    @Override
    public void deleteMeter(int id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Meter> query = session.createQuery("delete from Meter where id=:meterId");
        query.setParameter("meterId", id);
        query.executeUpdate();
    }
}