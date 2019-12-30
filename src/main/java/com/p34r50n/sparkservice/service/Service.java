package com.p34r50n.sparkservice.service;

import static spark.Spark.get;
import static spark.Spark.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p34r50n.sparkservice.routes.Endpoints;
import com.p34r50n.sparkservice.routes.GetUsersRoute;
import com.p34r50n.sparkservice.routes.PostRoute;
import com.p34r50n.sparkservice.utils.DbUtils;

public class Service {
    private final static Logger logger = LoggerFactory.getLogger(Service.class);

    public static void main(String[] args) {
        get("/", Endpoints.index);

        get("/get_users", (req, res) -> {
            logger.info("Getting Users");
            res.type("text/json");
            res.status(200);

            DbUtils db = new DbUtils();
            return db.getUsers();
        });

        get("/check_user_exists", (req, res) -> {
            logger.info("Checking User name");
            res.type("text/plain");
            res.status(200);

            String user = req.queryParams("user");

            DbUtils db = new DbUtils();
            return db.checkUserExists(user);
        });

        get("/get_user_list", new GetUsersRoute());

        post("/check_post_params", new PostRoute());
    }
}