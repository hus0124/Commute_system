package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateStatsExcute extends DAOBase implements UpdateStats, CommuteList {
	
	List<CommuteDTO> statsList = new ArrayList<CommuteDTO>();
	
	@Override
	public List<CommuteDTO> readList() throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		CommuteDTO tempDTO = null;
		
		try {
			String sql = "SELECT id, workername, month(workdate), SUM(worktime) \r\n" + 
					"FROM sample2\r\n" + 
					"GROUP BY id, month(workdate);";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tempDTO = new CommuteDTO();
				tempDTO.setId(rs.getString(1));
				tempDTO.setWorkername(rs.getString(2));
				tempDTO.setMonth(rs.getInt(3));
				tempDTO.setWorktime(rs.getInt(4));
				statsList.add(tempDTO);
			}
			System.out.println("DB select stats success");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB select stats fail");
		}
		finally {
			closeDBResources(rs, pstmt, conn);
		}
		return statsList;
	}

	@Override
	public int updateStats(CommuteDTO cDTO) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		
		try {
			String sql2 = "SELECT comein FROM sample WHERE id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, cDTO.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cDTO.setComein(rs.getString(1));
			}
			pstmt.close();
			rs.close();
			
			String sql = "INSERT INTO sample2 VALUES(?,\r\n" + 
					"(SELECT workername FROM sample WHERE id = ?),\r\n" + 
					"?, SYSDATE(), ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cDTO.getId());
			pstmt.setString(2, cDTO.getId());
			pstmt.setString(3, cDTO.getComein());
			pstmt.setInt(4, cDTO.getWorktime());
			pstmt.executeUpdate();
			System.out.println("DB insert stats success");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB insert stats fail");
		}
		finally {
			closeDBResources(rs, pstmt, conn);
		}
		return 0;
	}

}
