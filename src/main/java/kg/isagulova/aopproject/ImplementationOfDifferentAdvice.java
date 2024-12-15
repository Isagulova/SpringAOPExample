package kg.isagulova.aopproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kg.isagulova.aopproject.service.ServiceExample;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@SpringBootApplication
// @EnableAspectJAutoProxy annotation enables support for
// handling the components marked with @Aspect annotation.
@EnableAspectJAutoProxy
public class ImplementationOfDifferentAdvice {
		public static void main(String[] args) {
			ConfigurableApplicationContext context = SpringApplication.run(ImplementationOfDifferentAdvice.class, args);
			// Fetching the object from the application
			// context.
			ServiceExample service = context.getBean(ServiceExample.class);
			// checking for an employee available in the
			// organization
			String employeeNumber = "emp12345";
			try {
				service.employeeStatus(employeeNumber);
			}
			catch (Exception ex) {
				System.out.println("Exception occurred.." + ex.getMessage());
			}
			// Displaying balance in the account.
			String employeeAccountNumber = "Emp1212";
			try {
				service.getAccountBalance(employeeAccountNumber);
			}
			catch (Exception ex) {
				System.out.println("Exception occurred.." + ex.getMessage());
			}

			// Employee has undergone some exams for promotion.
			// Let us check that
			int promotionExamMarks = 650;
			try {
				service.eligibilityForPromotion(promotionExamMarks);
			}
			catch (Exception ex) {
				System.out.println("Exception occurred.." + ex.getMessage());
			}
			// Closing the context object.
			context.close();
		}
}
