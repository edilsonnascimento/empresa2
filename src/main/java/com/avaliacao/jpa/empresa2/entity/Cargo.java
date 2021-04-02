package com.avaliacao.jpa.empresa2.entity;

import javax.persistence.*;

@Entity
public class Cargo {

    @Id
    private Long id;
    private String nomeCargo;

    @OneToOne(mappedBy = "cargo")
    private Funcionario funcionario;


    public Cargo() {
    }

    public Cargo(String nomeCargo, Funcionario funcionario) {
        this.nomeCargo = nomeCargo;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return " Cargo= " + nomeCargo;
    }
}
