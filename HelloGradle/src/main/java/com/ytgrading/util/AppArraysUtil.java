package com.ytgrading.util;

import java.util.ArrayList;

public class AppArraysUtil {
	@SuppressWarnings("unchecked")
	/** 泛型转换成数组时尚有问题 */
	public static <T> T[] addInFirst(T[] cmds, T... elements) {
		ArrayList<T> list = new ArrayList<>();
		for (T element : elements) {
			list.add(element);
		}
		for (T cmd : cmds) {
			list.add(cmd);
		}
		if (elements[0] instanceof String) {
			String[] newCmds = new String[list.size()];
			return (T[]) list.toArray(newCmds);
		}
		T[] newCmds = (T[]) new Object[list.size()];
		return list.toArray(newCmds);
	}

	public static final void main(String[] args) {
		String[] ll = { "hh" };
		String[] l2 = AppArraysUtil.addInFirst(ll, "dd");
		System.out.println(l2);
	}
}
