package com.auth.sp.quartz.service;

import java.util.Map;

import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.R;
import com.auth.sp.quartz.entity.QuartzJobLogEntity;

/**
 * 定时任务日志
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月21日 上午11:17:26
 */
public interface QuartzJobLogService {

	Page<QuartzJobLogEntity> listForPage(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
