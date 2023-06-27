package org.hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id @GeneratedValue
    @Column( name = "ORDER_ID" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "MEMBER_ID" )
    private Member member;

    @OneToMany( mappedBy = "orders" )
    List<OrderItem> orderItems = new ArrayList<OrderItem>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrders(this);
    }
}
