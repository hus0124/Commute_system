package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommuteDTO;
import model.adminStatsExcute;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		CommuteDTO mainDTO = new CommuteDTO();
		adminStatsExcute mainExcute = new adminStatsExcute();
		List<CommuteDTO> mainList = null; 
		String checkMonth = request.getParameter("month");
		String checkhour = request.getParameter("hour");
		
		if(checkMonth.equals("")) {
			response.sendRedirect("pop-up2.jsp");
		}
		else if(checkhour.equals("")) {
			mainDTO.setMonth(Integer.parseInt(checkMonth));
			
			try {
				mainList = new ArrayList<CommuteDTO>();
				mainList = mainExcute.readList(mainDTO);
				System.out.println(mainList.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("statsView.jsp");
			request.setAttribute("searchList", mainList);
			//request.setAttribute("checkmonth", checkMonth);
			dispatcher.forward(request, response);
		}
		else {
			mainDTO.setMonth(Integer.parseInt(checkMonth));
			mainDTO.setWorktime(Integer.parseInt(checkhour));
			
			try {
				mainList = new ArrayList<CommuteDTO>();
				mainList = mainExcute.readList2(mainDTO);
				System.out.println(mainList.toString());
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("statsView.jsp");
			request.setAttribute("searchList2", mainList);
			//request.setAttribute("checkmonth", checkMonth);
			//request.setAttribute("checkhour", checkhour);
			dispatcher.forward(request, response);
			
		}
	}
	

}
