package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckInOutExcute;
import model.CommuteDTO;
import model.UpdateInOutExcute;
import model.UpdateStatsExcute;
import model.UpdateWorkingTimeExcute;
import model.DAOBase;

@WebServlet("/check")
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public mainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CommuteDTO mainDTO = new CommuteDTO();
		UpdateInOutExcute mainInOutExcute = new UpdateInOutExcute();
		CheckInOutExcute mainCheckInOut = new CheckInOutExcute();
		UpdateWorkingTimeExcute mainTime = new UpdateWorkingTimeExcute();
		UpdateStatsExcute mainStats = new UpdateStatsExcute();
		List<CommuteDTO> mainList = new ArrayList<CommuteDTO>();
		List<String> idList = new ArrayList<String>();
		
		String id = request.getParameter("nfcid");
		mainDTO.setId(id);
		System.out.println(mainDTO.getId());
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		DAOBase daobase = new DAOBase();
		
		try {
			conn = daobase.getConnection();
			String sql = "SELECT id FROM sample";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ResultSetMetaData rsmd =null;
			rsmd=rs.getMetaData();
			int rowCnt = rsmd.getColumnCount();
			
			while(rs.next()) {
				for(int i = 1; i <= rowCnt; i++) {
					idList.add(rs.getString(i));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			daobase.closeDBResources(rs, pstmt, conn);
		}
		
		
		if(idList.contains(mainDTO.getId())) {
	
			if(mainDTO.getId().equals("admin")) {
				try {
					mainList = mainStats.readList();
					RequestDispatcher dispatcher2 = request.getRequestDispatcher("adminView.jsp");
					request.setAttribute("mainList", mainList);
					dispatcher2.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					mainCheckInOut.checkinout(mainDTO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				try {
					mainInOutExcute.updateInOut(mainDTO);
				} catch (SQLException e) {
					e.printStackTrace();			
				}
				
				System.out.println(mainDTO.getIsout());
				
				if(mainDTO.getIsout().equals("true")) {
					try {
						mainTime.updateWorkingTime(mainDTO);
						mainStats.updateStats(mainDTO);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
						
				RequestDispatcher dispatcher = request.getRequestDispatcher("mainView.jsp");
				request.setAttribute("mainDTO", mainDTO);
				dispatcher.forward(request, response);
						
				System.out.println(mainDTO.toString());
			}
		}
		else {
		response.sendRedirect("pop-up.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
