package com.kaifantech.bean.msg.agv;

import org.springframework.scheduling.annotation.Async;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.util.agv.msg.Direction;
import com.kaifantech.util.agv.msg.Location;
import com.kaifantech.util.constant.pi.detail.BASIC_INFO;
import com.kaifantech.util.constant.pi.detail.CLASH_AREA_INFO;
import com.ytgrading.util.AppTool;

public class AGVMsgBean implements IXYBean, Cloneable {
	protected String taskIsfinished;
	protected String taskid;
	protected Integer taskStep;
	protected String pauseStat;
	private String taskName;
	private String battery;
	private String time;
	protected Float angle;
	protected double x;
	protected double y;
	protected Integer agvId;
	private boolean withPath;
	private IXYBean lastAGVMsgBean;
	private Direction direction = Direction.Y_NEG;
	private double degree = 45;
	private double speed = 0.0;

	private String task;
	private String error;

	public int xaxisOfTarget;
	public int targetLocation;

	public AGVMsgBean() {
	}

	public int getCurrentLoacation() {
		if (AppTool.isNull(this.getY())) {
			return Location.Y_NEG;
		}

		if (this.getY() > BASIC_INFO.COORDINATE_Y_MAIN_ROAD_NORTH
				+ CLASH_AREA_INFO.DISTANCE_IN_LOCATION_ALLOWED_DEVIATION) {
			return Location.Y_POS;
		}

		if (this.getY() < BASIC_INFO.COORDINATE_Y_MAIN_ROAD_SOUTH
				- CLASH_AREA_INFO.DISTANCE_IN_LOCATION_ALLOWED_DEVIATION) {
			return Location.Y_NEG;
		}

		return Location.OTHERS;

	}

	public boolean isOutFromStock() {
		return (getCurrentLoacation() == Location.Y_POS && Direction.Y_NEG.equals(getDirection()))
				|| (getCurrentLoacation() == Location.Y_NEG && Direction.Y_POS.equals(getDirection()));
	}

	public boolean isSuccessDone(TaskexeBean command) {
		if (!command.getTaskid().equals(getTaskid()) || !"1".equals(getTaskIsfinished())) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isSendDone(TaskexeBean taskexeBean) {
		if (!"0".equals(getTaskIsfinished()) || !taskexeBean.getTaskid().equals(getTaskid())) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isAGVPause() {
		if (!"0".equals(getPauseStat())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTaskfinished() {
		return "1".equals(taskIsfinished);
	}

	public String getTaskIsfinished() {
		return taskIsfinished;
	}

	public void setTaskIsfinished(String taskIsfinished) {
		this.taskIsfinished = taskIsfinished;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getAGVId() {
		return agvId;
	}

	public void setAGVId(Integer agvId) {
		this.agvId = agvId;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getPauseStat() {
		return pauseStat;
	}

	public void setPauseStat(String pauseStat) {
		this.pauseStat = pauseStat;
	}

	public boolean isPause() {
		if (AppTool.isNull(pauseStat)) {
			return false;
		}
		if (!"0".equals(getPauseStat())) {
			return true;
		} else {
			return false;
		}
	}

	public Float getAngle() {
		return angle;
	}

	public void setAngle(Float angle) {
		this.angle = angle;
	}

	public Integer getTaskStep() {
		return taskStep;
	}

	public void setTaskStep(Integer taskStep) {
		this.taskStep = taskStep;
	}

	public boolean isWithPath() {
		return withPath;
	}

	public void setWithPath(boolean withPath) {
		this.withPath = withPath;
	}

	public IXYBean getLastAGVMsgBean() {
		return lastAGVMsgBean;
	}

	public void setLastAGVMsgBean(IXYBean lastAGVMsgBean) {
		this.lastAGVMsgBean = lastAGVMsgBean;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		calDirection();
		return direction;
	}

	@Async
	public Direction calDirection() {

		if (AppTool.isNull(getAngle())) {
			return direction;
		}

		IXYBean l = getLastAGVMsgBean();

		if (AppTool.isNullObj(l)) {
			return direction;
		}

		if (AppTool.isAnyNull(x, y, l.getX(), l.getY())) {
			return direction;
		}

		Direction forkDirection = getForkDirection();

		if (y - l.getY() == 0 && x - l.getX() == 0) {
			return direction;
		}

		double distance = Math.sqrt(Math.pow(getX() - l.getX(), 2) + Math.pow(getY() - l.getY(), 2));
		if (distance < 100) {
			return direction;
		}

		if (x - l.getX() == 0 || Direction.Y_POS.equals(forkDirection) || Direction.Y_NEG.equals(forkDirection)) {
			if (y - l.getY() > 0) {
				direction = Direction.Y_POS;
				degree = 90;
			} else {
				direction = Direction.Y_NEG;
				degree = 270;
			}
		}

		if (y - l.getY() == 0 || Direction.X_POS.equals(forkDirection) || Direction.X_NEG.equals(forkDirection)) {
			if (x - l.getX() > 0) {
				direction = Direction.X_POS;
				degree = 0;
			} else {
				direction = Direction.X_NEG;
				degree = 180;
			}
		}

		if (Direction.OTHERS.equals(forkDirection)) {
			direction = forkDirection;
			double tan = (y - l.getY()) / (x - l.getX());
			degree = Math.atan(tan);
			if (degree >= 0) {
				if (x < l.getX()) {
					degree = degree + Math.PI;
				}
			} else {
				if (x < l.getX()) {
					degree = degree + 2 * Math.PI;
				} else {
					degree = degree + Math.PI;
				}
			}
			degree = degree / Math.PI * 180;
			return direction;
		}

		return direction;
	}

	public boolean isUseful() {
		if (AppTool.isNull(x) || AppTool.isNull(y)) {
			return false;
		}
		return true;
	}

	public String toString() {
		if (!isUseful()) {
			return "";
		}

		IXYBean lastMsg = getLastAGVMsgBean();
		String lastMsgStr;
		if (AppTool.isNull(lastMsg)) {
			lastMsgStr = "";
		} else {
			lastMsgStr = "{" + lastMsg.getX() + "," + lastMsg.getY() + "}" + "-->";
		}
		return "【" + getAGVId() + "车" + getStrOfDirection() + lastMsgStr + "{" + x + "," + y + "}" + "】";
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}

	public void test() {
		String msg1 = "cmd=position;pause_stat=0;battery=461;error=0;x=-10901;y=-2256;a=275.239014;z=15;gAlarm=0;speed=-205;task=2-D-1-6-1-114.xml;veer_angle=90.000000;task_step=9;task_isfinished=0;task_error=0;walk_path_id=8004�";
		String msg2 = "cmd=position;pause_stat=0;battery=461;error=0;x=-10878;y=-2270;a=273.638000;z=15;gAlarm=0;speed=-162;task=2-D-1-6-1-114.xml;veer_angle=90.000000;task_step=9;task_isfinished=0;task_error=0;walk_path_id=8004�";

		AGVMsgBean bean1 = new AGVMsgBean();
		InomaAgvMsgBeanTransfer.transToBean(1, msg1, bean1);

		AGVMsgBean bean2 = new AGVMsgBean();
		InomaAgvMsgBeanTransfer.transToBean(1, msg2, bean2);
		bean2.setLastAGVMsgBean(bean1);
		bean2.calDirection();

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
