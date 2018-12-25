package com.kaifantech.util.constant.taskexe.cangzhou;

public interface CangzhouTaskexeStep {
	public static final Integer INIT_OR_OVER_SGZ = -1;// 初始状态，也代表送光轴结束
	public static final Integer TASK_READY = 0;// 准备就绪
	public static final Integer SONGLIAO_EXE = 1;// 执行送料中
	public static final Integer SONGLIAO_OVER = 2;// 送料结束
	public static final Integer SHANGLIAO_EXE = 3;// 执行上料中
	public static final Integer SHANGLIAO_OVER = 4;// 上料结束
	public static final Integer SONGGUANGZHOU_EXE = 5;// 执行送光轴中
	// public static final Integer SONGGUANGZHOU_OVER = 6;// 送光轴结束
}
