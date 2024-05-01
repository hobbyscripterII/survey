package egovframework.example.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardFileGetVo {
	private int ifile;
	private int iboard;
	private String originalName;
	private String savedName;
	private String ext;
	private int fileSize;
	
	public int getIfile() { return ifile; }
	public void setIfile(int ifile) { this.ifile = ifile; }
	public int getIboard() { return iboard; }
	public void setIboard(int iboard) { this.iboard = iboard; }
	public String getOriginalName() { return originalName; }
	public void setOriginalName(String originalName) { this.originalName = originalName; }
	public String getSavedName() { return savedName; }
	public void setSavedName(String savedName) { this.savedName = savedName; }
	public String getExt() { return ext; }
	public void setExt(String ext) { this.ext = ext; }
	public int getFileSize() { return fileSize; }
	public void setFileSize(int fileSize) { this.fileSize = fileSize; }
	
	@Override public String toString() { return "BoardFileGetVo [ifile=" + ifile + ", iboard=" + iboard + ", originalName=" + originalName + ", savedName=" + savedName + ", ext=" + ext + ", fileSize=" + fileSize + "]"; }
}
