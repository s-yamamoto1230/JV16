<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
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
%>
<DOCTYPE>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <title>insert title here</title>
  <body>
		<h2>カートの中には以下の商品が入っています</h2>
		<%
			String count1 = (String)session.getAttribute("syouhin1");
			String count2 = (String)session.getAttribute("syouhin2");
			String count3 = (String)session.getAttribute("syouhin3");
			if(count1 != null && !(Integer.valueOf(count1) <= 0)) {
		%>
		<table border="1" style="border-collapse: collapse">
			<tr>
				<td rowspan="3">
					<img src="./image/bung1.png" height="32px" width="32px">
				</td>
			</tr>
			<tr>
				<td width="80">商品No.</td>
				<td width="80">商品名</td>
				<td width="80" colspan="2">数量</td>
			</tr>
			<tr>
				<td width="80">1</td>
				<td width="80">ハサミ</td>
				<td width="80"><%= count1 %></td>
				<td>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="up1" value="1">
						<input type="submit" value="＋">
					</form>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="down1" value="-1">
						<input type="submit" value="ー">
					</form>
				</td>
				<tr>
					<td>
						<form action="cart_out.jsp" method="post">
							<input type="hidden" name="crea1" value="crea1">
							<input type="submit" value="削除">
						</form>
				</td>
				</tr>
			</tr>
		</table>
		<%
		}
		%>
		<br>
		<%
			if (count2 != null && !(Integer.valueOf(count2) <= 0)) {
		%>
		<table border="1" style="border-collapse: collapse">
			<tr>
				<td rowspan="3">
					<img src="./image/bung2.png" height="32px" width="32px">
				</td>
			</tr>
			<tr>
				<td width="80">商品No.</td>
				<td width="80">商品名</td>
				<td width="80" colspan="2">数量</td>
			</tr>
			<tr>
				<td width="80">2</td>
				<td width="80">えんぴつ</td>
				<td width="80"><%= count2 %></td>
				<td>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="up2" value="1">
						<input type="submit" value="＋">
					</form>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="down2" value="-1">
						<input type="submit" value="ー">
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="crea2" value="crea2">
						<input type="submit" value="削除">
					</form>
			</td>
			</tr>
		</table>
		<%
		}
		%>
		<br>
		<%
			if (count3 != null && !(Integer.valueOf(count3) <= 0)) {
		%>
		<table border="1" style="border-collapse: collapse">
			<tr>
				<td rowspan="3">
					<img src="./image/bung3.png" height="32px" width="32px">
				</td>
			</tr>
			<tr>
				<td width="80">商品No.</td>
				<td width="80">商品名</td>
				<td width="80" colspan="2">数量</td>
			</tr>
			<tr>
				<td width="80">3</td>
				<td width="80">ノート</td>
				<td width="80"><%= count3 %></td>
				<td>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="up3" value="1">
						<input type="submit" value="＋">
					</form>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="down3" value="-1">
						<input type="submit" value="ー">
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="crea3" value="crea3">
						<input type="submit" value="削除">
					</form>
			</td>
			</tr>
		</table>
		<%
		}
		%>
		<%
			if (count1 == null && count2 == null && count3 == null) {
		%>
		カートの中身はありません
		<br>
		<%
			}
		%>
		<br>
		<table border="0">
			<tr>
				<td>
					<form action="cart_in.jsp" method="post">
						<input type="submit" value="お買い物を続ける">
					</form>
				</td>
				<td>
					<form action="cart_out.jsp" method="post">
						<input type="hidden" name="crea" value="crea">
						<input type="submit" value="カートを空にする">
					</form>
				</td>
			</tr>
		</table>
  </body>
</html>
