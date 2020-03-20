package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateInOutExcute extends DAOBase implements UpdateInOut {
		
	@Override
	public int updateInOut(CommuteDTO cDTO) throws SQLException {
					
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		
		if (cDTO.getIsout().equals("true")) {
		
			try {
				String sql = "UPDATE sample SET comein = NOW() WHERE id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cDTO.getId());
				pstmt.executeUpdate();
				pstmt.close();
				
				String sql2 = "SELECT date_format(comein,'%Y-%m-%d+%H:%i:%s') FROM sample WHERE id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, cDTO.getId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					cDTO.setComein(rs.getString(1));
				}
				pstmt.close();
				rs.close();
				
				String sql3 = "SELECT workername FROM sample WHERE id = ?";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setString(1, cDTO.getId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					cDTO.setWorkername(rs.getString(1));
				}
				pstmt.close();
				rs.close();
				
				String sql4 = "UPDATE sample SET isout = 'false' WHERE id = ?";
				pstmt = conn.prepareStatement(sql4);
				pstmt.setString(1, cDTO.getId());
				pstmt.executeUpdate();
								
				String sql5 = "SELECT isout FROM sample WHERE id = ?";
				pstmt = conn.prepareStatement(sql5);
				pstmt.setString(1, cDTO.getId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					cDTO.setIsout(rs.getString(1));
				}
				System.out.println("DB comein update success");
				
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("DB comein update fail");
			}
			finally {
				closeDBResources(rs, pstmt, conn);
			}
			
		}
		
		else {
			
			try {
				String sql = "UPDATE sample SET comeout = NOW() WHERE id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cDTO.getId());
				pstmt.executeUpdate();
				pstmt.close();
				
				String sql2 = "SELECT date_format(comeout,'%Y-%m-%d+%H:%i:%s') FROM sample WHERE id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, cDTO.getId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					cDTO.setComeout(rs.getString(1));
				}
				pstmt.close();
				rs.close();
				
				String sql3 = "SELECT workername FROM sample WHERE id = ?";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setString(1, cDTO.getId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					cDTO.setWorkername(rs.getString(1));
				}
				pstmt.close();
				rs.close();
				
				String sql4 = "UPDATE sample SET isout = 'true' WHERE id = ?";
				pstmt = conn.prepareStatement(sql4);
				pstmt.setString(1, cDTO.getId());
				pstmt.executeUpdate();
				
				String sql5 = "SELECT isout FROM sample WHERE id = ?";
				pstmt = conn.prepareStatement(sql5);
				pstmt.setString(1, cDTO.getId());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					cDTO.setIsout(rs.getString(1));
				}
				
				System.out.println("DB comeout update success");
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("DB comeout update fail");
			}
			finally {
				closeDBResources(rs, pstmt, conn);
			}
			
		}	
		
		return 0;
	}

}
