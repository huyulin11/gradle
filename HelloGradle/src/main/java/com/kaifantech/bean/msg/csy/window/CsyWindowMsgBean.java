package com.kaifantech.bean.msg.csy.window;

import java.util.ArrayList;
import java.util.List;

import com.kaifantech.util.hex.AppByteUtil;
import com.ytgrading.util.AppTool;

public class CsyWindowMsgBean {
	private String str;

	public CsyWindowMsgBean(String str) {
		setStr(str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getLayers() {
		if (AppTool.isNull(getStr()) || getStr().length() != 4) {
			return null;
		}
		int layers = AppByteUtil.hexStringToInt(getStr().substring(2, 4));
		String s = Integer.toBinaryString(layers);
		return String.format("%0" + (8) + "d", Integer.parseInt(s));
	}

	public List<String> getLayersList() {
		String layers = getLayers();
		if (AppTool.isNull(layers)) {
			return null;
		}
		List<String> layerList = new ArrayList<>();
		for (int i = 1; i <= layers.length(); i++) {
			if (layers.charAt(layers.length() - i) == '1') {
				layerList.add("" + i);
			}
		}
		return layerList;
	}

	public static void main(String[] args) {
		String bs = new CsyWindowMsgBean("0041").getLayers();
		System.out.println(bs);
	}
}
