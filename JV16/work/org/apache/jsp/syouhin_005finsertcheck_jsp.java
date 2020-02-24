package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class syouhin_005finsertcheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");

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



      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>『商品登録』</title>\r\n");
      out.write("</head>\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\">\r\n");
      out.write("<BR><BR>\r\n");
      out.write("<h1>商品登録</h1>\r\n");
      out.write("<h2>以下の内容で登録しますか？</h2>\r\n");
      out.write("<BR><BR>\r\n");
      out.write("<FORM METHOD=\"POST\" ACTION=\"./syouhin_insertout.jsp\">\r\n");
      out.write("\r\n");
      out.write("    <input type=\"hidden\" name=\"syouhin_name\" value=\"");
      out.print( syouhin_nameStr );
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"syouhin_pre\" value=\"");
      out.print( pre_nameStr[0] );
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"syouhin_msg\" value=\"");
      out.print( syouhin_msgStr );
      out.write("\">\r\n");
      out.write("    <input type=\"hidden\" name=\"syouhin_icon\" value=\"");
      out.print( syouhin_iconStr );
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("<tr>\r\n");
      out.write("  <th>項目名</th><th>内容</th>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("  <td bgcolor=\"#99CC00\">商品名</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      ");
      out.print( syouhin_nameStr );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#99CC00\">生産地</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      ");
      out.print( pre_nameStr[1] );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#99CC00\">コメント</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      ");
      out.print( syouhin_msgStr );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#99CC00\">アイコン</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      <img src=\"./image/");
      out.print( syouhin_iconStr );
      out.write(".png\" height=\"70px\" width=\"70px\" />\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("  <INPUT TYPE=\"SUBMIT\" VALUE=\"登録\">\r\n");
      out.write("</form>\r\n");
      out.write("  <button id=\"correction\" type=\"button\" href=\"javascript:void(0)\" onclick=\"javascript:history.back()\">修正</button>\r\n");
      out.write("  <form method=\"post\" action=\"./syouhin_index.jsp\">\r\n");
      out.write("    <input type=\"hidden\" name=\"logout\" value=\"logout\">\r\n");
      out.write("    <input type=\"submit\" value=\"ログアウト\">\r\n");
      out.write("  </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
