package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateWorkingTimeExcute extends DAOBase implements UpdateWorkingTime {

	@Override
	public int updateWorkingTime(CommuteDTO cDTO) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		
		try {
			String sql = "update sample SET worktime = \r\n" + 
					"(SELECT HOUR(comeout) - HOUR(comein) FROM sample WHERE id=?)\r\n" + 
					"WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cDTO.getId());
			pstmt.setString(2, cDTO.getId());
			pstmt.executeUpdate();
			pstmt.close();
			
			String sql2 = "SELECT worktime FROM sample WHERE id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, cDTO.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cDTO.setWorktime(rs.getInt(1));
			}
			
			System.out.println("DB update worktime success");
			
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("DB update worktime fail");
		}
		finally {
			closeDBResources(rs, pstmt, conn);
		}
		return 0;
	}

}
