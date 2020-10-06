package com.xworkz.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.boot.entity.AppInfoEntity;

public interface AppInfoRepository extends JpaRepository<AppInfoEntity, Integer> {

}
