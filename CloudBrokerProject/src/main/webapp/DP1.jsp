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
				
		 	<form method="POST" class="register-form" id="register-form" action="DP1.php"> 
				
					<div class="corps-formulaire1">
						<div class="left1">
							<div class="boite">
								<label for="">Service Title :</label>
								<input type="text" name="title" />
							</div>
							<div class="boite">
								<label for="">SubscriptionFee :</label>
								<input type="text" name="fee" />
							</div>
							<div class="boite">
								<label for="">Version :</label>
								<input type="text" name="version" />
							</div>	
						</div>
						<div class="right1">
							<div class="boite">
								<label for="">Short Description :</label>
								<textarea name="description"></textarea>
							</div>
							
						</div>
					</div>
					<div class="corps-formulaire1">
						<div class="left1">
							<div class="boite">
								<label for="">Service URL :</label>
								<input type="text" name="url" />
							</div>							
						</div>
						<div class="right1">
							<div class="boite">						
								<label>Import SLA : </label>
									<input type="file" name="import" class="import" />
							</div>						
						</div>
					</div>
			    <div class="corps-formulairee">
                   <p>Payement Model :</p>

					<div class="corps-formulaire2">
						<div class="left2">
							
							<div class="boite">
								<label for="">Free :</label>
								<select name="free" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">PerUnit :</label>
								<select name="unit" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							
						</div>
						<div class="right2">
							<div class="boite">
								<label for="">Tiered :</label>
								<select name="tie" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Subscription :</label>
								<select name="sub" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							</div>
							
						</div>
					</div>
			

					<!--/////-->
					
                   <p>Openness :</p>

					<div class="corps-formulaire3">
						<div class="left3">
							
							<div class="boite">
								<label for="">LimitedLevel :</label>
								<select name="limited" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">CompleteLevel :</label>
								<select name="complete" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							
							
						</div>
						<div class="right3">
							<div class="boite">
								<label for="">BasicLevel :</label>
								<select name="basic" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">ModerateLevel :</label>
								<select name="moderate" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							</div>
							
						</div>
								<!--/////-->
					
                   <p>Service Interface :</p>

					<div class="corps-formulaire4">
						<div class="left4">
							
							<div class="boite">
								<label for="">WebPortal :</label>
								<select name="web" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">API :</label>
								<select name="api" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							
							
						</div>
						<div class="right4">
							<div class="boite">
								<label for="">CLI :</label>
								<select name="cli" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							
							</div>
							
						</div>
				

				<!-- -->
				<p>Location :</p>

					<div class="corps-formulaire4">
						<div class="left4">
							
							<div class="boite">
								<label for="">Africa :</label>
								<select name="africa" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Australlia :</label>
								<select name="australlia" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">MiddleeastNorthAfrica :</label>
								<select name="north" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							
							
						</div>
						<div class="right4">
							<div class="boite">
								<label for="">Asia :</label>
								<select name="asia" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							<div class="boite">
								<label for="">Europe_UK :</label>
								<select name="uk" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div> 
							<div class="boite">
								<label for="">US_Canada :</label>
								<select name="us" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div> 
						</div>
					</div>
							
							<!-- -->
							<p>License Type :</p>

					<div class="corps-formulaire4">
						<div class="left4">
							
							<div class="boite">
								<label for="">Proprietary :</label>
								<select name="prop" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							
							
						</div>
						<div class="right4">
							<div class="boite">
								<label for="">Open Source :</label>
								<select name="open" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div> </div></div>
							<!-- -->
							<!-- -->
							<p>Intended User :</p>

					<div class="corps-formulaire4">
						<div class="left4">
							
							<div class="boite">
								<label for="">Individuals :</label>
								<select name="individu" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div>
							
							
						</div>
						<div class="right4">
							<div class="boite">
								<label for="">Organizations :</label>
								<select name="orga" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
							</div> </div></div>
					<div class="pied-formulaire">
					<!--  	<button type="submit">Cancel</button> -->
						<button type="reset" name="signup" id="signup" class="form-submit" value="Cancel"> Cancel </button>
						<button type="submit" name="signup" id="signup" class="form-submit" value="Next"> Next </button>
					<!--        <button type="reset"> Next </button> -->
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