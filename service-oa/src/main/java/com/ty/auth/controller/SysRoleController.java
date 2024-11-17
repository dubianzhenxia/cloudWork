package com.ty.auth.controller;


import com.ty.auth.service.SysRoleService;
import com.ty.model.system.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ty.common.result.Result;

import java.util.List;
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService service;

    //查询所有角色
    //@RequestMapping("/findAll")
    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll(){
        return Result.ok(service.list());
    }
}
