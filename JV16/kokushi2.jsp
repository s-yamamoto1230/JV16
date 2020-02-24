<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
  String namaeStr = request.getParameter("namae");
  String gakunenStr = request.getParameter("gakunen");
  String gozenStr = request.getParameter("gozen");
  String gogoStr = request.getParameter("gogo");

  int gozen = Integer.parseInt(gozenStr);
  int gogo = Integer.parseInt(gogoStr);
  String goukei;
  if (gozen>=65 && gogo>=65 && gozen+gogo>=140) {
    goukei = "合格";
  }else{
    goukei = "不合格";
  }
%>
<html>
<head>
  <title>kokushi2.jsp</title>
</head>
  <body>
    kokushi2.jsp
    <center>
      <h1>国家試験判定
        <br>
        <br>
        <font color="deeppink">
          <%= gakunenStr %>
        </font>
        の
        <font color="deeppink">
          <%= namaeStr %>
        </font>
        さん
        <br>
        あなたの点数は
        <br>
        午前
        <font color="deeppink">
          <%= gozen+"点" %>
        </font>
        &emsp;午後
        <font color="deeppink">
          <%= gogo+"点" %>
        </font>
        &emsp;合計
        <font color="deeppink">
          <%= (gozen+gogo)+"点" %>
        </font>
        <br>
        判定結果は
        <font color="deeppink">
          <%= "「"+goukei+"」" %>
        </font>
        です。
      </h1>
    </center>
    <hr>
    <a href="./kokushi2.html">戻る</a>
  </body>
</html>