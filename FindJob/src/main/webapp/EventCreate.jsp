<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.Event" %>
<%@ page import="java.util.List" %>


<%@include file="DashBoardHeader.jspf" %>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="col-sm-12 col-xl-10">
                    <div class="bg-light rounded h-100 p-4">
                        <h6 class="mb-4">新增紀錄</h6>
                        <form action="./EventsManager" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">刊登公司</label>
                                <div class="col-sm-8">
                                    <input type="hidden" class="form-control" name="adId" value="0">
                                    <input type="text" class="form-control" name="compId" maxlength="8" required id="compId">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">價格</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="price" maxlength="10" required id="price">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">廣告圖</label>
                                <div class="col-sm-8 text-center">
                                    <img class="img-fluid mx-auto mb-4" id="preview_progressbarTW_img" src="#" alt="請選擇廣告圖" style="width: 320px; height: 200px;">
                                    <input class="form-control" type="file" name="imgURL" id="imgInp" accept="image/jpeg, image/png" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">廣告連結</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="eventLinkURL" required id="eventLinkURL">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">刊登開始時間</label>
                                <div class="col-sm-8">
                                    <input type="date" class="form-control" name="postStart" required id="postStart">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">刊登結束時間</label>
                                <div class="col-sm-8">
                                    <input type="date" class="form-control" name="postEnd" required id="postEnd">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">備註</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" placeholder="備註最多50個字" id="floatingTextarea" style="height: 150px;" name="remark" maxlength="50"></textarea>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary" name="create" value="confirm">確認新增</button>
                            <button type="button" class="btn btn-primary" onclick="location.href='./EventsManager'">取消</button>
                            <button type="button" class="btn btn-primary" id="wrongInput">錯誤輸入</button>
                            <button type="button" class="btn btn-primary" id="correctInput">正確輸入</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Content End -->

<%@include file="DashBoardFooter.jspf" %>