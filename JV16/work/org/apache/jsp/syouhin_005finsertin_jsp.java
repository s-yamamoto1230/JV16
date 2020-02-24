package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class syouhin_005finsertin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	//文字コードの指定
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	String session_name = (String)session.getAttribute("login_name");
	if (session_name == null) {
		response.sendRedirect("syouhin_index.jsp");
	}

      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>商品登録</TITLE>\r\n");
      out.write("<META HTTP-EQUIV=\"content-type\"  CONTENT=\"text/html;charset=UTF-8\">\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\">\r\n");
      out.write("<h1>商品登録</h1>\r\n");
      out.write("<FORM  METHOD=\"POST\" ACTION=\"./syouhin_insertcheck.jsp\">\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th bgcolor=\"#99CC00\">項目名</th><th bgcolor=\"#99CC00\">内容</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td bgcolor=\"#99CC00\">商品名</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"syouhin_name\" size=\"53\" maxlength=\"20\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td bgcolor=\"#99CC00\">生産地</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<select size=1 name=\"syouhin_pre\">\r\n");
      out.write("            <option value=\"1,北海道\">北海道</option>\r\n");
      out.write("        <option value=\"2,青森県\">青森県</option>\r\n");
      out.write("        <option value=\"3,岩手県\">岩手県</option>\r\n");
      out.write("        <option value=\"4,宮城県\">宮城県</option>\r\n");
      out.write("        <option value=\"5,秋田県\">秋田県</option>\r\n");
      out.write("        <option value=\"6,山形県\">山形県</option>\r\n");
      out.write("        <option value=\"7,福島県\">福島県</option>\r\n");
      out.write("        <option value=\"8,茨城県\">茨城県</option>\r\n");
      out.write("        <option value=\"9,栃木県\">栃木県</option>\r\n");
      out.write("        <option value=\"10,群馬県\">群馬県</option>\r\n");
      out.write("        <option value=\"11,埼玉県\">埼玉県</option>\r\n");
      out.write("        <option value=\"12,千葉県\">千葉県</option>\r\n");
      out.write("        <option value=\"13,東京都\">東京都</option>\r\n");
      out.write("        <option value=\"14,神奈川県\">神奈川県</option>\r\n");
      out.write("        <option value=\"15,新潟県\">新潟県</option>\r\n");
      out.write("        <option value=\"16,富山県\">富山県</option>\r\n");
      out.write("        <option value=\"17,石川県\">石川県</option>\r\n");
      out.write("        <option value=\"18,福岡県\">福井県</option>\r\n");
      out.write("        <option value=\"19,山梨県\">山梨県</option>\r\n");
      out.write("        <option value=\"20,長野県\">長野県</option>\r\n");
      out.write("        <option value=\"21,岐阜県\">岐阜県</option>\r\n");
      out.write("        <option value=\"22,静岡県\">静岡県</option>\r\n");
      out.write("        <option value=\"23,愛知県\">愛知県</option>\r\n");
      out.write("        <option value=\"24,三重県\">三重県</option>\r\n");
      out.write("        <option value=\"25,滋賀県\">滋賀県</option>\r\n");
      out.write("        <option value=\"26,京都府\">京都府</option>\r\n");
      out.write("        <option value=\"27,大阪府\">大阪府</option>\r\n");
      out.write("        <option value=\"28,兵庫県\">兵庫県</option>\r\n");
      out.write("        <option value=\"29,奈良県\">奈良県</option>\r\n");
      out.write("        <option value=\"30,和歌山県\">和歌山県</option>\r\n");
      out.write("        <option value=\"31,鳥取県\">鳥取県</option>\r\n");
      out.write("        <option value=\"32,島根県\">島根県</option>\r\n");
      out.write("        <option value=\"33,岡山県\">岡山県</option>\r\n");
      out.write("        <option value=\"34,広島県\">広島県</option>\r\n");
      out.write("        <option value=\"35,山口県\">山口県</option>\r\n");
      out.write("        <option value=\"36,徳島県\">徳島県</option>\r\n");
      out.write("        <option value=\"37,香川県\">香川県</option>\r\n");
      out.write("        <option value=\"38,愛媛県\">愛媛県</option>\r\n");
      out.write("        <option value=\"39,高知県\">高知県</option>\r\n");
      out.write("        <option value=\"40,福岡県\">福岡県</option>\r\n");
      out.write("        <option value=\"41,佐賀県\">佐賀県</option>\r\n");
      out.write("        <option value=\"42,長崎県\">長崎県</option>\r\n");
      out.write("        <option value=\"43,熊本県\">熊本県</option>\r\n");
      out.write("        <option value=\"44,大分県\">大分県</option>\r\n");
      out.write("        <option value=\"45,宮城県\">宮崎県</option>\r\n");
      out.write("        <option value=\"46,鹿児島県\">鹿児島県</option>\r\n");
      out.write("        <option value=\"47,沖縄県\">沖縄県</option>\r\n");
      out.write("          </select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td bgcolor=\"#99CC00\">コメント</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<textarea name=\"syouhin_msg\" rows=\"3\" cols=\"40\" ></textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td bgcolor=\"#99CC00\">アイコン</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<select name=\"syouhin_icon\">\r\n");
      out.write("\t\t\t\t<option value=\"1\">いちご</option>\r\n");
      out.write("\t\t\t\t<option value=\"2\">りんご</option>\r\n");
      out.write("\t\t\t\t<option value=\"3\">さくらんぼ</option>\r\n");
      out.write("\t\t\t\t<option value=\"4\">すいか</option>\r\n");
      out.write("\t\t\t\t<option value=\"5\">パイナップル</option>\r\n");
      out.write("\t\t\t\t<option value=\"6\">メロン</option>\r\n");
      out.write("\t\t\t\t<option value=\"7\">バナナ</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"登録\">\r\n");
      out.write("            <input type=\"reset\" value=\"リセット\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("<br />\r\n");
      out.write("<FORM  METHOD=\"POST\" ACTION=\"./syouhin_main.jsp\">\r\n");
      out.write("\t<input type=\"submit\" value=\"商品一覧に戻る\">\r\n");
      out.write("</FORM>\r\n");
      out.write("<form method=\"post\" action=\"./syouhin_index.jsp\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"logout\" value=\"logout\">\r\n");
      out.write("\t<input type=\"submit\" value=\"ログアウト\">\r\n");
      out.write("</form>\r\n");
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
