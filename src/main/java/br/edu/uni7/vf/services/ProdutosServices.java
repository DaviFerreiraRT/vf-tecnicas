package br.edu.uni7.vf.services;

import br.edu.uni7.vf.exceptions.QuantidadeInsuficienteException;
import br.edu.uni7.vf.model.Produto;
import br.edu.uni7.vf.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServices {
    private final ProdutosRepository produtosRepository;

    @Autowired
    public ProdutosServices(ProdutosRepository produtos){
        this.produtosRepository = produtos;
    }

    public Produto findByCodBarras(Integer codBarras){
        return produtosRepository.findById(codBarras).get();
    }

    public List<Produto>  findAllEmptyProducts(List<Produto> produto) {
        List<Produto> produtos = produto;

        if (produtos != null){
            for( Produto prod : produtos){
                if (prod.getQuantidade() == 0){
                    throw new QuantidadeInsuficienteException();
                }
            }
        }
        return produtosRepository.findAll();
    }

    public Produto create (Produto produto){
        return produtosRepository.save(produto);
    }
    public void delete(Integer codDeBarra){
        produtosRepository.deleteById(codDeBarra);
    }
    public Produto update(Produto produto){
        return produtosRepository.save(produto);

    }




}
