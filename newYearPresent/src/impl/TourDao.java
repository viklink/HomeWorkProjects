package impl;

import models.TourData;

public interface TourDao {
	
	TourData getTourByName(String name);
	TourData getTourByPrice(double price);
	boolean saveTour(TourData tourData);

}
