package net.wendal.nutzbook.bean.yvr;

public enum TopicType {

	duanzi("段子"),
	news("新鲜事"),
	pic("搞笑图"),
//	shortit("短点"),
	nb("灌水"), 
//	job("招聘"),
//	special("专题")
	;
	
	public String display;
	public Long count;
	
	TopicType(String display) {
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public Long getCount() {
		return count;
	}
}
