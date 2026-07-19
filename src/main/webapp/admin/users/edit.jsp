<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List"%>
<%@ page import="com.praveen.backend.model.User"%>
<%@ page import="com.praveen.backend.model.Role"%>
<%@ page import="com.praveen.backend.model.Department"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
User user =
        (User)request.getAttribute("user");

List<Role> roles =
        (List<Role>)request.getAttribute("roles");

List<Department> departments =
        (List<Department>)request.getAttribute("departments");

String error =
        (String)request.getAttribute("error");
%>

<div class="page-header">

    <h1>Edit User</h1>

    <a href="<%=request.getContextPath()%>/users"
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

<form action="<%=request.getContextPath()%>/users"
      method="post"
      class="form-card">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="userId"
           value="<%=user.getUserId()%>">

    <div class="form-grid">

        <div class="form-group">

            <label>Employee Code</label>

            <input type="text"
                   value="<%=user.getEmployeeCode()%>"
                   readonly>

        </div>

        <div class="form-group">

            <label>First Name</label>

            <input type="text"
                   name="firstName"
                   value="<%=user.getFirstName()%>"
                   required>

        </div>

        <div class="form-group">

            <label>Last Name</label>

            <input type="text"
                   name="lastName"
                   value="<%=user.getLastName()%>"
                   required>

        </div>

        <div class="form-group">

            <label>Email</label>

            <input type="email"
                   name="email"
                   value="<%=user.getEmail()%>"
                   required>

        </div>

        <div class="form-group">

            <label>Phone</label>

            <input type="text"
                   name="phone"
                   value="<%=user.getPhone()%>">

        </div>

        <div class="form-group">

            <label>Role</label>

            <select name="roleId">
                <%
if(roles != null){

    for(Role role : roles){
%>

<option
        value="<%=role.getRoleId()%>"

        <%= role.getRoleId()==user.getRole().getRoleId()
                ? "selected"
                : "" %>>

    <%=role.getRoleName()%>

</option>

<%
    }

}
%>

            </select>

        </div>

        <div class="form-group">

            <label>Department</label>

            <select name="departmentId">

<%
if(departments != null){

    for(Department department : departments){
%>

<option
        value="<%=department.getDepartmentId()%>"

        <%= department.getDepartmentId()==user.getDepartment().getDepartmentId()
                ? "selected"
                : "" %>>

    <%=department.getDepartmentName()%>

</option>

<%
    }

}
%>

            </select>

        </div>

        <div class="form-group">

            <label>Status</label>

            <select name="status">

                <option
                        value="ACTIVE"

                        <%= "ACTIVE".equals(user.getStatus())
                                ? "selected"
                                : "" %>>

                    ACTIVE

                </option>

                <option
                        value="INACTIVE"

                        <%= "INACTIVE".equals(user.getStatus())
                                ? "selected"
                                : "" %>>

                    INACTIVE

                </option>

            </select>

        </div>

    </div>

    <br>

    <button
            type="submit"
            class="btn btn-primary">

        Update User

    </button>

</form>

<%@ include file="../../common/footer.jsp"%>
                