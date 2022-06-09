<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.EventBean" %>
<%@ page import="java.util.List" %>


<%@include file="DashBoardHeader.jspf" %>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">廣告紀錄</h6>
                        <button type="button" class="btn btn-primary mb-0" onclick="location.href='./EventCreate.jsp'">新增紀錄</button>
                    </div>
                    <div class="table-responsive">
                        <table class="table align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-dark">
                                    <th scope="col">廣告編號</th>
                                    <th scope="col">刊登公司統編</th>
                                    <th scope="col">價格(萬)</th>
                                    <th scope="col">刊登開始時間</th>
                                    <th scope="col">刊登結束時間</th>
                                    <th scope="col">備註</th>
                                    <th scope="col">修改</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            List<EventBean> events = (List<EventBean>) request.getAttribute("events");
                            if(events != null){
                            	for(EventBean event : events){
                            %>
                                <tr>
                                    <td><%= event.getEventId() %></td>
                                    <td><%= event.getCompId() %></td>
                                    <td><%= event.getPrice() %></td>
                                    <td><%= event.getFormatedPostStart() %></td>
                                    <td><%= event.getFormatedPostEnd() %></td>
                                    <td><%= event.getRemark() %></td>
                                    <td>
                                        <button type="button" class="btn btn-outline-primary m-0 btn-eventUpdate" value="<%= event.getEventId() %>">更新</button>
                                        <button type="button" class="btn btn-outline-danger m-0 btn-eventDelete" value="<%= event.getEventId() %>">刪除</button>
                                    </td>
                                </tr>
                            <% }} %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Content End -->

<%@include file="DashBoardFooter.jspf" %>