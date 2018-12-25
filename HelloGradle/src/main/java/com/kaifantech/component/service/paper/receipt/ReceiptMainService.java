package com.kaifantech.component.service.paper.receipt;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.receipt.ReceiptDetailBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptMainBean;
import com.kaifantech.component.service.paper.base.AbstractWmsPaperMainService;
import com.kaifantech.entity.ReceiptMainFormMap;
import com.kaifantech.mappings.base.WmsPaperMainMapper;
import com.kaifantech.mappings.receipt.ReceiptMainMapper;
import com.ytgrading.util.FormMap;

@Service
public class ReceiptMainService extends AbstractWmsPaperMainService<ReceiptDetailBean, ReceiptMainBean, ReceiptMainFormMap> {
	@Inject
	private ReceiptMainMapper mapper;

	@Autowired
	private ReceiptDetailService receiptDetailService;

	@Override
	public WmsPaperMainMapper<ReceiptDetailBean, ReceiptMainBean, ReceiptMainFormMap> getMapper() {
		return mapper;
	}

	@Override
	public FormMap<String, Object> createFormMap() {
		return new ReceiptMainFormMap();
	}

	@Override
	public ReceiptMainBean createMainObj() {
		return new ReceiptMainBean();
	}

	@Override
	public List<ReceiptDetailBean> findDetailsByPaperid(String paperid) {
		return receiptDetailService.findByPaperid(paperid);
	}

}