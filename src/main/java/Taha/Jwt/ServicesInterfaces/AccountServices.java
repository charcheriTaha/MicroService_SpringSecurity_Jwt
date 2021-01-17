package Taha.Jwt.ServicesInterfaces;

import Taha.Jwt.Entities.AppRole;
import Taha.Jwt.Entities.AppUser;

public interface AccountServices {
	//méthode pour ajouter un user 
	public AppUser save(AppUser user );
	//méthode pour ajouter un role
	public AppRole save(AppRole role );
	//méthode pour associer un role à un user  
	public void addRoleToUser(String userName ,String roleName);
	//méthode pour chrhuer un user avec son username
	public AppUser findUserByUsername(String userName);

}
