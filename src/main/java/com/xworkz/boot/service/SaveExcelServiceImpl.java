package com.xworkz.boot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
public class SaveExcelServiceImpl implements SaveExcelService {
	@Autowired
	private ExcelService excelService;
	@Autowired
	private AppInfoRepository appInfoRepository;
	private static final Logger logger = LoggerFactory.getLogger(SaveExcelServiceImpl.class);

	public SaveExcelServiceImpl() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public String saveExcel(MultipartFile excelfile) {
		logger.debug("invoked saveExcel method in SaveExcelImpl class..");
		try {
			List<AppInfoDTO> appInfoDTO = excelService.readAppInfoFromExcel(excelfile);
			System.out.println(appInfoDTO);
			
			Iterator<AppInfoDTO> iter = appInfoDTO.iterator();

			if (Objects.nonNull(appInfoDTO)) {
				logger.debug("appInfoDTO is not null can save it..");

				

				while (iter.hasNext()) {

					AppInfoDTO dto = iter.next();

					/* for (AppInfoDTO dto : appDTO) { */
					AppInfoEntity entity = new AppInfoEntity();
					BeanUtils.copyProperties(dto, entity);
					//AppInfoEnvEntity EnvEntity = new AppInfoEnvEntity();

					List<String> envList = dto.getEnv();
					List<String> urlList = dto.getUrl();
					Iterator<String> itr1=envList.iterator();
					Iterator<String> itr2=urlList.iterator();
					//final int envEntitiesListSize = envList.size() > urlList.size() ? envList.size() : urlList.size();

					//List<AppInfoEnvEntity> envEntities = new ArrayList<AppInfoEnvEntity>(envEntitiesListSize);
					List<AppInfoEnvEntity> envEntities = new ArrayList<AppInfoEnvEntity>();
					AppInfoEnvEntity appInfoEnvEntity = null;
					while (itr1.hasNext() && itr2.hasNext()) {
						appInfoEnvEntity = new AppInfoEnvEntity();
						String env=itr1.next();
						String url=itr2.next();
						appInfoEnvEntity.setEnv(env);
						appInfoEnvEntity.setUrl(url);
						envEntities.add(appInfoEnvEntity);
						
					}
				/*	for (String elist : envList) {
						
						appInfoEnvEntity.setEnv(elist);
						envEntities.add(appInfoEnvEntity);
					}

					for (int i = 0; i < urlList.size(); i++) {

						// appInfoEnvEntity.setUrl(ulist);
						// envEntities.addAll(envEntities.get(i).setUrl(urlList.get(i)));
						envEntities.get(i).setUrl(urlList.get(i));

					}*/

					entity.setAppInfoEnvEntity(envEntities);
					appInfoEnvEntity.setAppInfoEntity(entity);
					appInfoRepository.save(entity);
					

					/*
					 * } i++;
					 */
				}
				return "File Uploaded Successfully and Save it..";

			} else {
				logger.debug("appInfoDTO is null can't save it..");
				return "File Uploaded Successfully but not Save it..";
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
