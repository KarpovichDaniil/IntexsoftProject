package by.intexsoft.progcomm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsoft.progcomm.entity.CompanyEntity;
import by.intexsoft.progcomm.entity.MainCountryEntity;
import by.intexsoft.progcomm.service.CompanyService;
import by.intexsoft.progcomm.service.impl.CompanyServiceImpl;

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
