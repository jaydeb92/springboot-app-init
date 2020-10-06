package com.xworkz.boot.service;

import java.util.List;

import com.xworkz.boot.dto.AppInfoDTO;

public interface AppInfoService {
	public AppInfoDTO create(AppInfoDTO dto,List<AppInfoDTO> list);

}
