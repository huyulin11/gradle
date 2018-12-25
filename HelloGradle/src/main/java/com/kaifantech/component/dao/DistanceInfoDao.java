package com.kaifantech.component.dao;

import org.springframework.stereotype.Service;

@Service
public class DistanceInfoDao extends ControlInfoDao {

	public Integer getDistanceRepeat() {
		return getValueByType("PI_DISTANCE_XY_REPEAT_POINT");
	}

	public Integer getDistanceUnsafe() {
		return getValueByType("PI_DISTANCE_XY_2AGVS_UNSAFE");
	}

	public Integer getDistanceWarning() {
		return getValueByType("PI_DISTANCE_XY_2AGVS_WARNING");
	}

	public Integer getDistanceWarningNonPath() {
		return getValueByType("PI_DISTANCE_XY_2AGVS_NON_PATH_WARNING");
	}

	public Integer getDistanceUnsafeParallel() {
		return getValueByType("PI_DISTANCE_XY_2AGVS_PARALLEL_EQUIDIRECTIONAL_UNSAFE");
	}

	public Integer getDistanceUnsafeNonPath() {
		return getValueByType("PI_DISTANCE_XY_2AGVS_NON_PATH_UNSAFE");
	}

	public Integer getDistanceWarningParallel() {
		return getValueByType("PI_DISTANCE_XY_2AGVS_PARALLEL_EQUIDIRECTIONAL_WARNING");
	}

	public Integer getAngleAllowDeviation() {
		return getValueByType("PI_ANGLE_ALLOW_DEVIATION");
	}

	public Integer getDistanceForComputeNonRightAngleArea() {
		return getValueByType("PI_DISTANCE_AREA_IN_PATH_NON_RIGHT_ANGLE");
	}

	public Integer getDistanceForComputeRightAngleArea() {
		return getValueByType("PI_DISTANCE_AREA_IN_PATH_RIGHT_ANGLE");
	}

}
