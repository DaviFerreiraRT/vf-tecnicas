package br.edu.uni7.vf.services;


import br.edu.uni7.vf.model.Cliente;
import br.edu.uni7.vf.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServices {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClientesServices(ClienteRepository cliente){
        this.clienteRepository = cliente;
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
    public Cliente create (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public void delete(Integer codDeBarra){
        clienteRepository.deleteById(codDeBarra);
    }
    public Cliente update(Cliente cliente){
        return clienteRepository.save(cliente);

    }
    public Cliente findByCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }
    public Cliente findById(Integer id){
        return clienteRepository.findById(id).get();
    }
}
