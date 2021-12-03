package br.edu.uni7.vf.controller;

import br.edu.uni7.vf.model.Compra;
import br.edu.uni7.vf.services.ComprasServices;
import br.edu.uni7.vf.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompraController {

    private final ComprasServices service;

    @Autowired
    public CompraController(ComprasServices service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "compra", method = RequestMethod.GET)
    public List<Compra> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "compra/{id}", method = RequestMethod.GET)
    public Compra findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "compra", method = RequestMethod.POST)
    public Compra create(@RequestBody Compra compra){
        return service.create(compra);
    }

    @ResponseBody
    @RequestMapping(value = "compra/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
        service.remove(id);
    }

    @ResponseBody
    @RequestMapping(value = "compra/cpf/{cpfCliente}", method = RequestMethod.GET)
    public List<Compra> findById(@PathVariable String cpfCliente){
        return service.findAllByCpfCliente(cpfCliente);
    }
}
