package com.janani.restapiapp.controller;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.janani.restapiapp.dao.RestApiMethodDAO;
import com.janani.restapiapp.model.RestApiMethod;

@RestController
@CrossOrigin
@RequestMapping("/restApiMethods")
public class RestApiMethodController {
	@GetMapping
	public List<RestApiMethod> findAll(ModelMap model) {
		RestApiMethodDAO dao = new RestApiMethodDAO();
		List<RestApiMethod> restApiMethodList = null;
		try {
			restApiMethodList = dao.findAll();
			model.addAttribute("RESTAPILIST", restApiMethodList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restApiMethodList;
	}

	@PostMapping("/entiyId")
	public List<RestApiMethod> findByEntityId(@RequestParam("entity_id") String entityId, ModelMap model) {
		RestApiMethodDAO dao = new RestApiMethodDAO();
		List<RestApiMethod> restApiMethodList = null;
		try {
			restApiMethodList = dao.findByEntityId(Integer.parseInt(entityId));
			model.addAttribute("RESTAPILIST", restApiMethodList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restApiMethodList;
	}

	@PostMapping("/update")
	public List<RestApiMethod> update(@RequestParam("id") String id, @RequestParam("entity_id") String entityId,
			@RequestParam("method_name") String methodName, @RequestParam("description") String description,
			@RequestParam("active") String active, @RequestParam("role_name") String roleName,
			@RequestParam("status") String status, ModelMap model) {
		RestApiMethod restApiMethod = new RestApiMethod();
		restApiMethod.setId(Integer.parseInt(id));
		restApiMethod.setEntityId(Integer.parseInt(entityId));
		restApiMethod.setMethod_name(methodName);
		restApiMethod.setDescription(description);
		restApiMethod.setActive(Integer.parseInt(active));
		restApiMethod.setRoleName(roleName);
		restApiMethod.setStatus(status);
		RestApiMethodDAO dao = new RestApiMethodDAO();
		List<RestApiMethod> restApiMethodList = null;
		try {
			dao.update(restApiMethod);
			restApiMethodList = dao.findAll();
			model.addAttribute("RESTAPILIST", restApiMethodList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restApiMethodList;
	}

	@PostMapping("/activate")
	public List<RestApiMethod> activate(@RequestParam("id") String id, ModelMap model) {

		RestApiMethodDAO dao = new RestApiMethodDAO();
		List<RestApiMethod> restApiMethodList = null;
		try {
			dao.activate(Integer.parseInt(id));
			restApiMethodList = dao.findAll();
			model.addAttribute("RESTAPILIST", restApiMethodList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restApiMethodList;
	}

	@PostMapping("/deactivate")
	public List<RestApiMethod> deactivate(@RequestParam("id") String id, ModelMap model) {

		RestApiMethodDAO dao = new RestApiMethodDAO();
		List<RestApiMethod> restApiMethodList = null;
		try {
			dao.deactivate(Integer.parseInt(id));
			restApiMethodList = dao.findAll();
			model.addAttribute("RESTAPILIST", restApiMethodList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restApiMethodList;
	}
}
