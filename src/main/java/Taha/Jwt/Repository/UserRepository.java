package Taha.Jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Taha.Jwt.Entities.AppUser;

// @RepositoryRestResource
public interface UserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}