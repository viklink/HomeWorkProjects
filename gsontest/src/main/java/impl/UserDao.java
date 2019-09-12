package impl;


import models.UserData;

public interface UserDao {
	
	UserData getUserById(int id);
	boolean saveUser(UserData userData);
	void deleteUserRecord();

}
