package com.auth.sp.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth.sp.common.entity.SysUserEntity;
import com.auth.sp.common.utils.ShiroUtils;

/**
 * Controller公共组件
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月8日 下午2:43:23
 */
public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
	
}
