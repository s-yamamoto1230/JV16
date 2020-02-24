<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%

  String namaeStr = request.getParameter("namae");
  String yuubinStr = request.getParameter("yuubin");
  String jyuusyoStr = request.getParameter("jyuusyo");
  String telStr = request.getParameter("tel");
  String seibetuStr = request.getParameter("seibetu");
  String nenStr = request.getParameter("nen");
  String tukiStr = request.getParameter("tuki");
  String hiStr = request.getParameter("hi");
  if (seibetuStr.equals("0")) {
    seibetuStr="男性";
  }else{
    seibetuStr="女性";
  }

    int nen = Integer.parseInt(nenStr);
    int tuki = Integer.parseInt(tukiStr);
    int hi = Integer.parseInt(hiStr);

    Date today = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(today);

    int toshi=0;

    //年、月、日の取得
    int y = cal.get(Calendar.YEAR);
    int m = cal.get(Calendar.MONTH)+1;
    int d = cal.get(Calendar.DATE);

     //今日の日付取得
    int yy = cal.get(Calendar.YEAR);
    int tlast = cal.get(Calendar.DAY_OF_YEAR);
    //365日取得
    cal.set(y,12-1,31);
    int oneyear = cal.get(Calendar.DAY_OF_YEAR);
    //来年誕生日まで
    int set_yy = cal.get(Calendar.YEAR)+1;
    int set_mm = tuki;
    int set_dd = hi;
    cal.set(Calendar.YEAR,set_yy);
    cal.set(Calendar.MONTH,set_mm-1);
    cal.set(Calendar.DATE,set_dd);
    int nlast = cal.get(Calendar.DAY_OF_YEAR);

    int last = oneyear-tlast;
    int day = last + nlast; 

    int age = y-nen;
    
    if (tuki <= m && hi <= d){
      toshi = age;
    }else{
      toshi = age-1;
    }

    cal.set(Calendar.YEAR,nen);
    cal.set(Calendar.MONTH,tuki-1);
    cal.set(Calendar.DATE,hi);
    
    int youbi = cal.get(Calendar.DAY_OF_WEEK);

    String week = "";
    switch(youbi){
      case 1 : week = "日";
      break;
      case 2 : week = "月";
      break;
      case 3 : week = "火";
      break;
      case 4 : week = "水";
      break;
      case 5 : week = "木";
      break;
      case 6 : week = "金";
      break;
      case 7 : week = "土";
      break;
    }

%>



<html>
  <head>
    <title>JSPへデータ送信</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  <body>
    <h1>入力確認画面</h1>
      <table border="1">
        <tr>
          <th>項目名</th>
          <th>内容</th>
        </tr>
        <tr>
          <td>お名前</td>
          <td>
            <%= namaeStr %>
          </td>
        </tr>
        <tr>
          <td>郵便番号</td>
          <td>
            <%= yuubinStr %>
          </td>
        </tr>
        <tr>
          <td>電話番号</td>
          <td>
            <%= telStr %>
          </td>
        </tr>
        <tr>
          <td>性別</td>
          <td>
            <%= seibetuStr %>
          </td>
        </tr>
        <tr>
          <td>生年月日</td>
          <td>
            <%= nen+"年"+tuki+"月"+hi+"日"+"("+week+")" %>
          </td>
        </tr>
          <td>年齢</td>
          <td>
            <%= toshi %>
          </td>
        </tr>
        <tr>
          <td>次の誕生日まで</td>
          <td>
            <%= "残り"+day %>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <p><a href="./question1.jsp">戻る</a></p>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>