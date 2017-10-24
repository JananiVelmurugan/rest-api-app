package com.janani.restapiapp.controller;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janani.restapiapp.dao.RestApiDAO;
import com.janani.restapiapp.model.RestApi;

@RestController
@CrossOrigin
@RequestMapping("/restApi")
public class RestApiController {
	@GetMapping
	public List<RestApi> findAll(ModelMap model) {
		RestApiDAO dao = new RestApiDAO();
		List<RestApi> restApiList = null;
		try {
			restApiList = dao.findAll();
			model.addAttribute("RESTAPILIST", restApiList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restApiList;
	}

	@PostMapping("/update")
	public List<RestApi> update(@RequestParam("table_name") String tableName,
			@RequestParam("entity_name") String entityName, @RequestParam("rest_api") String apiName, ModelMap model) {
		RestApi restApi = new RestApi();
		restApi.setTableName(tableName);
		restApi.setEntityName(entityName);
		restApi.setApiName(apiName);
		RestApiDAO dao = new RestApiDAO();
		List<RestApi> restApiList = null;
		try {
			dao.update(restApi);
			restApiList = dao.findAll();
			model.addAttribute("RESTAPILIST", restApiList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restApiList;
	}

}