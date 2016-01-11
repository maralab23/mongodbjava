package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoutes {
	public static void main(String[] args) {
		Spark.get("/", new Route() {
			public Object handle(final Request request, Response response) {
				return "Hello World";
			}
		});
		
		Spark.get("/test", new Route() {
			public Object handle(final Request request, Response response) {
				return "This is a test page\n";
			}
		});
		
		Spark.get("/echo/:thing", new Route() {
			public Object handle(final Request request, Response response) {
				return request.params(":thing");
			}
		});
	}
}
