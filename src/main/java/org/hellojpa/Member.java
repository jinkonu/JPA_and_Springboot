package org.hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "USER") // >>> 어느 테이블에 Member 객체 데이터를 넣을지
public class Member {
    @Id
    private long id;
    // @column (name = "username") >>> 어느 컬럼에 name 변수 데이터를 넣을지
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
