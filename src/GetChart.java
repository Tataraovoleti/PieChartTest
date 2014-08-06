

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.piechart.bean.UserBean;

/**
 * Servlet implementation class GetChart
 */
@WebServlet("/GetChart")
public class GetChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con=null;

    /**
     * Default constructor. 
     */
    public GetChart() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int userid=Integer.parseInt(request.getParameter("userid"));
		PreparedStatement ps;
		UserBean ub=null;
		try {
			ps = con.prepareStatement("select * from user_activity where user_id=?");
			ps.setInt(1,userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				ub=new UserBean();
				ub.setUserWork(rs.getString(2));
				ub.setUserEat(rs.getString(3));
				ub.setUserCommute(rs.getString(4));
				ub.setUserWatchTv(rs.getString(5));
				ub.setUserSleep(rs.getString(6));
			}
			 request.getSession().setAttribute("user_act", ub);
			 request.getRequestDispatcher("index.jsp").forward(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
