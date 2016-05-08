package net.wendal.nutzbook.bean.yvr;

public enum TopicType {

	ask("问答"), 
	news("新闻"), 
	share("分享"), 
	shortit("短点"),
	work("工作"),
	house("居住"),
	fav("兴趣"),
	nb("灌水"), 
	job("招聘"),
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
