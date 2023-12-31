package org.hellojpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    @Column( name = "ORDER_ITEM_ID" )
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "ORDER_ID" )
    private Orders orders;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "ITEM_ID" )
    private Item item;

    private int orderPrice;
    private int count;

    @ManyToMany( mappedBy = "orderItems" )
    private List<Category> categories = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
