package ru.kata.SecuritiApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.SecuritiApp.model.Role;
import ru.kata.SecuritiApp.repository.RoleRepositoy;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    private final RoleRepositoy roleRepositoy;


    public RoleServiceImp(RoleRepositoy roleRepositoy) {
        this.roleRepositoy = roleRepositoy;
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepositoy.findAll();
    }
}


