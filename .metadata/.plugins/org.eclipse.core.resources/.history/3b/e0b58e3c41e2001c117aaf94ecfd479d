<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Bean.Interview"%>
<%@ page import="java.util.List"%>


<%@include file="DashBoardHeader.jspf"%>

<!-- Content Start -->
<body>

	<div class="container-fluid pt-4 px-4">
		<div class="col-sm-12 col-xl-10">
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">新增紀錄</h6>
				<form action="./InterViewServletDS" method="post"
					onsubmit="return checkForm2()">
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">求職者帳號</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="USER_ID" required
								id="USER_ID"> <input type="hidden" class="form-control"
								name="cv_no" value="0">
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">面試時間</label>
						<div class="col-sm-8">
							<input type="date" class="form-control" name="Int_Time" required
								id="Int_Time"> <input type="hidden" class="form-control"
								name="Created_Time" id="Created_Time">
						</div>
					</div>



					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">面試公司</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="Comp_Name"
								size="10">
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">面試職缺</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="Job_Name"
								maxlength="8" required id="job_name" size="10">
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">是否錄取</label>

						<div class="col-sm-8">
							<input type="radio" name="Offer" value="是">是 <input
								type="radio" name="Offer" value="否">否
						</div>
					</div>



					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">筆試或口試</label>
						<div class="col-sm-8">
							<input type="radio" name="Test" value="有" id="Test">有 <input
								type="radio" name="Test" value="無" id="Test">無
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">面試語言</label><br>
						<div class="col-sm-8">
							<label><input type="checkbox" name="Language" value="國語"
								id="">國語 </label> <label> <input type="checkbox"
								name="Language" value="英語" id="">英語
							</label> <label> <input type="checkbox" name="Language"
								value="日語" id="">日語
							</label> <label> <input type="checkbox" name="Language"
								value="韓文" id="">韓文
							</label> <label> <input type="checkbox" name="Language"
								value="德文" id="">德文
							</label> <label> <input type="checkbox" name="Language"
								value="法文" id="">法文
							</label>  <label> <input type="checkbox" name="Language"
								value="義大利文" id="">義大利文
							</label> <label> <input type="checkbox" name="Language"
								value="西班牙文" id="">西班牙文
							</label> <label> <input type="checkbox" name="Language"
								value="葡萄牙文" id="">葡萄牙文
							</label> <label> <input type="checkbox" name="Language"
								value="其他" id="">其他
							</label>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">考官問題</label>
						<div class="col-sm-8">
							<textarea class="form-control" placeholder="備註最多50字"
								id="floatingTextarea" style="height: 150px;" name="QA"
								maxlength="50"></textarea>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">心得分享</label>
						<div class="col-sm-8">
							<textarea class="form-control" placeholder="備註最多100字"
								id="floatingTextarea" style="height: 150px;" name="Share"
								maxlength="100"></textarea>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">面試評分</label>

						<div class="col-sm-8">
							<input type="radio" name="Int_Score" value="1" id="Int_Score">1
							<input type="radio" name="Int_Score" value="2" id="Int_Score">2
							<input type="radio" name="Int_Score" value="3" id="Int_Score">3
							<input type="radio" name="Int_Score" value="4" id="Int_Score">4
							<input type="radio" name="Int_Score" value="5" id="Int_Score">5
							<input type="radio" name="Int_Score" value="6" id="Int_Score">6
							<input type="radio" name="Int_Score" value="7" id="Int_Score">7
							<input type="radio" name="Int_Score" value="8" id="Int_Score">8
							<input type="radio" name="Int_Score" value="9" id="Int_Score">9
							<input type="radio" name="Int_Score" value="10" id="Int_Score">10
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">給該公司評分</label>
						<div class="col-sm-8">
							<input type="radio" name="Comp_Score" value="1" id="Comp_Score">1
							<input type="radio" name="Comp_Score" value="2" id="Comp_Score">2
							<input type="radio" name="Comp_Score" value="3" id="Comp_Score">3
							<input type="radio" name="Comp_Score" value="4" id="Comp_Score">4
							<input type="radio" name="Comp_Score" value="5" id="Comp_Score">5
							<input type="radio" name="Comp_Score" value="6" id="Comp_Score">6
							<input type="radio" name="Comp_Score" value="7" id="Comp_Score">7
							<input type="radio" name="Comp_Score" value="8" id="Comp_Score">8
							<input type="radio" name="Comp_Score" value="9" id="Comp_Score">9
							<input type="radio" name="Comp_Score" value="10" id="Comp_Score">10
						</div>
					</div>
					<button type="submit" class="btn btn-primary" name="create"
						value="confirm">確認新增</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='./InterViewServletDS'">取消</button>

				</form>
			</div>
		</div>
	</div>
</body>
<!-- Content End -->

<%@include file="DashBoardFooter.jspf"%>