package com.mongodb;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class SparkFormHandling {
	public static void main(String[] args) {
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFormHandling.class,  "/");
		
		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) throws Exception {
				StringWriter writer = new StringWriter();
				
				try {
					Map<String, Object> fruitsMap = new HashMap<String, Object>();
					fruitsMap.put("fruits", Arrays.asList("apple", "orange", "banana", "peach"));
					Template fruitPrickerTemplate = configuration.getTemplate("fruitPicker.ftl");
					fruitPrickerTemplate.process(fruitsMap, writer);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return writer;
			}
		});		
		
		Spark.post("favorite_fruit", new Route() {
			public Object handle(final Request request, final Response response) throws Exception {
				final String fruit = request.queryParams("fruit");
				if (fruit == null) {
					return "Why don't you pick one?";
				} else {
					return "Your favorite fruit is " + fruit;
				}
			}
		});
	}
}
