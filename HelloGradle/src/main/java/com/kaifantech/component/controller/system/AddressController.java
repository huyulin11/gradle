package com.kaifantech.component.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytgrading.dao.AddressMapper;

@Controller
@RequestMapping("/sys/address/")
public class AddressController {
	@Autowired
	AddressMapper addrMapper;

	@RequestMapping("{countryid}/{provinceid}/{cityid}.shtml")
	@ResponseBody
	public List getAddress(@PathVariable("countryid") String countryid,
			@PathVariable("provinceid") String provinceid,
			@PathVariable("cityid") String cityid) {
		return addrMapper.selectCountry();
	}

	@RequestMapping("getCountryList")
	@ResponseBody
	public List getCountryList() {
		return addrMapper.selectCountry();
	}

	@RequestMapping("getProvinceList")
	@ResponseBody
	public List getProvinceList(@RequestParam("parentid") String parentid) {
		return addrMapper.selectProvince(parentid);
	}

	@RequestMapping("getCityList")
	@ResponseBody
	public List getCityList(@RequestParam("parentid") String parentid) {
		return addrMapper.selectCity(parentid);
	}

	@RequestMapping("getDistrictList")
	@ResponseBody
	public List getDistrictList(@RequestParam("parentid") String parentid) {
		return addrMapper.selectDistrict(parentid);
	}

	@RequestMapping("searchAddr")
	@ResponseBody
	public List searchAddr(@RequestParam("keywords") String keywords) {
		return addrMapper.searchAddress(keywords);
	}
}
