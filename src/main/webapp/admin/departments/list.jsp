<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List"%>
<%@ page import="com.praveen.backend.model.Department"%>

<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/sidebar.jsp"%>

<%
List<Department> departments =
        (List<Department>) request.getAttribute("departments");

String keyword =
        request.getAttribute("keyword") == null
                ? ""
                : request.getAttribute("keyword").toString();

String success =
        request.getParameter("success");

String error =
        request.getParameter("error");

Integer currentPage =
        (Integer) request.getAttribute("currentPage");

Integer totalPages =
        (Integer) request.getAttribute("totalPages");

if(currentPage == null)
    currentPage = 1;

if(totalPages == null)
    totalPages = 1;

int totalDepartments =
        departments == null ? 0 : departments.size();
%>

<div class="page-header">

    <h1>Department Management</h1>

    <div class="page-actions">

        <form action="<%=request.getContextPath()%>/departments"
              method="get"
              style="display:flex;gap:10px;">

            <input
                    type="text"
                    name="keyword"
                    value="<%=keyword%>"
                    placeholder="Search Department..."
                    class="search-box">

            <button
                    type="submit"
                    class="btn">

                Search

            </button>

        </form>

        <a href="<%=request.getContextPath()%>/departments?page=add"
           class="btn">

            + Add Department

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

Department added successfully.

<%
}else if(success.equals("updated")){
%>

Department updated successfully.

<%
}else if(success.equals("deleted")){
%>

Department deleted successfully.

<%
}
%>

</div>

<%
}
%>

<%
if(error != null){
%>

<div class="alert alert-danger">

<%
if(error.equals("assigned")){
%>

Cannot delete department because it is assigned to one or more users.

<%
}
%>

</div>

<%
}
%>

<h3>

Total Departments :

<%=totalDepartments%>

</h3>

<table>

    <thead>

    <tr>

        <th>ID</th>

        <th>Department Name</th>

        <th width="240">

            Actions

        </th>

    </tr>

    </thead>

    <tbody>

<%
if(departments != null &&
        !departments.isEmpty()){

    for(Department department : departments){
%>

<tr>

    <td>

        <%=department.getDepartmentId()%>

    </td>

    <td>

        <%=department.getDepartmentName()%>

    </td>

    <td>

        <a href="<%=request.getContextPath()%>/departments?action=view&id=<%=department.getDepartmentId()%>"
           class="action-link">

            View

        </a>

        &nbsp;

        <a href="<%=request.getContextPath()%>/departments?action=edit&id=<%=department.getDepartmentId()%>"
           class="action-link action-edit">

            Edit

        </a>

        &nbsp;

        <a href="<%=request.getContextPath()%>/departments?action=delete&id=<%=department.getDepartmentId()%>"
           class="action-link action-delete"
           onclick="return confirm('Are you sure you want to delete this department?');">

            Delete

        </a>

    </td>

</tr>

<%
    }

}else{
%>

<tr>

    <td colspan="3"
        style="text-align:center;padding:20px;">

        No departments found.

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

<a href="<%=request.getContextPath()%>/departments?currentPage=<%=i%>"
   class="<%=currentPage == i ? "page-active" : "page-link"%>">

    <%=i%>

</a>

<%
}
%>

</div>

<%@ include file="../../common/footer.jsp"%>