package impl;

import models.TourData;
import models.UserData;

public interface TourUserDao {
	
	TourData getTourByUserId(int user_id);
	UserData getUserByTourCount();
	//boolean saveTourForUser(TourData tourData, UserData userData);
}
