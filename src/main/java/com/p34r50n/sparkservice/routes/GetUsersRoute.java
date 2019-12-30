package com.p34r50n.sparkservice.routes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p34r50n.sparkservice.service.Service;
import com.p34r50n.sparkservice.utils.DbUtils;

import spark.Request;
import spark.Response;
import spark.Route;

public class GetUsersRoute implements Route {
	private final static Logger logger = LoggerFactory.getLogger(Service.class);

	public Object handle(Request req, Response resp) throws Exception {
		logger.info("Getting Users");
		DbUtils db = new DbUtils();
		List<String> users = db.getUsers(); 
		String jsonUsers = "";

		ObjectMapper om = new ObjectMapper();
		jsonUsers = om.writeValueAsString(users);

		return jsonUsers;
	}
}