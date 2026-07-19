<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List"%>
<%@ page import="com.praveen.backend.model.User"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
List<User> users =
        (List<User>)request.getAttribute("users");

String keyword =
        request.getAttribute("keyword") == null
                ? ""
                : request.getAttribute("keyword").toString();

String success =
        request.getParameter("success");

Integer currentPage =
        (Integer)request.getAttribute("currentPage");

Integer totalPages =
        (Integer)request.getAttribute("totalPages");

if(currentPage == null)
    currentPage = 1;

if(totalPages == null)
    totalPages = 1;

int totalUsers =
        users == null ? 0 : users.size();
%>

<div class="page-header">

    <h1>User Management</h1>

    <div class="page-actions">

        <form action="<%=request.getContextPath()%>/users"
              method="get"
              style="display:flex;gap:10px;">

            <input
                    type="text"
                    name="keyword"
                    value="<%=keyword%>"
                    placeholder="Search Employee, Email..."
                    class="search-box">

            <button
                    class="btn"
                    type="submit">

                Search

            </button>

        </form>

        <a
                href="<%=request.getContextPath()%>/users?page=add"
                class="btn">

            + Add User

        </a>

    </div>

</div>

<%
if(success != null){
%>

<div class="success-message">

<%
if(success.equals("added")){
%>

User added successfully.

<%
}else if(success.equals("updated")){
%>

User updated successfully.

<%
}else if(success.equals("deleted")){
%>

User deleted successfully.

<%
}
%>

</div>

<%
}
%>

<h3>

Total Users :

<%=totalUsers%>

</h3>

<table>

<thead>

<tr>

<th>ID</th>

<th>Employee Code</th>

<th>Name</th>

<th>Email</th>

<th>Role</th>

<th>Department</th>

<th>Status</th>

<th width="240">

Actions

</th>

</tr>

</thead>

<tbody>
    <%
if(users != null && !users.isEmpty()){

    for(User user : users){
%>

<tr>

    <td>

        <%=user.getUserId()%>

    </td>

    <td>

        <%=user.getEmployeeCode()%>

    </td>

    <td>

        <%=user.getFullName()%>

    </td>

    <td>

        <%=user.getEmail()%>

    </td>

    <td>

        <%=user.getRole().getRoleName()%>

    </td>

    <td>

        <%=user.getDepartment().getDepartmentName()%>

    </td>

    <td>

<%
if("ACTIVE".equals(user.getStatus())){
%>

<span class="status-active">

    ACTIVE

</span>

<%
}else{
%>

<span class="status-inactive">

    INACTIVE

</span>

<%
}
%>

    </td>

    <td>

        <a href="<%=request.getContextPath()%>/users?action=view&id=<%=user.getUserId()%>"
           class="action-link">

            View

        </a>

        &nbsp;

        <a href="<%=request.getContextPath()%>/users?action=edit&id=<%=user.getUserId()%>"
           class="action-link action-edit">

            Edit

        </a>

        &nbsp;

        <a href="<%=request.getContextPath()%>/users?action=delete&id=<%=user.getUserId()%>"
           class="action-link action-delete"
           onclick="return confirm('Are you sure you want to delete this user?');">

            Delete

        </a>

    </td>

</tr>

<%
    }

}else{
%>

<tr>

    <td colspan="8"
        style="text-align:center;padding:20px;">

        No users found.

    </td>

</tr>

<%
}
%>

</tbody>

</table>

<br>

<div class="pagination">

<%
for(int i = 1; i <= totalPages; i++){
%>

<a
href="<%=request.getContextPath()%>/users?currentPage=<%=i%>"

class="<%=currentPage == i ? "page-active" : "page-link"%>">

<%=i%>

</a>

<%
}
%>

</div>

<%@ include file="../../common/footer.jsp"%>