package com.ProjetoFinal.goldestile.service;

import com.ProjetoFinal.goldestile.model.Cliente;
import com.ProjetoFinal.goldestile.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(int id) {
        return clienteRepository.findById(id).get();
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public void delete(int id) {
        clienteRepository.deleteById(id);
    }
}
