package br.edu.uni7.vf.model;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.List;
import java.util.UUID;

@Document
public class Compras {
    @Id
    private UUID uuid = UUID.randomUUID();
    private List<Produtos> produtos;
    private Double valorCompra;



}
