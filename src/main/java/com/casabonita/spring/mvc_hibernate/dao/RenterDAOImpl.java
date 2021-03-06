package com.casabonita.spring.mvc_hibernate.dao;

import com.casabonita.spring.mvc_hibernate.entity.Renter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RenterDAOImpl implements RenterDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Renter> getAllRenters() {

        Session session = sessionFactory.getCurrentSession();
        List<Renter> allRenters = session.createQuery("from Renter as r order by r.name asc", Renter.class).getResultList();

        return allRenters;
    }

    @Override
    public void saveRenter(Renter renter) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(renter);
    }

    @Override
    public Renter getRenter(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        Renter renter = session.get(Renter.class, id);

        return renter;
    }

    @Override
    public Renter getRenterByName(String name) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Renter where name=:param");
        query.setParameter("param", name);

        Renter renter = (Renter) query.getSingleResult();

        return renter;
    }

    @Override
    public void deleteRenterById(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Renter> query = session.createQuery("delete from Renter where id=:param");
        query.setParameter("param", id);
        query.executeUpdate();
    }
}
