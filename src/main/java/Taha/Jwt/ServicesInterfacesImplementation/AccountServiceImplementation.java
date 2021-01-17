package Taha.Jwt.ServicesInterfacesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Taha.Jwt.Entities.AppRole;
import Taha.Jwt.Entities.AppUser;
import Taha.Jwt.Repository.RoleRepository;
import Taha.Jwt.Repository.UserRepository;
import Taha.Jwt.ServicesInterfaces.AccountServices;
@Service
public class AccountServiceImplementation implements AccountServices{
 
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private RoleRepository roleRepository ;
	@Override
	public AppUser save(AppUser user) {
		// TODO Auto-generated method stub
		String hashPW=bcryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole save(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		// TODO Auto-generated method stub
		AppRole role =roleRepository.findByRoleName(roleName);
		AppUser user =userRepository.findByUsername(userName);
		user.getRoles().add(role);
		System.out.println("services ***************************************");
		System.out.println(role.toString());
		System.out.println(user.toString());
		System.out.println(user.getRoles().toString());
	}

	@Override
	public AppUser findUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(userName);
	}

}
