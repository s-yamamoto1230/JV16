<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	//文字コードの指定
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	String session_name = (String)session.getAttribute("login_name");
	if (session_name == null) {
		response.sendRedirect("syouhin_index.jsp");
	}

	//入力データ受信
  String syou_noStr  = request.getParameter("syouhin_no");
  String syou_nameStr = request.getParameter("syouhin_name");
  String syou_preStr = request.getParameter("syouhin_pre");
  String syou_msgStr = request.getParameter("syouhin_msg");
  String syou_iconStr = request.getParameter("syouhin_icon");

	//データベースに接続するために使用する変数宣言
	Connection con = null;
	Statement stmt = null;
	StringBuffer SQL = null;
	ResultSet rs = null;

	//ローカルのMySQLに接続する設定
	//String USER ="root";
	//String PASSWORD = "";
	//String URL ="jdbc:mysql://localhost/nhs90345db";

	//サーバーのMySQLに接続する設定
	String USER = "nhs90345";
	String PASSWORD = "b19931230";
  String URL ="jdbc:mysql://192.168.121.16/nhs90345db";

	String DRIVER = "com.mysql.jdbc.Driver";

	//確認メッセージ
	StringBuffer ERMSG = null;

	//更新件数
	int upd_count = 0;

	try{	// ロードに失敗したときのための例外処理
		// JDBCドライバのロード
		Class.forName(DRIVER).newInstance();

		// Connectionオブジェクトの作成
		con = DriverManager.getConnection(URL,USER,PASSWORD);

		//Statementオブジェクトの作成
		stmt = con.createStatement();

		//SQLステートメントの作成（選択クエリ）
		SQL = new StringBuffer();

		//SQL文の構築（DB更新）
    SQL.append("update syou_tbl set syou_name ='");
		SQL.append(syou_nameStr);
		SQL.append("',syou_pre ='");
		SQL.append(syou_preStr);
		SQL.append("',syou_msg = '");
		SQL.append(syou_msgStr);
		SQL.append("',syou_icon ='");
		SQL.append(syou_iconStr);
		SQL.append("' where syou_no =");
		SQL.append(syou_noStr);


      System.out.println(SQL.toString());
		upd_count = stmt.executeUpdate(SQL.toString());

	}	//tryブロック終了
	catch(ClassNotFoundException e){
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	}
	catch(SQLException e){
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	}
	catch(Exception e){
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
	}

	finally{
		//各種オブジェクトクローズ
	    try{
	    	if(rs != null){
	    		rs.close();
	    	}
	    	if(stmt != null){
	    		stmt.close();
			}
	    	if(con != null){
	    		con.close();
			}
	    }
		catch(SQLException e){
		ERMSG = new StringBuffer();
		ERMSG.append(e.getMessage());
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>『商品更新』</title>
</head>
<body>
<%
	if(upd_count == 0){  //更新処理失敗
%>
	更新NG<br>
	  <%= "更新処理が失敗しました" %>
<%
	}else{  //更新OK
%>
	更新OK<br>
	  <%= upd_count + "件　更新が完了しました" %>
<%
	}
%>
<br><br>
<% if(ERMSG != null){ %>
予期せぬエラーが発生しました<br />
<%= ERMSG %>
<% }else{ %>
※エラーは発生しませんでした<br/>
<% } %>

  <a href="./syouhin_main.jsp">メインに戻る</a>
	<form method="post" action="./syouhin_index.jsp">
		<input type="hidden" name="logout" value="logout">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>
