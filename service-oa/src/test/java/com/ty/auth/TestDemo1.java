package com.ty.auth;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ty.auth.mapper.SysRolwMapper;
import com.ty.auth.service.SysRoleService;
import com.ty.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class TestDemo1 {


    //注入
    @Autowired
    private SysRolwMapper mapper;
    @Autowired
    private SysRoleService service;


    @Test
    public void getAll() {
        List<SysRole> sysRoles = mapper.selectList(null);
        System.out.println(sysRoles);
    }

    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("管理员");
        sysRole.setRoleCode("admin_anzu");
        sysRole.setDescription("杏子可爱");

        int rows = mapper.insert(sysRole);
    }


    @Test
    public void update() {
        SysRole sysRole1 = mapper.selectById(1);

        sysRole1.setDescription("测试修改");

        int count = mapper.updateById(sysRole1);
    }


    @Test
    public void delete() {
        SysRole sysRole1 = mapper.selectById(1);
        // @TableLogic  对应属性加了逻辑删除注解，故调用的是删除方法，实际执行的是修改操作【此注解可以自定义表示逻辑删除的字符】
        //且前面的查询的方法自动不查已经逻辑删除的数据
        mapper.deleteById(sysRole1);
        //批量删除  传入集合，用Arrays.asList方法构建集合，逻辑删除ID为1、2的数据
        mapper.deleteBatchIds(Arrays.asList(1, 2));
    }


    //条件查询
    @Test
    public void query() {
        //创建QueryWrapper对象，调用方法封装条件
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        //第一个参数是数据库的列名，不是java对象的属性名，下面就是查询role_name是test的结果
        wrapper.eq("role_name", "test");//此条查不到，输出[]因为被逻辑删除了
        List<SysRole> sysRoles = mapper.selectList(wrapper);
        System.out.println("@@@@" + sysRoles);


        QueryWrapper<SysRole> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("description", "杏子可爱");
        List<SysRole> sysRoles2 = mapper.selectList(wrapper2);
        System.out.println("####" + sysRoles2);
    }

    //条件查询2
    //lambda写法
    @Test
    public void query2() {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper();
        wrapper.eq(SysRole::getDescription, "杏子可爱");
        List<SysRole> sysRoles = mapper.selectList(wrapper);
        System.out.println("####" + sysRoles);
    }


    //测试封装的service
    @Test
    public void testService() {
        //查全部（因为加了注解故不含逻辑删除的数据）
        List<SysRole> list = service.list();
        System.out.println(list);


        //新增
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员2");
        sysRole.setRoleCode("admin_ty");
        sysRole.setDescription("角色管理员2");

        boolean result = service.save(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole); //id自动回填


        //更新
        SysRole sysRole2 = new SysRole();
        sysRole2.setId(1L);
        sysRole2.setRoleName("角色管理员1");

        boolean result2 = service.updateById(sysRole2);
        System.out.println(result2);


        //删除（因为加了注解，所以是逻辑删）
        boolean result3 = service.removeById(1L);
        System.out.println(result3);


        //条件查询
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(SysRole::getRoleCode, "1");
        List<SysRole> users = service.list(queryWrapper);
        System.out.println(users);
    }

}
