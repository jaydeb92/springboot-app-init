package com.xworkz.boot.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.xworkz.boot.dto.AppInfoDTO;

public interface ExcelService {
	public List<AppInfoDTO> readAppInfoFromExcel(MultipartFile excelfile);
	

}
