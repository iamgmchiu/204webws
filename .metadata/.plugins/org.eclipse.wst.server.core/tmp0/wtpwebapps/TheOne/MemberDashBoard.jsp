<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.Member" %>
<%@ page import="java.util.List" %>


<%@include file="DashBoardHeader.jspf" %>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">會員資訊</h6>
                        <button type="button" class="btn btn-primary mb-0" onclick="location.href='./MemberCreate.jsp'">新增會員</button>
                    </div>
                    <div class="table-responsive">
                        <table class="table align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-dark">
                                	<th scope="col">會員編號</th>
                                    <th scope="col">帳號(身分證)</th>
                                    <th scope="col">密碼</th>
                                    <th scope="col">姓名</th>
                                    <th scope="col">性別</th>
                                    <th scope="col">會員點數</th>
                                    <th scope="col">修改</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            //int pageCount = (int) request.getAttribute("pageCount");
                            List<Member> members = (List<Member>) request.getAttribute("members");
                            if(members != null){
                            for(Member m : members) {
                            %>
                                <tr>
                                    <td><%= m.getIdNumber() %></td>
                                    <td><%= m.getUserid() %></td>
                                    <td><%= m.getPwd() %></td>
                                    <td><%= m.getUsername() %></td>
                                    <td><%= m.getGender() %></td>
                                    <td><%= m.getPoint() %></td>
                                    <td>
                                        <button type="button" class="btn btn-outline-primary m-0" onclick="location.href='./MemberServlet?UpdateId=<%= m.getIdNumber() %>'">修改會員</button>
                                        <button type="button" class="btn btn-outline-danger m-0" onclick="javascript:if(confirm('確定要刪除嗎?'))location.href='./MemberServlet?DeleteId=<%= m.getIdNumber() %>'">刪除會員</button>
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