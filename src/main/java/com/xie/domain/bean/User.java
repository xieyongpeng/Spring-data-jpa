package com.xie.domain.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(name="user_name")
    private String userName;
    @Column(name="age")
    private Integer age;
    
//    @ManyToMany(targetEntity=Role.class)
//    @JoinTable(name="sys_user_role",
//    joinColumns={@JoinColumn(name="sys_user_id",referencedColumnName="user_id")},
//    inverseJoinColumns={@JoinColumn(name="sys_role_id",referencedColumnName="role_id")})
    //mappedBy：对方配置关系的属性名称
    @ManyToMany(mappedBy="users",cascade= CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", age="
				+ age + "]";
	}
    
}
