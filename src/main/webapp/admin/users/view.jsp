<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="com.praveen.backend.model.User"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
User user =
        (User)request.getAttribute("user");
%>

<div class="page-header">

    <h1>User Details</h1>

    <a href="<%=request.getContextPath()%>/users"
       class="btn">

        ← Back

    </a>

</div>

<div class="form-card">

    <div class="form-grid">

        <div class="form-group">

            <label>Employee Code</label>

            <input
                    type="text"
                    value="<%=user.getEmployeeCode()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>First Name</label>

            <input
                    type="text"
                    value="<%=user.getFirstName()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Last Name</label>

            <input
                    type="text"
                    value="<%=user.getLastName()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Email</label>

            <input
                    type="email"
                    value="<%=user.getEmail()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Phone</label>

            <input
                    type="text"
                    value="<%=user.getPhone()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Role</label>

            <input
                    type="text"
                    value="<%=user.getRole().getRoleName()%>"
                    readonly>
                            </div>

        <div class="form-group">

            <label>Department</label>

            <input
                    type="text"
                    value="<%=user.getDepartment().getDepartmentName()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Joining Date</label>

            <input
                    type="text"
                    value="<%=user.getJoiningDate()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Status</label>

            <input
                    type="text"
                    value="<%=user.getStatus()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Last Login</label>

            <input
                    type="text"
                    value="<%=user.getLastLogin() == null ? "Never Logged In" : user.getLastLogin()%>"
                    readonly>

        </div>

        <div class="form-group">

            <label>Created At</label>

            <input
                    type="text"
                    value="<%=user.getCreatedAt()%>"
                    readonly>

        </div>

    </div>

    <br>

    <a href="<%=request.getContextPath()%>/users"
       class="btn btn-primary">

        Back to Users

    </a>

</div>

<%@ include file="../../common/footer.jsp"%>