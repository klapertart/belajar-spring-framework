package com.klapertart.belajarspring;

import com.klapertart.belajarspring.model.*;
import com.klapertart.belajarspring.service.DatabaseConfig;
import com.klapertart.belajarspring.validator.AuthorValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;

public class BelajarSpringApplication {

	public static void main(String[] args) throws IOException {
		System.setProperty("spring.profiles.active","production");

		Locale.setDefault(new Locale("in","ID"));
		ApplicationContext context =  SpringApplication.run(BelajarConfiguration.class, args);

		//DataBean data = context.getBean(DataBean.class);
		//System.out.println(data.getValue());

		//SampleBean data = context.getBean(SampleBean.class);
		//System.out.println(data.getDataBean().getValue());

		//OtherBean data = context.getBean(OtherBean.class);
		//System.out.println(data.getDataBean().getValue());
		//System.out.println(data.getSampleBean().getDataBean().getValue());

		//SayHello data = context.getBean(SayHello.class);
		//String sapa = data.hello("Otong Sunandar");
		//System.out.println(sapa);

		/*
		// -- tes anotasi Scope
		// scope - prototype
		System.out.println("----- Prototype : Bean akan dibuat berbeda-beda");
		DataBean db1 = context.getBean("databean-1", DataBean.class);
		System.out.println("Scope - prototype : " + db1.getValue());
		DataBean db2 = context.getBean("databean-1", DataBean.class);
		System.out.println("Scope - prototype : " + db2.getValue());
		DataBean db3 = context.getBean("databean-1", DataBean.class);
		System.out.println("Scope - prototype : " + db3.getValue());

		// scope - singleton
		System.out.println("");
		System.out.println("----- Singleton : Bean sama, karena Spring membuat sekali");
		DataBean db4 = context.getBean("databean-2", DataBean.class);
		System.out.println("Scope - singleton : " + db4.getValue());
		DataBean db5 = context.getBean("databean-2", DataBean.class);
		System.out.println("Scope - singleton : " + db5.getValue());
		DataBean db6 = context.getBean("databean-2", DataBean.class);
		System.out.println("Scope - singleton : " + db6.getValue());
		*/

		//OtherBean data = context.getBean(OtherBean.class);
		//data.doHello("Abdillah Hamka");

		//DatabaseConfig data = context.getBean(DatabaseConfig.class);
		//System.out.println(data.getValue());

		//FileBean data = context.getBean(FileBean.class);
		//data.printInfo();

		//Author data = context.getBean(Author.class);
		//System.out.println(data.getUser());
		//System.out.println(data.getEmail());


		// --- Spring Validator
		/*
		//Author author = new Author("","");
		Author author = new Author("Otong","otong@state.net");
		DataBinder binder = new DataBinder(author);
		binder.addValidators(new AuthorValidator());

		binder.validate();

		BindingResult result = binder.getBindingResult();

		if(result.hasErrors()){
			//errors
			MessageSource messageSource = context.getBean(MessageSource.class);

			result.getAllErrors().stream().forEach(error -> {
				System.out.println(messageSource.getMessage(error.getCode(),null,Locale.getDefault()));
			});
		}else{
			//no errors
			System.out.println("Tidak ada error!");
		}
		 */

		// Bean Validator
		/*
		Validator validator = context.getBean(Validator.class);

		User user = new User();
		user.setEmail("tes");
		user.setId("");
		user.setName("");

		Set<ConstraintViolation<User>> result = validator.validate(user);
		result.forEach((constraint) -> {
			System.out.println(constraint.getMessage());
		});
		*/


		// Expression Language
		Contoh data = context.getBean(Contoh.class);
		System.out.println(data.getAuthorName());
		System.out.println(data.getNilai());
	}

}
