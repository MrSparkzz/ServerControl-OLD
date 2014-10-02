package net.sparkzz.servercontrol.util;

import java.io.*;

/**
 * @author Brendon
 *
 * Public File Management API
 */
public class FileManager extends Utility {

	//TODO: Wait until configs are implemented, or if they are at all

	public static boolean copy(File source, File target, boolean overwrite) {
		String failed = "Failed to copy file: ";

		if (!source.exists()) {
			logger.severe(failed + "Source file does not exist!");
		} else if (!target.exists()) {
			boolean success;

			try {
				success = target.mkdirs();
			} catch (SecurityException exception) {
				logger.severe(failed + "Not permitted!");
				return false;
			}

			if (!success) {
				logger.severe(failed + "Unabled to create directories to copy target!");
				return false;
			}
		} else if (!overwrite) {
			logger.warn(failed + "Target file already exists!");
			return false;
		}

		if (source.isDirectory())
			return copyDirectory(source, target);
		else
			return copyFile(source, target);
	}

	public static boolean copyDirectory(File source, File target) {
		for (String file : source.list())
			if (!copy(new File(source, file), new File(target, file), true))
				return false;
		return true;
	}

	public static boolean copyFile(File source, File target) {
		try {
			InputStream input = new FileInputStream(source);
			OutputStream output = new FileOutputStream(target);
			byte[] buffer = new byte[1024];
			int length;

			while ((length = input.read(buffer)) > 0)
				output.write(buffer, 0, length);

			input.close();
			output.close();
			return true;
		} catch(Exception exception) {
			logger.severe("An error occurred while copying file: " + source.getPath());
			exception.printStackTrace();
			return false;
		}
	}

	public static boolean delete(File file) {
		return file.delete();
	}
}