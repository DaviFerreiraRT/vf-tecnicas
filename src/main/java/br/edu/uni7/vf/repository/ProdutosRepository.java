package br.edu.uni7.vf.repository;

import br.edu.uni7.vf.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto,Integer> {

}
