<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="com.praveen.backend.model.Department"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
Department department =
        (Department)request.getAttribute("department");

String error =
        (String)request.getAttribute("error");
%>

<div class="page-header">

    <h1>Edit Department</h1>

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

    <input
            type="hidden"
            name="action"
            value="update">

    <input
            type="hidden"
            name="departmentId"
            value="<%=department.getDepartmentId()%>">

    <div class="form-group">

        <label>

            Department Name

        </label>

        <input
                type="text"
                name="departmentName"
                value="<%=department.getDepartmentName()%>"
                required>

    </div>

    <br>

    <button
            type="submit"
            class="btn btn-primary">

        Update Department

    </button>

</form>

<%@ include file="../../common/footer.jsp"%>