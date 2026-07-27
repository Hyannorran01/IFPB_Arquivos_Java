package com.ProjetoFinal.goldestile.service;

import com.ProjetoFinal.goldestile.model.Admin;
import com.ProjetoFinal.goldestile.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    @Autowired
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Iterable<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(int id) {
        return adminRepository.findById(id).get();
    }

    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    public void delete(int id) {
        adminRepository.deleteById(id);
    }
}
