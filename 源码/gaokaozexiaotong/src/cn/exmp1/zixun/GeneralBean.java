package cn.exmp1.zixun;

public class GeneralBean {

	private int resid;//ͼƬ��idֵ
	private String name;//���¼ҵ�����
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GeneralBean() {
		// TODO Auto-generated constructor stub
	}
	public GeneralBean(int resid, String name) {
		super();
		this.resid = resid;
		this.name = name;
	}
	@Override
	public String toString() {
		return "GeneralBean [resid=" + resid + ", name=" + name + "]";
	}
}
