package com.auth.sp.quartz.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.common.dao.BaseMapper;
import com.auth.sp.quartz.entity.QuartzJobLogEntity;

/**
 * 定时任务日志
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月20日 下午11:04:51
 */
@MapperScan
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {

	int batchRemoveAll();
	
}
