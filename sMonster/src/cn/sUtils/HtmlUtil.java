package cn.sUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
@Component("htmlUtil")  
public class HtmlUtil {
	
	public static  <T> List<T> getHtmlByJsoup(String url){
		Document doc = null;
		Elements newsHeadlines = null;
		List<Elements> list = new ArrayList<Elements>();
		try {
			doc = Jsoup.connect(url).get();
			newsHeadlines = doc.select(".state");
			Elements price = doc.getElementsByClass("_close");
			System.out.println("1"+"---"+price.text());
			System.out.println("2"+"---"+price.html());
			System.out.println("3"+"---"+newsHeadlines.text());
			System.out.println("4"+"---"+newsHeadlines.html());
			
			list.add(newsHeadlines);
			list.add(price);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<T>) list;
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		String url = "https://gupiao.baidu.com/stock/sz002082.html";
		List<Elements> html = getHtmlByJsoup(url);
		
		System.out.println(html);
	}
}
