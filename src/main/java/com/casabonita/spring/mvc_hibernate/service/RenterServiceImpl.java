package com.casabonita.spring.mvc_hibernate.service;

import com.casabonita.spring.mvc_hibernate.dao.RenterDAO;
import com.casabonita.spring.mvc_hibernate.entity.Renter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RenterServiceImpl implements RenterService{

    @Autowired
    private RenterDAO renterDAO;

    @Override
    @Transactional
    public List<Renter> getAllRenters() {

        return renterDAO.getAllRenters();
    }

    @Override
    @Transactional
    public void saveRenter(Renter renter) {

        renterDAO.saveRenter(renter);
    }

    @Override
    @Transactional
    public Renter getRenter(int id) {

        return renterDAO.getRenter(id);
    }

    @Override
    @Transactional
    public void deleteRenter(int id) {

        renterDAO.deleteRenter(id);
    }
}