package com.auth.sp.quartz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.sp.common.annotation.SysLog;
import com.auth.sp.common.entity.Page;
import com.auth.sp.common.entity.R;
import com.auth.sp.quartz.entity.QuartzJobLogEntity;
import com.auth.sp.quartz.service.QuartzJobLogService;

/**
 * 定时任务日志
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月21日 上午11:48:14
 */
@RestController
@RequestMapping("/quartz/job/log")
public class QuartzJobLogController {

	@Autowired
	private QuartzJobLogService quartzJobLogService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<QuartzJobLogEntity> list(@RequestBody Map<String, Object> params) {
		return quartzJobLogService.listForPage(params);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除定时任务日志")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return quartzJobLogService.batchRemove(id);
	}
	
	/**
	 * 清空
	 * @return
	 */
	@SysLog("清空定时任务日志")
	@RequestMapping("/clear")
	public R batchRemoveAll() {
		return quartzJobLogService.batchRemoveAll();
	}
	
}
