<div class="sidebar">

    <div class="logo">

        <i class="fa-solid fa-diagram-project"></i>

        <span>EWA</span>

    </div>

    <ul>

        <li>

            <a href="<%=request.getContextPath()%>/admin/dashboard.jsp">

                <i class="fa-solid fa-house"></i>

                Dashboard

            </a>

        </li>

        <li>

            <a href="<%=request.getContextPath()%>/users">

                <i class="fa-solid fa-users"></i>

                Users

            </a>

        </li>

        <li>

            <a href="<%=request.getContextPath()%>/admin/departments.jsp">

                <i class="fa-solid fa-building"></i>

                Departments

            </a>

        </li>

        <li>

            <a href="<%=request.getContextPath()%>/admin/request-types.jsp">

                <i class="fa-solid fa-file-lines"></i>

                Request Types

            </a>

        </li>

        <li>

            <a href="<%=request.getContextPath()%>/admin/reports.jsp">

                <i class="fa-solid fa-chart-column"></i>

                Reports

            </a>

        </li>

        <li>

            <a href="<%=request.getContextPath()%>/logout">

                <i class="fa-solid fa-right-from-bracket"></i>

                Logout

            </a>

        </li>

    </ul>

</div>

<div class="main-content">

<%@ include file="navbar.jsp" %>