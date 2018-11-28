package com.auth.sp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.common.dao.BaseMapper;
import com.auth.sp.shiro.entity.SysUserRoleEntity;

/**
 * 用户与角色关系
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月13日 上午1:01:55
 */
@MapperScan
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

	List<Long> listUserRoleId(Long userId);
	
	int batchRemoveByUserId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
}
