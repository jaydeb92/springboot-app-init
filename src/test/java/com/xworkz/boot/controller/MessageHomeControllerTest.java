package com.xworkz.boot.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.ui.Model;

import com.xworkz.boot.dto.MessageDTO;

@WebMvcTest(MessageHomeController.class)
public class MessageHomeControllerTest {

	@InjectMocks
	private MessageHomeController homeController = new MessageHomeController();
	@Mock
	private Model model;
	@Mock
	private MessageDTO dto;

	@Test
	public void testshowMessagePage() throws Exception {

		final String target = "showMessage";
		 String nextPage=homeController.showMessagePage(dto, model);
		assertEquals( target,nextPage, "Controller is not requesting the correct form");

	}

}
