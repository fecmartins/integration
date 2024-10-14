package com.api.integration.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    private String full_name;

    @Column(unique=true)
    private String email;

    private String phone_number;

    private String location;

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(account_id, account.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(account_id);
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAccount_id(Long accountId) {
        this.account_id = accountId;
    }

    public Long getAccount_id() {
        return account_id;
    }
}
