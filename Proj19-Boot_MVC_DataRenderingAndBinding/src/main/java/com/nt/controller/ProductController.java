package com.nt.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	public ProductController() {
		System.out.println("ProductController.ProductController()");
	}
	
	@GetMapping("/prod1")
	public String bindProd1Data(@RequestParam int pno, @RequestParam String pname, Map<String, Object> map) {
		System.out.println("ProductController.bindProdData()");
		System.out.println(pno + " "+pname);
		map.put("pno", pno);
		map.put("pname", pname);
		return "show_prod_data";
	}

	@GetMapping("/prod2")
	public String bindProd2Data(@RequestParam("pno") int no, @RequestParam("pname") String name, Map<String, Object> map) {
		System.out.println("ProductController.bindProdData()");
		System.out.println(no + " "+name);
		map.put("pno", no);
		map.put("pname", name);
		return "show_prod_data";
	}
	
	@GetMapping("/prod3")
	public String bindProd3Data(@RequestParam("pno") int no, @RequestParam(name = "pname", required = false) String name, Map<String, Object> map) {
		System.out.println("ProductController.bindProdData()");
		System.out.println(no + " "+name);
		map.put("pno", no);
		map.put("pname", name);
		return "show_prod_data";
	}

	@GetMapping("/prod4")
	public String bindProd4Data(@RequestParam("pno") int no, @RequestParam(name = "pname", defaultValue = "TV") String name, Map<String, Object> map) {
		System.out.println("ProductController.bindProdData()");
		System.out.println(no + " "+name);
		map.put("pno", no);
		map.put("pname", name);
		return "show_prod_data";
	}

	//here if we provide pno = "" it will treat null
	@GetMapping("/prod5")
	public String bindProd5Data(@RequestParam("pno") Integer no, @RequestParam(name = "pname", defaultValue = "TV") String name, Map<String, Object> map) {
		System.out.println("ProductController.bindProdData()");
		System.out.println(no + " "+name);
		map.put("pno", no);
		map.put("pname", name);
		return "show_prod_data";
	}

	@GetMapping("/prod6")
	public String bindProd6Data(@RequestParam("pno") Integer no, @RequestParam("pname") String[] names, Map<String, Object> map) {
		System.out.println("ProductController.bindProdData()");
		System.out.println(no + " "+Arrays.toString(names));
		map.put("pno", no);
		map.put("pname", names);
		return "show_prod_data";
	}
}
