<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.Order" %>
<%@ page import="java.util.List" %>


<%@include file="DashBoardHeader.jspf" %>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="col-sm-12 col-xl-10">
                    <div class="bg-light rounded h-100 p-4">
                        <h6 class="mb-4">新增訂單</h6>
                        <form action="./OrderManager" method="post" onsubmit="return checkOrderForm()">
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label" >會員帳號</label>
                                <div class="col-sm-8">
                                    <input type="hidden" class="form-control" name="orderId" value="0" >
                                    <input type="text" class="form-control" name="userId" maxlength="10" required id="userId" placeholder="請輸入身分證" >
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">訂單日期</label>
                                <div class="col-sm-8">
                                    <input type="date" class="form-control" name="orderDate" required id="orderDate">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">狀態</label>
                                <div class="col-sm-8">
                                 <select class="form-select mb-3" aria-label="Default select example" name="state" required id="state">
                                 	<option id="1" value="1">完成</option>
                                 	<option id="2" value="2">保留</option>
                                 	<option id="3" value="3">取消</option>
                                	<option id="4" value="4">等待付款</option>
                                </select>       					
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">購買課程</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="productId" required id="productId" placeholder="請輸入課程 例:1,2,3,4">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">總價</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="totalPrice" required id="totalPrice" maxlength="9">
                                </div>
                            </div>
                            
                            <button type="submit" class="btn btn-primary" name="create" value="confirm">確認新增</button>
                            <button type="button" class="btn btn-danger m-2" onclick="location.href='./OrderManager'">取消</button>
                        	<button type="button" class="btn btn-outline-danger m-2" id="OrderwrongInput">錯誤輸入</button>
                            <button type="button" class="btn btn-outline-primary m-2" id="OrdercorrectInput">正確輸入</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Content End -->

<%@include file="DashBoardFooter.jspf" %>