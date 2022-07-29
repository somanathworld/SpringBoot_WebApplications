package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pvariables")
public class PathVariableOperationsController {

	@GetMapping("/vars1/{no}/{name}")
	public String fetchData1(@PathVariable("name") String cname,
								@PathVariable Integer no) {
		return no+"<------>"+cname;
	}

	@GetMapping("/vars2/{no}/{name}")
	public String fetchData2(@PathVariable(name = "name", required = false) String cname,
								@PathVariable(required = false) Integer no) {
		return no+"<------>"+cname;
	}
	
	
	@GetMapping("/report/no/name")
	public String fetchData2s(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "from fetchtData2s";
	}

	@GetMapping("/report/no/{name}")
	public String fetchData1s1d(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "from fetchtData1s1d";
	}
	@GetMapping("/report/{no}/{name}")
	public String fetchData2d(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "from fetchtData2d";
	}
	@GetMapping("/report/{no}/name")
	public String fetchData1d1s(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "from fetchtData1d1s";
	}
}
