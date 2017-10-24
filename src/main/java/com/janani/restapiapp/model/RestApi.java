package com.janani.restapiapp.model;

public class RestApi {

	private Integer id;
	private String tableName;
	private String entityName;
	private String apiName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	@Override
	public String toString() {
		return "RestApi [id=" + id + ", tableName=" + tableName + ", entityName=" + entityName + ", apiName=" + apiName
				+ "]";
	}

}
