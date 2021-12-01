package br.edu.uni7.vf.repository;


import br.edu.uni7.vf.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Integer> {
}
