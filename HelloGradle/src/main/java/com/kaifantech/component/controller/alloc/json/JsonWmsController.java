package com.kaifantech.component.controller.alloc.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.kaifantech.bean.taskexe.SkuInfoBean;
import com.kaifantech.bean.wms.alloc.AllocationAreaInfoBean;
import com.kaifantech.bean.wms.sku.SkuTypeBean;
import com.kaifantech.component.dao.LapDao;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.service.alloc.amount.IAllocAmountService;
import com.kaifantech.component.service.alloc.area.AllocAreaService;
import com.kaifantech.component.service.alloc.column.IAllocColumnService;
import com.kaifantech.component.service.alloc.status.IAllocStatusMgrService;
import com.kaifantech.component.service.sku.SkuInfoService;

@Controller
@RequestMapping("/json/wms/")
public class JsonWmsController {

	@Autowired
	private IAllocColumnService allocColumnService;

	@Autowired
	private AllocItemDao allocDao;

	@Autowired
	private IAllocAmountService allocOpService;

	@Autowired
	private IAllocStatusMgrService allocStatusMgrService;

	@Autowired
	private SkuInfoService skuInfoService;

	@Autowired
	private LapDao lapDao;

	@Autowired
	private AllocAreaService allocAreaService;

	@RequestMapping("getAreaList")
	@ResponseBody
	public Object getAreaList() {
		try {
			List<AllocationAreaInfoBean> object = allocAreaService.getAllocationAreaInfoBeanListForShow();
			System.out.println(object);
			return JSONArray.toJSON(object);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("getAllAllocationInfo")
	@ResponseBody
	public Object getAllAllocationInfo(Integer areaId) {
		return JSONArray.toJSON(allocDao.getAllAllocationInfoToShow(areaId));
	}

	@RequestMapping("getAllocColumn")
	@ResponseBody
	public Object getAllocColumn(Integer areaId) {
		return JSONArray.toJSON(allocColumnService.getListShowBy(areaId));
	}

	@RequestMapping("clearAllocByColId")
	@ResponseBody
	public String clearAllocByColId(Integer areaId, Integer colId, Integer minRowId, Integer minZId) {
		return "更新货位数：" + allocStatusMgrService.clearAllocByColId(areaId, colId, minRowId, minZId);
	}

	@RequestMapping("doChangeNum")
	@ResponseBody
	public String doChangeNum(Integer allocItemId, Integer skuId, Integer num) {
		return allocOpService.changeAllocNum(allocItemId, skuId, num);
	}

	@RequestMapping("getSkuInfo")
	@ResponseBody
	public Object getSkuInfo() {
		try {
			List<SkuInfoBean> skuInfoList = skuInfoService.getSkuInfoBeanList();
			List<SkuTypeBean> skuTypeList = skuInfoService.getSkuTypeBeanList();
			Map<String, Object> map = new HashMap<>();
			map.put("skuInfo", skuInfoList);
			map.put("skuType", skuTypeList);
			return JSONArray.toJSON(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("changeSku")
	@ResponseBody
	public int changeSku(Integer lapId, Integer skuId) {
		return lapDao.updateLap(lapId, skuId);
	}

}
