package org.hellojpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column (name = "TEAM_ID")
    private long id;
    private String name;
    @OneToMany ( mappedBy = "team" )
    private List<Member> members = new ArrayList<Member>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
