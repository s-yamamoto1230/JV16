<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
  String namaeStr = request.getParameter("namae");
  String seibetuStr = request.getParameter("seibetu");
  String toshiStr = request.getParameter("toshi");
  String address1Str = request.getParameter("address1");
  if(seibetuStr.equals("1")){
  seibetuStr ="男性";
  }else{
  seibetuStr ="女性";
  }
%>
<html>
<head>
  <title>param2.jsp</title>
</head>
  <body>
    paramu2.jsp
    <center>
      <h1>HTMLさんから届きました
        <br>
        <br>
        あなたは
        <br>
        <font color="deeppink">
          <%= address1Str %>
        </font>
        にお住いの
        <font color="deeppink">
          <%= namaeStr %>
        </font>
        さんですね
        <br>
        ほうでもって
        <br>
        <font color="deeppink">
          <%= toshiStr %>
        </font>
        歳の
        <font color="deeppink">
          <%= seibetuStr %>
        </font>
        なんですね
      </h1>
    </center>
    <hr>
    <a href="./param2.html">戻る</a>
  </body>
</html>