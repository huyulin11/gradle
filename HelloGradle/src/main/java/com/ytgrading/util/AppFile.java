package com.ytgrading.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.kaifantech.init.sys.SystemInitiator;

public class AppFile {
	private static String logPath(String type) throws IOException {
		return getOrCreateFile(SystemInitiator.LOG_PATH + DateFactory.currentDate2String("yyMMdd"),
				type + DateFactory.currentDate2String("yyMMdd") + ".txt");
	}

	public static String WriteLogsTo(String type, String content) {
		try {
			return WriteLogsTo(type, content, logPath(type + "-"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String WriteLogsTo(String type, String content, String filepath) {
		RandomAccessFile mm = null;
		FileOutputStream o = null;
		try {
			String innerContent = type + "-" + DateFactory.getCurrTime() + "-" + content;
			o = new FileOutputStream(filepath, true);
			o.write(innerContent.getBytes("UTF-8"));
			o.write("\r\n".getBytes("UTF-8"));
			o.close();
			return innerContent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (mm != null) {
				try {
					mm.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String getOrCreateFile(String path, String filename) throws IOException {
		String newPath = path;
		File dir = new File(newPath);
		if (!AppTool.isNullStr(newPath)) {
			if (!dir.exists()) {
				dir.mkdirs();
			}
		}
		newPath = newPath + "/" + filename;
		File file = new File(newPath);
		if (!file.exists()) {
			file.createNewFile();
		}
		return newPath;
	}
}
