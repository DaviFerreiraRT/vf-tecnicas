package br.edu.uni7.vf.controller;

import br.edu.uni7.vf.model.Cliente;
import br.edu.uni7.vf.model.Produto;
import br.edu.uni7.vf.services.ClientesServices;
import br.edu.uni7.vf.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseBody
    @RequestMapping(value = "cliente", method = RequestMethod.GET)
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "cliente/{id}", method = RequestMethod.GET)
    public Cliente findById(@PathVariable Integer id){
        return service.findById(id);
    }
    @ResponseBody
    @RequestMapping(value = "cliente/cpf/{cpf}",method = RequestMethod.GET)
    public Cliente findByCPF(@PathVariable String cpf){
        return service.findByCpf(cpf);
    }

    @ResponseBody
    @RequestMapping(value = "cliente/{id}",method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
             service.delete(id);
    }



}
