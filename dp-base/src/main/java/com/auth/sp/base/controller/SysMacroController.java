package com.auth.sp.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.sp.base.entity.SysMacroEntity;
import com.auth.sp.base.service.SysMacroService;
import com.auth.sp.common.annotation.SysLog;
import com.auth.sp.common.controller.AbstractController;
import com.auth.sp.common.entity.R;

/**
 * 通用字典
 *
 * @author Mr.薛
 * @email 1877****1110@163.com
 * @url https://gitee.com/ascott/
 * @date 2017年8月15日 下午12:54:33
 */
@RestController
@RequestMapping("/sys/macro")
public class SysMacroController extends AbstractController {

	@Autowired
	private SysMacroService sysMacroService;
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<SysMacroEntity> list() {
		return sysMacroService.listMacro();
	}
	
	/**
	 * 树形列表
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysMacroEntity> select() {
		return sysMacroService.listNotMacro();
	}
	
	/**
	 * 新增字典
	 * @param macro
	 * @return
	 */
	@SysLog("新增字典")
	@RequestMapping("/save")
	public R save(@RequestBody SysMacroEntity macro) {
		return sysMacroService.saveMacro(macro);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return sysMacroService.getObjectById(id);
	}
	
	/**
	 * 修改字典
	 * @param macro
	 * @return
	 */
	@SysLog("修改字典")
	@RequestMapping("/update")
	public R update(@RequestBody SysMacroEntity macro) {
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 显示字典
	 * @param id
	 * @return
	 */
	@SysLog("显示字典")
	@RequestMapping("/enable")
	public R updateStateShow(@RequestBody Long id) {
		SysMacroEntity macro = new SysMacroEntity();
		macro.setMacroId(id);
		macro.setStatus(1);
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 隐藏字典
	 * @param id
	 * @return
	 */
	@SysLog("隐藏字典")
	@RequestMapping("/disable")
	public R updateStateHide(@RequestBody Long id) {
		SysMacroEntity macro = new SysMacroEntity();
		macro.setMacroId(id);
		macro.setStatus(0);
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 删除字典
	 * @param id
	 * @return
	 */
	@SysLog("删除字典")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return sysMacroService.batchRemove(id);
	}

	/**
	 * 获取某个类型所有参数值，用于前台构建下拉框
	 * @param value
	 * @return
	 */
	@RequestMapping("/value")
	public List<SysMacroEntity> listMacroValue(@RequestParam String value) {
		return sysMacroService.listMacroValue(value);
	}
	
}
