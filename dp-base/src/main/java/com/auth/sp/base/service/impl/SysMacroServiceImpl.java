package com.auth.sp.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.sp.base.entity.SysMacroEntity;
import com.auth.sp.base.manager.SysMacroManager;
import com.auth.sp.base.service.SysMacroService;
import com.auth.sp.common.constant.MsgConstant;
import com.auth.sp.common.constant.SystemConstant.MacroType;
import com.auth.sp.common.constant.SystemConstant.StatusType;
import com.auth.sp.common.entity.R;
import com.auth.sp.common.utils.CommonUtils;

/**
 * 通用字典
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月15日 下午12:52:38
 */
@Service("sysMacroService")
public class SysMacroServiceImpl implements SysMacroService {

	@Autowired
	private SysMacroManager sysMacroManager;
	
	@Override
	public List<SysMacroEntity> listMacro() {
		return sysMacroManager.listMacro();
	}

	@Override
	public List<SysMacroEntity> listNotMacro() {
		List<SysMacroEntity> macros = sysMacroManager.listNotMacro();
		SysMacroEntity macro = new SysMacroEntity();
		macro.setMacroId(0L);
		macro.setTypeId(-1L);
		macro.setName("一级目录");
		macro.setOpen(true);
		macros.add(macro);
		return macros;
	}

	@Override
	public R saveMacro(SysMacroEntity macro) {
		int count = sysMacroManager.saveMacro(validateMacro(macro));
		return CommonUtils.msg(count);
	}

	@Override
	public R getObjectById(Long id) {
		SysMacroEntity macro = sysMacroManager.getObjectById(id);
		return CommonUtils.msg(macro);
	}

	@Override
	public R updateMacro(SysMacroEntity macro) {
		int count = sysMacroManager.updateMacro(macro);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		boolean children = sysMacroManager.hasChildren(id);
		if(children) {
			return R.error(MsgConstant.MSG_HAS_CHILD);
		}
		int count = sysMacroManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public List<SysMacroEntity> listMacroValue(String type) {
		return sysMacroManager.listMacroValue(type);
	}

	/**
	 * 当为参数类型时，状态为显示
	 * @param macro
	 * @return
	 */
	public SysMacroEntity validateMacro(SysMacroEntity macro) {
		if(macro.getType() == MacroType.TYPE.getValue()) {
			macro.setStatus(StatusType.SHOW.getValue());
		}
		return macro;
	}

}
