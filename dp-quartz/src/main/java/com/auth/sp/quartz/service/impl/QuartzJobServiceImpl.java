package com.auth.sp.quartz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.sp.common.constant.SystemConstant.ScheduleStatus;
import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.Query;
import com.auth.sp.common.entity.R;
import com.auth.sp.common.utils.CommonUtils;
import com.auth.sp.quartz.entity.QuartzJobEntity;
import com.auth.sp.quartz.manager.QuartzJobManager;
import com.auth.sp.quartz.service.QuartzJobService;
import com.auth.sp.quartz.utils.ScheduleUtils;

/**
 * 定时任务
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月20日 下午11:49:18
 */
@Service("quartzJobService")
public class QuartzJobServiceImpl implements QuartzJobService {
	
	@Autowired
	private QuartzJobManager quartzJobManager;
	
	/**
	 * 项目启动，初始化任务
	 */
	@PostConstruct
	public void init() {
		List<QuartzJobEntity> jobList = quartzJobManager.listNormalJob();
		for(QuartzJobEntity job : jobList) {
			CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(job.getJobId());
            //如果不存在，则创建
            if(cronTrigger == null) {
                ScheduleUtils.createScheduleJob(job);
            }else {
                ScheduleUtils.updateScheduleJob(job);
            }
		}
	}

	@Override
	public Page<QuartzJobEntity> list(Map<String, Object> params) {
		Query query = new Query(params);
		Page<QuartzJobEntity> page = new Page<>(query);
		quartzJobManager.listForPage(page, query);
		return page;
	}

	@Override
	public R saveQuartzJob(QuartzJobEntity job) {
		job.setStatus(ScheduleStatus.NORMAL.getValue());
		int count = quartzJobManager.saveQuartzJob(job);
		ScheduleUtils.createScheduleJob(job);
		return CommonUtils.msg(count);
	}

	@Override
	public R getQuartzJobById(Long jobId) {
		QuartzJobEntity job = quartzJobManager.getQuartzJobById(jobId);
		return CommonUtils.msg(job);
	}

	@Override
	public R updateQuartzJob(QuartzJobEntity job) {
		int count = quartzJobManager.updateQuartzJob(job);
		ScheduleUtils.updateScheduleJob(job);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemoveQuartzJob(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.deleteScheduleJob(jobId);
		}
		int count = quartzJobManager.batchRemoveQuartzJob(id);
		return CommonUtils.msg(id, count);
	}
	
	@Override
	public R run(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.run(quartzJobManager.getQuartzJobById(jobId));
		}
		return CommonUtils.msg(1);
	}
	
	@Override
	public R pause(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.pauseJob(jobId);
		}
		int count = quartzJobManager.batchUpdate(id, ScheduleStatus.PAUSE.getValue());
		return CommonUtils.msg(id, count);
	}
	
	@Override
	public R resume(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.resumeJob(jobId);
		}
		int count = quartzJobManager.batchUpdate(id, ScheduleStatus.NORMAL.getValue());
		return CommonUtils.msg(id, count);
	}

}
