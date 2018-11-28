package com.auth.sp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.common.dao.BaseMapper;
import com.auth.sp.shiro.entity.SysMenuEntity;

/**
 * 系统菜单dao
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月10日 上午12:21:34
 */
@MapperScan
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
	
	List<SysMenuEntity> listParentId(Long parentId);
	
	List<SysMenuEntity> listNotButton();
	
	List<String> listUserPerms(Long userId);
	
	int countMenuChildren(Long parentId);

}
