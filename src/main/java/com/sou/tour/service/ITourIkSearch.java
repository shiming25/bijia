package com.sou.tour.service;

import com.sou.tour.domain.vo.TourInfoPageVo;
import com.sou.tour.domain.vo.TourInfoVo;

public interface ITourIkSearch {
	TourInfoPageVo searchTop(TourInfoVo tourInfoVo);
}
