package com.auth.sp.shiro.service;

import java.util.List;
import java.util.Map;

import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.R;
import com.auth.sp.shiro.entity.SysRoleEntity;

/**
 * 系统角色
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月12日 上午12:40:42
 */
public interface SysRoleService {

	Page<SysRoleEntity> listRole(Map<String, Object> params);
	
	R saveRole(SysRoleEntity role);
	
	R getRoleById(Long id);
	
	R updateRole(SysRoleEntity role);
	
	R batchRemove(Long[] id);

	List<SysRoleEntity> listRole();
	
	R updateRoleAuthorization(SysRoleEntity role);
	
}
