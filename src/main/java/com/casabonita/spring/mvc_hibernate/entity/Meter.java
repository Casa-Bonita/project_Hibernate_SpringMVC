package com.casabonita.spring.mvc_hibernate.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="meter")
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="meter_number")
    private String number;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="place_id")
    private Place meterPlace;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "meter", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Reading> readingsList;

    public Meter() {
    }

    public Meter(String number, Place meterPlace) {
        this.number = number;
        this.meterPlace = meterPlace;
    }

    public void addReadingToMeter(Reading reading){
        if(readingsList == null){
            readingsList = new ArrayList<>();
        }
        readingsList.add(reading);
        reading.setMeter(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Place getMeterPlace() {
        return meterPlace;
    }

    public void setMeterPlace(Place meterPlace) {
        this.meterPlace = meterPlace;
    }

    public List<Reading> getReadingsList() {
        return readingsList;
    }

    public void setReadingsList(List<Reading> readingsList) {
        this.readingsList = readingsList;
    }
}
