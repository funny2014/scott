package com.auth.sp.quartz.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.common.dao.BaseMapper;
import com.auth.sp.quartz.entity.QuartzJobEntity;

/**
 * 定时任务
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月20日 下午11:19:55
 */
@MapperScan
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
