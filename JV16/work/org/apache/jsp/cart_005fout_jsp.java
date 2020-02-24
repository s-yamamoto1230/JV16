package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_005fout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	//文字コードの指定
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	//入力した数量を格納する配列
	String[] syouhin = new String[3];
	String[] up = new String[3];
	String[] down = new String[3];

	//sessionの数量を格納する配列
	String[] syouhin_count = new String[3];

	//カートの中を空にする
	String cart_crea = request.getParameter("crea");
	String cart_crea1 = request.getParameter("crea1");
	String cart_crea2 = request.getParameter("crea2");
	String cart_crea3 = request.getParameter("crea3");
	if (cart_crea != null) {
		//セッション削除
		session.removeAttribute("syouhin1");
		session.removeAttribute("syouhin2");
		session.removeAttribute("syouhin3");
	}else if (cart_crea1 != null) {
		session.removeAttribute("syouhin1");
	}else if (cart_crea2 != null) {
		session.removeAttribute("syouhin2");
	}else if (cart_crea3 != null) {
		session.removeAttribute("syouhin3");
	}
	//商品ページから数量の取得
	syouhin[0] = request.getParameter("syouhin1");
	syouhin[1] = request.getParameter("syouhin2");
	syouhin[2] = request.getParameter("syouhin3");
	//sessionから数量の取得
	syouhin_count[0] = (String)session.getAttribute("syouhin1");
	syouhin_count[1] = (String)session.getAttribute("syouhin2");
	syouhin_count[2] = (String)session.getAttribute("syouhin3");
	up[0] = request.getParameter("up1");
	up[1] = request.getParameter("up2");
	up[2] = request.getParameter("up3");
	down[0] = request.getParameter("down1");
	down[1] = request.getParameter("down2");
	down[2] = request.getParameter("down3");
	//合計を加算
	int goukei = 0;
	for (int i = 0;i < 3 ;i++ ) {
		if (up[i] != null) {
				if (syouhin_count[i] != null) {
					goukei = Integer.parseInt(syouhin_count[i]);
			}
					goukei = goukei+Integer.parseInt(up[i]);
		}else if (down[i] != null) {
				if (syouhin_count[i] != null) {
					goukei = Integer.parseInt(syouhin_count[i]);
			}
					goukei = goukei+Integer.parseInt(down[i]);
			}else if (syouhin[i] != null) {
				if (syouhin_count[i] != null) {
					goukei = Integer.parseInt(syouhin_count[i]);
				}
					goukei = goukei + Integer.parseInt(syouhin[i]);
			}
		}
	//セッションにバインド
if (syouhin[0] != null || up[0] != null || down[0] != null) {
		session.setAttribute("syouhin1",new Integer(goukei).toString());
	}else if (syouhin[1] != null || up[1] != null || down[1] != null) {
		session.setAttribute("syouhin2",new Integer(goukei).toString());
	}else if (syouhin[2] != null || up[2] != null || down[2] != null) {
		session.setAttribute("syouhin3",new Integer(goukei).toString());
	}
	//有効時間
	session.setMaxInactiveInterval(30);

      out.write("\r\n");
      out.write("<DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <title>insert title here</title>\r\n");
      out.write("  <body>\r\n");
      out.write("\t\t<h2>カートの中には以下の商品が入っています</h2>\r\n");
      out.write("\t\t");

			String count1 = (String)session.getAttribute("syouhin1");
			String count2 = (String)session.getAttribute("syouhin2");
			String count3 = (String)session.getAttribute("syouhin3");
			if(count1 != null && !(Integer.valueOf(count1) <= 0)) {
		
      out.write("\r\n");
      out.write("\t\t<table border=\"1\" style=\"border-collapse: collapse\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td rowspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<img src=\"./image/bung1.png\" height=\"32px\" width=\"32px\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"80\">商品No.</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">商品名</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\" colspan=\"2\">数量</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"80\">1</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">ハサミ</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">");
      out.print( count1 );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"up1\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"＋\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"down1\" value=\"-1\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"ー\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"crea1\" value=\"crea1\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"削除\">\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t");

			if (count2 != null && !(Integer.valueOf(count2) <= 0)) {
		
      out.write("\r\n");
      out.write("\t\t<table border=\"1\" style=\"border-collapse: collapse\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td rowspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<img src=\"./image/bung2.png\" height=\"32px\" width=\"32px\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"80\">商品No.</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">商品名</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\" colspan=\"2\">数量</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"80\">2</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">えんぴつ</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">");
      out.print( count2 );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"up2\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"＋\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"down2\" value=\"-1\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"ー\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"crea2\" value=\"crea2\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"削除\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t");

			if (count3 != null && !(Integer.valueOf(count3) <= 0)) {
		
      out.write("\r\n");
      out.write("\t\t<table border=\"1\" style=\"border-collapse: collapse\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td rowspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<img src=\"./image/bung3.png\" height=\"32px\" width=\"32px\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"80\">商品No.</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">商品名</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\" colspan=\"2\">数量</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"80\">3</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">ノート</td>\r\n");
      out.write("\t\t\t\t<td width=\"80\">");
      out.print( count3 );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"up3\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"＋\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"down3\" value=\"-1\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"ー\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"crea3\" value=\"crea3\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"削除\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
      out.write("\t\t");

			if (count1 == null && count2 == null && count3 == null) {
		
      out.write("\r\n");
      out.write("\t\tカートの中身はありません\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<table border=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_in.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"お買い物を続ける\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<form action=\"cart_out.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"crea\" value=\"crea\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"カートを空にする\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
