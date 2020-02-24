<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("UTF-8");

String logout = request.getParameter("logout");
if(logout != null){
  //セッション変数を削除
  session.removeAttribute("login_name");
}
String session_name = (String)session.getAttribute("login_name");
if(session_name != null){
  response.sendRedirect("syouhin_main.jsp");
}

%>
<HTML>
<HEAD>
<TITLE>顧客ID入力</TITLE>
<META HTTP-EQUIV="content-type"  CONTENT="text/html;charset=UTF-8">
</HEAD>
<BODY BGCOLOR="#FFFFFF">
<BR><Br>
<h1>商品管理ログイン</h1>
<BR><BR>

  <table border="1">
    <FORM  METHOD="POST" ACTION="./login_index_action.jsp">
      <tr>
        <td>顧客ID</td>
        <td> <INPUT TYPE="text" NAME="id" size="50" maxlength="20"></td>
      </tr>
      <tr>
        <td>顧客PW</td>
        <td><INPUT TYPE="text" NAME="pas" size="50" maxlength="20"></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><INPUT TYPE="SUBMIT" VALUE="ログイン"></td>
      </tr>
    </FORM>
  </table>
</BODY>
</HTML>
