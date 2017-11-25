package function; 

import java.util.ArrayList;

import db.jdbcmysql;
import function.YouBikeItem;

public class YouBikeData extends jdbcmysql { 
	
	public ArrayList<YouBikeItem> GetStop(){
		
		StringBuffer sSql = new StringBuffer();
		ArrayList<YouBikeItem> result = new ArrayList<YouBikeItem>();
		
		try {
			
			sSql.append("SELECT * FROM daytrip.youbikestop order by id asc");
			
			pst = con.prepareStatement(sSql.toString()); 
			pst.clearParameters();
			
    		rs = pst.executeQuery();


			while(rs.next()){
				YouBikeItem YouBikeI = new YouBikeItem();
				
				YouBikeI.setId(rs.getInt("id"));
				YouBikeI.setLat(rs.getDouble("lat"));
				YouBikeI.setLng(rs.getDouble("lng"));
				YouBikeI.setStation(rs.getString("station"));
				YouBikeI.setSarea(rs.getString("sarea"));
				YouBikeI.setAddress(rs.getString("address"));
				YouBikeI.setTotal(rs.getInt("total"));
				
				result.add(YouBikeI);
			}
			
			return result;
		      
		}
		catch(Exception SQLE)
		{ 
			System.out.println("SQLException: " + SQLE.toString()); 
		}finally{
			Close();
		}
		
		return null;

	}
	
	public ArrayList<YouBikeItem> GetHsinchu(){
		
		StringBuffer sSql = new StringBuffer();
		ArrayList<YouBikeItem> result = new ArrayList<YouBikeItem>();
		
		try {
			
			sSql.append("SELECT * FROM daytrip.hsinchu order by id asc");
			
			pst = con.prepareStatement(sSql.toString()); 
			pst.clearParameters();
			
    		rs = pst.executeQuery();


			while(rs.next()){
				YouBikeItem YouBikeI = new YouBikeItem();
				
				YouBikeI.setId(rs.getInt("id"));
				YouBikeI.setLat(rs.getDouble("lat"));
				YouBikeI.setLng(rs.getDouble("lng"));
				YouBikeI.setStation(rs.getString("station"));
				YouBikeI.setAddress(rs.getString("address"));
				YouBikeI.setTotal(rs.getInt("total"));
				
				int total = rs.getInt("total");
				if(total > 100){
					//red
					YouBikeI.setImage("r.png");
				}else if(total <= 100 && total > 50){
					//yellow
					YouBikeI.setImage("o.png");
				}else if(total <= 50){
					//green
					YouBikeI.setImage("g.png");
				}
				
				result.add(YouBikeI);
			}
			
			return result;
		      
		}
		catch(Exception SQLE)
		{ 
			System.out.println("SQLException: " + SQLE.toString()); 
		}finally{
			Close();
		}
		
		return null;

	}

	public ArrayList<YouBikeItem> GetCircle(){
		
		StringBuffer sSql = new StringBuffer();
		ArrayList<YouBikeItem> result = new ArrayList<YouBikeItem>();
		
		try {
			
			sSql.append("SELECT * FROM daytrip.circle order by id asc");
			
			pst = con.prepareStatement(sSql.toString()); 
			pst.clearParameters();
			
    		rs = pst.executeQuery();


			while(rs.next()){
				YouBikeItem YouBikeI = new YouBikeItem();
				
				YouBikeI.setId(rs.getInt("id"));
				YouBikeI.setLat(rs.getDouble("lat"));
				YouBikeI.setLng(rs.getDouble("lng"));
				YouBikeI.setStation(rs.getString("station"));
				YouBikeI.setAddress(rs.getString("address"));

				result.add(YouBikeI);
			}
			
			return result;
		      
		}
		catch(Exception SQLE)
		{ 
			System.out.println("SQLException: " + SQLE.toString()); 
		}finally{
			Close();
		}
		
		return null;

	}	
}