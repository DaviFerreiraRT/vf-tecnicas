package br.edu.uni7.vf.services;

import br.edu.uni7.vf.exceptions.ClienteDesconhecido;
import br.edu.uni7.vf.exceptions.QuantidadeInsuficienteException;
import br.edu.uni7.vf.model.Cliente;
import br.edu.uni7.vf.model.Compra;
import br.edu.uni7.vf.model.Produto;
import br.edu.uni7.vf.repository.ClienteRepository;
import br.edu.uni7.vf.repository.ComprasRepository;
import br.edu.uni7.vf.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprasServices {
    private final ComprasRepository compraRepository;
    private final ProdutosRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ComprasServices(ComprasRepository compraRepository, ProdutosRepository produtoRepository, ClienteRepository clienteRepository) {
        this.compraRepository = compraRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Compra> list() {
        return compraRepository.findAll();
    }

    public Compra findById(Integer id) {
        return compraRepository.findById(id).get();
    }

    public Compra create(Compra compra) {
        double valorTotal = 0;

        Cliente clienteBD = clienteRepository.findByCpf(compra.getCpfCliente());
        if (clienteBD == null) {
            throw new ClienteDesconhecido();
        }
        List<Produto> produtos = compra.getProdutos();
        if (produtos != null) {
            for (Produto produto : produtos) {
                Produto produtoDB = produtoRepository.findById(produto.getId()).get();
                if (produtoDB.getQuantidade() < produto.getQuantidade()) {
                    throw new QuantidadeInsuficienteException();
                } else {
                    valorTotal = valorTotal + (produtoDB.getPreco() * produto.getQuantidade());
                    produtoDB.setQuantidade(produtoDB.getQuantidade() - produto.getQuantidade());
                }
            }
        }
        System.out.println(compra.getCpfCliente());
        System.out.print(compra.getProdutos().get(0).getMarca());
        compra.setValor(valorTotal);
        clienteBD.setTotalGasto(clienteBD.getTotalGasto() + valorTotal);
        return compraRepository.save(compra);

    }

    public Compra update(Compra compra) {
        compraRepository.save(compra);
        return compra;
    }

    public void remove(Integer id) {
        compraRepository.deleteById(id);
    }

    public List<Compra> findAllByCpfCliente(String cpfCliente) {
        return compraRepository.findAllByCpfCliente(cpfCliente);
    }
}
