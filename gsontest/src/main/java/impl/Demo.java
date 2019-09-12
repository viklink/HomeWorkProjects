package impl;
import impl.DefaultUserDao;
import models.TourData;
import models.UserData;

public class Demo {
	
	public static void main(String[] args) {
		
		//UserDao userDao = new DefaultUserDao();
		
		/*UserData userData = userDao.getUserById(1);
		System.out.print("To add user enter user's id name: ");
		boolean isNewUser = userDao.saveUser(userData);
		System.out.print("To delete user's record enter user's id: ");
		userDao.deleteUserRecord();
		System.out.println(userData);
		System.out.println(isNewUser);
		*/
		//TourDao tourDao = new DefaultTourDao();
		//TourData tourData = tourDao.getTourByName("Tour2");
		//boolean isNewTour = tourDao.saveTour(tourData);
		//TourData tourPrice = tourDao.getTourByPrice(5000.0);
		
		TourUserDao tourUserDao = new DefaultTourUserDao();
		//TourData tourUserData = tourUserDao.getTourByUserId(3);
		UserData userData = tourUserDao.getUserByTourCount();
		
		//System.out.println(tourData);
		//System.out.println(isNewTour);
		//System.out.println(tourPrice);
		System.out.println("Selected tours are " + userData);
		//System.out.println(userData);
		
	}
}
   