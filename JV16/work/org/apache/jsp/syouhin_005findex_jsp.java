package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class syouhin_005findex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

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


      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>顧客ID入力</TITLE>\r\n");
      out.write("<META HTTP-EQUIV=\"content-type\"  CONTENT=\"text/html;charset=UTF-8\">\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\">\r\n");
      out.write("<BR><Br>\r\n");
      out.write("<h1>商品管理ログイン</h1>\r\n");
      out.write("<BR><BR>\r\n");
      out.write("\r\n");
      out.write("  <table border=\"1\">\r\n");
      out.write("    <FORM  METHOD=\"POST\" ACTION=\"./login_index_action.jsp\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>顧客ID</td>\r\n");
      out.write("        <td> <INPUT TYPE=\"text\" NAME=\"id\" size=\"50\" maxlength=\"20\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>顧客PW</td>\r\n");
      out.write("        <td><INPUT TYPE=\"text\" NAME=\"pas\" size=\"50\" maxlength=\"20\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" align=\"center\"><INPUT TYPE=\"SUBMIT\" VALUE=\"ログイン\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </FORM>\r\n");
      out.write("  </table>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
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
