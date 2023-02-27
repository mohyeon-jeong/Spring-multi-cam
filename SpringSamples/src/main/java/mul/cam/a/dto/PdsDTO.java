package mul.cam.a.dto;

import java.io.Serializable;

// Personal Data Store

/*
	create table pds(
		seq int auto_increment primary key,
	    id varchar(50) not null,
	    title varchar(200) not null,
	    content varchar(4000) not null,
	    fileName varchar(50) not null,
	    newFileName varchar(50) not null,
	    readCount decimal(8) not null,
	    downCount decimal(8) not null,
	    regDate timestamp not null
	);

	alter table pds
	add foreign key(id) references member(id);
*/

public class PdsDTO implements Serializable {
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private String fileName; // 원본 파일명
	private String newFileName; // 업로드 파일명
	private int readCount;
	private int downCount;
	private String regDate;
	
	public PdsDTO() {
	}

	public PdsDTO(String id, String title, String content, String fileName) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.fileName = fileName;
	}

	public PdsDTO(int seq, String id, String title, String content, String fileName, String newFileName, int readCount,
			int downCount, String regDate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.newFileName = newFileName;
		this.readCount = readCount;
		this.downCount = downCount;
		this.regDate = regDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "PdsDTO [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", fileName="
				+ fileName + ", newFileName=" + newFileName + ", readCount=" + readCount + ", downCount=" + downCount
				+ ", regDate=" + regDate + "]";
	}
	
}
