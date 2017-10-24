package com.janani.restapiapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.janani.restapiapp.model.RestApi;
import com.janani.restapiapp.util.ConnectionUtil;

public class RestApiDAO {
	public List<RestApi> findAll() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,table_name,entity_name,rest_api from entity_rest_api";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<RestApi> restApiList = new ArrayList<RestApi>();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String tableName = rs.getString("table_name");
			String entityName = rs.getString("entity_name");
			String apiName = rs.getString("rest_api");
			RestApi restApi = new RestApi();
			restApi.setId(id);
			restApi.setTableName(tableName);
			restApi.setEntityName(entityName);
			restApi.setApiName(apiName);
			restApiList.add(restApi);
		}
		return restApiList;
	}


	public void update(RestApi restApi) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update entity_rest_api set entity_name=?,rest_api=? where table_name=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, restApi.getEntityName());
		pst.setString(2, restApi.getApiName());
		pst.setString(3, restApi.getTableName());
		pst.executeUpdate();
	}
}
