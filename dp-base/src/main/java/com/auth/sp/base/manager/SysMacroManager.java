package com.auth.sp.base.manager;

import java.util.List;

import com.auth.sp.base.entity.SysMacroEntity;

/**
 * 通用字典
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月15日 下午12:49:14
 */
public interface SysMacroManager {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	int saveMacro(SysMacroEntity macro);
	
	SysMacroEntity getObjectById(Long id);
	
	int updateMacro(SysMacroEntity macro);
	
	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);

	List<SysMacroEntity> listMacroValue(String type);
	
}
