package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompaniesWithFirstFreeLettersAre",
        query = "SELECT * FROM COMPANIES WHERE LEFT(COMPANY_NAME, 3) = :THREELETTERS"
)

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID")
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
