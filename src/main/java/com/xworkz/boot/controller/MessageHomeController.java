package com.xworkz.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.boot.dto.MessageDTO;
import com.xworkz.boot.service.MessageService;

@Controller
@RequestMapping(value = "/")
public class MessageHomeController {
	private static final Logger logger = LoggerFactory.getLogger(MessageHomeController.class);
	@Autowired
	private MessageService messageService;

	public MessageHomeController() {
		logger.debug("created\t" + this.getClass().getSimpleName());
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

}
