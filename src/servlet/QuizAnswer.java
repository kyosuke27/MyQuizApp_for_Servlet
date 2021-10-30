package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Question;
import Bean.QuestionDao;

/**
 * Servlet implementation class QuizAnswer
 */
@WebServlet("/QuizAnswer")
public class QuizAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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

		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/question.jsp");
		//ここをDBから値を取って来る
		QuestionDao dao=new QuestionDao();
		
		//可変長配列にDBより取得情報を
		ArrayList<Question> questions= dao.getQuestion();
		request.setAttribute("questions", questions);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =getServletContext().getRequestDispatcher("/WEB-INF/answer.jsp");
		
		String[] anStrings= {
				"東京",
				"獅白ぼたん",
				"ときのそら"
		};
		//フォームより値を受け取る
		request.setCharacterEncoding("UTF-8");
		
		String[] answerStrings= {
				request.getParameter("question0"),
				request.getParameter("question1"),
				request.getParameter("question2")
		};
		
		//受け取った値を比較して結果を求める。
		int answer=0;
		for(int i=0;i<anStrings.length;i++) {
			if (answerStrings[i]!=null) {
				if(answerStrings[i].equals(anStrings[i])) {
					answer++;
				}
			}
		}
		
		request.setAttribute("ansCount", answer);
		dispatcher.forward(request, response);
		
	}

}
