package com.auth.sp.common.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.common.entity.SysLogEntity;

/**
 * 系统日志 
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月14日 下午8:19:01
 */
@MapperScan
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	int batchRemoveAll();
	
}
