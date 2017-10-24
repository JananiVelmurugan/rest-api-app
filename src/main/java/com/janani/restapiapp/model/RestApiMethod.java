package com.janani.restapiapp.model;

public class RestApiMethod {
	private Integer id;
	private Integer entityId;
	private String method_name;
	private String description;
	private Integer active;
	private String roleName;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "RestApiMethod [id=" + id + ", entityId=" + entityId + ", method_name=" + method_name + ", description="
				+ description + ", active=" + active + ", roleName=" + roleName + ", status=" + status + "]";
	}

}
