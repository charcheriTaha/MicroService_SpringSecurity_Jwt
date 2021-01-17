package Taha.Jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Taha.Jwt.Entities.AppRole;

//@RepositoryRestResource
public interface RoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}