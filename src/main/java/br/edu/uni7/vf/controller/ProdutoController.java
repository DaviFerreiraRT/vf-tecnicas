package br.edu.uni7.vf.controller;

import br.edu.uni7.vf.model.Produto;
import br.edu.uni7.vf.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
