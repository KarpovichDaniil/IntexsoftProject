package main.java.by.intexsoft.adsboard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import main.java.by.intexsoft.adsboard.entity.CompanyEntity;
import main.java.by.intexsoft.adsboard.entity.MainCountryEntity;
import main.java.by.intexsoft.adsboard.service.CompanyService;
import main.java.by.intexsoft.adsboard.service.impl.CompanyServiceImpl;

public class ProgCommRun {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"by.intexsoft.progcomm.config");
		CompanyService companyService = context.getBean(CompanyServiceImpl.class);
		CompanyEntity insert = new CompanyEntity();
		insert.company_name = "Intexsoft";
		insert.main_country_id = new MainCountryEntity();
		companyService.save(insert);
		companyService.findAll().forEach((CompanyEntity company) -> System.out.println(company.company_name));
		context.close();
	}
}
