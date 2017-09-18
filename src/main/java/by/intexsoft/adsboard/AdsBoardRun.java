package main.java.by.intexsoft.adsboard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import main.java.by.intexsoft.adsboard.model.Categories;
import main.java.by.intexsoft.adsboard.service.CategoriesService;
import main.java.by.intexsoft.adsboard.service.impl.CategoriesServiceImpl;

public class AdsBoardRun {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"main.java.by.intexsoft.adsboard.config");
		CategoriesService categoryService = context.getBean(CategoriesServiceImpl.class);
		Categories insert = new Categories();
		insert.name = "Cars";
		categoryService.save(insert);
		categoryService.findAll().forEach((Categories category) -> System.out.println(category.name));
		context.close();
	}
}
