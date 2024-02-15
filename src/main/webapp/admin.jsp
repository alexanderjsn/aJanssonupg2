<%@ page import="java.util.List" %>
<%@ page import="org.example.models.Course" %>
<%@ page import="org.example.models.student" %>
<%@ page import="org.example.models.association" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="/script/script.js"></script>
    <title>Title</title>
</head>
<body>
<header>
    <h1 class="logo">Grit Academy</h1>
    <nav>


        <ul>
            <li>
                <a href="index.html">Homrrre</a>
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
<h2>Kurser</h2>
<table border="1" id="courses">
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
</table>

<h2>Elever</h2>

<table border="1" id="students">
    <tr>
        <th>Id</th>
        <th>First Names</th>
        <th>Last Name</th>
        <th>City</th>
        <th>Hobby</th>
    </tr>



    <% List<student> students = (List<student>) request.getAttribute("students");
      for (student student : students) { %>
      <tr>
                <td><%= student.getStudent_id() %></td>
                <td><%= student.getFname() %></td>
                <td><%= student.getLname() %></td>
                <td><%= student.getCity() %></td>
                <td><%= student.getHobby() %></td>
      </tr>
      <% } %>
      </table>


      <table border="1" id="association">
          <tr>
              <th>Association ID</th>
              <th>Student ID</th>
              <th>Kurs ID</th>


          </tr>
          <% List<association> associationList = (List<association>) request.getAttribute("associationList");
             for (association association : associationList) { %>

              <tr>
                   <td><%= association.getId() %></td>
                    <td><%= association.getStudentId() %></td>
                   <td><%= association.getCourseId() %></td>
              </tr>
              <% } %>
      </table>
          <form action="attendance" method="post">
            <label for="addStudentID">Student:</label>
            <input type="number" id="student_id" name="student_id">
            <br>
             <label for="addCourseID">Kurs:</label>
               <input type="number" id="course_id" name="course_id">
              <input type="submit" value="Lägg till">
                </form>
      <script>
      document.querySelectorAll("td").forEach(cell => {
          cell.addEventListener("click", function() {
              var tableId = this.closest('table').id;
              cell.style.backgroundColor = 'green';
              var value = this.innerText;
              if (tableId === 'students'){
              document.getElementById("searchFName").value = value;
              }
              else if (tableId === "courses"){
              document.getElementById("searchLName").value = value;
              }
          });
      });

      </script>
</body>
</html>
