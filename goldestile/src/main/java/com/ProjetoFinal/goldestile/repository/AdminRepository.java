package com.ProjetoFinal.goldestile.repository;
import com.ProjetoFinal.goldestile.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{

}
