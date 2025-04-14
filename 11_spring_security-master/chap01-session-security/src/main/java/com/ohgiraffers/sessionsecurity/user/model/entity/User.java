package com.ohgiraffers.sessionsecurity.user.model.entity;

import com.ohgiraffers.sessionsecurity.common.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "TBL_USER")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NO")
    private Integer id;
    
    @Column(name = "USER_ID", unique = true, nullable = false, length = 30)
    private String username;
    
    @Column(name = "USER_NAME", length = 30)
    private String name;
    
    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;
    
    @Column(name = "USER_ROLE", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}