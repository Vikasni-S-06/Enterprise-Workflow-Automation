<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List"%>
<%@ page import="com.praveen.backend.model.Role"%>
<%@ page import="com.praveen.backend.model.Department"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
List<Role> roleList =
        (List<Role>)request.getAttribute("roles");

List<Department> departmentList =
        (List<Department>)request.getAttribute("departments");

String error =
        (String)request.getAttribute("error");
%>

<div class="page-header">

    <h1>Add New User</h1>

    <a href="<%=request.getContextPath()%>/users"
       class="btn">

        ← Back

    </a>

</div>

<%
if(error != null){
%>

<div class="alert alert-danger">

    <%= error %>

</div>

<%
}
%>

<form action="<%=request.getContextPath()%>/users"
      method="post"
      class="form-card">

    <div class="form-grid">

        <div class="form-group">

            <label>Employee Code</label>

            <input type="text"
                   name="employeeCode"
                   value="<%=request.getParameter("employeeCode")==null?"":request.getParameter("employeeCode")%>"
                   required>

        </div>

        <div class="form-group">

            <label>First Name</label>

            <input type="text"
                   name="firstName"
                   value="<%=request.getParameter("firstName")==null?"":request.getParameter("firstName")%>"
                   required>

        </div>

        <div class="form-group">

            <label>Last Name</label>

            <input type="text"
                   name="lastName"
                   value="<%=request.getParameter("lastName")==null?"":request.getParameter("lastName")%>"
                   required>

        </div>

        <div class="form-group">

            <label>Email</label>

            <input type="email"
                   name="email"
                   value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>"
                   required>

        </div>

        <div class="form-group">

            <label>Password</label>

            <input type="password"
                   name="password"
                   required>

        </div>

        <div class="form-group">

            <label>Phone</label>

            <input type="text"
                   name="phone"
                   value="<%=request.getParameter("phone")==null?"":request.getParameter("phone")%>">

        </div>

        <div class="form-group">

            <label>Role</label>

            <select name="roleId" required>
                <%
if(roleList != null){

    String selectedRole =
            request.getParameter("roleId");

    for(Role roleObj : roleList){
%>

<option
        value="<%=roleObj.getRoleId()%>"

        <%= selectedRole != null &&
            selectedRole.equals(
                    String.valueOf(
                            roleObj.getRoleId()))
                ? "selected"
                : "" %>>

    <%=roleObj.getRoleName()%>

</option>

<%
    }

}
%>

</select>

</div>

<div class="form-group">

    <label>Department</label>

    <select name="departmentId" required>

<%
if(departmentList != null){

    String selectedDepartment =
            request.getParameter("departmentId");

    for(Department deptObj : departmentList){
%>

<option
        value="<%=deptObj.getDepartmentId()%>"

        <%= selectedDepartment != null &&
            selectedDepartment.equals(
                    String.valueOf(
                            deptObj.getDepartmentId()))
                ? "selected"
                : "" %>>

    <%=deptObj.getDepartmentName()%>

</option>

<%
    }

}
%>

    </select>

</div>

<div class="form-group">

    <label>Joining Date</label>

    <input type="date"
           name="joiningDate"
           value="<%=request.getParameter("joiningDate")==null?"":request.getParameter("joiningDate")%>"
           required>

</div>

<div class="form-group">

    <label>Status</label>

    <select name="status">

        <option value="ACTIVE"

            <%= "ACTIVE".equals(
                    request.getParameter("status"))
                    || request.getParameter("status")==null
                    ? "selected"
                    : "" %>>

            ACTIVE

        </option>

        <option value="INACTIVE"

            <%= "INACTIVE".equals(
                    request.getParameter("status"))
                    ? "selected"
                    : "" %>>

            INACTIVE

        </option>

    </select>

</div>

</div>

<br>

<button type="submit"
        class="btn btn-primary">

    Save User

</button>

</form>

<%@ include file="../../common/footer.jsp"%>