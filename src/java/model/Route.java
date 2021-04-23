/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Philip
 */
@Entity
@SequenceGenerator(name = "routeseq", sequenceName = "route_seq", initialValue = 1, allocationSize = 1)
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routeseq")
    private long id;
    private String source;
    private String destination;
    @OneToMany(mappedBy = "route")
    private List<CompanyRoute> companies = new ArrayList<>();
    @OneToMany(mappedBy = "route")
    private List<Journey> journeys = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<CompanyRoute> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyRoute> companies) {
        this.companies = companies;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }
    
}
