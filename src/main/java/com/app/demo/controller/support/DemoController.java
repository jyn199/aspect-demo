package com.app.demo.controller.support;

import org.springframework.stereotype.Controller;

import com.app.demo.controller.IBaseController;

@Controller
public class DemoController implements IBaseController{
	public void demo(){
		System.out.println("test");
	}
	
	//this target結果不同
	public void doDemo(){
		System.out.println("do test");
	}
}
