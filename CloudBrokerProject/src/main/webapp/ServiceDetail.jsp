<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8" />
		<title>${model.service.get("General Information").get("ServiceTitle")}</title>
		<link rel="stylesheet" href="css/ServiceDetails.css" />
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link rel="shortcut icon" href="images/logo.png" />
		<link
			href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
			rel="stylesheet"
		/>
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
			rel="stylesheet"
		/>
		<link
			rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
			integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
			crossorigin="anonymous"
			referrerpolicy="no-referrer"
		/>
	</head>
	<body>
		
			
			<div class="description">
				
				<table>
				<tr><td class ="nowrap"><h1> General Informations : </h1></td></tr>
				<tr>	
				<td class ="nowrap">Functionality Functional :</td>
				<td>${model.service.get("FF")}</td>
				</tr>
				<tr>
				<td>ServiceTitle :</td>
				<td >${model.service.get("General Information").get("ServiceTitle")}</td>
				</tr>
				<tr>
				<td class="Title">Short Description :</td>
				<td>${model.service.get("General Information").get("ShortDescription")}</td>
				</tr>
				<tr>
				<td>SubscriptionFee :</td>
				<td>${model.service.get("General Information").get("SubscriptionFee")}</td>
				</tr>
				<tr>
				<td>Version :</td>
				<td>${model.service.get("General Information").get("Version")}</td>
				</tr>
				<tr>
				<td>Service URL :</td>
				<td>${model.service.get("General Information").get("ServiceURL")}</td>
				</tr>
				<tr>
				<td>Provider :</td>
				<td>${model.service.get("General Information").get("Provider").get("nom")}</td>
				</tr>
				<tr>
				<td class="blood">License Type :</td>
				</tr>
				<tr>
				<td>OpenSource :</td>
				<td>${model.service.get("General Information").get("LicenseType").get("Opensource")}</td>
				</tr>
				<tr>
				<td>Proprietary :</td>
				<td>${model.service.get("General Information").get("LicenseType").get("Proprietary")}</td>
				</tr>
				<tr>
				<td class="blood">Openness :</td>
				</tr>
				<tr>
				<td>ModerateLevel :</td>
				<td>${model.service.get("General Information").get("Openness").get("ModerateLevel")}</td>
				</tr>
				<tr>
				<td>BasicLevel :</td>
				<td>${model.service.get("General Information").get("Openness").get("BasicLevel")}</td>
				</tr>
				<tr>
				<td>CompleteLevel :</td>
				<td>${model.service.get("General Information").get("Openness").get("CompleteLevel")}</td>
				</tr>
				<tr>
				<td>LimitedLevel :</td>
				<td>${model.service.get("General Information").get("Openness").get("LimitedLevel")}</td>
				</tr>
				<tr>
				<td class="blood">PayementModel :</td>
				</tr>
				<tr>
				<td>PerUnit :</td>
				<td>${model.service.get("General Information").get("PayementModel").get("PerUnit")}</td>
				</tr>
				<tr>
				<td>Subscription :</td>
				<td>${model.service.get("General Information").get("PayementModel").get("Subscription")}</td>
				</tr>
				<tr>
				<td>Free:</td>
				<td>${model.service.get("General Information").get("PayementModel").get("Free")}</td>
				</tr>
				<tr>
				<td>Tiered :</td>
				<td>${model.service.get("General Information").get("PayementModel").get("Tiered")}</td>
				</tr>
				<tr>
				<td class="blood">IntendedUser :</td>
				</tr>
				<tr>
				<td>Organizations :</td>
				<td>${model.service.get("General Information").get("IntendedUser").get("Organizations")}</td>
				</tr>
				<tr>
				<td>Individuals :</td>
				<td>${model.service.get("General Information").get("IntendedUser").get("Individuals")}</td>
				</tr>
				<tr>
				<td class="blood">ServiceInterface :</td>
				</tr>
				<tr>
				<td>WebPortalInterface :</td>
				<td>${model.service.get("General Information").get("ServiceInterface").get("WebPortalInterface")}</td>
				</tr>
				<tr>
				<td>APIInterface :</td>
				<td>${model.service.get("General Information").get("ServiceInterface").get("APIInterface")}</td>
				</tr>
				<tr>
				<td>CLIInterface:</td>
				<td>${model.service.get("General Information").get("ServiceInterface").get("CLIInterface")}</td>
				</tr>
				<tr>
				<td class="blood">Location :</td>
				</tr>
				<tr>
				<td>Australlia :</td>
				<td>${model.service.get("General Information").get("Location").get("Australlia")}</td>
				</tr>
				<tr>
				<td>Asia :</td>
				<td>${model.service.get("General Information").get("Location").get("Asia")}</td>
				</tr>
				<tr>
				<td>Europe_UK :</td>
				<td>${model.service.get("General Information").get("Location").get("Europe_UK")}</td>
				</tr>
				<tr>
				<td>Africa :</td>
				<td>${model.service.get("General Information").get("Location").get("Africa")}</td>
				</tr>
				<tr>
				<td>US_Canada :</td>
				<td>${model.service.get("General Information").get("Location").get("US_Canada")}</td>
				</tr>
				<tr>
				<td><a href="SLA.php">Show SLA</a></td>
				</tr>
				</table>
			</div>
			
			<div class="pied">
			<form action="orderService.php">
			<input name="ServiceTitle" value='${model.service.get("General Information").get("ServiceTitle")}' class="novisible">
			<input type="submit" value="Order" class="button">
			</form>	
			</div>
			
			 <div class="popup-overlay">
			<div class="popup-box">
				<div class="check-container">
					<ion-icon name="checkmark-outline"></ion-icon>
				</div>
				<div class="popup-message-container">
					<h2>Thank you !</h2>
					<p>The service request has been successfully processed</p>
				</div>
				<button class="ok-btn">OK</button>
			</div>
		</div>
		
		<c:if test="${model.showpop == true}">
		<script>
		const popbox = document.querySelector('.popup-overlay');

	 popbox.classList.add('active');
	  
      </script> 
		</c:if>
		
		<script
			type="module"
			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
		></script>
		<script
			nomodule
			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
		></script>
    <!--side bar section-->
			<%@ include file="MenuUser.jsp" %>
		<!-- Script part-->
		<script>
		const okbtn = document.querySelector('.ok-btn');
		okbtn.addEventListener('click', () => {
			popbox.classList.add('active');
			popbox.classList.remove('active');
		}); 
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