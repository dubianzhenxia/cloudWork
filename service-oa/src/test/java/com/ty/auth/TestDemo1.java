package com.ty.auth;


import com.ty.auth.mapper.SysRolwMapper;
import com.ty.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestDemo1 {


    //注入
    @Autowired
  private SysRolwMapper mapper;


    @Test
    public void getAll(){
        List<SysRole> sysRoles = mapper.selectList(null);
        System.out.println(sysRoles);
    }
}
