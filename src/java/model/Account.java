/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Philip
 */
@MappedSuperclass
public class Account {
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_role")
    private Role accountRole;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Role getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(Role accountRole) {
        this.accountRole = accountRole;
    }

    
}
