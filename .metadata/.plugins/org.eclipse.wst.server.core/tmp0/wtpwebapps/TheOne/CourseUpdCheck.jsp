<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Bean.CourseBean"%>
<%@include file="DashBoardHeader.jspf"%>

<BODY>
	<div class="container-fluid pt-4 px-4">
		<div class="col-sm-12 col-xl-10">
			<div class="bg-light text-center rounded p-4">
				<div class="d-flex align-items-center justify-content-between mb-4">
					<h6 class="mb-0">更新課程資訊</h6>
				</div>
				<!-- 					<div class="table-responsive"> -->
				<FORM ACTION="./CourseController" method="post" enctype="multipart/form-data" onsubmit="return checkCourseForm()">

					<% CourseBean course = (CourseBean) request.getAttribute("courseBean");%>
					
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程編號</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="courseNo"
								value="<%=course.getCourseNo()%>" id="courseName"
								readonly="readonly">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程分類</label>
						<div class="col-sm-8">
							<select name="courseCategory" id="courseCategory">
								<option value="英文證照"
									<c:if test="${course.courseCategory=='英文證照'}">selected</c:if>>英文證照
								</option>
								<option value="日語證照"
									<c:if test="${course.courseCategory=='日語證照'}">selected</c:if>>日語證照
								</option>
								<option value="韓語證照"
									<c:if test="${course.courseCategory=='韓語證照'}">selected</c:if>>韓語證照
								</option>
								<option value="生涯轉換與轉業"
									<c:if test="${course.courseCategory=='生涯轉換與轉業'}">selected</c:if>>生涯轉換與轉業
								</option>
								<option value="自我認知"
									<c:if test="${course.courseCategory=='自我認知'}">selected</c:if>>自我認知
								</option>
								<option value="求職技巧"
									<c:if test="${course.courseCategory=='求職技巧'}">selected</c:if>>求職技巧
								</option>
								<option value="就業市場現況與趨勢"
									<c:if test="${course.courseCategory=='就業市場現況與趨勢'}">selected</c:if>>就業市場現況與趨勢
								</option>
							</select>
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程名稱</label>
						<div class="col-sm-8">
							<!-- <input type="hidden" class="form-control" name="courseName" value="update"> -->
							<input type="text" class="form-control" name="courseName"
								value="<%=course.getCourseName()%>" id="courseIntroduction">
						</div>
					</div>

					<div class="row mb-3">
							<label class="col-sm-2 col-form-label">課程介紹</label>
							<div class="col-sm-8">
								<textarea name="courseIntroduction" class="form-control" 
									
									placeholder="課程介紹..." cols="62" rows="5"><%=course.getCourseIntroduction()%></textarea>

								<!-- 							<input type="text" class="form-control" -->
								<!-- 									name="courseIntroduction" -->
								<%-- 									value="<%=course.getCourseIntroduction()%>"> --%>
							</div>
						</div>

						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">講師</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="lecturer"
									value="<%=course.getLecturer()%>" id="lecturer">
							</div>
						</div>

						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">上架時間</label>
							<div class="col-sm-8">
								<input type="date" class="form-control" name="date"
									value="<%=course.getDate()%>" id="date">
							</div>
						</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程圖</label>
						<div class="col-sm-8 text-center">
							<img class="img-fluid mx-auto mb-4" id="preview_img" src="#"
								alt="請選擇課程圖" style="width: 320px; height: 200px;"> 
							<input class="form-control" type="file" name="imgURL" id="imgInput" 
							accept="image/jpeg, image/png">
						</div>
					</div>

<!-- 						<div class="row mb-3"> -->
<!-- 							<label class="col-sm-2 col-form-label">圖片位置</label> -->
<!-- 							<div class="col-sm-8"> -->
<!-- 								<input type="text" class="form-control" name="coursePic" -->
<%-- 									value="<%=course.getCoursePicUrl()%>" id="coursePic"> --%>
<!-- 							</div> -->
<!-- 						</div> -->

						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">影片位置</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="courseVedio"
									value="<%=course.getCourseVedioUrl()%>" id="courseVedio">
							</div>
						</div>

						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">評分</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="score"
									value="<%=course.getScore()%>" placeholder="0~9.9" id="score">
							</div>
						</div>

						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">價錢</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="price"
									value="<%=course.getPrice()%>" id="price">
							</div>
						</div>

						<div>
							<button type="submit" class="btn btn-primary"
								name="updateConfirm" value="確認更改"
								onclick="javascript:return upd();">確認更改</button>

							<button type="reset" class="btn btn-primary" name="reset"
								value="回復原始資料">回復原始資料</button>

							<button type="button" class="btn btn-primary"
								onclick="location.href='./CourseController'">取消</button>
						</div>
				</FORM>
			</div>
		</div>
	</div>

	<script>
		function upd() {
			var msg = "您真的確定要更新嗎？\n\n請確認！";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</BODY>

<%@include file="DashBoardFooter.jspf"%>