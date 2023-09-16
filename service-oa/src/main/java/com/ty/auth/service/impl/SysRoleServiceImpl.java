package com.ty.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ty.auth.mapper.SysRolwMapper;
import com.ty.auth.service.SysRoleService;
import com.ty.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//实现类除了需实现接口外，还需继承封装的ServiceImpl类，第一个泛型是操作对象的mapper，第二个泛型为操作对象
public class SysRoleServiceImpl extends ServiceImpl<SysRolwMapper, SysRole> implements SysRoleService {


    //原来像下面这样在service中注入mapper不需要了，ServiceImpl已经注入了【取名baseMapper】，54行
//    @Autowired
//   private SysRolwMapper sysRolwMapper;


}
