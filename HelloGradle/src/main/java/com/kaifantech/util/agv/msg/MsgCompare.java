package com.kaifantech.util.agv.msg;

import java.text.DecimalFormat;

import com.kaifantech.bean.msg.agv.IXYBean;

public class MsgCompare<T extends IXYBean> {
	private T msgOne;
	private T msgAnother;

	public MsgCompare(T msgOne, T msgAnother) {
		this.msgOne = msgOne;
		this.msgAnother = msgAnother;
	}

	public T getBehindOne() {
		if (!msgOne.isPositiveAngle() && !msgOne.isPositiveAngle()) {
			return null;
		}
		T positiveAngleBean = msgOne.isPositiveAngle() ? msgOne : msgAnother;
		T anotherBean = !msgOne.isPositiveAngle() ? msgOne : msgAnother;
		Direction direction = positiveAngleBean.getDirection();
		if (Direction.X_NEG.equals(direction)) {
			return positiveAngleBean.getX() >= anotherBean.getX() ? positiveAngleBean : anotherBean;
		} else if (Direction.X_POS.equals(direction)) {
			return positiveAngleBean.getX() < anotherBean.getX() ? positiveAngleBean : anotherBean;
		} else if (Direction.Y_NEG.equals(direction)) {
			return positiveAngleBean.getY() >= anotherBean.getY() ? positiveAngleBean : anotherBean;
		} else if (Direction.Y_POS.equals(direction)) {
			return positiveAngleBean.getY() < anotherBean.getY() ? positiveAngleBean : anotherBean;
		} else {
			return null;
		}
	}

	public double getDistanceOfX() {
		return Math.abs(msgOne.getX() - msgAnother.getX());
	}

	public float getDistance() {
		double distance = Math
				.sqrt(Math.pow(msgOne.getX() - msgAnother.getX(), 2) + Math.pow(msgOne.getY() - msgAnother.getY(), 2));
		String distanceStr = new DecimalFormat("#.##").format(distance);

		return Float.parseFloat(distanceStr);
	}

	public double getDistanceOfY() {
		return Math.abs(msgOne.getY() - msgAnother.getY());
	}

	public boolean isParallel() {
		return (msgOne.isOnTheXaxis() && msgAnother.isOnTheXaxis())
				|| (msgOne.isOnTheYaxis() && msgAnother.isOnTheYaxis());
	}

	public boolean isConverse() {
		return isParallel() && (!msgOne.getDirection().equals(msgAnother.getDirection()));
	}

	public boolean isSyntropy() {
		return isParallel() && (msgOne.getDirection().equals(msgAnother.getDirection()));
	}

	public boolean isVertical() {
		return (msgOne.isOnTheYaxis() && msgAnother.isOnTheXaxis())
				|| (msgOne.isOnTheXaxis() && msgAnother.isOnTheYaxis());
	}

	public Point getCrossPoint() {
		Point point = new Point();
		if (!isVertical()) {
			if (!msgOne.isPositiveAngle() && !msgOne.isPositiveAngle()) {
				return null;
			}
			T positiveAngleBean = msgOne.isPositiveAngle() ? msgOne : msgAnother;
			T unPositiveAngleBean = !msgOne.isPositiveAngle() ? msgOne : msgAnother;
			if (positiveAngleBean.isOnTheXaxis()) {
				point.setX(unPositiveAngleBean.getX());
				point.setY(positiveAngleBean.getY());
			} else {
				point.setX(positiveAngleBean.getX());
				point.setY(unPositiveAngleBean.getY());
			}
			return point;
		} else {
			if (msgOne.isOnTheYaxis()) {
				point.setX(msgOne.getX());
				point.setY(msgAnother.getY());
			} else {
				point.setX(msgAnother.getX());
				point.setY(msgOne.getY());
			}
			return point;
		}
	}

}
