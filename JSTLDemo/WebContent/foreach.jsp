<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%-- if demo1 --%> 
<c:set var="number" value="${200}" > </c:set>
<c:if test="${number<500}">
<c:out value="number is less than 500"></c:out>  
</c:if> <b/>

<%-- if demo2 --%> 
<c:set var="salary" scope="session" value="${2000*2}"/>
<c:if test="${salary > 2000}">
   <p>My salary is: <c:out value="${salary}"/><p>
</c:if> <b/>

<%-- forEach demo --%>
<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach><b/>

<%-- forEach demo --%>
<c:forEach items="Zara,nuha,roshy" var="name">
   <c:out value="${name}"/><p>
</c:forEach><b/>

<%-- forToken demo --%>
<c:forTokens items="Zara,nuha,roshy" delims="," var="name">
   <c:out value="${name}"/><p>
</c:forTokens> <b/>

<%-- remove tag demo --%>
<c:set var="bonus" scope="session" value="${2000*2}"/>
<p>Before Remove Value (bonus): <c:out value="${bonus}"/></p>
<c:remove var="bonus" />
<p>After Remove Value (bonus): <c:out value="${bonus}"/></p>


<%-- when tag demo --%>
<c:set var="income" scope="session" value="${2000*2}"/>
<p>Your income is : <c:out value="${income}"/></p>
<c:choose>
    <c:when test="${income <= 0}">
       Income is very low to survive.
    </c:when>
    <c:when test="${income > 1000}">
        Income is very good.
    </c:when>
    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose>

