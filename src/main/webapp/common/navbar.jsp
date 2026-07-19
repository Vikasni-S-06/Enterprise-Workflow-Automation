<div class="top-navbar">

    <div class="page-title">
        Enterprise Workflow Automation
    </div>

    <%
        String loggedInUser = (String) session.getAttribute("userName");
        String loggedInRole = (String) session.getAttribute("role");

        if(loggedInUser == null){
            loggedInUser = "Guest";
        }

        if(loggedInRole == null){
            loggedInRole = "";
        }
    %>

    <div class="user-profile">

        <span class="user-name">
            Welcome,
            <%= loggedInUser %>
        </span>

        <% if(!loggedInRole.isEmpty()){ %>

            <span class="user-role">
                (<%= loggedInRole %>)
            </span>

        <% } %>

    </div>

</div>