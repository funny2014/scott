package com.auth.sp.shiro.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.sp.common.annotation.SysLog;
import com.auth.sp.common.constant.SystemConstant;
import com.auth.sp.common.controller.AbstractController;
import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.R;
import com.auth.sp.shiro.entity.SysRoleEntity;
import com.auth.sp.shiro.service.SysRoleService;

/**
 * 系统角色
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月12日 上午12:43:10
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysRoleEntity> list(@RequestBody Map<String, Object> params) {
		if(getUserId() != SystemConstant.SUPER_ADMIN) {
			params.put("userIdCreate", getUserId());
		}
		return sysRoleService.listRole(params);
	}
	
	/**
	 * 用户角色
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysRoleEntity> listRole() {
		return sysRoleService.listRole();
	}
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	@SysLog("新增角色")
	@RequestMapping("/save")
	public R saveRole(@RequestBody SysRoleEntity role) {
		role.setUserIdCreate(getUserId());
		return sysRoleService.saveRole(role);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getRoleById(@RequestBody Long id) {
		return sysRoleService.getRoleById(id);
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@SysLog("修改角色")
	@RequestMapping("/update")
	public R updateRole(@RequestBody SysRoleEntity role) {
		return sysRoleService.updateRole(role);
	}
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	@SysLog("删除角色")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return sysRoleService.batchRemove(id);
	}
	
	/**
	 * 分配权限
	 * @param role
	 * @return
	 */
	@SysLog("分配权限")
	@RequestMapping("/authorize")
	public R updateRoleAuthorization(@RequestBody SysRoleEntity role) {
		return sysRoleService.updateRoleAuthorization(role);
	}
	
}