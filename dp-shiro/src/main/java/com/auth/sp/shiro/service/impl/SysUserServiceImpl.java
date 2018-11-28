package com.auth.sp.shiro.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.Query;
import com.auth.sp.common.entity.R;
import com.auth.sp.common.entity.SysUserEntity;
import com.auth.sp.common.utils.CommonUtils;
import com.auth.sp.common.utils.MD5Utils;
import com.auth.sp.shiro.manager.SysUserManager;
import com.auth.sp.shiro.service.SysUserService;

/**
 * 系统用户
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月11日 上午11:47:17
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserManager sysUserManager;
	
	@Override
	public Page<SysUserEntity> listUser(Map<String, Object> params) {
		Query form = new Query(params);
		Page<SysUserEntity> page = new Page<>(form);
		sysUserManager.listUser(page, form);
		return page;
	}

	@Override
	public R saveUser(SysUserEntity user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		int count = sysUserManager.saveUser(user);
		return CommonUtils.msg(count);
	}

	@Override
	public R getUserById(Long userId) {
		SysUserEntity user = sysUserManager.getById(userId);
		return CommonUtils.msg(user);
	}

	@Override
	public R updateUser(SysUserEntity user) {
		int count = sysUserManager.updateUser(user);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysUserManager.batchRemove(id);
		return CommonUtils.msg(count);
	}

	@Override
	public R listUserPerms(Long userId) {
		Set<String> perms = sysUserManager.listUserPerms(userId);
		return CommonUtils.msgNotCheckNull(perms);
	}

	@Override
	public R updatePswdByUser(SysUserEntity user) {
		String username = user.getUsername();
		String pswd = user.getPassword();
		String newPswd = user.getEmail();
		pswd = MD5Utils.encrypt(username, pswd);
		newPswd = MD5Utils.encrypt(username, newPswd);
		Query query = new Query();
		query.put("userId", user.getUserId());
		query.put("pswd", pswd);
		query.put("newPswd", newPswd);
		int count = sysUserManager.updatePswdByUser(query);
		if(!CommonUtils.isIntThanZero(count)) {
			return R.error("原密码错误");
		}
		return CommonUtils.msg(count);
	}

	@Override
	public R updateUserEnable(Long[] id) {
		int count = sysUserManager.updateUserEnable(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R updateUserDisable(Long[] id) {
		int count = sysUserManager.updateUserDisable(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R updatePswd(SysUserEntity user) {
		SysUserEntity currUser = sysUserManager.getUserById(user.getUserId());
		user.setPassword(MD5Utils.encrypt(currUser.getUsername(), user.getPassword()));
		int count = sysUserManager.updatePswd(user);
		return CommonUtils.msg(count);
	}

}
