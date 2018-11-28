package com.auth.sp.common.service;

import java.util.Map;

import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.R;
import com.auth.sp.common.entity.SysLogEntity;

/**
 * 系统日志
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月14日 下午8:40:52
 */
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
