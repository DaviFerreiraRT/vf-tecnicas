package br.edu.uni7.vf.controller;

import br.edu.uni7.vf.model.Cliente;
import br.edu.uni7.vf.model.Produto;
import br.edu.uni7.vf.services.ClientesServices;
import br.edu.uni7.vf.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClienteController {

    private final ClientesServices service;

    @Autowired
    public ClienteController(ClientesServices service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "cliente", method = RequestMethod.POST)
    public Cliente create(@RequestBody Cliente cliente) {
        return service.create(cliente);
    }

}
