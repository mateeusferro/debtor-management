package com.ferromateus.debtorsmanagement.domain.model;

import java.util.UUID;

public class Debtor {
    private UUID id;
    private String address;
    private String cpf;
    private String email;
    private String name;
    private String phoneNumber;
    private Boolean status;

    public Debtor() {}

    public Debtor(UUID id, String address, String cpf, String email, String name, String phoneNumber, Boolean status) {
        this.id = id;
        this.address = address;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
