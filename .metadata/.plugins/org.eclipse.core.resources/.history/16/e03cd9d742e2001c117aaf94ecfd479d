<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.Interview" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="DashBoardHeader.jspf" %>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="col-sm-12 col-xl-10">
                    <div class="bg-light rounded h-100 p-4">
                        <h6 class="mb-4">修改紀錄</h6>
                        <form action="./InterViewServletDS" method="post"  onsubmit="return checkForm2()">
                        <% Interview intvForUpdate = (Interview) request.getAttribute("intvForUpdate"); %>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">面試內容編號</label>
                                <div class="col-sm-8">
                           <input type="text" class="form-control" name="cv_no" value=<%= intvForUpdate.getCv_No() %> readonly>          
                                </div>
                            </div>
                            <div class="row mb-3">
								<label class="col-sm-2 col-form-label">求職者帳號</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="USER_ID" 
									value=<%= intvForUpdate.getUSER_ID() %>  required id="USER_ID">
								</div>
							</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">面試時間</label>
					<div class="col-sm-8">
						<input type="date" class="form-control" name="Int_Time" required
							id="Int_Time" value=<%= intvForUpdate.getInt_Time() %>>
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">修改時間</label>
					<div class="col-sm-8"><%= intvForUpdate.getCreated_Time() %>
				<input type="hidden" class="form-control" name="Created_Time" 
							id="Created_Time">
		</div></div>

		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">面試公司</label>
			 <div class="col-sm-8">
			 <input type="text" class="form-control" name="Comp_Name" size="10" value=<%= intvForUpdate.getComp_Name() %>>
		</div></div>
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">面試職缺</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="Job_Name"
					maxlength="8" required id="job_name" size="10" value=<%= intvForUpdate.getJob_Name() %>>
			</div>
		</div>
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">是否錄取</label>

			<div class="col-sm-8">
			 <input type="radio" name="Offer" value="是" <c:if test="${intvForUpdate.getOffer()== '是'}">checked="checked"</c:if>>是
     				<input type="radio" name="Offer" value="否" <c:if test="${intvForUpdate.getOffer()== '否'}">checked="checked"</c:if>>否
			
			</div></div>



			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">筆試或口試</label>
				<div class="col-sm-8">
					  <input type="radio" name="Test" value="有" <c:if test="${intvForUpdate.getTest()== '有'}">checked="checked"</c:if>>有
     				<input type="radio" name="Test" value="無" <c:if test="${intvForUpdate.getTest()== '無'}">checked="checked"</c:if>>無
				</div></div>


<div class="row mb-3">
     <label class="col-sm-2 col-form-label">面試語言</label><br>
     <div class="col-sm-8">
      <c:forEach items="${intvForUpdate.getLanguageArray()}" var="lags">
       <input type="checkbox" name="language" value="${lags.language}" <c:if test="${lags.getCheckStatus()== 'Y'}">checked="checked"</c:if> >${lags.language}
      </c:forEach> 
     </div>
    </div>

				



					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">考官問題</label>
						<div class="col-sm-8">
							<textarea class="form-control" placeholder="備註最多50字"
								id="floatingTextarea" style="height: 150px;" name="QA"
								maxlength="50" ><%= intvForUpdate.getQA() %></textarea>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">心得分享</label>
						<div class="col-sm-8">
							<textarea class="form-control" placeholder="備註最多200字"
								id="floatingTextarea" style="height: 150px;" name="Share"
								maxlength="200" ><%= intvForUpdate.getShare() %></textarea>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">面試評分</label>

						<div class="col-sm-8">
							<input type="radio" name="Int_Score" value="1" <c:if test="${intvForUpdate.getInt_Score()== '1'}">checked="checked"</c:if>>1
							<input type="radio" name="Int_Score" value="2" <c:if test="${intvForUpdate.getInt_Score()== '2'}">checked="checked"</c:if>>2
							<input type="radio" name="Int_Score" value="3" <c:if test="${intvForUpdate.getInt_Score()== '3'}">checked="checked"</c:if>>3
							<input type="radio" name="Int_Score" value="4" <c:if test="${intvForUpdate.getInt_Score()== '4'}">checked="checked"</c:if>>4
							<input type="radio" name="Int_Score" value="5" <c:if test="${intvForUpdate.getInt_Score()== '5'}">checked="checked"</c:if>>5
							<input type="radio" name="Int_Score" value="6" <c:if test="${intvForUpdate.getInt_Score()== '6'}">checked="checked"</c:if>>6
							<input type="radio" name="Int_Score" value="7" <c:if test="${intvForUpdate.getInt_Score()== '7'}">checked="checked"</c:if>>7
							<input type="radio" name="Int_Score" value="8" <c:if test="${intvForUpdate.getInt_Score()== '8'}">checked="checked"</c:if>>8
							<input type="radio" name="Int_Score" value="9" <c:if test="${intvForUpdate.getInt_Score()== '9'}">checked="checked"</c:if>>9
							<input type="radio" name="Int_Score" value="10" <c:if test="${intvForUpdate.getInt_Score()== '10'}">checked="checked"</c:if>>10
						</div>
</div>


						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">給該公司評分</label>
							<div class="col-sm-8">
								
								<input type="radio" name="Comp_Score" value="1" <c:if test="${intvForUpdate.getComp_Score()== '1'}">checked="checked"</c:if>>1
								<input type="radio" name="Comp_Score" value="2" <c:if test="${intvForUpdate.getComp_Score()== '2'}">checked="checked"</c:if>>2
								<input type="radio" name="Comp_Score" value="3" <c:if test="${intvForUpdate.getComp_Score()== '3'}">checked="checked"</c:if>>3
								<input type="radio" name="Comp_Score" value="4" <c:if test="${intvForUpdate.getComp_Score()== '4'}">checked="checked"</c:if>>4
								<input type="radio" name="Comp_Score" value="5" <c:if test="${intvForUpdate.getComp_Score()== '5'}">checked="checked"</c:if>>5
								<input type="radio" name="Comp_Score" value="6" <c:if test="${intvForUpdate.getComp_Score()== '6'}">checked="checked"</c:if>>6
								<input type="radio" name="Comp_Score" value="7" <c:if test="${intvForUpdate.getComp_Score()== '7'}">checked="checked"</c:if>>7
								<input type="radio" name="Comp_Score" value="8" <c:if test="${intvForUpdate.getComp_Score()== '8'}">checked="checked"</c:if>>8
								<input type="radio" name="Comp_Score" value="9" <c:if test="${intvForUpdate.getComp_Score()== '9'}">checked="checked"</c:if>>9
								<input type="radio" name="Comp_Score" value="10" <c:if test="${intvForUpdate.getComp_Score()== '10'}">checked="checked"</c:if>>10
							</div>
							</div>
							<button type="submit" class="btn btn-primary" name="Update" value="confirm">確認修改</button>
							<button type="button" class="btn btn-primary"
								onclick="location.href='./InterViewServletDS'">取消</button>
							
							</form>
						</div>
					</div>
				</div>
				<!-- Content End -->
<%@include file="DashBoardFooter.jspf" %>