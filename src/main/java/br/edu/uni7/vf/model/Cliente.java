package br.edu.uni7.vf.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private Double totalGasto;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(Double totalGasto) {
        this.totalGasto = totalGasto;
    }
}
