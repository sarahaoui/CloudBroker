<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Services used</title>
<link rel="stylesheet" href="css/UsedServices.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
			rel="stylesheet"
		/>
		<link
			href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
			rel="stylesheet"
		/>
		<link rel="shortcut icon" href="images/logo.png" />
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>
<div class="container">

       
       <table>
					<thead>
						<tr>
							<th>Service Title</th>
							<th>Provider Name</th>
							<th>Rating</th>
							<th>Functionality</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${model.servicesorder}" var="p">
							<tr>
							<td>${p.serviceTitle}</td>
							<td>${p.provoderName}</td>
							<td>${p.rating} /5</td>
							<td>${p.ff}</td>
						   <td><a href="AddRating.php?title=${p.serviceTitle}">Rate</a></td>
							</tr>
							</c:forEach>
							
							
					</tbody>
				</table>
       </div>

           <!--side bar section-->
			<%@ include file="MenuUser.jsp" %>
			
			<script>
  let arrow = document.querySelectorAll(".arrow");
  for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e)=>{
   let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
   arrowParent.classList.toggle("showMenu");
    });
  }
  let sidebar = document.querySelector(".sidebar");
  let sidebarBtn = document.querySelector(".bx-menu");
  console.log(sidebarBtn);
  sidebarBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("close");
  });
  </script>
</body>
</html>