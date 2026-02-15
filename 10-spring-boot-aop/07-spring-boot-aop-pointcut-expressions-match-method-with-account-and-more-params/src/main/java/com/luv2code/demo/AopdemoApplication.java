package com.luv2code.demo;

import com.luv2code.demo.dao.AccountDao;
import com.luv2code.demo.dao.MembershiptDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao theAccountDao, MembershiptDao theMembershipDao) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDao,theMembershipDao);
		};
	}

	private void demoTheBeforeAdvice(AccountDao theAccountDao, MembershiptDao theMembershipDao) {
		Account myAccount = new Account();
		theAccountDao.addAccount(myAccount,true);
		theMembershipDao.addSillyMember();
	}

}
