package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class adminStatsExcute extends DAOBase implements adminStatsList {
	List<CommuteDTO> alist = new ArrayList<CommuteDTO>();
	List<CommuteDTO> blist = new ArrayList<CommuteDTO>();
	
	@Override
	public List<CommuteDTO> readList(CommuteDTO cDTO) throws SQLException {
						
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		CommuteDTO tempDTO = null;
		
		try {
			String sql = "SELECT id, workername, SUM(worktime) FROM sample2 WHERE MONTH(workdate)=? GROUP BY id, MONTH(workdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cDTO.getMonth());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tempDTO = new CommuteDTO();
				tempDTO.setId(rs.getString(1));
				tempDTO.setWorkername(rs.getString(2));
				tempDTO.setWorktime(rs.getInt(3));
				alist.add(tempDTO);
			}
			
			System.out.println("adminStats readlist working success");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("adminStats readlist fail");
		}
		finally {
			closeDBResources(rs, pstmt, conn);
		}
			
		return alist;
	}
	
	public List<CommuteDTO> readList2(CommuteDTO cDTO) throws SQLException{
				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		CommuteDTO tempDTO = new CommuteDTO();
		
		try {
			String sql = "SELECT id, workername, SUM(worktime)\r\n" + 
					"FROM sample2\r\n" + 
					"WHERE MONTH(workdate)= ?\r\n" + 
					"GROUP BY id , MONTH(workdate)\r\n" + 
					"HAVING SUM(worktime) > ?;  ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cDTO.getMonth());
			pstmt.setInt(2,  cDTO.getWorktime());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tempDTO = new CommuteDTO();
				tempDTO.setId(rs.getString(1));
				tempDTO.setWorkername(rs.getString(2));
				tempDTO.setWorktime(rs.getInt(3));
				blist.add(tempDTO);
			}
			System.out.println("adminStats readlist2 working success");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("adminStats readlist2 fail");
		}
		finally {
			closeDBResources(rs, pstmt, conn);
		}
		
		return blist;
	
	}

}
