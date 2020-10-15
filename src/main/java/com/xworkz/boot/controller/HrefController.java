package com.xworkz.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HrefController {
	private static final Logger logger = LoggerFactory.getLogger(HrefController.class);

	public HrefController() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/upload")
	public String getUploadExcelPage() {
		logger.debug("invoked getUploadExcelPage method in HrefController class");

		return "UploadExcel";

	}

}
