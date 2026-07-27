package com.ProjetoFinal.goldestile.service;


import com.ProjetoFinal.goldestile.model.Camisa;
import com.ProjetoFinal.goldestile.repository.CamisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CamisaService {
    @Autowired
    private final CamisaRepository camisaRepository;

    public CamisaService(CamisaRepository camisaRepository) {
        this.camisaRepository = camisaRepository;
    }

    public Iterable<Camisa> findAll() {
        return camisaRepository.findAll();
    }

    public Camisa findById(int id) {
        return camisaRepository.findById(id).get();
    }

    public void save(Camisa camisa) {
//        Optional<Camisa> existente = camisaRepository.findById(camisa.getID());
//        if (existente != null)
//            throw new IllegalArgumentException("Já existe um ID para essa camisa");
        camisaRepository.save(camisa);
    }

    public void delete(Camisa camisa) {
        camisaRepository.delete(camisa);
    }

    public void delete(int id) {
        camisaRepository.deleteById(id);
    }
}
