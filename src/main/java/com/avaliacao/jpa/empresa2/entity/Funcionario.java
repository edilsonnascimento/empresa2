package com.avaliacao.jpa.empresa2.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    private Long id;
    private String nome;
    private String sexo;
    private String telefone;

    @OneToOne
    private Cargo cargo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                "," + cargo +
                '}';
    }
}