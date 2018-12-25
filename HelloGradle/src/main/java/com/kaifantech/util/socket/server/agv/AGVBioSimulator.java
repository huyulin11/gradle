package com.kaifantech.util.socket.server.agv;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import com.kaifantech.util.socket.server.AbstractServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

public class AGVBioSimulator extends AbstractServer {
	ServerSocket ss = null;
	public TransDealer transDealer;
	boolean started = false;
	Socket s;

	public AGVBioSimulator(int port) {
		super(port);
	}

	public static void main(String[] args) {
		new AGVBioSimulator(1111).start();
	}

	@Override
	public void start() {
		try {
			ss = new ServerSocket(getPort());
			started = true;
			System.out.println("端口已开启,占用" + getPort() + "端口号....");
		} catch (BindException e) {
			System.out.println("端口使用中....");
			System.out.println("请关掉相关程序并重新运行服务器！");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ThreadTool.getThreadPool().execute(new Runnable() {
			public void run() {
				startListen();
			}
		});

	}

	private void startListen() {
		try {
			while (started) {
				if (s == null || !s.isConnected() || s.isClosed()) {
					s = ss.accept();
					transDealer = new TransDealer(s);
					System.out.println("a client connected!");

					ThreadTool.getThreadPool().execute(transDealer);
					ThreadTool.sleep(1000);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
				System.out.println();
				System.out.println("重新开始监听！");
				startListen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getMsgTobeSend() {
		return transDealer.getStrReadFromC();
	}

	public void setMsgTobeSend(String strToSend) {
		if (AppTool.isNull(transDealer)) {
			return;
		}
		transDealer.setStrToSend(strToSend);
	}
}