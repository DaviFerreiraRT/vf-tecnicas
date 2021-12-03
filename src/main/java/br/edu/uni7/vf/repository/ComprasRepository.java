package br.edu.uni7.vf.repository;

import br.edu.uni7.vf.model.Compra;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


@Repository
public interface ComprasRepository extends MongoRepository<Compra, Integer> {
    List<Compra> findAllByCpfCliente(String cpfCliente);
}
