package com.auth.sp.common.manager;

import java.util.List;

import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.Query;
import com.auth.sp.common.entity.SysLogEntity;

/**
 * 系统日志
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月14日 下午8:43:06
 */
public interface SysLogManager {

	void saveLog(SysLogEntity log);
	
	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
