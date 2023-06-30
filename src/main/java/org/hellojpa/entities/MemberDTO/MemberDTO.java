package org.hellojpa.entities.MemberDTO;

public class MemberDTO {
    private String name;
    private long id;

    public MemberDTO() {
    }

    public MemberDTO(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
