package com.janani.restapiapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.janani.restapiapp.model.RestApiMethod;
import com.janani.restapiapp.util.ConnectionUtil;

public class RestApiMethodDAO {
	public List<RestApiMethod> findAll() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,entity_id,method_name,description,active,role_name,status from rest_api_methods";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<RestApiMethod> restApiMethodList = new ArrayList<RestApiMethod>();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			Integer entityId = rs.getInt("entity_id");
			String methodName = rs.getString("method_name");
			String description = rs.getString("description");
			Integer active = rs.getInt("active");
			String roleName = rs.getString("role_name");
			String status = rs.getString("status");
			RestApiMethod restApiMethod = new RestApiMethod();
			restApiMethod.setId(id);
			restApiMethod.setEntityId(entityId);
			restApiMethod.setMethod_name(methodName);
			restApiMethod.setDescription(description);
			restApiMethod.setActive(active);
			restApiMethod.setRoleName(roleName);
			restApiMethod.setStatus(status);
			restApiMethodList.add(restApiMethod);
		}
		return restApiMethodList;
	}

	public List<RestApiMethod> findByEntityId(Integer eId) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,entity_id,method_name,description,active,role_name,status from rest_api_methods where entity_id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, eId);
		ResultSet rs = pst.executeQuery();
		List<RestApiMethod> restApiMethodList = new ArrayList<RestApiMethod>();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			Integer entityId = rs.getInt("entity_id");
			String methodName = rs.getString("method_name");
			String description = rs.getString("description");
			Integer active = rs.getInt("active");
			String roleName = rs.getString("role_name");
			String status = rs.getString("status");
			RestApiMethod restApiMethod = new RestApiMethod();
			restApiMethod.setId(id);
			restApiMethod.setEntityId(entityId);
			restApiMethod.setMethod_name(methodName);
			restApiMethod.setDescription(description);
			restApiMethod.setActive(active);
			restApiMethod.setRoleName(roleName);
			restApiMethod.setStatus(status);
			restApiMethodList.add(restApiMethod);
		}
		return restApiMethodList;
	}

	public void activate(Integer id) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update rest_api_methods set active=1 where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();

	}

	public void deactivate(Integer id) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update rest_api_methods set active=0 where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();

	}

	public void update(RestApiMethod restApiMethod) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update rest_api_methods set entity_id=?,method_name=?,description=?,active=?,role_name=?,status=? where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, restApiMethod.getEntityId());
		pst.setString(2, restApiMethod.getMethod_name());
		pst.setString(3, restApiMethod.getDescription());
		pst.setInt(4, restApiMethod.getActive());
		pst.setString(5, restApiMethod.getRoleName());
		pst.setString(6, restApiMethod.getStatus());
		pst.setInt(7, restApiMethod.getId());
		pst.executeUpdate();
	}
}
