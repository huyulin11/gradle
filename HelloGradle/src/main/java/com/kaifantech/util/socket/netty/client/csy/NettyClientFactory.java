package com.kaifantech.util.socket.netty.client.csy;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemClient.ProjectName;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.socket.iot.client.RoboticArmClient;
import com.kaifantech.util.socket.netty.client.InomaNettyClient;

public class NettyClientFactory {

	private static AbstractSocketClient create(String host, int port, int devtype) {
		if (devtype == 9) {
			return new RoboticArmClient(host, port);
		} else {
			if (ProjectName.KF_CSY_DAJ.equals(SystemClient.PROJECT_NAME)) {
				if (devtype == 0) {
					return new CsyAgvNettyClient(host, port, devtype);
				} else if (devtype == 3) {
					return new CsyScanNettyClient(host, port, devtype);
				} else if (devtype == 4) {
					return new CsyPlcNettyClient(host, port, devtype);
				} else if (devtype == 5) {
					return new CsyChargeNettyClient(host, port, devtype);
				} else if (devtype == 6) {
					return new CsyWindowNettyClient(host, port, devtype);
				}
			} else {
				return new InomaNettyClient(host, port, devtype);
			}
		}
		return null;
	}

	public static AbstractSocketClient create(IotClientBean bean) {
		AbstractSocketClient client = create(bean.getIp(), bean.getPort(), bean.getDevtype());
		client.setDevId(bean.getId());
		return client;
	}

}
