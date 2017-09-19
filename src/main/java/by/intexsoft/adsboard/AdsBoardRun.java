package by.intexsoft.adsboard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsoft.adsboard.model.Categories;
import by.intexsoft.adsboard.service.CategoriesService;
import by.intexsoft.adsboard.service.impl.CategoriesServiceImpl;

public class AdsBoardRun {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"by.intexsoft.adsboard.config");
		CategoriesService categoryService = context.getBean(CategoriesServiceImpl.class);
		Categories insert = new Categories();
		insert.name = "Cars";
		categoryService.save(insert);
		categoryService.findAll().forEach((Categories category) -> System.out.println(category.name));
		context.close();
	}
}
