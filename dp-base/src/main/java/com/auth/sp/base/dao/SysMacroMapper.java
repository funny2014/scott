package com.auth.sp.base.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.auth.sp.base.entity.SysMacroEntity;
import com.auth.sp.common.dao.BaseMapper;

/**
 * 通用字典
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月15日 下午12:46:31
 */
@MapperScan
public interface SysMacroMapper extends BaseMapper<SysMacroEntity> {

	List<SysMacroEntity> listNotMacro();
	
	int countMacroChildren(Long typeId);

	List<SysMacroEntity> listMacroValue(String type);
	
}
