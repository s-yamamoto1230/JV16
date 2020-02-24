package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class syouhin_005fupdatein_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  String syou_noStr  = request.getParameter("syou_no");

  //データベースに接続するために使用する変数宣言
  Connection con = null;
  Statement stmt = null;
  StringBuffer SQL = null;
  ResultSet rs = null;

  //ローカルのMySQLに接続する設定
	//String USER ="root";
	//String PASSWORD = "";
	//String URL ="jdbc:mysql://localhost/nhs90345db";

	//サーバーのMySQLに接続する設定
	String USER = "nhs90345";
	String PASSWORD = "b19931230";
  String URL ="jdbc:mysql://192.168.121.16/nhs90345db";

  String DRIVER = "com.mysql.jdbc.Driver";

  //確認メッセージ
  StringBuffer ERMSG = null;

  //ヒットフラグ
  int hit_flag = 0;

  //HashMap（1件分のデータを格納する連想配列）
  HashMap<String,String> map = null;

  //ArrayList（すべての件数を格納する配列）
  ArrayList<HashMap> list = null;
  list = new ArrayList<HashMap>();

  try{  // ロードに失敗したときのための例外処理
    // JDBCドライバのロード
    Class.forName(DRIVER).newInstance();

    // Connectionオブジェクトの作成
    con = DriverManager.getConnection(URL,USER,PASSWORD);

    //Statementオブジェクトの作成
    stmt = con.createStatement();

    //SQLステートメントの作成（選択クエリ）
    SQL = new StringBuffer();

    //SQL文の構築（選択クエリ）
    SQL.append("select * from syou_tbl , ken_tbl where syou_pre = pre_no and syou_no =");
    SQL.append(syou_noStr);
//      System.out.println(SQL.toString());

    //SQL文の実行（選択クエリ）
    rs = stmt.executeQuery(SQL.toString());

    //入力したデータがデータベースに存在するか調べる
    if(rs.next()){  //存在する
      //ヒットフラグON
      hit_flag = 1;

        //検索データをHashMapへ格納する
        map = new HashMap<String,String>();
      map.put("syou_no",rs.getString("syou_no"));
      map.put("syou_name",rs.getString("syou_name"));
      map.put("syou_pre",rs.getString("syou_pre"));
      map.put("syou_msg",rs.getString("syou_msg"));
      map.put("syou_icon",rs.getString("syou_icon"));
      map.put("pre_no",rs.getString("pre_no"));
      map.put("pre_name",rs.getString("pre_name"));

      //1件分のデータ(HashMap)をArrayListへ追加
      list.add(map);
    }else{  //存在しない
      //ヒットフラグOFF
      hit_flag = 0;
    }
  } //tryブロック終了
  catch(ClassNotFoundException e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
  }
  catch(SQLException e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
  }
  catch(Exception e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
  }

  finally{
    //各種オブジェクトクローズ
      try{
        if(rs != null){
          rs.close();
        }
        if(stmt != null){
          stmt.close();
      }
        if(con != null){
          con.close();
      }
      }
    catch(SQLException e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
    }
  }

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>商品変更</TITLE>\r\n");
      out.write("<META HTTP-EQUIV=\"content-type\"  CONTENT=\"text/html;charset=UTF-8\">\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\">\r\n");
      out.write("<BR><BR>\r\n");
      out.write("商品変更\r\n");
      out.write("<BR><BR>\r\n");
      out.write("<FORM name=\"frm\" METHOD=\"POST\" ACTION=\"./syouhin_updatecheck.jsp\">\r\n");
      out.write("\r\n");
      out.write("  <input type=\"hidden\" name=\"pre_name\" value=\"");
      out.print( list.get(0).get("pre_name") );
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("<tr>\r\n");
      out.write("  <th>項目名</th><th>内容</th>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("  <td>商品No</td>\r\n");
      out.write("  <td>\r\n");
      out.write("    <input type=\"text\" name=\"syouhin_no\" size=\"10\" maxlength=\"20\" readonly value=\"");
      out.print( list.get(0).get("syou_no") );
      out.write("\">\r\n");
      out.write("  </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("  <td bgcolor=\"#99CC00\">商品名</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      <input type=\"text\" name=\"syouhin_name\" size=\"50\" maxlength=\"50\" value=\"");
      out.print( list.get(0).get("syou_name") );
      out.write("\">\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#99CC00\">生産地</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      <select size=1 name=\"syouhin_pre\">\r\n");
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
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#99CC00\">コメント</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      <textarea name=\"syouhin_msg\" rows=\"3\" cols=\"40\" >");
      out.print( list.get(0).get("syou_msg") );
      out.write("</textarea>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td bgcolor=\"#99CC00\">アイコン</td>\r\n");
      out.write("    <td>\r\n");
      out.write("      <select  name=\"syouhin_icon\">\r\n");
      out.write("        <option value=\"1\">いちご</option>\r\n");
      out.write("        <option value=\"2\">りんご</option>\r\n");
      out.write("        <option value=\"3\">さくらんぼ</option>\r\n");
      out.write("        <option value=\"4\">すいか</option>\r\n");
      out.write("        <option value=\"5\">パイナップル</option>\r\n");
      out.write("        <option value=\"6\">メロン</option>\r\n");
      out.write("        <option value=\"7\">バナナ</option>\r\n");
      out.write("      </select>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("  <INPUT TYPE=\"SUBMIT\" VALUE=\"変更\">\r\n");
      out.write("  <input type=\"reset\" value=\"リセット\">\r\n");
      out.write("</form>\r\n");
      out.write("<form method=\"post\" action=\"./syouhin_index.jsp\">\r\n");
      out.write("  <input type=\"hidden\" name=\"logout\" value=\"logout\">\r\n");
      out.write("  <input type=\"submit\" value=\"ログアウト\">\r\n");
      out.write("</form>\r\n");
      out.write("  <a href=\"./syouhin_main.jsp\">メインに戻る</a>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("    document.frm.syouhin_pre.selectedIndex=");
      out.print( list.get(0).get("syou_pre") );
      out.write("-1;\r\n");
      out.write("    document.frm.syouhin_icon.selectedIndex=");
      out.print( list.get(0).get("syou_icon") );
      out.write("-1;\r\n");
      out.write("  </script>\r\n");
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
