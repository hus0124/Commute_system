package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class todayViewExcute extends DAOBase implements todayView {
	List<CommuteDTO> alist = new ArrayList<CommuteDTO>();
	
	@Override
	public List<CommuteDTO> todaySelect(CommuteDTO cDTO) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		CommuteDTO tempDTO = null;
		
		try {
			String sql = "SELECT * FROM sample\r\n" + 
					"WHERE DATE_FORMAT(comein, '%Y-%m-%d')= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cDTO.getWorkdate());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tempDTO = new CommuteDTO();
				tempDTO.setId(rs.getString(1));
				tempDTO.setWorkername(rs.getString(2));
				tempDTO.setIsout(rs.getString(3));
				tempDTO.setComein(rs.getString(4));
				tempDTO.setComeout(rs.getString(5));
				tempDTO.setWorktime(rs.getInt(6));
				alist.add(tempDTO);
			}
			System.out.println("today list DB success");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			closeDBResources(rs, pstmt, conn);
		}
		
		return alist;
	}

}
