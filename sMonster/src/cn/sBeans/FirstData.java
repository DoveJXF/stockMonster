package cn.sBeans;

import java.util.ArrayList;
import java.util.List;

public class FirstData {
	private String reason,result;
	private int error_code,resultcode;
	private List<SecondData> secondData = new ArrayList<SecondData>();
	
	
	
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getResultcode() {
		return resultcode;
	}
	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}
	public List<SecondData> getSecondData() {
		return secondData;
	}
	public void setSecondData(List<SecondData> secondData) {
		this.secondData = secondData;
	}
}
