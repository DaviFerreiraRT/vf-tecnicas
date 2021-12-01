package br.edu.uni7.vf.services;


import br.edu.uni7.vf.model.Cliente;
import br.edu.uni7.vf.model.Produto;
import br.edu.uni7.vf.repository.ClienteRepository;
import br.edu.uni7.vf.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServices {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClientesServices(ClienteRepository cliente){
        this.clienteRepository = cliente;
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
}
