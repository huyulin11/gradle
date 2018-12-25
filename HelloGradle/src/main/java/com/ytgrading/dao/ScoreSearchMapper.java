package com.ytgrading.dao;

import java.util.List;


import com.ytgrading.bean.ScoreSearch;
import com.ytgrading.bean.SpaceDay;

public interface ScoreSearchMapper {
	List<ScoreSearch> getScoreSearch();
	List<ScoreSearch> getTopTwentySearch();
	List<SpaceDay> getSpaceCoin();
	List<SpaceDay> getSpaceBill();
	List<SpaceDay> getTwoAnniversary();
	int addModernCoin();
	int addFlowCoin();
	int addBillCoin();
	int addAllCoin();
}
