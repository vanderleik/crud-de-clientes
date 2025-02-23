package com.api.crud_de_clientes.dtos;

import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientRequestToUpdateDTO {

    private String name;

    private String cpf;

    private Double income;

    @PastOrPresent(message = "A data de nascimento não pode ser futura")
    private LocalDate birthDate;

    private Integer children;

    public ClientRequestToUpdateDTO() {
    }

    public ClientRequestToUpdateDTO(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
