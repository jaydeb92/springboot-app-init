package com.xworkz.boot.service;

import org.springframework.web.multipart.MultipartFile;

public interface SaveExcelService {
	public String saveExcel(MultipartFile excelfile);

}
