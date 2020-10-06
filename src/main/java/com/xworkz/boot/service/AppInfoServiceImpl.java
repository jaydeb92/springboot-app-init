package com.xworkz.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.boot.dto.AppInfoDTO;

import com.xworkz.boot.entity.AppInfoEntity;
import com.xworkz.boot.entity.AppInfoEnvEntity;
import com.xworkz.boot.repository.AppInfoRepository;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	private static final Logger logger = LoggerFactory.getLogger(AppInfoServiceImpl.class);
	@Autowired
	private AppInfoRepository appInfoRepository;

	public AppInfoServiceImpl() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public AppInfoDTO create(AppInfoDTO dto, List<AppInfoDTO> list) {
		try {
			if (Objects.nonNull(dto) && Objects.nonNull(list)) {
				logger.debug("AppInfoDTO not null can save..");

				AppInfoEntity appInfoEntity = new AppInfoEntity();
				List<AppInfoEnvEntity> appInfoEnvEntityList = new ArrayList<>();

				BeanUtils.copyProperties(dto, appInfoEntity);

				for (AppInfoDTO envList : list) {

					AppInfoEnvEntity appInfoEnvEntity = new AppInfoEnvEntity();
					BeanUtils.copyProperties(envList, appInfoEnvEntity);

					appInfoEnvEntity.setAppInfoEntity(appInfoEntity);

					appInfoEnvEntityList.add(appInfoEnvEntity);
				}

				appInfoEntity.setAppInfoEnvEntity(appInfoEnvEntityList);

				appInfoRepository.save(appInfoEntity);

			} else {
				logger.debug("AppInfoDTO is null can't save..");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
