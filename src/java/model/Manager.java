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
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Philip
 */
@Entity
@SequenceGenerator(name="managerseq", sequenceName = "manager_seq", initialValue = 1,allocationSize = 1)
public class Manager extends Person {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="managerseq")
    private long id;
    
    
    
}
