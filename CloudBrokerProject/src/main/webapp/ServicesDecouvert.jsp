<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Services</title>
<link rel="stylesheet" href="css/ServiceDecouvert.css" />
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

       <div class="Services">
       <table>
					<thead>
						<tr>
							<th>Service Title</th>
							<th>Provider Name</th>
							<th>Price</th>
							<th>Rating</th>
							<th>Availability</th>
							<th>Functionality</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${model.rankedCatServices}" var="p">  
							<tr>
							<td>
							${p.get("General Information").get("ServiceTitle")}
							</td> 
							<td>${p.get("General Information").get("Provider").get("nom")}</td>
							<td>${p.get("QoS").get("price")}$</td>
							<td>${p.get("QoS").get("rating")}/5</td>
							<td>${p.get("QoS").get("availability")}%</td>
							<td>${p.get("FF")}</td>
							<td><a href='Order.php?title=${p.get("General Information").get("ServiceTitle")}'>Order</a></td>
							</tr>
						     </c:forEach>
							
							
					</tbody>
				</table>
       </div>

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