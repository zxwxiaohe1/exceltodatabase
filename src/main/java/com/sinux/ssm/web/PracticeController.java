package com.sinux.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sinux.ssm.entity.User;

@Controller
@RequestMapping("/prictice")
public class PracticeController {
	@RequestMapping("/testde")
	public void testde(String nam, User user) {

		System.out.println("---------------" + user.getUid() + "---------------"
				+ user.getName() + "---------------" + user.getAge());
		System.out.println("name" + nam);
	}
}
