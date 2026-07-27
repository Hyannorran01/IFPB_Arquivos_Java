package com.ProjetoFinal.goldestile.repository;


import com.ProjetoFinal.goldestile.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
