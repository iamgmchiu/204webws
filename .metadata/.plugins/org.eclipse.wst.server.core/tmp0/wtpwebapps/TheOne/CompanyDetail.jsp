<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="Bean.Company"%>
<%@include file="DashBoardHeader.jspf"%>

            <!-- Content Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="col-sm-12 col-xl-10">
                    <div class="bg-light rounded h-100 p-4">
                        <h6 class="mb-4">資料內容</h6>
                        <FORM ACTION="./CompanyServlet" method="post">
                        <% Company company = (Company) request.getAttribute("company");%>
                        <div class="row mb-3">
                                    <input type="hidden"  class="form-control" name="comppk" id="comppk" value="<%=company.getComppk()%>" readonly="readonly">
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">帳號(統編)</label>
                                <div class="col-sm-8">
                                    <input type="text"  class="form-control"  maxlength="8" name="compid"  id="compid" value="<%=company.getCompid()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">密碼</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" maxlength="15" name="compwd"  id="compwd" value="<%=company.getCompwd()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">公司名稱</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="corpname"  id="corpname" value="<%=company.getCorpname()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">負責人</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="owner" id="owner" value="<%=company.getOwner()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">產業</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="industry"  id="industry" value="<%=company.getIndustry()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">聯絡人</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="contact"  id="contact" value="<%=company.getContact()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">聯絡電話</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="comptele" id="comptele" value="<%=company.getComptele()%>" readonly="readonly">
                                </div>
                            </div>
                        
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">傳真號碼</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="fax" id="fax" value="<%=company.getFax()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">公司地址</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="compaddress"  id="compaddress" value="<%=company.getCompaddress()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">員工人數</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="empnumber"  required id="empnumber" value="<%=company.getEmpnumber()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">公司網站</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="website" id="website" value="<%=company.getWebsite()%>" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label">資本額</label>
                                <div class="col-sm-8 text-center">
                                <input type="text" class="form-control" maxlength="10"  name="capital"  id="capital" value="<%=company.getCapital()%>" readonly="readonly">  
                                </div>
                            </div>
                            <button type="button" class="btn btn-primary" onclick="location.href='./CompanyServlet'">返回</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Content End -->

<%@include file="DashBoardFooter.jspf" %>