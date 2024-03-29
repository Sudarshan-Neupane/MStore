package mum.edu.mstore.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProductFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private FileType fileType;
	
	private String filePath;
	
	public ProductFile() {

	}

	
	
	public ProductFile(String filePath, FileType fileType) {
		this.fileType = fileType;
		this.filePath = filePath;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public enum FileType {
		MP3, MP4, WMV, WAV
	}

}
