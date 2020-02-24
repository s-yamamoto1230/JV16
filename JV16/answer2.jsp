<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.lang.Math" %>
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
    
    //Calendarクラスのオブジェクト生成
    Calendar cal = Calendar.getInstance();
    
    //現在の日付設定
    cal.setTime(today);

    int toshi=0;

    //年、月、日の取得
    int yy = cal.get(Calendar.YEAR);
    int mm = cal.get(Calendar.MONTH)+1;
    int dd = cal.get(Calendar.DATE);
    
    int age = yy-nen;
    
    if (tuki <= mm && hi < dd){
      toshi = age-1;
    }else{
      toshi = age;
    }

    double random=Math.floor(Math.random()*7);
    int i=(int)random;
    String[] fortune = new String[7];
    fortune[0] ="大吉";
    fortune[1] ="中吉";
    fortune[2] ="小吉";
    fortune[3] ="吉";
    fortune[4] ="末吉";
    fortune[5] ="凶";
    fortune[6] ="大凶";

	
    String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    String pass="";
    for(int loop=1;loop<=6;loop++) {
      if(loop==1){
        double random1=Math.floor(Math.random()*52);
        int j=(int)random1;
        pass=pass+str.charAt(j);
      }else{
        double random1=Math.floor(Math.random()*62);
        int k=(int)random1;
        pass=pass+str.charAt(k);
      }
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
          <td>住所</td>
          <td>
            <%= jyuusyoStr %>
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
            <%= nen+"年"+tuki+"月"+hi+"日" %>
          </td>
        </tr>
          <td>年齢</td>
          <td>
            <%= toshi %>
          </td>
        </tr>
        <tr>
          <td>今日の運勢</td>
          <td>
            <%= fortune[i] %>
          </td>
        </tr>
        <tr>
          <td>パスワード</td>
          <td>
            <%= pass %>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <p><a href="./question2.jsp">戻る</a></p>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>