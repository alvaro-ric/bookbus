/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Philip
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="adminaccountseq", sequenceName = "adminaccount_seq", initialValue = 1,allocationSize = 1)
public class AdminAccount extends Account{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="adminaccountseq")
    private long id;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
