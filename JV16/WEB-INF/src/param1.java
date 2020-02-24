import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class param1 extends HttpServlet{
  public void doPost(
      HttpServletRequest req,
      HttpServletResponse res)
        throws ServletException,IOException{
          PrintWriter out;
          req.setCharacterEncoding("UTF-8");
          res.setContentType("text/html;charset=UTF-8");
          out=res.getWriter();
          //webブラウザのformからパラメータを取得
          String namaeStr = req.getParameter("namae");
          String seibetuStr = req.getParameter("seibetu");
          String toshiStr = req.getParameter("toshi");
          String address1Str = req.getParameter("address1");

          //入力データの表示
          StringBuffer sb = new StringBuffer();
          sb.append("<html><body>");
          sb.append("parem1.java");
          sb.append("<center><h1>");
          sb.append("htmlさんから届きました");
          sb.append("<br><br>");
          sb.append("あなたは");
          sb.append("<br><font color='deeppink'>");
          sb.append(address1Str);
          sb.append("</font>");
          sb.append("にお住いの");
          sb.append("<font color='deeppink'>");
          sb.append(namaeStr);
          sb.append("<font>");
          sb.append("さんですね");
          sb.append("<br>");
          sb.append("ほいでもって");
          sb.append("<br>");
          sb.append("<font color='deeppink'>");
          sb.append(toshiStr);
          sb.append("</font>");
          sb.append("歳の");
          sb.append("<font color='deeppink'>");
          if(seibetuStr.equals("1")){
            sb.append("男性");
          }else{
            sb.append("女性");
          }
          sb.append("</font>");
          sb.append("なんですね");
          sb.append("<h1></center></body></html>");
          out.println(sb.toString());
        }
      }