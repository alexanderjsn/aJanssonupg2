<%@ page import="java.util.List" %>
<%@ page import="org.example.models.Course" %>
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
        <th>Kurs-ID</th>
        <th>Namn</th>
        <th>YHP</th>
        <th>Beskrivning</th>
    </tr>
  <% List<Course> courseList = (List<Course>) request.getAttribute("courseList");
  for (Course course : courseList) { %>

    <tr>
        <td><%= course.getCourseId() %></td>
        <td><%= course.getName() %></td>
        <td><%= course.getYhp() %></td>
        <td><%= course.getDescription() %></td>
    </tr>
    <% } %>

         <form action="addCourse" method="post">
              Namn: <input type="text" name="name"><br>
              YHP: <input type="number" name="yhp"><br>
              beskrivning: <input type="text" name="description"><br>
              <input type="submit" value="Lägg till kurs">
          <input type="submit" value="Lägg till">
             </form>


</table>
</body>
</html>