package org.hcltraining.aadharmanagement.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aadharId;
    private String aadharNumber;
    private String address;
    private Date receivedOn;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;


}
