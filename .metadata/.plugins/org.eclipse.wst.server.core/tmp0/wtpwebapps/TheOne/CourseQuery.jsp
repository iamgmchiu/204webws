<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="Bean.CourseBean"%>
<%@include file="DashBoardHeader.jspf"%>


<style>
::placeholder {
	font-style: italic;
	color: lightgray;
}
</style>

<BODY>
	<div class="container-fluid pt-4 px-4">
		<div class="bg-light text-center rounded p-4">
				<div class="d-flex align-items-center justify-content-between mb-4">
<!-- -----------------------------------------Query form start----------------------------------------------------------------------- -->
					<h5 class="mb-0">
						課程資訊查詢
					</h5>
					<button type="button" class="btn btn-primary mb-0"
						onclick="location.href='./CourseCreate.jsp'">新增課程</button>
				</div>

				<FORM ACTION="./CourseController" method="get">

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程編號</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="courseNo"
								maxlength="10" placeholder="編號">
						</div>
					</div>
					
					<div>
						<button type="submit" class="btn btn-primary" name="findByNo"
							value="查詢">編號查詢</button>
					</div>
					
					<hr>
	
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程分類</label>
						<div class="col-sm-8">
							<INPUT TYPE="TEXT" NAME="courseCategory" list="data1" placeholder="輸入分類 or 使用選單">
							<datalist id="data1">
								<option value="英文證照">英文證照</option>
								<option value="日語證照">日語證照</option>
								<option value="韓語證照">韓語證照</option>
								<option value="生涯轉換與轉業">生涯轉換與轉業</option>
								<option value="自我認知">自我認知</option>
								<option value="求職技巧">求職技巧</option>
								<option value="就業市場現況與趨勢">就業市場現況與趨勢</option>
							</datalist>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">課程名稱</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="courseName"
								maxlength="20" placeholder="例：雅思 or 雅思檢定班">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">講師</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="lecturer"
								maxlength="10" placeholder="例：楊胖虎">
						</div>
					</div>


					<div>
						<button type="submit" class="btn btn-primary" name="findByMulti"
							value="查詢">模糊查詢</button>

						<button type="reset" class="btn btn-primary" name="reset">清空</button>
					</div>
				</FORM>
<!-- -----------------------------------------Query form end----------------------------------------------------------------------- -->
				<hr>
<!-- -----------------------------------------show form result start----------------------------------------------------------------------- -->
				<div class="table-responsive">
					<table id="table_id" class="table align-middle table-bordered table-hover mb-0 order-column">
						<thead>
							<tr class="text-dark">
								<th scope="col">編號</th>
								<th scope="col">類別</th>
								<th scope="col">名稱</th>
								<th scope="col">講師</th>
								<th scope="col">上架時間</th>
								<th scope="col">評分</th>
								<th scope="col">價錢</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="course" items="${courseList}">
							<tr>
								<td><c:out value="${course.courseNo}"/> </td>
					 			<td><c:out value="${course.courseCategory}"/> </td>
								<td><c:out value="${course.courseName}"/> </td>
								<td><c:out value="${course.lecturer}"/> </td>
								<td><c:out value="${course.date}"/> </td>
								<td><c:out value="${course.score}"/> </td>
								<td><c:out value="${course.price}"/> </td>
								
								<td>
									<button type="button" class="btn btn-outline-success m-0"
										onclick="location.href='./CourseController?courseNo=${course.courseNo}&detailForm=詳細'">詳細</button>

									<button type="button" class="btn btn-outline-primary m-0"
										onclick="location.href='./CourseController?courseNo=${course.courseNo}&UptdByCourseNO=更新查詢'">更新</button>
									
									<button type="button" class="btn btn-outline-danger m-0"
										onclick="javascript:if(confirm('確認要刪除嗎?'))location.href='./CourseController?courseNo=${course.courseNo}&DELETE=刪除'">刪除</button>
<%-- 								亦可		onclick="if(confirm('確認要刪除嗎?'))location.href='./CourseController?courseNo=${course.courseNo}&DELETE=刪除'">刪除</button> --%>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
<!-- -----------------------------------------show form result end ----------------------------------------------------------------------- -->		
				</div>
			</div>
		</div>
</BODY>

<%@include file="DashBoardFooter.jspf"%>