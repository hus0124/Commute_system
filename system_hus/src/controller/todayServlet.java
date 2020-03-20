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
import model.todayViewExcute;

@WebServlet("/todayServlet")
public class todayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public todayServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String today = request.getParameter("today");
		CommuteDTO mainDTO = new CommuteDTO();
		List<CommuteDTO> mainList = new ArrayList<CommuteDTO>();
		todayViewExcute mainTodayExcute = new todayViewExcute();
		mainDTO.setWorkdate(today);
		
		try {
			mainList = mainTodayExcute.todaySelect(mainDTO);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("todayServlet mainList fail");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("todayView.jsp");
		request.setAttribute("todayList", mainList);
		dispatcher.forward(request, response);
	}

}
