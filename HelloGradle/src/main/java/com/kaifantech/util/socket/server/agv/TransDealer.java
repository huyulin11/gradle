package com.kaifantech.util.socket.server.agv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

public class TransDealer implements Runnable {
	private Socket s;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private boolean bConnected = false;
	private String strReadFromC;
	private String strToSend;

	public TransDealer(Socket s) {
		this.s = s;
		initIO();
	}

	private void initIO() {
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			bConnected = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String str) throws IOException {
		dos.writeUTF(str);
	}

	private void sendMsg() {
		while (bConnected) {
			try {
				if (!AppTool.isNull(strToSend)) {
					send(strToSend);
				}
				ThreadTool.sleep(500);
			} catch (Exception e) {
				System.out.print("socket断开或者被关闭！");
				break;
			}
		}
	}

	public void run() {
		Thread.currentThread().setName("agv模拟器-信号收集器" + (ThreadID.number++));

		try {
			ThreadTool.getThreadPool().execute(new Runnable() {
				public void run() {
					sendMsg();
				}
			});

			while (bConnected) {
				dis = new DataInputStream(s.getInputStream());
				String cmd = dis.readUTF();
				System.out.println(cmd);
				setStrReadFromC(cmd);
				ThreadTool.sleep(500);
			}
		} catch (EOFException e) {
			System.out.println("Client closed!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (dos != null)
					dos.close();
				if (s != null) {
					s.close();
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	public String getStrReadFromC() {
		return strReadFromC;
	}

	public void setStrReadFromC(String strReadFromC) {
		this.strReadFromC = strReadFromC;
	}

	public String getStrToSend() {
		return strToSend;
	}

	public void setStrToSend(String strToSend) {
		this.strToSend = strToSend;
	}

}