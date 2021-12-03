package br.edu.uni7.vf.repository;

import br.edu.uni7.vf.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto,Integer> {

    List<Produto> findAllByCodBarra(String codBarra);

    List<Produto> findAllByCategoria(String categoria);

    List<Produto> findAllByQuantidade(Integer quantidade);

}
