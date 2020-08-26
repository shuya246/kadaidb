package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Person;

public class SelectKadaiAll {
	//引数をintで渡す。
	public List<Person> selectAllSQL(){


		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//テーブルのデータを複数入れるために、リストにして配列化する。
		List<Person> personList = new ArrayList<Person>();
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
			//select文の実行
			rs = stmt.executeQuery("select * from person");
			//結果の表示
			while(rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				personList.add(person);
			}
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
		return personList;
	}

	}


