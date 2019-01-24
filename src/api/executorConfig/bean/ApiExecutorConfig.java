package api.executorConfig.bean;

import java.sql.Date;

public class ApiExecutorConfig {

	private String configId;
	private String apiName;
	private String handlerClass;
	private String status;
	private Date createTime;
	private Date able_time;
	private Date disable_time;

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getHandlerClass() {
		return handlerClass;
	}

	public void setHandlerClass(String handlerClass) {
		this.handlerClass = handlerClass;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAble_time() {
		return able_time;
	}

	public void setAble_time(Date able_time) {
		this.able_time = able_time;
	}

	public Date getDisable_time() {
		return disable_time;
	}

	public void setDisable_time(Date disable_time) {
		this.disable_time = disable_time;
	}

	public boolean isAble() {
		Date now = new Date(System.currentTimeMillis());
		return "1000".equals(getStatus()) // 有效
				&& getAble_time().after(now)// 已生效
				&& getDisable_time().before(now);// 还没失效
	}

}
