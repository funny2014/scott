package com.auth.sp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.common.dao.BaseMapper;
import com.auth.sp.shiro.entity.SysRoleMenuEntity;

/**
 * 系统角色与菜单关系
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月13日 下午8:32:26
 */
@MapperScan
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	int batchRemoveByMenuId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
	List<Long> listMenuId(Long id);
	
}
