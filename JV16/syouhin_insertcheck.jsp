<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
  //文字コードの指定
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");

  String session_name = (String)session.getAttribute("login_name");
  if (session_name == null) {
    response.sendRedirect("syouhin_index.jsp");
  }

  //入力データ受信
  String syouhin_nameStr  = request.getParameter("syouhin_name");
  String syouhin_preStr = request.getParameter("syouhin_pre");
  String syouhin_msgStr = request.getParameter("syouhin_msg");
  String syouhin_iconStr = request.getParameter("syouhin_icon");

  String str =syouhin_preStr;
  String[] pre_nameStr = str.split(",", 0);


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>『商品登録』</title>
</head>
<BODY BGCOLOR="#FFFFFF">
<BR><BR>
<h1>商品登録</h1>
<h2>以下の内容で登録しますか？</h2>
<BR><BR>
<FORM METHOD="POST" ACTION="./syouhin_insertout.jsp">

    <input type="hidden" name="syouhin_name" value="<%= syouhin_nameStr %>">
    <input type="hidden" name="syouhin_pre" value="<%= pre_nameStr[0] %>">
    <input type="hidden" name="syouhin_msg" value="<%= syouhin_msgStr %>">
    <input type="hidden" name="syouhin_icon" value="<%= syouhin_iconStr %>">

<table border="1">
<tr>
  <th>項目名</th><th>内容</th>
</tr>
<tr>
  <td bgcolor="#99CC00">商品名</td>
    <td>
      <%= syouhin_nameStr %>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">生産地</td>
    <td>
      <%= pre_nameStr[1] %>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">コメント</td>
    <td>
      <%= syouhin_msgStr %>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">アイコン</td>
    <td>
      <img src="./image/<%= syouhin_iconStr %>.png" height="70px" width="70px" />
    </td>
  </tr>
</table>
<br>
  <INPUT TYPE="SUBMIT" VALUE="登録">
</form>
  <button id="correction" type="button" href="javascript:void(0)" onclick="javascript:history.back()">修正</button>
  <form method="post" action="./syouhin_index.jsp">
    <input type="hidden" name="logout" value="logout">
    <input type="submit" value="ログアウト">
  </form>


</body>
</html>
