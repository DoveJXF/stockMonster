package cn.sController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sBeans.Group;
import cn.sBeans.FirstData;
import cn.sBeans.SecondData;
import cn.sBeans.ThirdData;
import cn.sBeans.User;
import cn.sDao.StockMapper;

import com.alibaba.fastjson.JSON;

public class Test {
	@org.junit.Test
	public void test1() {
		Group group = new Group();
		group.setId(0L);
		group.setName("admin");

		User guestUser = new User();
		guestUser.setId(2);
		guestUser.setUserName("guest");

		User rootUser = new User();
		rootUser.setId(3);
		rootUser.setUserName("root");

		group.getUsers().add(guestUser);
		group.getUsers().add(rootUser);

		String jsonString = JSON.toJSONString(group);

		System.out.println(jsonString);
		
		Group group2 = JSON.parseObject(jsonString, Group.class);
		System.out.println(group2.getUsers().get(0).getUserName());
	}
	@org.junit.Test
	public void test2() {
				
		
				String abc = sendGet("http://web.juhe.cn:8080/finance/stock/hs",
						"key=982b0e99283fb423068d122ec1d7a066&dtype=json&gid=sh600234");
				String cba = sendGet("http://qt.gtimg.cn/q=sz000858 ", "");
				FirstData jst = JSON.parseObject(abc,FirstData.class);
				List<SecondData> dda = JSON.parseArray(jst.getResult(), SecondData.class);
				ThirdData ddd = JSON.parseObject(dda.get(0).getData(),ThirdData.class);
				
				
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
	
	@org.junit.Test
	public void test3() {
		// TODO Auto-generated method stub
		Connection conn = null; // 数据库连接
		Statement stmt = null; // 数据库表达式
		ResultSet rs = null; // 结果集
		try {
			/* 加载驱动 */
			Class.forName("com.mysql.jdbc.Driver");
			/* 连接到数据库 */
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/class?", "root", "");
			/* 获取表达式 */
			stmt = (Statement) conn.createStatement();
			/* 插入数据 */
			//stmt.executeUpdate("insert into student (name,age) values ('test',20)");
			/* 执行SQL */
			rs = stmt.executeQuery("select * from student");
			/* 查看里面的数据 */
			while (rs.next()) {
				System.out.println("姓名=" + rs.getString("name"));
				System.out.println("年龄=" + rs.getString("age"));
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void test5(){
		 SqlSessionFactory sqlSessionFactory;
		    Reader reader; 

		        try{
		            reader    = Resources.getResourceAsReader("Configuration.xml");
		            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		        }catch(Exception e){
		            e.printStackTrace();
		        }

		    SqlSessionFactory sqlSessionFactory1 = null;
		    
		        SqlSession session = sqlSessionFactory1.openSession();
		        try {
		        User user = (User) session.selectOne("cn.sDao.sMapper.deleteAsset");
		        System.out.println(user.getUserName());
		        } finally {
		        session.close();
		        }
	}
	@org.junit.Test
	public void test56(){
		System.out.println("dsf");
//		int adc  = JOptionPane.showConfirmDialog(null, "dsf", "dsfd", JOptionPane.YES_NO_OPTION);
//		System.out.println(adc);
		
		JFrame jfe = new JFrame("d第三方岁的法大赛复赛");
		jfe.setSize(200, 300);
		jfe.setVisible(true);
		jfe.setAlwaysOnTop(true);
	}
	
			
//				    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
//				       //1、收集参数、验证参数  
//				       //2、绑定参数到命令对象  
//				       //3、将命令对象传入业务对象进行业务处理  
//				       //4、选择下一个页面  
//				       ModelAndView mv = new ModelAndView();  
//				       //添加模型数据 可以是任意的POJO对象  
//				       mv.addObject("message", "Hello World!");  
//				       //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
//				       mv.setViewName("hello");  
//				       return mv;  
//				    }  
}
