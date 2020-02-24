import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class kokushi1 extends HttpServlet{
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
          String gakunenStr = req.getParameter("gakunen");
          String gozenStr = req.getParameter("gozen");
          String gogoStr = req.getParameter("gogo");

          int gozen = Integer.parseInt(gozenStr);
          int gogo = Integer.parseInt(gogoStr);

          //入力データの表示
          StringBuffer sb = new StringBuffer();
          sb.append("<html><body>");
          sb.append("parem1.java");
          sb.append("<center><h1>");
          sb.append("国家試験判定");
          sb.append("<br><br>");
          sb.append("<br><font color='deeppink'>");
          sb.append(gakunenStr+"の"+namaeStr+"さん");
          sb.append("<br>");
          sb.append("あなたの得点は");
          sb.append("<br>");
          sb.append("午前"+gozenStr+"点");
          sb.append("午後"+gogoStr+"点");
          sb.append("合計"+(gozen+gogo)+"点");
          sb.append("<br>");
          sb.append("判定結果は");
          if (gozen>=65 && gogo>=65 && gozen+gogo>=140) {
              sb.append("合格");
            }else{
              sb.append("不合格");
            }

          sb.append("です");


          sb.append("</font></h1></center></body></html>");
          out.println(sb.toString());
        }
      }