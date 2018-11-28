package com.auth.sp.quartz.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.Query;
import com.auth.sp.quartz.dao.QuartzJobMapper;
import com.auth.sp.quartz.entity.QuartzJobEntity;
import com.auth.sp.quartz.manager.QuartzJobManager;

/**
 * 定时任务
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月20日 下午11:47:19
 */
@Component("quartzJobManager")
public class QuartzJobManagerImpl implements QuartzJobManager {

	@Autowired
	private QuartzJobMapper quartzJobMapper;
	
	@Override
	public List<QuartzJobEntity> listNormalJob() {
		return quartzJobMapper.list();
	}

	@Override
	public List<QuartzJobEntity> listForPage(Page<QuartzJobEntity> page, Query query) {
		return quartzJobMapper.listForPage(page, query);
	}

	@Override
	public int saveQuartzJob(QuartzJobEntity job) {
		return quartzJobMapper.save(job);
	}

	@Override
	public QuartzJobEntity getQuartzJobById(Long jobId) {
		return quartzJobMapper.getObjectById(jobId);
	}

	@Override
	public int updateQuartzJob(QuartzJobEntity job) {
		return quartzJobMapper.update(job);
	}

	@Override
	public int batchRemoveQuartzJob(Long[] id) {
		return quartzJobMapper.batchRemove(id);
	}

	@Override
	public int batchUpdate(Long[] jobId, Integer status) {
		Query query = new Query();
		query.put("jobIdList", jobId);
		query.put("status", status);
		return quartzJobMapper.batchUpdate(query);
	}

}
