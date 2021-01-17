package Taha.Jwt.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import Taha.Jwt.Entities.Task;
public interface TaskRepository extends JpaRepository<Task,Long>{

}
