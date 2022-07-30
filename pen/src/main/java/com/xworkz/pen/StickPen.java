package com.xworkz.pen;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Component
public class StickPen {

	public StickPen() {
		super();
		System.out.println(this.getClass().getSimpleName()+ "Bean is created");
	}

	
}