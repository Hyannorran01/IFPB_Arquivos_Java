package com.ProjetoFinal.goldestile.repository;
import com.ProjetoFinal.goldestile.model.Camisa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamisaRepository extends CrudRepository<Camisa,Integer>{
}
