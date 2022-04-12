<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8" />
		<title>AddService-Provider</title>
		<link rel="stylesheet" href="css/QoS.css" />
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
				<h1> Quality Of Service Paramaters : </h1>

		 	<form method="POST" class="register-form" id="register-form" action="QoS.php"> 
					
					<div class="corps-formulaire">
						<div class="left">
							<div class="boite">
								<label for="">ConsumabilityEfforts :</label>
								<select name="Consumability">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
							</div>
							<div class="boite">
								<label for="">FaultToleranceEfforts :</label>
								<select name="FaultTolerance">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
							</div>
							<div class="boite">
								<label for="">MigrationabilityEfforts :</label>
								<select name="Migrationability">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Performance :</label>
								<select name="Performance">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
							</div>
							<div class="boite">
								<label for="">ReliabilityEfforts :</label>
								<select name="Reliability">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
							</div>
						</div>
						<div class="right">
							<div class="boite">
								
								<label>RuntimeTunning : </label>
								<select name="RuntimeTunning">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>

							</div>
							<div class="boite">
								<label for="">ScalabilityEfforts :</label>
								<select name="Scalability">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>

							</div>
							<div class="boite">
								<label for="">SecurityEfforts :</label>
								<select name="Security">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
							</div>
							<div class="boite">
								<label for="">StandardizedEfforts :</label>
								<select name="Standardized">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
							</div>
						</div>
					</div>

					<!--/////-->
					<div class="pied-formulaire">
				<button type="reset" name="signup" id="signup" class="form-submit" value="Cancel"> Cancel </button>
				<button type="submit" name="signup" id="signup" class="form-submit" value="Next"> Next </button>
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