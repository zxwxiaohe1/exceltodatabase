package com.sinux.ssm.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Maps;
import com.sinux.ssm.common.utils.AuthUtil;
import com.sinux.ssm.entity.User;
import com.sinux.ssm.service.ExcelService;
import com.sinux.ssm.service.UserService;

/**
 * 用途:处理用户请求
 * */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;// 用户服务
	@Autowired
	private ExcelService excelService;// excel导入服务
	@Autowired
	private HttpServletRequest request;

	/* 根据ID查询用户 */
	@RequestMapping(value = "/list")
	public String index(Model model, int id) {
		model.addAttribute("userList", userService.findAllUserLists(id));
		return "userList";
	}

	/* 根据路径导入指定Excel */
	@RequestMapping(value = "/saveUser", method = { RequestMethod.POST })
	public String saveUserList(Model model, MultipartFile pictureFile)
			throws Exception {
		model.addAttribute("userList",
				excelService.poireadExcel(pictureFile, request));
		return "extoda";
	}

	/* 判断是否登录成功 */
	@RequestMapping(value = "/login")
	public String loginBoolean(HttpSession session, Model model, User user) {
		String result = "extra/error";
		user.setPassword(AuthUtil.encryptByMd5(user.getPassword()));
		List<User> list = userService.findUserInfo(user);
		if (list.size() != 0) {
			model.addAttribute("userList", list);
			session.setAttribute("usercode", user.getLoginname());
			result = "user/backsys";
		}
		System.out.println("result" + result);
		return result;
	}

	/* 分页查询用户信息 */
	@RequestMapping(value = "/userlist")
	public @ResponseBody
	Object checkLogin(int page, int rows) throws IOException {
		int first = rows * (page - 1);
		System.out.println("first" + first + "rows" + rows);
		System.out
				.println("request.getRequestURI()=" + request.getRequestURI());
		System.out.println("page=" + page + "rows" + rows);
		Map<String, Object> map = Maps.newHashMap();
		List<User> list = userService.findPageUser(first, rows);
		List<User> allUser = userService.findAllUser();
		map.put("total", allUser.size());
		map.put("rows", list);
		return map;
	}

	/* 用户注册 */
	@RequestMapping(value = "/register")
	public void register(HttpServletResponse response, User user) {
		System.out.println("users.getName()=" + user.getName());
		try {
			userService.savaUserList(user);
			response.getWriter().write("success");
		} catch (Exception e) {

		}
	}

	/* 删除用户 */
	@RequestMapping(value = "/deleteUser")
	public void deleteUser(HttpServletResponse response,
			@RequestParam(value = "uids") int[] uids) {
		try {
			userService.deleteUser(uids);
			response.getWriter().write("fdgsdfgs");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 提出登录 */
	@RequestMapping(value = "/loginout")
	public void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 清空所有session
		request.getSession().invalidate();
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	/* ajax请求响应json */
	@RequestMapping("/responseJson")
	public @ResponseBody
	String responseJson(User user) throws Exception {
		System.out.println("user.getNumber()=" + user.getNumber());
		int count = 0;
		try {
			count = userService.findUser(user.getNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	/* 注册跳转 */
	@RequestMapping(value = "/redirct")
	public String regist(String address) {
		System.out.println("address=" + address);
		return address;
	}
}
