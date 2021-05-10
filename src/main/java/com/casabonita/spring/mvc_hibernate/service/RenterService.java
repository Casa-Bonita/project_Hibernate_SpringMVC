package com.casabonita.spring.mvc_hibernate.service;

import com.casabonita.spring.mvc_hibernate.entity.Renter;

import java.util.List;

public interface RenterService {

    List<Renter> getAllRenters();

    void saveRenter(Renter renter);

    Renter getRenter (int id);

    void deleteRenter(int id);

    Renter getRenterByName (String name);
}
