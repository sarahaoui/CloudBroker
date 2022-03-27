<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8" />
		<title>AddService-Provider</title>
		<link rel="stylesheet" href="css/DP1.css" />
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
		<div class="content">
			
			<div class="description">
				<h1> General Paramaters : </h1>
				<form>
					<div class="corps-formulaire">
						<div class="left1">
							<div class="boite">
								<label for="">Service Ttile :</label>
								<input type="text" />
							</div>
							<div class="boite">
								<label for="">SubscriptionFee :</label>
								<input type="text" />
							</div>
							<div class="boite">
								<label for="">Version :</label>
								<input type="text" />
							</div>	
						</div>
						<div class="right1">
							<div class="boite">
								<label for="">Short Description :</label>
								<textarea></textarea>
							</div>
							
						</div>
					</div>
					<div class="corps-formulaire2">
						<div class="left2">
							<div class="boite">
								<label for="">Service URL :</label>
								<input type="text" />
							</div>
							<div class="boite">
								<label for="">Payement Model :</label>
								<select name="Contrainte" id="Contrainte">
									<option selected disabled></option>
									<option value="Contrainte1">Contrainte 1</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Intended User :</label>
								<select name="Contrainte" id="Contrainte">
									<option selected disabled></option>
									<option value="Contrainte1">Contrainte 1</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Service Interface :</label>
								<select name="Contrainte" id="Contrainte">
									<option selected disabled></option>
									<option value="Contrainte1">Contrainte 1</option>
								</select>
							</div>
						</div>
						<div class="right2">
							<div class="boite">
								
								<label>Import SLA : </label>
									<input type="file" />
							</div>
							<div class="boite">
								<label for="">License Type :</label>
								<select name="Contrainte" id="Contrainte">
									<option selected disabled></option>
									<option value="Contrainte1">Contrainte 1</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Openness :</label>
								<select name="Contrainte" id="Contrainte">
									<option selected disabled></option>
									<option value="Contrainte1">Contrainte 1</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Location :</label>
								<select name="Contrainte" id="Contrainte">
									<option selected disabled></option>
									<option value="Contrainte1">Contrainte 1</option>
								</select>
							</div>
						</div>
					</div>

					<!--/////-->
					<div class="pied-formulaire">
						<button type="submit">Cancel</button>
						<button type="reset">Next</button>
					</div>
				</form>
			</div>	
			<!--side bar section-->
			<%@ include file="Menu.jsp" %>
		<!-- Script part-->
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