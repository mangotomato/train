package org.happylearn.train.springmvc.web;

import org.happylearn.train.springmvc.domain.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/request-response-body")
public class RequestResponseBodyController {
	
	
	@RequestMapping("/req_to_resp")
	public @ResponseBody Teacher requestToResponse(@RequestBody Teacher t) {
		t.setAge(2);
		return t;
	}
}
