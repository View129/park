package com.issc.second.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 月租户
 */
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telephone;

    private String memberName;

    private String description;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    @JSONField(serialize=false)
    private List<MemberCar> list ;

    public List<MemberCar> getList() {
        return list;
    }

    public void setList(List<MemberCar> list) {
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
