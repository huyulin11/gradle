package com.kaifantech.util.constant.taskexe.ctrl;

public class TaskType {
	public static class NormalTaskType {
		public static final Integer NOTCONTROL = -1;// 不受控"
		public static final Integer NORMAL = 0;// 普通"
		public static final Integer GOTO_CHARGE = 5;// 送料"
		public static final Integer BACK_FROM_CHARGE = 6;// 上料"
	}

	public static class CangzhouTaskType {
		public static final Integer SONGLIAO = 1;// 送料"
		public static final Integer SHANGLIAO = 2;// 上料"
		public static final Integer SONGGUANGZHOU = 3;// 送光轴"
	}

	public static class XuzhouWeiweiTaskType {
	}
}
