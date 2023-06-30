package org.hellojpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue
    @Column( name = "CATEGORY_ID" )
    private long id;

    private String name;

    @ManyToMany
    @JoinTable( name = "CATEGORY_NAME",
    joinColumns = @JoinColumn( name = "CATEGORY_ID" ),
    inverseJoinColumns = @JoinColumn( name = "ORDERITEM_ID"))
    private List<OrderItem> orderItems = new ArrayList<>();
}
