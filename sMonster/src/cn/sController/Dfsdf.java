package cn.sController;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sBeans.JsonResult;
import cn.sBeans.User;


@Controller//<bean id="userController" class="userControlelr">
@RequestMapping("/user")
public class Dfsdf {
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<String> create(@RequestBody User user) {
		try {
			String moID = user.getUserName();
			System.out.println(moID);
			return new JsonResult<String>(moID).success();
		} catch (Throwable e) {

			return new JsonResult<String>(null).fail(JsonResult.SERVER_ERROR,
					e.getMessage());
		}
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
