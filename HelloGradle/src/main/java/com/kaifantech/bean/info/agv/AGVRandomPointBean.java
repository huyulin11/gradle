package com.kaifantech.bean.info.agv;

public class AGVRandomPointBean {

	private Integer xx = (int) ((Math.random() - 0.5) * 40000);
	private Integer yy = (int) ((Math.random() - 0.5) * 40000);
	private boolean flagx = true;
	private boolean flagy = true;

	protected interface Step {
		Integer small = 10;
		Integer middle = 50;
		Integer large = 300;
	}

	public Integer getXx(int x) {
		if (xx + x > 20000) {
			flagx = false;
		}
		if (xx + x < -20000) {
			flagx = true;
		}
		xx = (int) (flagx ? xx + Step.large * Math.random() : xx - Step.large * Math.random());
		return xx;
	}

	public Integer getYy(int y) {
		if (yy + y > 20000) {
			flagy = false;
		}
		if (yy + y < -20000) {
			flagy = true;
		}
		yy = (int) (flagy ? yy + Step.large * Math.random() : yy - Step.large * Math.random());
		return yy;
	}
}
