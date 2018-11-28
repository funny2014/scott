package com.auth.sp.base.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.base.entity.SysAreaEntity;
import com.auth.sp.common.dao.BaseMapper;
import com.auth.sp.common.entity.Query;

/**
 * 行政区域
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月18日 下午3:36:04
 */
@MapperScan
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int countAreaChildren(Long areaId);
	
}
