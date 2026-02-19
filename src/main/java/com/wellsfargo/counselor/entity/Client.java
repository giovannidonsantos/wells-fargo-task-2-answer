package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    protected Client() {
        // required by JPA
    }

    public Client(Long clientId, String firstname, String lastname,
                  String email, LocalDate dateOfBirth,
                  LocalDateTime createdAt,
                  Advisor advisor, Portfolio portfolio) {
        this.clientId = clientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.advisor = advisor;
        this.portfolio = portfolio;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
