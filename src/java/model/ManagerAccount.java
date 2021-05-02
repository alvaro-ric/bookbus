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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Philip
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="claccountseq", sequenceName = "claccount_seq", initialValue = 1,allocationSize = 1)
public class ManagerAccount extends Account {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="claccountseq")
    private long id;
    
    @OneToOne
    private Manager manager;
    @OneToMany(mappedBy = "managerAccount")
    private List<AccountState> accountState = new ArrayList<>();
    
    @OneToOne
    private Company company;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
    

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<AccountState> getAccountState() {
        return accountState;
    }

    public void setAccountState(List<AccountState> accountState) {
        this.accountState = accountState;
    }
    
    
    
    
}
