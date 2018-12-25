package com.kaifantech.component.service.led;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.led.LedDevInfoBean;
import com.kaifantech.bean.wms.alloc.AllocColumnInfoBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.dao.alloc.AllocColumnDao;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.dao.led.LedDevInfoDao;
import com.listenvision.led;

@Service
public class LedDevInfoService {
	@Autowired
	private AllocColumnDao allocColumnDao;

	@Autowired
	private LedDevInfoDao ledDevInfoDao;

	@Autowired
	private AllocItemDao allocItemDao;

	private static final int ITEM_NUM = 16;
	private static final int LED_WIDTH = ITEM_NUM * 2 * 4;
	private static final int LED_HEIGHT = ITEM_NUM * 1;

	public void sendToAll() {

		for (AllocColumnInfoBean columnBean : allocColumnDao.getAllAllocationColumnInfoBean()) {
			int totalNum = 0;
			for (AllocItemInfoBean allocItemBean : allocItemDao.getAllAllocationInfoBean(columnBean.getAreaId(),
					columnBean.getColId())) {
				totalNum = totalNum + (allocItemBean.getNum() != null ? allocItemBean.getNum() : 0);
			}
			send(columnBean.getColumnId(), "库存数量：" + totalNum);
		}
	}

	public void send(Integer columnId, String content) {
		LedDevInfoBean ledDevInfoBean = ledDevInfoDao.getLedDevInfoBean(columnId);

		if (ledDevInfoBean == null) {
			return;
		}

		int hProgram = led.CreateProgram(LED_WIDTH, LED_HEIGHT, 1);
		led.AddProgram(hProgram, 1, 0, 1);
		led.AddImageTextArea(hProgram, 1, 1, 0, 0, LED_WIDTH, LED_HEIGHT, 1);
		led.AddSinglelineTextToImageTextArea(hProgram, 1, 1, 0, content, "宋体", 12, 0xff, 0, 0, 0, 0, 4, 2);

		led.NetWorkSend(ledDevInfoBean.getIp(), hProgram);
		led.DeleteProgram(hProgram);
	}
}
