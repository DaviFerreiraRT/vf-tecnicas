package br.edu.uni7.vf.controller;

import br.edu.uni7.vf.model.Produto;
import br.edu.uni7.vf.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutoController {


    private final ProdutosServices service;

    @Autowired
    public ProdutoController(ProdutosServices service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "produto", method = RequestMethod.POST)
    public Produto create(@RequestBody Produto produto) {
        return service.create(produto);
    }

    @ResponseBody
    @RequestMapping(value = "produto/{codBarra}",method = RequestMethod.GET)
    public Produto findByCodBarras(@PathVariable Integer codBarra){
        return service.findByCodBarras(codBarra);
    }


    @ResponseBody
    @RequestMapping(value = "produto/{codBarra}",method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer codBarra){
        service.delete(codBarra);
    }

    @ResponseBody
    @RequestMapping(value = "produto/{id}", method = RequestMethod.PUT)
    public Produto update(@PathVariable Integer id, @RequestBody Produto produto) {
        produto.setId(id);
        return service.update(id,produto);
    }
    @ResponseBody
    @RequestMapping(value = "produto/codBarra/{codBarra}", method = RequestMethod.GET)
    public List<Produto> findAllByCodigoDeBarra(@PathVariable String codBarra){
        return service.findAllByCodBarra(codBarra);
    }

    @ResponseBody
    @RequestMapping(value = "produto", method = RequestMethod.GET)
    public List<Produto> findAllProdutos(){
        return service.findAllProdutos();
    }

    @ResponseBody
    @RequestMapping(value = "produto/categoria/{categoria}", method = RequestMethod.GET)
    public List<Produto> findAllByCategoria(@PathVariable String categoria){
        return service.findAllByCategoria(categoria.toLowerCase());
    }

    @ResponseBody
    @RequestMapping(value = "produto/faltando", method = RequestMethod.GET)
    public List<Produto> findAllByQuantidadeZero(){
        return service.findAllByQuantidadeZero();
    }


}
