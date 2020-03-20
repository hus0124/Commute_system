package model;

public class CommuteDTO {
	
	private String id;
	private String workername;
	private String comein;
	private String comeout;
	private String workdate;
	private int worktime;
	private int month;
	private String isout;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComein() {
		return comein;
	}

	public void setComein(String comein) {
		this.comein = comein;
	}

	public String getComeout() {
		return comeout;
	}

	public void setComeout(String comeout) {
		this.comeout = comeout;
	}

	public String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public int getWorktime() {
		return worktime;
	}

	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
		public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}

	public String getIsout() {
		return isout;
	}

	public void setIsout(String isout) {
		this.isout = isout;
	}
	

	@Override
	public String toString() {
		return "CommuteDTO [id=" + id + ", workername=" + workername + ", comein=" + comein + ", comeout=" + comeout
				+ ", workdate=" + workdate + ", worktime=" + worktime + ", month=" + month + ", isout=" + isout + "]";
	}
}
