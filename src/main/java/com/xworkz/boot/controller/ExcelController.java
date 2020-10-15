package com.xworkz.boot.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.boot.dto.AppInfoDTO;
import com.xworkz.boot.service.ExcelService;
import com.xworkz.boot.service.SaveExcelService;

@Controller
public class ExcelController {
	private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);
	@Autowired
	private SaveExcelService saveExcelService;

	public ExcelController() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)

	public String uploadExcel(@RequestParam("excelfile") MultipartFile excelfile, Model model) {
		logger.debug("invoked uploadExcel method in ExcelController class");
		try {
			String messageFromSave=saveExcelService.saveExcel(excelfile);
			
				model.addAttribute("message", messageFromSave);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return "UploadExcel";

	}
}
