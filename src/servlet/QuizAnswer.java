package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Bean.Question;
import Bean.QuestionDao;

/**
 * Servlet implementation class QuizAnswer
 */
@WebServlet("/QuizAnswer")
public class QuizAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session;
    RequestDispatcher dispatcher;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/question.jsp");
		//ここをDBから値を取って来る
		QuestionDao dao=new QuestionDao();
		
		//可変長配列にDBより取得情報を
		ArrayList<Question> questions= dao.getQuestion();
		session=request.getSession();
		//セッションに値が入っていた場合初期化する
		if (session.getAttribute("questions")!=null) {
			session.removeAttribute("questions");
		}	
		request.setAttribute("questions", questions);
		//問題数をセッションとして管理する
		session.setAttribute("question",questions);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatcher =getServletContext().getRequestDispatcher("/WEB-INF/answer.jsp");
		session=request.getSession();
		
		ArrayList<Question> questions=(ArrayList<Question>)session.getAttribute("question");
		
		//フォームより値を受け取る
		request.setCharacterEncoding("UTF-8");
		
		//受け取った値を比較して結果を求める。
		int answer=0;
		for(int i=0;i<questions.size();i++) {
			String answerString=request.getParameter(""+questions.get(i).getQuestionId());
			if (questions.get(i).getAnswerString().equals(answerString)){
				answer++;
			}
		}
		
		request.setAttribute("ansCount", answer);
		dispatcher.forward(request, response);
		
	}

}
