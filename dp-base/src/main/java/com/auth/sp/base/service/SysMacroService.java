package com.auth.sp.base.service;

import java.util.List;

import com.auth.sp.base.entity.SysMacroEntity;
import com.auth.sp.common.entity.R;

/**
 * 通用字典
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月15日 下午12:51:35
 */
public interface SysMacroService {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	R saveMacro(SysMacroEntity macro);
	
	R getObjectById(Long id);
	
	R updateMacro(SysMacroEntity macro);
	
	R batchRemove(Long[] id);

	List<SysMacroEntity> listMacroValue(String type);
	
}
