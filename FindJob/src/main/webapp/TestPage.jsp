<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<title>Html的Form表單元素</title>
</head>
<fieldset style="width: 500px;">
	<legend>Html的Form表單元素</legend>
	<!--form表單的action屬性規定當提交表單時，向何處發送表單數據，method屬性指明表單的提交方式，分為get和post，默認為get-->
	<form action="./RequestDemo03" method="post" >
		<!--輸入文字方塊，SIZE表示顯示長度，maxlength表示最多輸入長度-->
		編 號(文字方塊)： <input type="text" name="userid" value="NO." size="2"
			maxlength="2"><br>
		<!--輸入文字方塊，通過value指定其顯示的預設值-->
		用戶名(文字方塊)：<input type="text" name="username" value="請輸入用戶名"><br>
		<!--密碼框，其中所有輸入的內容都以密文的形式顯示-->
		密 碼(密碼框)：
		<!-- 表示的是一個空格-->
		<input type="password" name="userpass" value="請輸入密碼"><br>
		<!--選項按鈕，通過checked指定默認選中，名稱必須一樣，其中value為真正需要的內容-->
		性 別(單選框)： <input type="radio" name="sex" value="男" checked>男 <input
			type="radio" name="sex" value="女">女<br>
		<!--下拉式清單方塊，通過<option>元素指定下拉的選項-->
		部 門(下拉清單)： <select name="dept">
			<option value="技術部">技術部</option>
			<option value="銷售部" SELECTED>銷售部</option>
			<option value="財務部">財務部</option>
		</select><br>
		<!--核取方塊，可以同時選擇多個選項，名稱必須一樣，其中value為真正需要的內容-->
		興 趣(核取方塊)： <input type="checkbox" name="inst" value="唱歌">唱歌 <input
			type="checkbox" name="inst" value="游泳">游泳 <input
			type="checkbox" name="inst" value="跳舞">跳舞 <input
			type="checkbox" name="inst" value="程式設計" checked>程式設計 <input
			type="checkbox" name="inst" value="上網">上網 <br>
		<!--大文本輸入框，寬度為34列，高度為5行-->
		說 明(文本域)：
		<textarea name="note" cols="34" rows="5">
     </textarea>
		<br>
		<!--隱藏欄位，在頁面上無法看到，專門用來傳遞參數或者保存參數-->
		<input type="hidden" name="hiddenField" value="hiddenvalue" />
		<!--提交表單按鈕，當點擊提交後，所有填寫的表單內容都會被傳輸到伺服器端-->
		<input type="submit" value="提交(提交按鈕)">
		<!--重置表單按鈕，當點擊重置後，所有表單恢復原始顯示內容-->
		<input type="reset" value="重置(重新開機按鈕)">
	</form>
	<!--表單結束-->
</fieldset>
</body>
<!--完結標記-->
</html>
<!--完結標記-->