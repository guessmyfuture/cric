package com.coeuz.cricbounz.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Matches;
import com.coeuz.cricbounz.model.Tournament;

@Repository
public class TournamentDAO extends BaseDAO<Tournament, Integer> {
		
	@Autowired
	MatchDetailsDAO matchDetailsDAO;
	
	@Autowired
	public TournamentDAO(SessionFactory sessionFactory) {
		super(Tournament.class);
        super.setSessionFactory(sessionFactory);
    }
	
	
	public void createTournament(Tournament tournament){
		tournament.setTourStartDate(convertStrToDate(tournament.getTournamentStartDate(), TimeZone.getDefault().getID()));
		tournament.setTourEndDate(convertStrToDate(tournament.getTournamentEndDate(), TimeZone.getDefault().getID()));
		tournament.setRegEndDate(convertStrToDate(tournament.getRegistrationEndDate(), TimeZone.getDefault().getID()));
		tournament.setRegStartDate(convertStrToDate(tournament.getRegistrationStartDate(), TimeZone.getDefault().getID()));
		tournament.setStatus("UPCOMING");
		saveorUpdate(tournament);
	}
	
	public List<Tournament> retrieveTournamentBasedOnStatus(String status){
		String hql = "FROM Tournament E WHERE E.status = '"+status+"'";
		Query query = getSessionFactory().openSession().createQuery(hql);
		List<Tournament> results = query.list();		
		return results;
	}
	
	public Map<Integer, List<Matches>> saveUpdatedTournmentDetails(Map<Integer, List<Matches>> updatedTournmentdetails) throws ParseException{
		
		for(Integer groupID : updatedTournmentdetails.keySet()){
			List<Matches> matchDetailsList = updatedTournmentdetails.get(groupID);
			for(Matches matchDetails:matchDetailsList){
				if(matchDetails.getMatchInfo().equals("Daily")){
					String tournmentHql="FROM Tournament tm WHERE tm.id='"+matchDetails.getTournamentId();
					Session session =getSessionFactory().openSession();
					Query tournmenQuery = session.createQuery(tournmentHql);
					List<Tournament> tournamentList =(List<Tournament>)tournmenQuery.list(); 
					if(tournamentList!=null && tournamentList.size()>0){
						Tournament tournament = tournamentList.get(0);
						Date tournmentStartDate = tournament.getTourStartDate();
						Date tournmentEndDate =tournament.getTourEndDate();
						
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						Date startDate = formatter.parse(tournmentStartDate.toString());
						Date endDate = formatter.parse(tournmentEndDate.toString());
						 
						Calendar start = Calendar.getInstance();
						start.setTime(startDate);

						Calendar end = Calendar.getInstance();
						end.setTime(endDate);
								
						while(start.before(end)){
							int slot=1;
							while(slot<=4){
								matchDetails.setGroupNumber(groupID);
								matchDetails.setPlayingDate(start.getTime());
								matchDetails.setSlotNumber(1);
								matchDetails.setStatus("Scheduled");
								matchDetailsDAO.save(matchDetails);
								slot=slot+1;
							}
																		
							start.add(Calendar.DATE, 1);
						}
						
					}
									
				}else if(matchDetails.getMatchInfo().equals("Weekends")){
					
					String tournmentHql="FROM Tournament tm WHERE tm.id='"+matchDetails.getTournamentId();
					Session session =getSessionFactory().openSession();
					Query tournmenQuery = session.createQuery(tournmentHql);
					List<Tournament> tournamentList =(List<Tournament>)tournmenQuery.list(); 
					if(tournamentList!=null && tournamentList.size()>0){
						Tournament tournament = tournamentList.get(0);
						Date tournmentStartDate = tournament.getTourStartDate();
						Date tournmentEndDate =tournament.getTourEndDate();
						
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						Date startDate = formatter.parse(tournmentStartDate.toString());
						Date endDate = formatter.parse(tournmentEndDate.toString());
						 
						Calendar start = Calendar.getInstance();
						start.setTime(startDate);

						Calendar end = Calendar.getInstance();
						end.setTime(endDate);
								
						while(start.before(end)){
							    String dateString = start.getTime().toString();
							    String delimit=" ";
							    StringTokenizer stringTokenizer = new StringTokenizer(dateString,delimit);
							    while(stringTokenizer.hasMoreTokens()){
							    	String days = stringTokenizer.nextToken();
							    	if(days.equals("Sat")){
							    		int slot=1;
										while(slot<=4){
											matchDetails.setGroupNumber(groupID);
											matchDetails.setPlayingDate(start.getTime());
											matchDetails.setSlotNumber(1);
											matchDetails.setStatus("Scheduled");
											matchDetailsDAO.save(matchDetails);
											slot=slot+1;
										}
							    		
							    	}
							    	if(days.equals("Sun")){
							    		int slot=1;
										while(slot<=4){
											matchDetails.setGroupNumber(groupID);
											matchDetails.setPlayingDate(start.getTime());
											matchDetails.setSlotNumber(1);
											matchDetails.setStatus("Scheduled");
											matchDetailsDAO.save(matchDetails);
											slot=slot+1;
										}
							    		
							    	}
							    }
							    																
						    start.add(Calendar.DATE, 1);
						}
						
					}
					
					
					
				}
				
			}
		}
				
		return updatedTournmentdetails;	
	}
	
	
	
	
	
	
	
}
