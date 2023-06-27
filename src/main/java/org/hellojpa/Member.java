package org.hellojpa;

import javax.persistence.*;

@Entity
// @Table (name = "MEMBER") // >>> 어느 테이블에 Member 객체 데이터를 넣을지
public class Member {
    @Id
    @GeneratedValue
    @Column (name = "MEMBER_ID") // >>> 어느 컬럼에 name 변수 데이터를 넣을지
    private long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @ManyToOne
    @JoinColumn( name = "TEAM_ID" )
    private Team team;

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
}
