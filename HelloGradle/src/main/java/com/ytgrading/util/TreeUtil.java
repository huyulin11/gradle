package com.ytgrading.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeUtil {

	public List<TreeObject> getChildTreeObjects(List<TreeObject> list, int praentId) {
		List<TreeObject> returnList = new ArrayList<TreeObject>();
		for (TreeObject t : list) {
			if (t.getParentId() == praentId) {
				recursionFn(list, t);
				returnList.add(t);
			}
		}
		return returnList;
	}

	private void recursionFn(List<TreeObject> list, TreeObject t) {
		List<TreeObject> childList = getChildList(list, t);
		t.setChildren(childList);
		for (TreeObject tChild : childList) {
			if (hasChild(list, tChild)) {
				Iterator<TreeObject> it = childList.iterator();
				while (it.hasNext()) {
					TreeObject n = (TreeObject) it.next();
					recursionFn(list, n);
				}
			}
		}
	}

	private List<TreeObject> getChildList(List<TreeObject> list, TreeObject t) {
		List<TreeObject> tlist = new ArrayList<TreeObject>();
		Iterator<TreeObject> it = list.iterator();
		while (it.hasNext()) {
			TreeObject n = (TreeObject) it.next();
			if (n.getParentId().equals(t.getId())) {
				tlist.add(n);
			}
		}
		return tlist;
	}

	List<TreeObject> returnList = new ArrayList<TreeObject>();

	public List<TreeObject> getChildTreeObjects(List<TreeObject> list, int typeId, String prefix) {
		if (list == null)
			return null;
		for (Iterator<TreeObject> iterator = list.iterator(); iterator.hasNext();) {
			TreeObject node = (TreeObject) iterator.next();
			if (node.getParentId() == typeId) {
				recursionFn(list, node, prefix);
			}
		}
		return returnList;
	}

	private void recursionFn(List<TreeObject> list, TreeObject node, String p) {
		List<TreeObject> childList = getChildList(list, node);
		if (hasChild(list, node)) {
			returnList.add(node);
			Iterator<TreeObject> it = childList.iterator();
			while (it.hasNext()) {
				TreeObject n = (TreeObject) it.next();
				n.setName(p + n.getName());
				recursionFn(list, n, p + p);
			}
		} else {
			returnList.add(node);
		}
	}

	private boolean hasChild(List<TreeObject> list, TreeObject t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}
}
