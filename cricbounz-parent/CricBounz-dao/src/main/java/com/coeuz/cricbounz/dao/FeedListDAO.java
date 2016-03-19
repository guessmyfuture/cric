package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.NewsFeed;

@Repository
public class FeedListDAO extends BaseDAO <Ground, Integer> {

	@Autowired
    public FeedListDAO(SessionFactory sessionFactory) {
        super(Ground.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public List<NewsFeed> getNewsFeed() {
		List<NewsFeed> feedList = new ArrayList<NewsFeed>();
		for (int i = 0; i < 6; i++) {
			NewsFeed feed = new NewsFeed();
			feed.setPostedby("" + i);
			feed.setMediaType("TEXT");
			feed.setPostContentMessage("We are part of the Coeuz");
			feedList.add(feed);
		}
		Ground ground = new Ground();
		ground.setArea("Medavakkam");
		ground.setCity("Chennai");
		ground.setActivate("YES");
		ground.setAddress("Mari");
		ground.setLandmark("Rajesh Home");
		ground.setManager("Senthil");
		ground.setBalltype("RED CRICKET BALL");
		ground.setPitchtype("TURF");
		ground.setName("Anand");
		ground.setContactno("74987484");
		save(ground);
		return feedList;

	}

}
