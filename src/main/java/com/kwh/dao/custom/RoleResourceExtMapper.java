package com.kwh.dao.custom;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RoleResourceExtMapper {

	List<Map<String,String>> getRoleResources(@Param(value = "roleId") String roleId);

	List<Map<String,String>> getRoleNotAllowResources(@Param(value = "roleId") String roleId);
}
