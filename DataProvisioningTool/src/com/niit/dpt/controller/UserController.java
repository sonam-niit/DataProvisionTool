package com.niit.dpt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.dpt.dao.PlanDao;
import com.niit.dpt.dao.PlanDaoImpl;
import com.niit.dpt.dao.UserDao;
import com.niit.dpt.dao.UserDaoImpl;
import com.niit.dpt.dataplan.DataPlan;
import com.niit.dpt.dataplan.PackDetails;
import com.niit.dpt.mailservice.Mailer;
import com.niit.dpt.model.User;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UserDao dao=new UserDaoImpl();
    PlanDao plandao=new PlanDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		HttpSession session;
		String userOperations = request.getServletPath();
		User user;
		switch (userOperations) {
		case "/": login(request, response); break;
		case "/registerPage": register(request, response); break;
		case "/register":
				try {
					createUser(request, response);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
		case "/profile":
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
			dispatcher.forward(request, response);
		case "/validate":
				
					String username = request.getParameter("email");
					session = request.getSession();

					String pw = request.getParameter("pword");
					user = dao.validateUser(username, pw);
					
					if (user!= null)
						{
							session.setAttribute("user", user);
							dispatcher = request.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
							dispatcher.forward(request, response);
						}
						
					 else {
						
						String message = "Invalid Username & Password";
						request.setAttribute("message", message);
						dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
						dispatcher.include(request, response);
					}

				
				break;
		case "/welcome":	
			if (request.getParameter("productId")!=null)
			{
				List<DataPlan> list=null;
				int id=Integer.parseInt(request.getParameter("productId"));
				if(id==1)
					list=PackDetails.airtelPlans();
				else if(id==2)
					list=PackDetails.ideaPlans();
				else if(id==3)
					list=PackDetails.jioPlans();
				else
					list=null;
				request.setAttribute("productId", id);
				request.setAttribute("list", list);
				dispatcher = request.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
				dispatcher.forward(request, response);
				
			}
			else
			{
							dispatcher = request.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
							dispatcher.forward(request, response);
			}
		case "/confirm":
				if(request.getParameter("info")!=null && request.getParameter("sim")!=null)
				{
				request.setAttribute("message", "plan purchased successfully, It will be activated after 24 hours");
				int id=Integer.parseInt(request.getParameter("sim"));
				List<DataPlan> list=null;
				if(id==1)
					list=PackDetails.airtelPlans();
				else if(id==2)
					list=PackDetails.ideaPlans();
				else if(id==3)
					list=PackDetails.jioPlans();
				DataPlan plan=list.get(Integer.parseInt(request.getParameter("info")));
				session=request.getSession();
				user=(User)session.getAttribute("user");
				if(plandao.addPlan(plan, user.getUid()))
				{
					Mailer mailer=new Mailer();
					String msg="Plan Details: "+plan.getDescription()+"\nPrice: "+plan.getPrice()+"\nValidity: "+plan.getValidity();
					//mailer.send(user.getEmail(), "Plan activation for your "+user.getPhone(), msg);
					request.setAttribute("plan", plan);
					dispatcher = request.getRequestDispatcher("/WEB-INF/views/activatedPlan.jsp");
					dispatcher.forward(request, response);
				}
				}
				break;
		case "/dataplan":
			session=request.getSession();
			user=(User)session.getAttribute("user");
			List<DataPlan> list1=plandao.findPlanByName(user.getUid());
			request.setAttribute("plans", list1);
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/activatedPlan.jsp");
			dispatcher.forward(request, response);
			break;
		case "/purchase":
					
					
					if(request.getParameter("sim")==null || request.getParameter("planid")==null)
					{
						request.setAttribute("info", "No plan selected kindly select in again");
						//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
						//dispatcher.forward(request, response);
					}
					else
					{
						int planId=Integer.parseInt(request.getParameter("planid"));
						int simId=Integer.parseInt(request.getParameter("sim"));
						List<DataPlan> list=null;
						if(simId==1)
							list=PackDetails.airtelPlans();
						else if(simId==2)
							list=PackDetails.ideaPlans();
						else if(simId==3)
							list=PackDetails.jioPlans();
						DataPlan plan=list.get(planId);
						request.setAttribute("plan", plan);
						//request.setAttribute("planid", planId);
						request.setAttribute("sim", simId);
						dispatcher = request.getRequestDispatcher("/WEB-INF/views/confirm.jsp");
						dispatcher.forward(request, response);
						
					}
					break;
		case "/logout":
						request.setAttribute("message","Successfully Logged Out");
						session=request.getSession();
						session.invalidate();
						login(request, response);
		default:
			break;
		}
	}

	private void createUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		User user = new User();
		
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		user.setPassword(request.getParameter("pword"));
		user.setSimType(request.getParameter("sim"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("pword"));
		
		int result=dao.insert(user);
		
		if(result>0)
		{
			request.setAttribute("message","Successfully Registered.. Login Here..");
			login(request, response);
		}
		else
		{
			request.setAttribute("message","Error while registering Tray Again..");
			register(request, response);
		}

	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);

	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void validateUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("email");
		//System.out.println("Stored from html" + username);
		HttpSession session = request.getSession();

		String pw = request.getParameter("password");
		User user = dao.getUserByEmail(username);
		
		if (user!= null) {
			{
				session.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
				dispatcher.forward(request, response);
			}
			
		} else {
			
			String message = "Invalid Username & Password";
			request.setAttribute("message", message);
			login(request, response);
		}

	}

	
}
