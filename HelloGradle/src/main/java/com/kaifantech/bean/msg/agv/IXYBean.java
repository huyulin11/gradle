package com.kaifantech.bean.msg.agv;

import com.kaifantech.util.agv.msg.AngleDegree;
import com.kaifantech.util.agv.msg.Direction;
import com.kaifantech.util.agv.msg.Point;
import com.kaifantech.util.agv.msg.Road;
import com.kaifantech.util.constant.pi.detail.BASIC_INFO;
import com.kaifantech.util.constant.pi.detail.CLASH_AREA_INFO;
import com.kaifantech.util.constant.pi.detail.ClashArea;
import com.ytgrading.util.AppTool;

public interface IXYBean {

	String getTaskid();

	void setTaskid(String taskid);

	Integer getAGVId();

	void setAGVId(Integer agvId);

	double getX();

	void setX(double x);

	double getSpeed();

	void setSpeed(double speed);

	double getY();

	void setY(double y);

	Float getAngle();

	void setAngle(Float angle);

	Integer getTaskStep();

	void setTaskStep(Integer taskStep);

	public IXYBean getLastAGVMsgBean();

	public void setLastAGVMsgBean(IXYBean lastAGVMsgBean);

	public default boolean isPositiveAngle() {
		return !getDirection().equals(Direction.OTHERS);
	}

	public default boolean isOnTheXaxis() {
		Direction direction = getDirection();
		return direction.equals(Direction.X_NEG) || direction.equals(Direction.X_POS);
	}

	public default boolean isOnTheYaxis() {
		Direction direction = getDirection();
		return direction.equals(Direction.Y_NEG) || direction.equals(Direction.Y_POS);
	}

	public default boolean isOnTheYaxisStrict() {
		try {
			return Math.abs(getAngle() - AngleDegree.Y_NEG) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION_STRICT
					|| Math.abs(getAngle() - AngleDegree.Y_POS) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION_STRICT;
		} catch (Exception e) {
			return false;
		}
	}

	public default boolean isCloseTo(Point point) {
		Direction direction = getDirection();
		return (direction.equals(Direction.Y_NEG) && this.getY() >= point.getY())
				|| (direction.equals(Direction.Y_POS) && this.getY() <= point.getY())
				|| (direction.equals(Direction.X_NEG) && this.getX() >= point.getX())
				|| (direction.equals(Direction.X_POS) && this.getX() <= point.getX());
	}

	public default boolean isCloseTo(IXYBean point) {
		Direction direction = getDirection();
		return (direction.equals(Direction.Y_NEG) && this.getY() >= point.getY())
				|| (direction.equals(Direction.Y_POS) && this.getY() <= point.getY())
				|| (direction.equals(Direction.X_NEG) && this.getX() >= point.getX())
				|| (direction.equals(Direction.X_POS) && this.getX() <= point.getX());
	}

	public default Direction getForkDirection() {
		if (AppTool.isNull(getAngle())) {
			return Direction.OTHERS;
		}
		if (Math.abs(getAngle() - AngleDegree.X_NEG) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION || Math
				.abs(getAngle() - AngleDegree.CIRCLE - AngleDegree.X_NEG) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION) {
			return Direction.X_NEG;
		} else if (Math.abs(getAngle() - AngleDegree.X_POS) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION || Math
				.abs(getAngle() - AngleDegree.CIRCLE - AngleDegree.X_POS) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION) {
			return Direction.X_POS;
		} else if (Math.abs(getAngle() - AngleDegree.Y_NEG) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION) {
			return Direction.Y_NEG;
		} else if (Math.abs(getAngle() - AngleDegree.Y_POS) <= BASIC_INFO.ANGLE_ALLOWED_DEVIATION) {
			return Direction.Y_POS;
		} else {
			return Direction.OTHERS;
		}
	}

	public default boolean inSameDirectionWithFD() {
		return getForkDirection().equals(getDirection());
	}

	public default Direction getDirection() {
		return Direction.OTHERS;
	}

	public default Road getCurrentRoad() {
		return null;
	}

	public default String getStrOfDirection() {
		Direction direction = getDirection();
		if (Direction.Y_POS.equals(direction)) {
			return "↑";
		} else if (Direction.Y_NEG.equals(direction)) {
			return "↓";
		} else if (Direction.X_NEG.equals(direction)) {
			return "←";
		} else if (Direction.X_POS.equals(direction)) {
			return "→";
		} else {
			return "O";
		}
	}

	public default boolean isCloseYRoad(int roadYaxis) {
		if (getX() > roadYaxis && Direction.X_NEG.equals(this.getDirection())) {
			return true;
		}
		if (getX() < roadYaxis && Direction.X_POS.equals(this.getDirection())) {
			return true;
		}
		return false;
	}

	public default boolean isCloseToMainRoad() {
		if (getY() > (BASIC_INFO.COORDINATE_Y_MAIN_ROAD_NORTH + BASIC_INFO.COORDINATE_Y_MAIN_ROAD_SOUTH) / 2
				&& Direction.Y_NEG.equals(this.getDirection())) {
			return true;
		}
		if (getY() < (BASIC_INFO.COORDINATE_Y_MAIN_ROAD_NORTH + BASIC_INFO.COORDINATE_Y_MAIN_ROAD_SOUTH) / 2
				&& Direction.Y_POS.equals(this.getDirection())) {
			return true;
		}
		return false;
	}

	public default boolean isCloseToArea(ClashArea area) {
		double distanceToAreaRight = getX() - area.getRightXaxis();
		if (Direction.X_NEG.equals(getDirection()) && distanceToAreaRight > 0
				&& distanceToAreaRight < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return true;
		}

		double distanceToAreaLeft = getX() - area.getLeftXaxis();
		if (Direction.X_POS.equals(getDirection()) && distanceToAreaLeft < 0
				&& Math.abs(distanceToAreaLeft) < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return true;
		}

		double distanceToAreaUp = getY() - area.getUpYaxis();
		if (Direction.Y_NEG.equals(getDirection()) && distanceToAreaUp > 0
				&& Math.abs(distanceToAreaUp) < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return true;
		}

		double distanceToAreaDown = getY() - area.getDownYaxis();
		if (Direction.Y_POS.equals(getDirection()) && distanceToAreaDown < 0
				&& distanceToAreaDown < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return true;
		}

		return false;
	}

	public default boolean isInTheXArea(ClashArea area) {
		double distanceToAreaLeft = getX() - area.getLeftXaxis() + CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA
				+ BASIC_INFO.addedDistance(this);
		double distanceToAreaRight = getX() - area.getRightXaxis() - CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA
				- BASIC_INFO.addedDistance(this);
		if (distanceToAreaLeft > 0 && distanceToAreaRight < 0 && getY() > BASIC_INFO.COORDINATE_y_OF_ROBOTIC_ARM) {
			return true;
		}
		return false;
	}

	public default boolean isInTheArea(ClashArea area) {
		if (getY() > area.getDownYaxis() && getY() < area.getUpYaxis() && getX() > area.getLeftXaxis()
				&& getX() < area.getRightXaxis()) {
			return true;
		}
		return false;
	}

	public default double getDistanceToArea(ClashArea area) {
		if (isInTheArea(area)) {
			return 0;
		}

		double distanceToAreaRight = getX() - area.getRightXaxis();
		if (Direction.X_NEG.equals(getDirection()) && distanceToAreaRight > 0
				&& distanceToAreaRight < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return distanceToAreaRight;
		}

		double distanceToAreaLeft = getX() - area.getLeftXaxis();
		if (Direction.X_POS.equals(getDirection()) && distanceToAreaLeft < 0
				&& Math.abs(distanceToAreaLeft) < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return -distanceToAreaLeft;
		}

		double distanceToAreaUp = getY() - area.getUpYaxis();
		if (Direction.Y_NEG.equals(getDirection()) && distanceToAreaUp > 0
				&& Math.abs(distanceToAreaUp) < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return distanceToAreaUp;
		}

		double distanceToAreaDown = getY() - area.getDownYaxis();
		if (Direction.Y_POS.equals(getDirection()) && distanceToAreaDown < 0
				&& distanceToAreaDown < CLASH_AREA_INFO.DISTANCE_SAFE_TO_CLASH_AREA) {
			return -distanceToAreaDown;
		}

		return 99999;

	}
}
