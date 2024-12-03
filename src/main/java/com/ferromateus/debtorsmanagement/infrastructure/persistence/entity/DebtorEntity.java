package com.ferromateus.debtorsmanagement.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "DEBTORS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebtorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "DEBTOR_ID")
    private UUID id;

    @Column(name = "DEBTOR_CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
