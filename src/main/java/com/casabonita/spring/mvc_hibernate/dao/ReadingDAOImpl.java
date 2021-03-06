package com.casabonita.spring.mvc_hibernate.dao;

import com.casabonita.spring.mvc_hibernate.entity.Reading;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ReadingDAOImpl implements ReadingDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Reading> getAllReadings() {

        Session session = sessionFactory.getCurrentSession();
        List<Reading> allReadings = session.createQuery("from Reading as r order by r.meter asc, r.transferDate asc", Reading.class).getResultList();

        return allReadings;
    }

    @Override
    public void saveReading(Reading reading) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(reading);

    }

    @Override
    public Reading getReading(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        Reading reading = session.get(Reading.class, id);

        return reading;
    }

    @Override
    public void deleteReadingById(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Reading> query = session.createQuery("delete from Reading where id=:param");
        query.setParameter("param", id);
        query.executeUpdate();

    }

    @Override
    public void deleteReadingByMeterId(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Reading> queryReading = session.createQuery("delete from Reading where meter.id=:param");
        queryReading.setParameter("param", id);
        queryReading.executeUpdate();

    }
}
