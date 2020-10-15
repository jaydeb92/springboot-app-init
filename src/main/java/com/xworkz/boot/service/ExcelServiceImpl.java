package com.xworkz.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.boot.dto.AppInfoDTO;
import com.xworkz.boot.entity.AppInfoEntity;
import com.xworkz.boot.entity.AppInfoEnvEntity;
import com.xworkz.boot.repository.AppInfoRepository;

@Service
public class ExcelServiceImpl implements ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(ExcelServiceImpl.class);

	public ExcelServiceImpl() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public List<AppInfoDTO> readAppInfoFromExcel(MultipartFile excelfile) {
		logger.debug("invoked readAppInfoFromExcel method in ExcelServiceImpl class");

		final List<AppInfoDTO> listAppInfo = new ArrayList<>();

		try {
			
			// fetching excel data for AppInfo..
			int i = 1;
			// Creates a workbook object from the uploaded excelfile
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet for
			// AppInfo
			XSSFSheet worksheet = workbook.getSheetAt(0);
			// Creates a worksheet object representing the first sheet for
			// EnvInfo
			XSSFSheet worksheetForEnv = workbook.getSheetAt(1);
			// Reads the data in excel file until last row is encountered
			while (i < worksheet.getLastRowNum()) {

				final AppInfoDTO appInfo = new AppInfoDTO();

				// Creates an object representing a single row in excel for
				// AppInfo
				XSSFRow row = worksheet.getRow(i);

				// Sets the Read data to the model class for AppInfo
				appInfo.setProjectName(row.getCell(0).getStringCellValue());
				appInfo.setVersion(row.getCell(1).getStringCellValue());
				appInfo.setTeamManager(row.getCell(2).getStringCellValue());
				appInfo.setLastRelease(row.getCell(3).getDateCellValue());
				appInfo.setEmail(row.getCell(4).getStringCellValue());
				appInfo.setNextRelease(row.getCell(5).getDateCellValue());
				appInfo.setDeComm(row.getCell(6).getStringCellValue());
				appInfo.setDevelopDate(row.getCell(7).getDateCellValue());
				appInfo.setCreatedTimestamp(row.getCell(8).getDateCellValue());
				appInfo.setCreatedBy(row.getCell(9).getStringCellValue());
				appInfo.setUpdatedTimestamp(row.getCell(10).getDateCellValue());
				appInfo.setUpdatedBy(row.getCell(11).getStringCellValue());

				/*
				 * String s1 = row.getCell(12).getStringCellValue(); double
				 * idForApp=Double.parseDouble(s1);
				 * System.out.println(idForApp);
				 */

				double idForApp = row.getCell(12).getNumericCellValue();
				System.out.println("idForApp :" + idForApp);

				int j = 1;
				double idForEnv = 0.0;
				List<String> urlList = new ArrayList<>();
				List<String> envList = new ArrayList<>();
				// setting data for EnvInfo
				while (j < worksheetForEnv.getLastRowNum()+1) {
					// Creates an object representing a single row in excel for
					// EnvInfo
					XSSFRow rowForEnv = worksheetForEnv.getRow(j);
					// Sets the Read data to the model class for EnvInfo

					/*
					 * String s2 = rowForEnv.getCell(0).getStringCellValue();
					 * double idForEnv=Double.parseDouble(s2);
					 * System.out.println(idForEnv);
					 */
					idForEnv = rowForEnv.getCell(0).getNumericCellValue();
					System.out.println("idForEnv :" + idForEnv);

					if (idForApp == idForEnv) {

						urlList.add(rowForEnv.getCell(2).getStringCellValue());
						envList.add(rowForEnv.getCell(1).getStringCellValue());

					}

					j++;
				}

				appInfo.setUrl(urlList);
				appInfo.setEnv(envList);

				System.out.println(urlList);
				System.out.println(envList);

				// persist data into database in here

				listAppInfo.add(appInfo);

				System.out.println(listAppInfo);
				

				i++;
				
				// appInfoRepository.saveAll(appInfoEntity);

			}
			
			

			workbook.close();
			return listAppInfo;

		} catch (Exception e) {
			e.printStackTrace();

			logger.error(e.getMessage());
		}
		return listAppInfo;

	}

}
