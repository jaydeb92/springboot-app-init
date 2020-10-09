package com.xworkz.boot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xworkz.boot.dto.AppInfoDTO;
import com.xworkz.boot.dto.MessageDTO;
import com.xworkz.boot.service.AppInfoService;
import com.xworkz.boot.service.MessageService;

@Controller
@RequestMapping(value = "/")
public class MessageHomeController {
	private static final Logger logger = LoggerFactory.getLogger(MessageHomeController.class);
	@Autowired
	private MessageService messageService;
	@Autowired
	private AppInfoService appInfoService;
	private List<AppInfoDTO> list;

	public MessageHomeController() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@PostConstruct
	public void init() {
		list = new ArrayList<AppInfoDTO>();
	}

	public String getWelcomePage() {

		logger.debug("invoked getWelcomePage method");
		return "index";

	}

	@RequestMapping(value = "sendMessage", method = RequestMethod.POST)
	public String showMessagePage(MessageDTO dto, Model model) {
		logger.debug("invoked showMessagePage method");
		try {
			int messageId = messageService.create(dto);
			if (messageId > 0) {
				String name = dto.getFromName();
				String messageFromname = dto.getMessage();
				logger.debug("Name: " + name + "Message " + messageFromname + "messageId: " + messageId);
				model.addAttribute("message", name + "," + messageFromname + "MessageId: " + messageId);

			} else {
				logger.debug("messageId is 0 ..");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "ShowMessage";

	}

	
	 
	
	@RequestMapping(value = "sendModal", method = RequestMethod.POST)
	public ResponseEntity<Object> getModalData(@RequestBody AppInfoDTO appInfoDTO) {
		 
		list.add(appInfoDTO);

		System.out.println(list);
		
		return ResponseEntity.ok().body("Success");

	}

	@RequestMapping(value = "/sendAppInfo", method = RequestMethod.POST)

	public String addAppInfoDetails(AppInfoDTO appInfoDTO, Model model) {
		logger.debug("invoked addAppInfoDetails method");
		appInfoService.create(appInfoDTO, list);
		return "AppInfo";

	}

}
