<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>If Tag Example</TITLE>
<LINK REL=STYLESHEET
HREF="JSP-Styles.css"
TYPE="text/css">
</HEAD>
<BODY>
<H1>If Tag Example</H1>
<%@ taglib uri="/WEB-INF/csajsp-taglib.tld" prefix="csajsp" %>
<csajsp:if>
<csajsp:condition>true</csajsp:condition>
<csajsp:then>Condition was true</csajsp:then>
<csajsp:else>Condition was false</csajsp:else>
</csajsp:if>
<P>
<csajsp:if>
<csajsp:condition><%= request.isSecure() %></csajsp:condition>
<csajsp:then>Request is using SSL (https)</csajsp:then>
<csajsp:else>Request is not using SSL</csajsp:else>
</csajsp:if>
<P>
Some coin tosses:<BR>
<csajsp:repeat reps="20">
<csajsp:if>
<csajsp:condition>
<%= Math.random() > 0.5 %>
</csajsp:condition>
<csajsp:then><B>Heads</B><BR></csajsp:then>
<csajsp:else><B>Tails</B><BR></csajsp:else>
</csajsp:if>
</csajsp:repeat>
</BODY>
</HTML>