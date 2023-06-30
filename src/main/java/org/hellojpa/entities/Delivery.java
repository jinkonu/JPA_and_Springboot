package org.hellojpa.entities;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    @Column( name = "DEIVERY_ID" )
    private long id;

    @OneToOne( mappedBy = "delivery", fetch = FetchType.LAZY )
    private Orders orders;

    @Embedded
    private Address address;

    /*
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    */


    public long getId() {
        return id;
    }
}
