<%@ page import="java.util.List" %>
<%@ page import="org.example.models.student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<header>
    <h1 class="logo">Grit Academy</h1>
    <nav>
        <ul>
            <li>
                <a href="index.html">Home</a>
            </li>
            <li>
                <a href="student">Students</a>
            </li>
            <li>
                <a href="course">Courses</a>
            </li>
        </ul>
    </nav>
</header>

<table border="1">

  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>City</th>
    <th>Hobbies</th>
  </tr>

  <% List<student> students = (List<student>) request.getAttribute("students");
  for (student student : students) { %>


  <tr>
            <td><%= student.getFname() %></td>
            <td><%= student.getLname() %></td>
            <td><%= student.getCity() %></td>
            <td><%= student.getHobby() %></td>
  </tr>
  <% } %>
</table>
</body>
</html>