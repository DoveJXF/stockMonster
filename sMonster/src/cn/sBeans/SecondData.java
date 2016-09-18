package cn.sBeans;

import java.util.ArrayList;
import java.util.List;

public class SecondData {
	private String data,dapandata,gopicture;
	private List<ThirdData> thirdData = new ArrayList<ThirdData>();
	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDapandata() {
		return dapandata;
	}

	public void setDapandata(String dapandata) {
		this.dapandata = dapandata;
	}

	public String getGopicture() {
		return gopicture;
	}

	public void setGopicture(String gopicture) {
		this.gopicture = gopicture;
	}

	public List<ThirdData> getThirdData() {
		return thirdData;
	}

	public void setThirdData(List<ThirdData> thirdData) {
		this.thirdData = thirdData;
	}

}
