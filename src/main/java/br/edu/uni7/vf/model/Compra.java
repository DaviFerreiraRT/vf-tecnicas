package br.edu.uni7.vf.model;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Document
public class Compra {
    @Id
    private UUID uuid;
    @OneToMany
    private List<Produto> produtos;
    private double valor;
    private String cpfCliente;
    private String notaFiscal;


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}
