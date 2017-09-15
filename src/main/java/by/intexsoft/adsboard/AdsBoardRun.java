package main.java.by.intexsoft.adsboard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import main.java.by.intexsoft.adsboard.entity.CategoriesEntity;
import main.java.by.intexsoft.adsboard.entity.RolesEntity;
import main.java.by.intexsoft.adsboard.service.CategoriesService;
import main.java.by.intexsoft.adsboard.service.impl.CategoriesServiceImpl;

public class AdsBoardRun {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"by.intexsoft.progcomm.config");
		CategoriesService companyService = context.getBean(CategoriesServiceImpl.class);
		CategoriesEntity insert = new CategoriesEntity();
		insert.company_name = "Intexsoft";
		insert.main_country_id = new RolesEntity();
		companyService.save(insert);
		companyService.findAll().forEach((CategoriesEntity company) -> System.out.println(company.company_name));
		context.close();
	}
}
