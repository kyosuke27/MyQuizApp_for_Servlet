package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Question;
import Bean.QuestionDao;

/**
 * Servlet implementation class AddPageController
 */
@WebServlet("/AddPageController")
public class AddPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Question addQuestion;
	QuestionDao questinDao;
	RequestDispatcher dispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/add_question.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		questinDao = new QuestionDao();
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("return_top") == null) {
			//登録処理を行う
			questinDao.setQuestion(request.getParameter("question"), request.getParameter("answer"));
		}
		//「登録」・「戻る」ボタンを押下した後の処理は共通してメインページへ戻る
		response.sendRedirect("/myQuiz/QuizAnswer");
	}

}
