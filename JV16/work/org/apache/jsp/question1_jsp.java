package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class question1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>JSPへデータ送信</title>\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <h1>アンケート画面</h1>\r\n");
      out.write("    <form method=\"post\" action=\"./answer1.jsp\">\r\n");
      out.write("      <table border=\"1\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <th>項目名</th>\r\n");
      out.write("          <th>内容</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>お名前</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"text\" name=\"namae\" size=\"40\" maxlength=\"20\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>郵便番号</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"text\" name=\"yuubin\" size=\"40\" maxlength=\"20\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>電話番号</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"text\" name=\"tel\" size=\"40\" maxlength=\"20\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>性別</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"radio\" name=\"seibetu\" value=\"0\" checked />男性\r\n");
      out.write("            <input type=\"radio\" name=\"seibetu\" value=\"1\" />女性\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>生年月日（年）</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"text\" name=\"nen\" size=\"40\" maxlength=\"4\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>生年月日（月）</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"text\" name=\"tuki\" size=\"40\" maxlength=\"2\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>生年月日（日）</td>\r\n");
      out.write("          <td>\r\n");
      out.write("            <input type=\"text\" name=\"hi\" size=\"40\" maxlength=\"2\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td colspan=\"2\" align=\"center\">\r\n");
      out.write("            <input type=\"submit\" value=\"送信する\" />\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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
