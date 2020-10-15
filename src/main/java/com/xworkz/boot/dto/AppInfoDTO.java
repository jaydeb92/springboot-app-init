package com.xworkz.boot.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AppInfoDTO implements Serializable {
	private String projectName;
	private String version;
	private String teamManager;
	private Date lastRelease;
	private String email;
	private Date nextRelease;
	private String deComm;
	private Date developDate;
	private List<String> env;
	private List<String> url;
	private Date createdTimestamp;
	private String createdBy;
	private Date updatedTimestamp;
	private String updatedBy;

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

	public Date getLastRelease() {
		return lastRelease;
	}

	public void setLastRelease(Date lastRelease) {
		this.lastRelease = lastRelease;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNextRelease() {
		return nextRelease;
	}

	public void setNextRelease(Date nextRelease) {
		this.nextRelease = nextRelease;
	}

	public String getDeComm() {
		return deComm;
	}

	public void setDeComm(String deComm) {
		this.deComm = deComm;
	}

	public Date getDevelopDate() {
		return developDate;
	}

	public void setDevelopDate(Date developDate) {
		this.developDate = developDate;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

	public List<String> getUrl() {
		return url;
	}

	public void setEnv(List<String> env) {
		this.env = env;
	}

	public List<String> getEnv() {
		return env;
	}

	@Override
	public String toString() {
		return "AppInfoDTO [projectName=" + projectName + ", version=" + version + ", teamManager=" + teamManager
				+ ", lastRelease=" + lastRelease + ", email=" + email + ", nextRelease=" + nextRelease + ", deComm="
				+ deComm + ", developDate=" + developDate + ", env=" + env + ", url=" + url + ", createdTimestamp="
				+ createdTimestamp + ", createdBy=" + createdBy + ", updatedTimestamp=" + updatedTimestamp
				+ ", updatedBy=" + updatedBy + "]";
	}

}
