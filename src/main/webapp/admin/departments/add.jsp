<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
String error =
        (String)request.getAttribute("error");
%>

<div class="page-header">

    <h1>Add Department</h1>

    <a href="<%=request.getContextPath()%>/departments"
       class="btn">

        ← Back

    </a>

</div>

<%
if(error != null){
%>

<div class="alert alert-danger">

    <%=error%>

</div>

<%
}
%>

<form action="<%=request.getContextPath()%>/departments"
      method="post"
      class="form-card">

    <div class="form-group">

        <label>

            Department Name

        </label>

        <input
                type="text"
                name="departmentName"
                value="<%=request.getAttribute("departmentName")==null ? "" : request.getAttribute("departmentName")%>"
                required>

    </div>

    <br>

    <button
            type="submit"
            class="btn btn-primary">

        Save Department

    </button>

</form>

<%@ include file="../../common/footer.jsp"%>