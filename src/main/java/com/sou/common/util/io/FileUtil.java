package com.sou.common.util.io;

/*      */import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.sou.common.util.lang.StringUtil;

public class FileUtil {
	private static final long ONE_GB = 1073741824L;
	private static final long ONE_KB = 1024L;
	private static final long ONE_MB = 1048576L;

	public static boolean createFile(String filename) throws IOException {
		File f = new File(filename);

		if (!f.createNewFile()) {
			throw new IOException("Create file " + filename + " failed");
		}
		return true;
	}

	public static boolean renameFile(String src, String dest)
			throws IOException {
		File oldf = new File(src);
		File newf = new File(dest);
		if (!oldf.renameTo(newf)) {
			throw new IOException("Rename file " + src + " to " + dest
					+ " failed");
		}
		return true;
	}

	public static String byteCountToDisplaySize(long size) {
		String displaySize;

		if (size / 1073741824L > 0L) {
			displaySize = String.valueOf(size / 1073741824L) + " GB";
		} else {

			if (size / 1048576L > 0L) {
				displaySize = String.valueOf(size / 1048576L) + " MB";
			} else {

				if (size / 1024L > 0L)
					displaySize = String.valueOf(size / 1024L) + " KB";
				else
					displaySize = String.valueOf(size) + " bytes";
			}
		}
		return displaySize;
	}

	public static void cleanDirectory(File directory) throws IOException {
		if (!directory.exists()) {
			String message = directory + " does not exist";
			throw new IllegalArgumentException(message);
		}

		if (!directory.isDirectory()) {
			String message = directory + " is not a directory";
			throw new IllegalArgumentException(message);
		}

		File[] files = directory.listFiles();
		if (files == null) {
			throw new IOException("Failed to list contents of " + directory);
		}

		IOException exception = null;
		for (File file : files) {
			try {
				forceDelete(file);
			} catch (IOException ioe) {
				exception = ioe;
			}
		}

		if (exception != null)
			throw exception;
	}

	public static void copyDirectory(File srcDir, File destDir)
			throws IOException {
		copyDirectory(srcDir, destDir, true);
	}

	public static void copyDirectory(File srcDir, File destDir,
			boolean preserveFileDate) throws IOException {
		copyDirectory(srcDir, destDir, null, preserveFileDate);
	}

	private static void copyDirectory(File srcDir, File destDir,
			FileFilter filter, boolean preserveFileDate) throws IOException {
		if (srcDir == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!srcDir.exists()) {
			throw new FileNotFoundException("Source '" + srcDir
					+ "' does not exist");
		}
		if (!srcDir.isDirectory()) {
			throw new IOException("Source '" + srcDir
					+ "' exists but is not a directory");
		}
		if (srcDir.getCanonicalPath().equals(destDir.getCanonicalPath())) {
			throw new IOException("Source '" + srcDir + "' and destination '"
					+ destDir + "' are the same");
		}

		List exclusionList = null;
		if (destDir.getCanonicalPath().startsWith(srcDir.getCanonicalPath())) {
			File[] srcFiles = filter == null ? srcDir.listFiles() : srcDir
					.listFiles(filter);
			if ((srcFiles != null) && (srcFiles.length > 0)) {
				exclusionList = new ArrayList(srcFiles.length);
				for (File srcFile : srcFiles) {
					File copiedFile = new File(destDir, srcFile.getName());
					exclusionList.add(copiedFile.getCanonicalPath());
				}
			}
		}
		doCopyDirectory(srcDir, destDir, filter, preserveFileDate,
				exclusionList);
	}

	public static void copyDirectoryToDirectory(File srcDir, File destDir)
			throws IOException {
		if (srcDir == null) {
			throw new NullPointerException("Source must not be null");
		}
		if ((srcDir.exists()) && (!srcDir.isDirectory())) {
			throw new IllegalArgumentException("Source '" + destDir
					+ "' is not a directory");
		}
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if ((destDir.exists()) && (!destDir.isDirectory())) {
			throw new IllegalArgumentException("Destination '" + destDir
					+ "' is not a directory");
		}
		copyDirectory(srcDir, new File(destDir, srcDir.getName()), true);
	}

	public static void copyFile(File srcFile, File destFile) throws IOException {
		copyFile(srcFile, destFile, true);
	}

	public static void copyFile(File srcFile, File destFile,
			boolean preserveFileDate) throws IOException {
		if (srcFile == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destFile == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!srcFile.exists()) {
			throw new FileNotFoundException("Source '" + srcFile
					+ "' does not exist");
		}
		if (srcFile.isDirectory()) {
			throw new IOException("Source '" + srcFile
					+ "' exists but is a directory");
		}

		if ((destFile.getParentFile() != null)
				&& (!destFile.getParentFile().exists())
				&& (!destFile.getParentFile().mkdirs())) {
			throw new IOException("Destination '" + destFile
					+ "' directory cannot be created");
		}

		if ((destFile.exists()) && (!destFile.canWrite())) {
			throw new IOException("Destination '" + destFile
					+ "' exists but is read-only");
		}
		doCopyFile(srcFile, destFile, preserveFileDate);
	}

	public static void copyFileToDirectory(File srcFile, File destDir)
			throws IOException {
		copyFileToDirectory(srcFile, destDir, true);
	}

	public static void copyFileToDirectory(File srcFile, File destDir,
			boolean preserveFileDate) throws IOException {
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if ((destDir.exists()) && (!destDir.isDirectory())) {
			throw new IllegalArgumentException("Destination '" + destDir
					+ "' is not a directory");
		}
		copyFile(srcFile, new File(destDir, srcFile.getName()),
				preserveFileDate);
	}

	public static void copyFileToDirectory(File srcFile, String destFileName,
			File destDir) throws IOException {
		copyFileToDirectory(srcFile, destFileName, destDir, true);
	}

	public static void copyFileToDirectory(File srcFile, String destFileName,
			File destDir, boolean preserveFileDate) throws IOException {
		if (destDir == null) {
			throw new NullPointerException("DestDirectory must not be null");
		}
		if ((destDir.exists()) && (!destDir.isDirectory())) {
			throw new IllegalArgumentException("Destination '" + destDir
					+ "' is not a directory");
		}
		if (StringUtil.isEmpty(destFileName))
			copyFile(srcFile, new File(destDir, srcFile.getName()),
					preserveFileDate);
		else
			copyFile(srcFile, new File(destDir, destFileName), preserveFileDate);
	}

	public static void copyURLToFile(URL source, File destination)
			throws IOException {
		InputStream input = source.openStream();
		try {
			FileOutputStream output = openOutputStream(destination);
			try {
				IOUtil.copy(input, output);
			} finally {
				IOUtil.closeQuietly(output);
			}
		} finally {
			IOUtil.closeQuietly(input);
		}
	}

	public static void deleteDirectory(File directory) throws IOException {
		if (!directory.exists()) {
			return;
		}
		cleanDirectory(directory);
		if (!directory.delete()) {
			String message = "Unable to delete directory " + directory + ".";
			throw new IOException(message);
		}
	}

	public static boolean deleteQuietly(File file) {
		if (file == null)
			return false;
		try {
			if (file.isDirectory())
				cleanDirectory(file);
		} catch (Exception localException1) {
		}
		try {
			return file.delete();
		} catch (Exception e) {
		}
		return false;
	}

	private static void doCopyDirectory(File srcDir, File destDir,
			FileFilter filter, boolean preserveFileDate, List exclusionList)
			throws IOException {
		if (destDir.exists()) {
			if (!destDir.isDirectory())
				throw new IOException("Destination '" + destDir
						+ "' exists but is not a directory");
		} else {
			if (!destDir.mkdirs()) {
				throw new IOException("Destination '" + destDir
						+ "' directory cannot be created");
			}
			if (preserveFileDate) {
				destDir.setLastModified(srcDir.lastModified());
			}
		}
		if (!destDir.canWrite()) {
			throw new IOException("Destination '" + destDir
					+ "' cannot be written to");
		}

		File[] files = filter == null ? srcDir.listFiles() : srcDir
				.listFiles(filter);
		if (files == null) {
			throw new IOException("Failed to list contents of " + srcDir);
		}
		for (int i = 0; i < files.length; i++) {
			File copiedFile = new File(destDir, files[i].getName());
			if ((exclusionList != null)
					&& (exclusionList.contains(files[i].getCanonicalPath())))
				continue;
			if (files[i].isDirectory())
				doCopyDirectory(files[i], copiedFile, filter, preserveFileDate,
						exclusionList);
			else
				doCopyFile(files[i], copiedFile, preserveFileDate);
		}
	}

	private static void doCopyFile(File srcFile, File destFile,
			boolean preserveFileDate) throws IOException {
		if ((destFile.exists()) && (destFile.isDirectory())) {
			throw new IOException("Destination '" + destFile
					+ "' exists but is a directory");
		}

		FileInputStream input = new FileInputStream(srcFile);
		try {
			FileOutputStream output = new FileOutputStream(destFile);
			try {
				IOUtil.copy(input, output);
			} finally {
				IOUtil.closeQuietly(output);
			}
		} finally {
			IOUtil.closeQuietly(input);
		}

		if (srcFile.length() != destFile.length()) {
			throw new IOException("Failed to copy full contents from '"
					+ srcFile + "' to '" + destFile + "'");
		}
		if (preserveFileDate)
			destFile.setLastModified(srcFile.lastModified());
	}

	public static void forceDelete(File file) throws IOException {
		if (file.isDirectory()) {
			deleteDirectory(file);
		} else {
			boolean filePresent = file.exists();
			if (!file.delete()) {
				if (!filePresent) {
					throw new FileNotFoundException("File does not exist: "
							+ file);
				}
				String message = "Unable to delete file: " + file;
				throw new IOException(message);
			}
		}
	}

	public static void forceMkdir(File directory) throws IOException {
		if (directory.exists()) {
			if (directory.isFile()) {
				String message = "File " + directory + " exists and is "
						+ "not a directory. Unable to create directory.";
				throw new IOException(message);
			}
		} else if (!directory.mkdirs()) {
			String message = "Unable to create directory " + directory;
			throw new IOException(message);
		}
	}

	public static boolean isFileNewer(File file, Date date) {
		if (date == null) {
			throw new IllegalArgumentException("No specified date");
		}
		return isFileNewer(file, date.getTime());
	}

	public static boolean isFileNewer(File file, File reference) {
		if (reference == null) {
			throw new IllegalArgumentException("No specified reference file");
		}
		if (!reference.exists()) {
			throw new IllegalArgumentException("The reference file '" + file
					+ "' doesn't exist");
		}
		return isFileNewer(file, reference.lastModified());
	}

	public static boolean isFileNewer(File file, long timeMillis) {
		if (file == null) {
			throw new IllegalArgumentException("No specified file");
		}
		if (!file.exists()) {
			return false;
		}
		return file.lastModified() > timeMillis;
	}

	public static boolean isFileOlder(File file, Date date) {
		if (date == null) {
			throw new IllegalArgumentException("No specified date");
		}
		return isFileOlder(file, date.getTime());
	}

	public static boolean isFileOlder(File file, File reference) {
		if (reference == null) {
			throw new IllegalArgumentException("No specified reference file");
		}
		if (!reference.exists()) {
			throw new IllegalArgumentException("The reference file '" + file
					+ "' doesn't exist");
		}
		return isFileOlder(file, reference.lastModified());
	}

	public static boolean isFileOlder(File file, long timeMillis) {
		if (file == null) {
			throw new IllegalArgumentException("No specified file");
		}
		if (!file.exists()) {
			return false;
		}
		return file.lastModified() < timeMillis;
	}

	public static void moveDirectory(File srcDir, File destDir)
			throws IOException {
		if (srcDir == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!srcDir.exists()) {
			throw new FileNotFoundException("Source '" + srcDir
					+ "' does not exist");
		}
		if (!srcDir.isDirectory()) {
			throw new IOException("Source '" + srcDir + "' is not a directory");
		}
		if (destDir.exists()) {
			throw new IOException("Destination '" + destDir
					+ "' already exists");
		}
		boolean rename = srcDir.renameTo(destDir);
		if (!rename) {
			copyDirectory(srcDir, destDir);
			deleteDirectory(srcDir);
			if (srcDir.exists())
				throw new IOException("Failed to delete original directory '"
						+ srcDir + "' after copy to '" + destDir + "'");
		}
	}

	public static void moveDirectoryToDirectory(File src, File destDir,
			boolean createDestDir) throws IOException {
		if (src == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException(
					"Destination directory must not be null");
		}
		if ((!destDir.exists()) && (createDestDir)) {
			destDir.mkdirs();
		}
		if (!destDir.exists()) {
			throw new FileNotFoundException("Destination directory '" + destDir
					+ "' does not exist [createDestDir=" + createDestDir + "]");
		}
		if (!destDir.isDirectory()) {
			throw new IOException("Destination '" + destDir
					+ "' is not a directory");
		}
		moveDirectory(src, new File(destDir, src.getName()));
	}

	public static void moveFile(File srcFile, File destFile) throws IOException {
		if (srcFile == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destFile == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!srcFile.exists()) {
			throw new FileNotFoundException("Source '" + srcFile
					+ "' does not exist");
		}
		if (srcFile.isDirectory()) {
			throw new IOException("Source '" + srcFile + "' is a directory");
		}
		if (destFile.exists()) {
			throw new IOException("Destination '" + destFile
					+ "' already exists");
		}
		if (destFile.isDirectory()) {
			throw new IOException("Destination '" + destFile
					+ "' is a directory");
		}
		boolean rename = srcFile.renameTo(destFile);
		if (!rename) {
			copyFile(srcFile, destFile);
			if (!srcFile.delete()) {
				deleteQuietly(destFile);
				throw new IOException("Failed to delete original file '"
						+ srcFile + "' after copy to '" + destFile + "'");
			}
		}
	}

	public static void moveFileToDirectory(File srcFile, File destDir,
			boolean createDestDir) throws IOException {
		if (srcFile == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException(
					"Destination directory must not be null");
		}
		if ((!destDir.exists()) && (createDestDir)) {
			destDir.mkdirs();
		}
		if (!destDir.exists()) {
			throw new FileNotFoundException("Destination directory '" + destDir
					+ "' does not exist [createDestDir=" + createDestDir + "]");
		}
		if (!destDir.isDirectory()) {
			throw new IOException("Destination '" + destDir
					+ "' is not a directory");
		}
		moveFile(srcFile, new File(destDir, srcFile.getName()));
	}

	public static void moveToDirectory(File src, File destDir,
			boolean createDestDir) throws IOException {
		if (src == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destDir == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!src.exists()) {
			throw new FileNotFoundException("Source '" + src
					+ "' does not exist");
		}
		if (src.isDirectory())
			moveDirectoryToDirectory(src, destDir, createDestDir);
		else
			moveFileToDirectory(src, destDir, createDestDir);
	}

	public static FileInputStream openInputStream(File file) throws IOException {
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file
						+ "' exists but is a directory");
			}
			if (!file.canRead())
				throw new IOException("File '" + file + "' cannot be read");
		} else {
			throw new FileNotFoundException("File '" + file
					+ "' does not exist");
		}
		return new FileInputStream(file);
	}

	public static FileOutputStream openOutputStream(File file)
			throws IOException {
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file
						+ "' exists but is a directory");
			}
			if (!file.canWrite())
				throw new IOException("File '" + file
						+ "' cannot be written to");
		} else {
			File parent = file.getParentFile();
			if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
				throw new IOException("File '" + file
						+ "' could not be created");
			}
		}

		return new FileOutputStream(file);
	}

	public static FileOutputStream openOutputStream(File file, boolean append)
			throws IOException {
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file
						+ "' exists but is a directory");
			}
			if (!file.canWrite())
				throw new IOException("File '" + file
						+ "' cannot be written to");
		} else {
			File parent = file.getParentFile();
			if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
				throw new IOException("File '" + file
						+ "' could not be created");
			}
		}

		return new FileOutputStream(file, append);
	}

	public static byte[] readFileToByteArray(File file) throws IOException {
		InputStream in = null;
		try {
			in = openInputStream(file);
			byte[] arrayOfByte = IOUtil.toByteArray(in);
			return arrayOfByte;
		} finally {
			IOUtil.closeQuietly(in);
		}
	}

	public static String readFileToString(File file) throws IOException {
		return readFileToString(file, null);
	}

	public static String readFileToString(File file, String encoding)
			throws IOException {
		InputStream in = null;
		try {
			in = openInputStream(file);
			String str = IOUtil.toString(in, encoding);
			return str;
		} finally {
			IOUtil.closeQuietly(in);
		}
	}

	public static List readLines(File file) throws IOException {
		return readLines(file, null);
	}

	public static List<String> readLines(File file, String encoding)
			throws IOException {
		InputStream in = null;
		try {
			in = openInputStream(file);
			List localList = IOUtil.readLines(in, encoding);
			return localList;
		} finally {
			IOUtil.closeQuietly(in);
		}
	}

	public static long sizeOfDirectory(File directory) {
		if (!directory.exists()) {
			String message = directory + " does not exist";
			throw new IllegalArgumentException(message);
		}

		if (!directory.isDirectory()) {
			String message = directory + " is not a directory";
			throw new IllegalArgumentException(message);
		}

		long size = 0L;

		File[] files = directory.listFiles();
		if (files == null) {
			return 0L;
		}
		for (File file : files) {
			if (file.isDirectory())
				size += sizeOfDirectory(file);
			else {
				size += file.length();
			}
		}
		return size;
	}

	public static void writeByteArrayToFile(File file, byte[] data)
			throws IOException {
		OutputStream out = null;
		try {
			out = openOutputStream(file);
			out.write(data);
		} finally {
			IOUtil.closeQuietly(out);
		}
	}

	public static void writeLines(File file, Collection lines)
			throws IOException {
		writeLines(file, null, lines, null);
	}

	public static void writeLines(File file, Collection lines, String encoding)
			throws IOException {
		writeLines(file, null, lines, encoding);
	}

	public static void writeLines(File file, String lineEnding, Collection lines)
			throws IOException {
		writeLines(file, lineEnding, lines, null);
	}

	public static void writeLines(File file, String lineEnding,
			Collection lines, String encoding) throws IOException {
		OutputStream out = null;
		try {
			out = openOutputStream(file);
			IOUtil.writeLines(lines, lineEnding, out, encoding);
		} finally {
			IOUtil.closeQuietly(out);
		}
	}

	public static void writeLines(File file, String lineEnding,
			Collection lines, String encoding, boolean append)
			throws IOException {
		OutputStream out = null;
		try {
			out = openOutputStream(file, append);
			IOUtil.writeLines(lines, lineEnding, out, encoding);
		} finally {
			IOUtil.closeQuietly(out);
		}
	}

	public static void writeStringToFile(File file, String data)
			throws IOException {
		writeStringToFile(file, data, null);
	}

	public static void writeStringToFile(File file, String data, String encoding)
			throws IOException {
		OutputStream out = null;
		try {
			out = openOutputStream(file);
			IOUtil.write(data, out, encoding);
		} finally {
			IOUtil.closeQuietly(out);
		}
	}
}
