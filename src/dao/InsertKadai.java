package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.Person;

public class InsertKadai {

	public int insertPerson(Person person) {
		// TODO 自動生成されたメソッド・スタブ
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int resultCount = 0;

		try {
			//driverクラスを使うための宣言（おまじない）
			Class.forName("com.mysql.jdbc.Driver");

			//dbとの接続①mysqlのurlと文字コード、②user、③パスワード(各自インストール時に設定したもの）
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/kadaidb?useUnicode=true&characterEncoding=UTF-8",
					"root",
					"04ssk29shy");
			//dbとやりとりするための窓口
			stmt = con.createStatement();
			//update文の実行
			resultCount = stmt.executeUpdate("insert into kadaidb.person (name,age) values ('"+person.getName()+"',"+ person.getAge()+")");
			//結果の表示
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//接続を閉じる
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resultCount;
	}

	}


