package com.kaifantech.component.service.paper.receipt;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.receipt.ReceiptDetailBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptMainBean;
import com.kaifantech.component.service.paper.base.AbstractWmsPaperDetailService;
import com.kaifantech.entity.ReceiptDetailFormMap;
import com.kaifantech.mappings.base.WmsPaperDetailMapper;
import com.kaifantech.mappings.receipt.ReceiptDetailMapper;
import com.ytgrading.util.FormMap;

@Service
public class ReceiptDetailService
		extends AbstractWmsPaperDetailService<ReceiptDetailBean, ReceiptMainBean, ReceiptDetailFormMap> {
	@Inject
	private ReceiptDetailMapper mapper;

	@Override
	public WmsPaperDetailMapper<ReceiptDetailBean, ReceiptMainBean, ReceiptDetailFormMap> getMapper() {
		return mapper;
	}

	@Override
	public FormMap<String, Object> createFormMap() {
		return new ReceiptDetailFormMap();
	}

	@Override
	public ReceiptDetailBean createDetailObj() {
		return new ReceiptDetailBean();
	}

}