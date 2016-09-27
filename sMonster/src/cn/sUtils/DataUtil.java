package cn.sUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import sun.org.mozilla.javascript.internal.Node.NodeIterator;
import sun.org.mozilla.javascript.internal.Parser;


public class DataUtil {
	
	public static String getHtmlByUrl(String url, String encoding) {
		
		StringBuffer str = new StringBuffer();
		URL urlObj = null;
		URLConnection uc = null;
		InputStreamReader isr = null;
		BufferedReader buffer = null;
		try {
			// 建立网络连接
			urlObj = new URL(url);
			// 打开网络连接
			uc = urlObj.openConnection();
			//建立文件写入流
			isr = new InputStreamReader(uc.getInputStream(), encoding);
			//建立文件缓冲流
			buffer = new BufferedReader(isr);
			
			//
			String temp = null;
			while((temp = buffer.readLine())!=null){
				str.append(temp+"\n");
			}
				

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return str.toString();
	}
	/**
	 * @author MacheNike
	 * @param args
	 * 
	 * 
	 */
	public static void main(String[] args){
		
		String url = "https://gupiao.baidu.com/stock/sh601519.html?from=aladingpc";
		String encoding = "utf-8";
		String html = getHtmlByUrl(url, encoding);
		//(new URL("http://127.0.0.1:8080/HTMLParserTester.html")).openConnection()
		
		System.out.println(html);
	}
}
