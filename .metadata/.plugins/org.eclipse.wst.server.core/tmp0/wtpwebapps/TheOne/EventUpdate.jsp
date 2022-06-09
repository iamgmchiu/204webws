<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.EventBean"%>
<%@ page import="java.util.List" %>


<%@include file="DashBoardHeader.jspf" %>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="col-sm-12 col-xl-10">
                    <div class="bg-light rounded h-100 p-4">
                        <h6 class="mb-4">修改紀錄</h6>
                        <form action="./EventsManager" method="post" enctype="multipart/form-data" id="form">
                        <% EventBean eventForUpdate = (EventBean) request.getAttribute("eventForUpdate"); %>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">廣告編號</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="eventId" value="<%= eventForUpdate.getEventId() %>" readonly id="eventId">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">刊登公司統編</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="compId" value="<%= eventForUpdate.getCompId() %>" maxlength="8" required id="compId">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">價格(萬)</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="price" value="<%= eventForUpdate.getPrice() %>" maxlength="10" required id="price">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">廣告圖</label>
                                <div class="col-sm-8 text-center">
                                    <img class="img-fluid mx-auto mb-4" id="preview_progressbarTW_img" src="<%= eventForUpdate.getImgUrl() %>" alt="請選擇廣告圖" style="width: 320px; height: 200px;">
                                    <input type="hidden" class="form-control" name="OringinImgURL" value="<%= eventForUpdate.getImgUrl() %>">
                                    <input class="form-control" type="file" name="imgURL" id="imgInp" accept="image/jpeg, image/png">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">廣告連結</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="eventLinkURL" value="<%= eventForUpdate.getEventLinkUrl() %>" required id="eventLinkURL">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">刊登開始時間</label>
                                <div class="col-sm-8">
                                    <input type="date" class="form-control" name="postStart" value="<%= eventForUpdate.getFormatedPostStart() %>" required id="postStart">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">刊登結束時間</label>
                                <div class="col-sm-8">
                                    <input type="date" class="form-control" name="postEnd" value="<%= eventForUpdate.getFormatedPostEnd() %>" required id="postEnd">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">備註</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" placeholder="備註最多50個字" id="floatingTextarea" style="height: 100px;" name="remark" maxlength="50"><%= eventForUpdate.getRemark() %></textarea>
                                </div>
                            </div>
                            <button type="button" class="btn btn-primary" name="update" id="btn-submit">確認修改</button>
                            <button type="button" class="btn btn-primary" onclick="location.href='./EventsManager'">取消</button>
                            <button type="button" class="btn btn-primary" id="eventWrongInput">錯誤輸入</button>
                            <button type="button" class="btn btn-primary" id="eventCorrectInput">正確輸入</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Content End -->

<%@include file="DashBoardFooter.jspf" %>