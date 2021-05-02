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

/**
 *
 * @author Philip
 */
@Entity
@SequenceGenerator(name="accountstateseq", sequenceName = "accountstate_seq", initialValue = 1,allocationSize = 1)
public class AccountState {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accountstateseq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @ManyToOne
    private ManagerAccount managerAccount;
    @OneToOne
    private Manager doneBy;
    private Date updateOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public ManagerAccount getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(ManagerAccount managerAccount) {
        this.managerAccount = managerAccount;
    }

    public Manager getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(Manager doneBy) {
        this.doneBy = doneBy;
    }

    

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }
    
    
}
