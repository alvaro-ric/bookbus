/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Philip
 */
@Entity
@SequenceGenerator(name="companyaccountseq", sequenceName = "companyaccount_seq", initialValue = 1,allocationSize = 1)
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="companyaccountseq")
    private long id;
    private String name;
    private String companySize;
    @OneToMany(mappedBy = "company")
    private List<CompanyRoute> routes = new ArrayList<>();
    
    @OneToMany(mappedBy = "company")
    private List<Journey> journeys = new ArrayList<>();
    private Timestamp createdOn;
    @OneToMany(mappedBy = "company")
    private List<ManagerAccount> managerAccounts = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus;
    @OneToMany(mappedBy = "company")
    private List<Ticket> tickets = new ArrayList<>();
    @OneToOne
    private Manager manager;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public List<CompanyRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<CompanyRoute> routes) {
        this.routes = routes;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public List<ManagerAccount> getManagerAccounts() {
        return managerAccounts;
    }

    public void setManagerAccounts(List<ManagerAccount> managerAccounts) {
        this.managerAccounts = managerAccounts;
    }

    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    
}
