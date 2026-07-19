<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="com.praveen.backend.model.Department"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
Department department =
        (Department)request.getAttribute("department");
%>

<div class="page-header">

    <h1>Department Details</h1>

    <a href="<%=request.getContextPath()%>/departments"
       class="btn">

        ← Back

    </a>

</div>

<div class="form-card">

    <div class="form-grid">

        <div class="form-group">

            <label>

                Department ID

            </label>

            <input
                    type="text"
                    value="<%=department.getDepartmentId()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>

                Department Name

            </label>

            <input
                    type="text"
                    value="<%=department.getDepartmentName()%>"
                    readonly>

        </div>

    </div>

    <br>

    <a href="<%=request.getContextPath()%>/departments"
       class="btn btn-primary">

        Back to Departments

    </a>

</div>

<%@ include file="../../common/footer.jsp"%>