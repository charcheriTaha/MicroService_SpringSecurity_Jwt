package Taha.Jwt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Taha.Jwt.Entities.Task;
import Taha.Jwt.Repository.TaskRepository;

@RestController 
public class TaskRestController {
    
	@Autowired
	private TaskRepository TR ;
	@GetMapping("/tasks") 
	public List<Task> listTasks(){
		return TR.findAll();
	}
	@PostMapping("/addtasks")
	public Task save(@RequestBody Task t ) {
		return TR.save(t);
	}
}
