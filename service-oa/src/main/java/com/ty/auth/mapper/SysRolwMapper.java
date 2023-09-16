package com.ty.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ty.model.system.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper  或者启动类加  @MapperScan("com.ty.auth.mapper")
public interface SysRolwMapper extends BaseMapper<SysRole> {
}
