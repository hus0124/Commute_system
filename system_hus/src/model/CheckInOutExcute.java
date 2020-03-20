package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckInOutExcute extends DAOBase implements CheckInOut {
		
	@Override
	public int checkinout(CommuteDTO cDTO) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		
		try {
			String sql = "SELECT isout FROM sample WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cDTO.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cDTO.setIsout(rs.getString(1));
			}
			System.out.println(cDTO.getIsout());
			System.out.println("checkinout success");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("checkinout fail");
		}
		finally {
			closeDBResources(rs, pstmt, conn);
		}
		return 0;
	}

}
