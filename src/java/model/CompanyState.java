/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Philip
 */
@Entity
@SequenceGenerator(name="companystateseq", sequenceName = "companystate_seq", initialValue = 1,allocationSize = 1)
public class CompanyState {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="companystateseq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus;
    @ManyToOne
    private Company company;
    @OneToOne
    private AdminAccount doneBy;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateOn;

    public CompanyState() {
    }

    public CompanyState(CompanyStatus companyStatus, Company company, AdminAccount doneBy, Date updateOn) {
        this.companyStatus = companyStatus;
        this.company = company;
        this.doneBy = doneBy;
        this.updateOn = updateOn;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public AdminAccount getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(AdminAccount doneBy) {
        this.doneBy = doneBy;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }
    
    
}
