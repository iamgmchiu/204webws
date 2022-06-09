<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.Order" %>
<%@ page import="java.util.List" %>


<%@include file="DashBoardHeader.jspf" %>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4" >
                        <h6 class="mb-0">訂單紀錄</h6>
                        <button type="button" class="btn btn-primary mb-0" onclick="location.href='./OrderCreate.jsp'">新增訂單</button>
                    </div>
                    <div class="table-responsive">
                        <table class="table align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-dark">
                                    <th scope="col">訂單編號</th>
                                    <th scope="col">訂單日期</th>
                                    <th scope="col">狀態</th>
                                    <th scope="col">會員帳號</th>
                                    <th scope="col">課程編號</th>
                                    <th scope="col">總價</th>
                                    <th scope="col">修改</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            List<Order> orders = (List<Order>) request.getAttribute("orders");
                            for(Order order : orders){
                            %>
                                <tr>
                                    <td><%= order.getOrderId() %></td>
                                    <td><%= order.getOrderDate() %></td>
                                    <td><% if("1".equals(order.getState())){ %>完成<%}else if("2".equals(order.getState())) {%>保留<%}else if("3".equals(order.getState())) {%>取消<%}else if("4".equals(order.getState())) {%>等待付款<%}%></td>
                                    <td><%= order.getUserId() %></td>
                                    <td><%= order.getProductId() %></td>
                                    <td>NT$<%= order.getTotalPrice() %></td>
                                    <td>
                                        <button type="button" class="btn btn-outline-primary m-0" onclick="location.href='./OrderManager?UpdateId=<%= order.getOrderId() %>'">修改訂單</button>
                                        <button type="button" class="btn btn-outline-danger m-0"  onclick="javascript:if(confirm('確實要刪除訂單嗎?'))location.href='./OrderManager?DeleteId=<%= order.getOrderId() %>'">刪除訂單</button>
                                    </td>
                                </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                    <div class="btn-group mt-4 me-2" role="group">
                        <button type="button" class="btn btn-primary">1</button>
                    </div>
                </div>
            </div>
            <!-- Content End -->

<%@include file="DashBoardFooter.jspf" %>