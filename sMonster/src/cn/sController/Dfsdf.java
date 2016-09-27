package cn.sController;


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
	@RequestMapping("hello")
	public String hello(Model model){
		model.addAttribute("hello", "admin");
		return "index";
	}
	@RequestMapping(value="/pg.do",method={RequestMethod.POST,RequestMethod.GET})
	public String pg(Model model){
		model.addAttribute("user", "admin");
		return "success";
	}
	@RequestMapping("toAdd")
	public String toAdd(){
		return "add";
	}
	@RequestMapping("recieve")
	public String basic(@RequestParam(defaultValue="2",value="sid",required=true) Integer id,Model model){
		System.out.println(id);
		model.addAttribute("id",id);
		return "success";
	}
	@RequestMapping("recieveStr")
	public String recieveStr(String username,Model model){
		System.out.println(username);
		model.addAttribute("username", username);
		return "success";
	}
	@RequestMapping("delete")
	public String deleteIds(Integer[] ids){
		System.out.println(ids);
		return "sucess";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable Integer id){
		System.out.println(id);
		return "redirect:/user/list.do";
	}
	@RequestMapping("update")
	public String update(){
		//return "redirect:list.do";
		//return "redirect:/user/list.do"
		//return "redirect:/orders/list.do";
		
		//return "forward:list.do";
		//return "forward:/user/list.do"
		return "forward:/orders/list.do";
	}
}
