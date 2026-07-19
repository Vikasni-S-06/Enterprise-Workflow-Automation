<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/header.jsp" %>
<%@ include file="../common/sidebar.jsp" %>

<div class="dashboard-header">

    <div>

        <h1>Dashboard</h1>

        <p>
            Welcome back,
            <strong><%=session.getAttribute("userName")%></strong>
        </p>

    </div>

    <div class="dashboard-role">

        <span class="status-active">
            <%=session.getAttribute("role")%>
        </span>

    </div>

</div>

<div class="cards">

    <div class="card">

        <h2>Total Users</h2>

        <h1>4</h1>

        <p>Registered Users</p>

    </div>

    <div class="card">

        <h2>Departments</h2>

        <h1>3</h1>

        <p>Available Departments</p>

    </div>

    <div class="card">

        <h2>Roles</h2>

        <h1>4</h1>

        <p>System Roles</p>

    </div>

    <div class="card">

        <h2>Pending Requests</h2>

        <h1>0</h1>

        <p>Workflow Requests</p>

    </div>

</div>

<div class="dashboard-section">

    <h2>Quick Actions</h2>

    <div class="quick-actions">

        <a href="<%=request.getContextPath()%>/users" class="btn">
            Manage Users
        </a>

        <a href="#" class="btn">
            Departments
        </a>

        <a href="#" class="btn">
            Reports
        </a>

    </div>

</div>

<%@ include file="../common/footer.jsp" %>