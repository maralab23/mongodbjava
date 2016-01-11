package com.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkStyle {
	public static void main(String[] args) {
		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) throws Exception {
				return "Hello World From Spark";
			}
		});
	}
}
