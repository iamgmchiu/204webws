<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@include file="DashBoardHeader.jspf"%>

<style>
::placeholder {
	font-style: italic;
	color: lightgray;
}

#divScore{
float:left;
}
</style>

<script>

	
//  另一種上傳圖片同步顯示的方法	
// 	imgInput.onchange = evt => {
// 		  const [file] = imgInp.files
// 		  if (file) {
// 			  preview_img.src = URL.createObjectURL(file)
// 		  }
// 		}
</script>


<BODY>
	<div class="container-fluid pt-4 px-4">
		<div class="col-sm-12 col-xl-10">
			<div class="bg-light text-center rounded p-4">
				<div class="d-flex align-items-center justify-content-between mb-4">
					<h6 class="mb-0">新增課程資訊</h6>
				</div>

				<FORM ACTION="./CourseController" method="post" enctype="multipart/form-data" onsubmit="return checkCourseForm()">

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程名稱</label>
						<div class="col-sm-8">
						 <input type="hidden" class="form-control" name="courseNo" value="0" id="courseNo">
							<input type="text" class="form-control" name="courseName"
								maxlength="20" required id="courseName">
						</div>
					</div>
					

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程分類</label>
						<div class="col-sm-8">
							<select name="courseCategory" required id="courseCategory">
								<option value="英文證照">英文證照</option>
								<option value="日語證照">日語證照</option>
								<option value="韓語證照">韓語證照</option>
								<option value="生涯轉換與轉業">生涯轉換與轉業</option>
								<option value="自我認知">自我認知</option>
								<option value="求職技巧">求職技巧</option>
								<option value="就業市場現況與趨勢">就業市場現況與趨勢</option>
							</select>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程介紹</label>
						<div class="col-sm-8">
							<textarea name="courseIntroduction" class="form-control" id="courseIntroduction" placeholder="介紹最多100個字" maxlength="100" cols="62" rows="5" required></textarea>
<!-- 							<input type="text" class="form-control" name="courseIntroduction" -->
<!-- 								placeholder="介紹最多50個字" maxlength="50" required -->
<!-- 								id="courseIntroduction"> -->
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">講師</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="lecturer"
								maxlength="10" required id="lecturer">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">上架時間</label>
						<div class="col-sm-8">
							<input type="date" class="form-control" name="date"
								maxlength="15" id="date" required>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程圖</label>
						<div class="col-sm-8 text-center">
							<img class="img-fluid mx-auto mb-4" id="preview_img" src="#" alt="請選擇課程圖" style="width: 320px; height: 200px;">
							<input class="form-control" type="file" name="imgURL" id="imgInput" accept="image/jpeg, image/png" >
						</div>
					</div>
			
<!-- 					<div class="row mb-3"> -->
<!-- 						<label class="col-sm-2 col-form-label">圖片位置</label> -->
<!-- 						<div class="col-sm-8"> -->
<!-- 							<input type="text" class="form-control" name="coursePic" required -->
<!-- 								id="coursePic"> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">影片位置</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="courseVedio"
								required id="courseVedio">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">評分</label>
						<div class="col-sm-8" id="divScore">
							<input type="text" class="form-control" name="score"
								maxlength="5" placeholder="0~9.9" id="score" required>
						</div>
						 <span id="score_check" ></span>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">價錢</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="price"
								maxlength="5" required id="price">
								
								
						</div>
					</div>

					<div>
<!-- 						<button type="submit" class="btn btn-primary" name="inset" -->
<!-- 							value="新增課程" onclick="create()">確認新增</button> -->
						<button type="submit" class="btn btn-primary" name="insert" id="inset1" 
						value="新增課程" >確認新增</button>
						<button type="reset" class="btn btn-primary" name="reset"
							value="清空輸入">清空輸入</button>
						<button type="button" class="btn btn-primary" id="correctInput">一鍵輸入</button>
						<button type="button" class="btn btn-primary" 
							onclick="location.href='./CourseController'">取消</button>
					</div>
				</FORM>
			</div>
		</div>
	</div>

	<script>
	
		document.getElementById("inset1").onclick = function() {
			if (confirm("您真的確定要新增嗎？\n\n請確認！")) {
				return true
			} else
				return false
		}
		
		document.getElementById("score").addEventListener("blur", function() {
			let scoreRegex = /^[\d.]+$/;
			let scoreValue = document.getElementById("score").value;
			let checkBoolean = scoreRegex.test(scoreValue);
			if (checkBoolean) {
				document.getElementById("score_check").innerHTML = "<img width='30' height='30' src='img/right.jpg'/>"
				return true
			} else {
				document.getElementById("score_check").innerHTML = "<img width='30' height='30' src='img/wrong.jpg'/>"
				return false
			}
		})

		// 		document.getElementById("inset1").addEventListener("click", function() {
		// 			if (confirm("您真的確定要新增嗎？\n\n請確認！")) {
		// 				return true
		// 			} else
		// 				return false
		// 		})

		// 		function create() {
		// 			var msg = "您真的確定要新增嗎？\n\n請確認！";
		// 			if (confirm(msg) == true) {
		// 				return true;
		// 			} else {
		// 				return false;
		// 			}
		// 		})
	</script>
</BODY>

<%@include file="DashBoardFooter.jspf"%>