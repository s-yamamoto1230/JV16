<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>

<%
  //文字コードの指定
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");

  String session_name = (String)session.getAttribute("login_name");
  if (session_name == null) {
    response.sendRedirect("syouhin_index.jsp");
  }

  //入力データ受信
  String syou_noStr  = request.getParameter("syou_no");

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

  //ヒットフラグ
  int hit_flag = 0;

  //HashMap（1件分のデータを格納する連想配列）
  HashMap<String,String> map = null;

  //ArrayList（すべての件数を格納する配列）
  ArrayList<HashMap> list = null;
  list = new ArrayList<HashMap>();

  try{  // ロードに失敗したときのための例外処理
    // JDBCドライバのロード
    Class.forName(DRIVER).newInstance();

    // Connectionオブジェクトの作成
    con = DriverManager.getConnection(URL,USER,PASSWORD);

    //Statementオブジェクトの作成
    stmt = con.createStatement();

    //SQLステートメントの作成（選択クエリ）
    SQL = new StringBuffer();

    //SQL文の構築（選択クエリ）
    SQL.append("select syou_no,syou_name,syou_pre,syou_msg,syou_icon,pre_name from syou_tbl,ken_tbl where syou_pre = pre_no and syou_no = ");
    SQL.append(syou_noStr);
    SQL.append(" order by syou_no ");
//      System.out.println(SQL.toString());

    //SQL文の実行（選択クエリ）
    rs = stmt.executeQuery(SQL.toString());

    //入力したデータがデータベースに存在するか調べる
    if(rs.next()){  //存在する
      //ヒットフラグON
      hit_flag = 1;

        //検索データをHashMapへ格納する
        map = new HashMap<String,String>();
      map.put("syou_no",rs.getString("syou_no"));
      map.put("syou_name",rs.getString("syou_name"));
      map.put("syou_pre",rs.getString("syou_pre"));
      map.put("pre_name",rs.getString("pre_name"));
      map.put("syou_msg",rs.getString("syou_msg"));
      map.put("syou_icon",rs.getString("syou_icon"));

      //1件分のデータ(HashMap)をArrayListへ追加
      list.add(map);
    }else{  //存在しない
      //ヒットフラグOFF
      hit_flag = 0;
    }
  } //tryブロック終了
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
<title>『商品削除』</title>
</head>
<BODY BGCOLOR="#FFFFFF">
<BR><BR>
<h1>商品削除</h1>
<h2>以下の内容を削除しますか？</h2>
<BR><BR>
<FORM METHOD="POST" ACTION="./syouhin_delete.jsp">

    <input type="hidden" name="syou_no" value="<%= list.get(0).get("syou_no") %>">

<table border="1">
<tr>
  <th>項目名</th><th>内容</th>
</tr>
<tr>
  <td>商品No</td>
  <td>
    <%= list.get(0).get("syou_no") %>
  </td>
</tr>
<tr>
  <td bgcolor="#99CC00">商品名</td>
    <td>
      <%= list.get(0).get("syou_name") %>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">生産地</td>
    <td>
      <%= list.get(0).get("pre_name") %>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">コメント</td>
    <td>
      <%= list.get(0).get("syou_msg") %>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">アイコン</td>
    <td>
      <img src="./image/<%= list.get(0).get("syou_icon") %>.png" height="70px" width="70px" />
    </td>
  </tr>
</table>
<br>
  <INPUT TYPE="SUBMIT" VALUE="削除">
</form>
    <form method="post" action="./syouhin_index.jsp">
      <input type="hidden" name="logout" value="logout">
      <input type="submit" value="ログアウト">
    </form>
  <a href="./syouhin_main.jsp">メインに戻る</a>

</body>
</html>
