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
    public Produto create (Produto produto){
        return produtosRepository.save(produto);
    }
    public void delete(Integer codDeBarra){
        produtosRepository.deleteById(codDeBarra);
    }
    public Produto update(Integer id,Produto produto){
        produtosRepository.save(produto);
        return produto;

    }
    public Produto findById(Integer id){
        return produtosRepository.findById(id).get();
    }

    public List<Produto> findAllProdutos(){
        return produtosRepository.findAll();
    }
    public List<Produto> findAllByCodBarra(String codBarra){
        return produtosRepository.findAllByCodBarra(codBarra);
    }

    public List<Produto> findAllByCategoria(String categoria){
        return produtosRepository.findAllByCategoria(categoria);
    }

    public List<Produto> findAllByQuantidadeZero(){
        return produtosRepository.findAllByQuantidade(0);
    }





}
