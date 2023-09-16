package com.ty.auth.controller;


import com.ty.auth.service.SysRoleService;
import com.ty.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService service;

    //查询所有角色
    //@RequestMapping("/findAll")
    @GetMapping("/findAll")
    public List<SysRole> findAll(){
        return service.list();
    }
}
