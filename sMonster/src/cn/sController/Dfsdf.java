package cn.sController;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.sBeans.FirstData;
import cn.sBeans.JsonResult;
import cn.sBeans.SecondData;
import cn.sBeans.ThirdData;
import cn.sBeans.User;


@Controller//<bean id="userController" class="userControlelr">
@RequestMapping("/user")
public class Dfsdf {
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<double[]> create(@RequestBody User user) {
		try {
			String moID = user.getUserName();
			//System.out.println(moID);
			double b3[];
			getDoubleArray(b3);
//			double b2[][] = {{2233.69,2302.6,2287.3,2377.94},{2120.26,2302.6,2117.3,2362.94}};
//			double b3[] =  b2[(int) (Math.random()*100%2)];
			return new JsonResult<>(b3).success();
		} catch (Throwable e) {

			/*return new JsonResult<String>(null).fail(JsonResult.SERVER_ERROR,
					e.getMessage());*/
		}
		return null;
	}
	
	private double[] getDoubleArray(double[] b3) {
		String abc = sendGet("http://web.juhe.cn:8080/finance/stock/hs",
				"key=982b0e99283fb423068d122ec1d7a066&dtype=json&gid=sh600234");
		String cba = sendGet("http://qt.gtimg.cn/q=sh600234", "");
		FirstData jst = JSON.parseObject(abc, FirstData.class);
		List<SecondData> dda = JSON.parseArray(jst.getResult(),
				SecondData.class);
		ThirdData ddd = JSON.parseObject(dda.get(0).getData(), ThirdData.class);

		System.out.println(cba);
//		System.out.println(abc);
		System.out.println(jst.getResult());
		return b3;
		
	}
	private String sendGet(String url, String param) {
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
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public String test(@RequestBody User user) {
		String moID = "2333";
		try {
			System.out.println(moID);
			return moID;
		} catch (Throwable e) {
			
		}
		return moID;
	}
	@RequestMapping("hello")
	public String hello(Model model){
		model.addAttribute("hello", "admin");
		return "index";
	}
	
}
