package cn.exmp1.shiian;

import java.util.List;

public class GroupStatusEntity {
	private String groupName;
	
	private List<ChildStatusEntity> childList;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<ChildStatusEntity> getChildList() {
		return childList;
	}

	public void setChildList(List<ChildStatusEntity> childList) {
		this.childList = childList;
	}

}