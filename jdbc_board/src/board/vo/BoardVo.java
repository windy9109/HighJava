package board.vo;

public class BoardVo {
	
	private int borad_no;
	private String borad_title;
	private String borad_viewCount;
	private String content;
	private String mem_id;
	
	
	public int getBorad_no() {
		return borad_no;
	}
	public void setBorad_no(int borad_no) {
		this.borad_no = borad_no;
	}
	public String getBorad_title() {
		return borad_title;
	}
	public void setBorad_title(String borad_title) {
		this.borad_title = borad_title;
	}
	public String getBorad_viewCount() {
		return borad_viewCount;
	}
	public void setBorad_viewCount(String borad_viewCount) {
		this.borad_viewCount = borad_viewCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "BoardVo [borad_no=" + borad_no + ", borad_title=" + borad_title + ", borad_viewCount=" + borad_viewCount
				+ ", content=" + content + ", mem_id=" + mem_id + "]";
	}
	

	
	
	
	
	
	
	

}
