/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-06-06 07:13:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import Bean.EventBean;
import java.util.List;

public final class EventsDashBoard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/DashBoardHeader.jspf", Long.valueOf(1654478619366L));
    _jspx_dependants.put("/DashBoardFooter.jspf", Long.valueOf(1654497742381L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("Bean.EventBean");
    _jspx_imports_classes.add("org.apache.jasper.tagplugins.jstl.core.ForEach");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>THE ONE</title>\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("    <meta content=\"\" name=\"keywords\">\r\n");
      out.write("    <meta content=\"\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Favicon -->\r\n");
      out.write("    <link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Google Web Fonts -->\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Icon Font Stylesheet -->\r\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Libraries Stylesheet -->\r\n");
      out.write("    <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery Raty -->\r\n");
      out.write("    <link href=\"css/jquery.raty.css\" rel=\"stylesheet\"> <!-- 莊詠筑 -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- Data Table -->\r\n");
      out.write("	<link href=\"//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css\" rel=\"stylesheet\"> <!-- 莊詠筑 -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Stylesheet -->\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container-xxl position-relative bg-white d-flex p-0\">\r\n");
      out.write("        <!-- Spinner Start -->\r\n");
      out.write("        <div id=\"spinner\"\r\n");
      out.write("            class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <div class=\"spinner-border text-primary\" style=\"width: 3rem; height: 3rem;\" role=\"status\">\r\n");
      out.write("                <span class=\"sr-only\">Loading...</span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Spinner End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Sidebar Start -->\r\n");
      out.write("        <div class=\"sidebar pe-4 pb-3\">\r\n");
      out.write("            <nav class=\"navbar bg-light navbar-light\">\r\n");
      out.write("                <a href=\"./MemberServlet\" class=\"navbar-brand mx-4 mb-3\">\r\n");
      out.write("                    <h3 class=\"text-primary\">The One</h3>\r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"d-flex align-items-center ms-4 mb-4\">\r\n");
      out.write("                    <div class=\"position-relative\">\r\n");
      out.write("                        <img class=\"rounded-circle\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\r\n");
      out.write("                        <div class=\"bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"ms-3\">\r\n");
      out.write("                        <h6 class=\"mb-0\">Admin</h6>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"navbar-nav w-100\">\r\n");
      out.write("                	<div class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-person-circle me-2\"></i><b>求職者</b></a>\r\n");
      out.write("                        <div class=\"dropdown-menu bg-transparent border-0\">\r\n");
      out.write("							<a href=\"./MemberServlet\" class=\"dropdown-item\">會員管理</a>\r\n");
      out.write("							<a href=\"./ResumeServlet\" class=\"dropdown-item\">履歷管理</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-building me-2\"></i><b>企業</b></a>\r\n");
      out.write("                        <div class=\"dropdown-menu bg-transparent border-0\">\r\n");
      out.write("							<a href=\"./CompanyServlet\" class=\"dropdown-item\">公司管理</a>\r\n");
      out.write("							<a href=\"./JobController\" class=\"dropdown-item\">職缺管理</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-chat-dots me-2\"></i><b>討論區</b></a>\r\n");
      out.write("                        <div class=\"dropdown-menu bg-transparent border-0\">\r\n");
      out.write("							<a href=\"./InterViewServletDS\" class=\"dropdown-item\">面試經驗談</a>\r\n");
      out.write("							<a href=\"./CommentsManager\" class=\"dropdown-item\">評論管理</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\"><i class=\"bi bi-cart4 me-2\"></i><b>收費項目</b></a>\r\n");
      out.write("                        <div class=\"dropdown-menu bg-transparent border-0\">\r\n");
      out.write("							<a href=\"./EventsManager\" class=\"dropdown-item\">廣告管理</a>\r\n");
      out.write("							<a href=\"./CourseController\" class=\"dropdown-item\">課程管理</a>\r\n");
      out.write("							<a href=\"./OrderManager\" class=\"dropdown-item\">訂單管理</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Sidebar End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Content Start -->\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <!-- Navbar Start -->\r\n");
      out.write("            <nav class=\"navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0\">\r\n");
      out.write("                <a href=\"#\" class=\"navbar-brand d-flex d-lg-none me-4\">\r\n");
      out.write("                    <h2 class=\"text-primary mb-0\"><i class=\"fa fa-hashtag\"></i></h2>\r\n");
      out.write("                </a>\r\n");
      out.write("                <a href=\"#\" class=\"sidebar-toggler flex-shrink-0\">\r\n");
      out.write("                    <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <form class=\"d-none d-md-flex ms-4\">\r\n");
      out.write("                    <input class=\"form-control border-0\" type=\"search\" placeholder=\"Search\">\r\n");
      out.write("                </form>\r\n");
      out.write("                <div class=\"navbar-nav align-items-center ms-auto\">\r\n");
      out.write("                    <div class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("                            <img class=\"rounded-circle me-lg-2\" src=\"img/user.jpg\" alt=\"\" style=\"width: 40px; height: 40px;\">\r\n");
      out.write("                            <span class=\"d-none d-lg-inline-flex\">Admin</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0\">\r\n");
      out.write("                            <a href=\"Login.jsp\" class=\"dropdown-item\">Log Out</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("            <!-- Navbar End -->");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- Content Start -->\r\n");
      out.write("            <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                <div class=\"bg-light text-center rounded p-4\">\r\n");
      out.write("                    <div class=\"d-flex align-items-center justify-content-between mb-4\">\r\n");
      out.write("                        <h6 class=\"mb-0\">廣告紀錄</h6>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary mb-0\" onclick=\"location.href='./EventCreate.jsp'\">新增紀錄</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"table-responsive\">\r\n");
      out.write("                        <table class=\"table align-middle table-bordered table-hover mb-0\">\r\n");
      out.write("                            <thead>\r\n");
      out.write("                                <tr class=\"text-dark\">\r\n");
      out.write("                                    <th scope=\"col\">廣告編號</th>\r\n");
      out.write("                                    <th scope=\"col\">刊登公司統編</th>\r\n");
      out.write("                                    <th scope=\"col\">價格(萬)</th>\r\n");
      out.write("                                    <th scope=\"col\">刊登開始時間</th>\r\n");
      out.write("                                    <th scope=\"col\">刊登結束時間</th>\r\n");
      out.write("                                    <th scope=\"col\">備註</th>\r\n");
      out.write("                                    <th scope=\"col\">修改</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </thead>\r\n");
      out.write("                            <tbody>\r\n");
      out.write("                            ");

                            List<EventBean> events = (List<EventBean>) request.getAttribute("events");
                            if(events != null){
                            	for(EventBean event : events){
                            
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>");
      out.print( event.getEventId() );
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print( event.getCompId() );
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print( event.getPrice() );
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print( event.getFormatedPostStart() );
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print( event.getFormatedPostEnd() );
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print( event.getRemark() );
      out.write("</td>\r\n");
      out.write("                                    <td>\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-outline-primary m-0 btn-eventUpdate\" value=\"");
      out.print( event.getEventId() );
      out.write("\">更新</button>\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-outline-danger m-0 btn-eventDelete\" value=\"");
      out.print( event.getEventId() );
      out.write("\">刪除</button>\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            ");
 }} 
      out.write("\r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Content End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<!-- Footer Start -->\r\n");
      out.write("            <div class=\"container-fluid pt-4 px-4\">\r\n");
      out.write("                <div class=\"bg-light rounded-top p-4\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-12 col-sm-6 text-center text-sm-start\">\r\n");
      out.write("                            &copy; <a href=\"#\">The One</a>, All Right Reserved.\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-12 col-sm-6 text-center text-sm-end\">\r\n");
      out.write("                            Designed By <a href=\"https://htmlcodex.com\">HTML Codex</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Footer End -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Content End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Back to Top -->\r\n");
      out.write("        <a href=\"#\" class=\"btn btn-lg btn-primary btn-lg-square back-to-top\"><i class=\"bi bi-arrow-up\"></i></a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- JavaScript Libraries -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/jquery.validate.min.js\"></script>\r\n");
      out.write("	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/localization/messages_zh_TW.min.js\"></script>\r\n");
      out.write("	<script src=\"https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/chart/chart.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/easing/easing.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment-timezone.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("    <script src=\"js/checkEventForm.js\"></script>\r\n");
      out.write("    <script src=\"js/checkMemberForm.js\"></script>\r\n");
      out.write("	<script src=\"js/checkJobForm.js\"></script>\r\n");
      out.write("	<script src=\"js/checkResumeForm.js\"></script>\r\n");
      out.write("	<script src=\"js/deleteForm.js\"></script>\r\n");
      out.write("	<script src=\"js/checkOrderForm.js\"></script>\r\n");
      out.write("	<script src=\"js/jquery.raty.js\"></script>\r\n");
      out.write("	<script src=\"js/checkCommentForm.js\"></script>\r\n");
      out.write("	<script src=\"js/checkCompanyForm.js\"></script>\r\n");
      out.write("	<script src=\"js/checkCourseForm.js\"></script>\r\n");
      out.write("	<script src=\"js/checkInterviewForm.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Javascript -->\r\n");
      out.write("    <script src=\"js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
