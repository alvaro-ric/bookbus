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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Philip
 */
@Entity
@SequenceGenerator(name = "passengerseq", sequenceName = "passenger_seq", initialValue = 1, allocationSize = 1)
public class Passenger extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerseq")
    private int id;
    @OneToOne(mappedBy = "passenger")
    private Ticket ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
