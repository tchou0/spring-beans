package org.yearup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yearup.model.Student;
import com.yearup.service.RegistrationService;
import com.yearup.service.StudentAlreadyRegisteredException;
public class App {
    public static void main(String[] args) throws
            StudentAlreadyRegisteredException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");

        RegistrationService registrationService =
                ctx.getBean(RegistrationService.class);
        Long studentID = registrationService.registerStudent(
                new Student("Alan", "Turing", "Computer Science"));
        System.out.println("Student Registered with ID: "
                + studentID);
        Long studentID2 = registrationService.registerStudent(
                new Student("Johannes", "Kepler", "Astronomy"));
        System.out.println("Student Registered with ID: "
                + studentID2);
    }
}