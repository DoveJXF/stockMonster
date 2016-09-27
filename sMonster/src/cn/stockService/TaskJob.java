package cn.stockService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.sBeans.FirstData;
import cn.sBeans.SecondData;
import cn.sBeans.ThirdData;

import com.alibaba.fastjson.JSON;

@Component("taskJob")  
public class TaskJob {
	public void job1() {
		String abc = sendGet("http://web.juhe.cn:8080/finance/stock/hs",
				"key=982b0e99283fb423068d122ec1d7a066&dtype=json&gid=sh600234");
		String cba = sendGet("http://qt.gtimg.cn/q=sz000858 ", "");
		FirstData jst = JSON.parseObject(abc, FirstData.class);
		List<SecondData> dda = JSON.parseArray(jst.getResult(),
				SecondData.class);
		ThirdData ddd = JSON.parseObject(dda.get(0).getData(), ThirdData.class);

		System.out.println(cba);
		System.out.println(abc);
		System.out.println(jst.getResult());
		System.out.println(ddd.getBuyFive());

	}

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = "";
			if (!"".equals(param)) {
				urlNameString = url + "?" + param;
			} else {
				urlNameString = url;
			}
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			// connection.setRequestProperty("accept", "*/*");
			// connection.setRequestProperty("connection", "Keep-Alive");
			// connection.setRequestProperty("user-agent",
			// "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}  
