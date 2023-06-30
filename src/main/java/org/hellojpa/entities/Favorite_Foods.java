package org.hellojpa.entities;

import javax.persistence.*;

@Entity
@Table( name = "FAVORITE_FOODS_ENTITY" )
public class Favorite_Foods {
    @Id @GeneratedValue
    @Column( name = "FAVORITE_FODDS_ID")
    private long id;

    @Column ( name = "FOOD_NAME")
    private String foodName = new String();

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn( name = "MEMBER_ID" )
    private Member member;

    public Favorite_Foods() { }

    public Favorite_Foods(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
