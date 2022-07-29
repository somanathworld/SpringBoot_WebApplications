package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qparam")
public class QueryParamOperationsController {

	@GetMapping("/params1")
	public String reportData1(@RequestParam("cno")Integer no,
								@RequestParam String cname) {
		return no + "<---->"+cname;
	}

	@GetMapping("/params2")
	public String reportData2(@RequestParam("cno")Integer no,        //required default value is true
			@RequestParam(required = false) String cname) {           
		return no + "<---->"+cname;
	}

	@GetMapping("/params3")
	public String reportData3(@RequestParam(name = "cno", defaultValue = "10")Integer no,
			@RequestParam(required = false) String cname) {
		return no + "<---->"+cname;
	}
}
