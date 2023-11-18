package com.ptsports.myproject.Service.IMPL;


import com.ptsports.myproject.Entity.Role;
import com.ptsports.myproject.Repository.RoleRepo;
import com.ptsports.myproject.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepo roleRepo;
    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
}
