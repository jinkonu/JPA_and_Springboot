package org.hellojpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
// @Table (name = "MEMBER") // >>> 어느 테이블에 Member 객체 데이터를 넣을지
public class Member {
    @Id
    @GeneratedValue
    @Column (name = "MEMBER_ID") // >>> 어느 컬럼에 name 변수 데이터를 넣을지
    private long id;
    private String name;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "TEAM_ID" )
    private Team team;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
    })
    private Address work_address;
    /*
    @ElementCollection
    @CollectionTable( name = "FAVORITE_FOOD", joinColumns =
    @JoinColumn( name = "MEMBER_ID" ))
    @Column( name = "FOOD_NAME" )
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable( name = "ADDRESS", joinColumns =
    @JoinColumn( name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();
    */

    @OneToMany( mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true )
    List<Favorite_Foods> favorite_foods = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Favorite_Foods> getFavorite_foods() {
        return favorite_foods;
    }

    public void addFoods(Favorite_Foods ff) {
        getFavorite_foods().add(ff);
        ff.setMember(this);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getWork_address() {
        return work_address;
    }

    public void setWork_address(Address work_address) {
        this.work_address = work_address;
    }
}
