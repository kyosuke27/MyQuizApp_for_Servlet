package Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuestionDao {
	final String urlString = "jdbc:mysql://localhost:3306/Question?serverTimezone=UTC&useSSL=false";
	final String dbUserName = "question_servlet";
	final String dbPawString = "question";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	public ArrayList<Question> getQuestion() {
		ArrayList<Question> questions=new ArrayList<>();
		Question question=null;
		String sql = "select * from QUESTION";

		try {
			// JDBC Driver の登録
			Class.forName("com.mysql.jdbc.Driver");

			// Connectionの作成
			conn = DriverManager.getConnection(urlString, dbUserName, dbPawString);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = conn.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rset = pstmt.executeQuery();
			while (rset.next()) {
				question=new Question(Integer.parseInt(rset.getString("questionId")),rset.getString("question"),rset.getString("answer"));
				questions.add(question);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return questions;
		} finally {
			try {
				// 念のため、finallyでDBとの接続を切断しておく
				conn.close();
			} catch (Exception e) {
			}
		}
		return questions;
	}

	public void setQuestion(String question,String answer) {
		
		String sql="insert into QUESTION(question,answer) values(?,?)";
		
		try {
			// JDBC Driver の登録
			Class.forName("com.mysql.jdbc.Driver");

			// Connectionの作成
			conn = DriverManager.getConnection(urlString, dbUserName, dbPawString);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,question);
			pstmt.setString(2,answer);
			// SQL文の実行(データ取得)
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("done");
			try {
				// 念のため、finallyでDBとの接続を切断しておく
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public boolean deleteQuestion(int questionId) {
		boolean deletFlg=false;
		
		String deleteSqlString="DELETE FROM QUESTION WHERE questionid=?";
		
		
		try {
			// JDBC Driver の登録
			Class.forName("com.mysql.jdbc.Driver");

			// Connectionの作成
			conn = DriverManager.getConnection(urlString, dbUserName, dbPawString);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = conn.prepareStatement(deleteSqlString);
			pstmt.setInt(1, questionId);
			// SQL文の実行(データ取得)
			pstmt.executeUpdate();
			deletFlg=true;
			
		}catch (Exception e) {
			return deletFlg;
		} finally {
			System.out.println("done");
			try {
				// 念のため、finallyでDBとの接続を切断しておく
				conn.close();
			} catch (Exception e) {
			}
		}
		return deletFlg;
		
	}

}
