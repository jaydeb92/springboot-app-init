package com.xworkz.boot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "APP_INFO_TABLE")
public class AppInfoEntity {
	private static final Logger logger = LoggerFactory.getLogger(AppInfoEntity.class);
	@Id
	@Column(name = "A_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	@Column(name = "PROJECT_NAME")
	private String projectName;
	@Column(name = "VERSION")
	private String version;
	@Column(name = "TEAM_MANAGER")
	private String teamManager;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DE_COMM")
	private String deComm;
	@Column(name = "LAST_RELEASE_DATE")
	private Date lastRelease;
	@Column(name = "NEXT_RELEASE_DATE")
	private Date nextRelease;
	@Column(name = "DEVELOP_DATE")
	private Date developDate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appInfoEntity")
	private List<AppInfoEnvEntity> appInfoEnvEntity;

	public AppInfoEntity() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTeamManager() {
		return teamManager;
	}

	public void setTeamManager(String teamManager) {
		this.teamManager = teamManager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeComm() {
		return deComm;
	}

	public void setDeComm(String deComm) {
		this.deComm = deComm;
	}

	public Date getLastRelease() {
		return lastRelease;
	}

	public void setLastRelease(Date lastRelease) {
		this.lastRelease = lastRelease;
	}

	public Date getNextRelease() {
		return nextRelease;
	}

	public void setNextRelease(Date nextRelease) {
		this.nextRelease = nextRelease;
	}

	public Date getDevelopDate() {
		return developDate;
	}

	public void setDevelopDate(Date developDate) {
		this.developDate = developDate;
	}

	public List<AppInfoEnvEntity> getAppInfoEnvEntity() {
		return appInfoEnvEntity;
	}

	public void setAppInfoEnvEntity(List<AppInfoEnvEntity> appInfoEnvEntity) {
		this.appInfoEnvEntity = appInfoEnvEntity;
	}

}