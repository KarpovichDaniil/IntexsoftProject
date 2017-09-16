package main.java.by.intexsoft.adsboard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import main.java.by.intexsoft.adsboard.entity.CategoriesEntity;
import main.java.by.intexsoft.adsboard.service.CategoriesService;
import main.java.by.intexsoft.adsboard.service.impl.CategoriesServiceImpl;

public class AdsBoardRun {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"main.java.by.intexsoft.adsboard.config");
		CategoriesService categoriesService = context.getBean(CategoriesServiceImpl.class);
		CategoriesEntity insert = new CategoriesEntity();
		insert.name = "Intexsoft";
		categoriesService.save(insert);
		categoriesService.findAll().forEach((CategoriesEntity category) -> System.out.println(category.name));
		context.close();
	}
}
