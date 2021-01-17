package Taha.Jwt;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Taha.Jwt.Entities.AppRole;
import Taha.Jwt.Entities.AppUser;
import Taha.Jwt.Entities.Task;
import Taha.Jwt.Repository.TaskRepository;
import Taha.Jwt.ServicesInterfaces.AccountServices;

@SpringBootApplication
public class JwtSpringSecurityApplication implements CommandLineRunner {
// CommandLineRunner elle va me permettre d'exécuter la méthode run aprés léxécution du projet 
	@Autowired
	TaskRepository TR;
	@Autowired
	AccountServices  accountServices;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}
	/* l'orsque lapplication est démarer toute méthode quii utilise l'annotation Bean va s'exécuter et lorsque ils sont exécuter le 
	 * résultat devient un bean spring et ====> donc on peut l'injecter partout 
	*/
    @Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//ajouter des user et roles
		accountServices.save(new AppUser(null,"admin","1234",null));
		accountServices.save(new AppUser(null,"user","1234",null));
		accountServices.save(new AppRole(null,"ADMIN"));
		accountServices.save(new AppRole(null,"USER"));
		accountServices.addRoleToUser("admin", "ADMIN");
		accountServices.addRoleToUser("user", "USER");
	
		
		Stream.of("T1", "T2", "T3").forEach(t -> {
			TR.save(new Task(null, t));
		});

		TR.findAll().forEach(t -> {
			System.out.println(t.getTaskName());
		});
	}

}
