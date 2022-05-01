<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8" />
		<title>Quality Of Service Paramaters</title>
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
		
			
			<div class="description">
				<h1> Quality Of Service Paramaters : </h1>

		 	<form method="POST" action="QoS.php" name="myForm" onsubmit="return validateForm()"> 
					
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
								<span class="error" id="Consumability"></span>
							</div>
							<div class="boite">
								<label for="">FaultToleranceEfforts :</label>
								<select name="FaultTolerance">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
								<span class="error" id="FaultTolerance"></span>
							</div>
							<div class="boite">
								<label for="">MigrationabilityEfforts :</label>
								<select name="Migrationability">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
								<span class="error" id="Migrationability"></span>
							</div>
							<div class="boite">
								<label for="">Performance :</label>
								<select name="Performance">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
								<span class="error" id="Performance"></span>
							</div>
							<div class="boite">
								<label for="">ReliabilityEfforts :</label>
								<select name="Reliability">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
								<span class="error" id="Reliability"></span>
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
								<span class="error" id="RuntimeTunning"></span>

							</div>
							<div class="boite">
								<label for="">ScalabilityEfforts :</label>
								<select name="Scalability">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
								<span class="error" id="Scalability"></span>

							</div>
							<div class="boite">
								<label for="">SecurityEfforts :</label>
								<select name="Security">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
								<span class="error" id="Security"></span>
							</div>
							<div class="boite">
								<label for="">StandardizedEfforts :</label>
								<select name="Standardized">
									<option selected disabled></option>
									<option value="Strong">Strong</option>
									<option value="Strong">Average</option>
									<option value="Strong">Weak</option>
								</select>
								<span class="error" id="Standardized"></span>
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

<script> 
            function validateForm()                                    
{  
    var Consumability = document.forms["myForm"]["Consumability"];
    var FaultTolerance = document.forms["myForm"]["FaultTolerance"];
    var Migrationability = document.forms["myForm"]["Migrationability"];
    var Performance = document.forms["myForm"]["Performance"];
    var Reliability = document.forms["myForm"]["Reliability"]; 
    var RuntimeTunning = document.forms["myForm"]["RuntimeTunning"];
    var Scalability = document.forms["myForm"]["Scalability"];
    var Security = document.forms["myForm"]["Security"];
    var Standardized = document.forms["myForm"]["Standardized"];
   
    ////////////////////////////////
    if (Consumability.value == "")                                  
    { 
        document.getElementById('Consumability').innerHTML="Enter the ConsumabilityEfforts";  
        Consumability.focus(); 
        return false; 
    }else{
        document.getElementById('Consumability').innerHTML="";  
    }

    ////////////////////////////////
    if (FaultTolerance.value == "")                                  
    { 
        document.getElementById('FaultTolerance').innerHTML="Enter the FaultToleranceEfforts";  
        FaultTolerance.focus(); 
        return false; 
    }else{
        document.getElementById('FaultTolerance').innerHTML="";  
    }


    ///////////////////////
    if (Migrationability.value == "")                                  
    { 
        document.getElementById('Migrationability').innerHTML="Enter the MigrationabilityEfforts";  
        Migrationability.focus(); 
        return false; 
    }else{
        document.getElementById('Migrationability').innerHTML="";  
    } 

    ///////////////////////

    if (Performance.value == "")                                  
    { 
        document.getElementById('Performance').innerHTML="Enter the Performance";  
        Performance.focus(); 
        return false; 
    }else{
        document.getElementById('Performance').innerHTML="";  
    }   
    /////////////////////////////////
   if (Reliability.value == "")                                  
    { 
        document.getElementById('Reliability').innerHTML="Enter the ReliabilityEfforts";  
        Reliability.focus(); 
        return false; 
    }else{
        document.getElementById('Reliability').innerHTML="";  
    }
        /////////////////////////////////
   if (RuntimeTunning.value == "")                                  
    { 
        document.getElementById('RuntimeTunning').innerHTML="Enter the RuntimeTunning";  
        RuntimeTunning.focus(); 
        return false; 
    }else{
        document.getElementById('RuntimeTunning').innerHTML="";  
    }
            /////////////////////////////////
   if (Scalability.value == "")                                  
    { 
        document.getElementById('Scalability').innerHTML="Enter the ScalabilityEfforts";  
        Scalability.focus(); 
        return false; 
    }else{
        document.getElementById('Scalability').innerHTML="";  
    }
                /////////////////////////////////
   if (Security.value == "")                                  
    { 
        document.getElementById('Security').innerHTML="Enter the SecurityEfforts";  
        Security.focus(); 
        return false; 
    }else{
        document.getElementById('Security').innerHTML="";  
    }
                    /////////////////////////////////
   if (Standardized.value == "")                                  
    { 
        document.getElementById('Standardized').innerHTML="Enter the StandardizedEfforts";  
        Standardized.focus(); 
        return false; 
    }else{
        document.getElementById('Standardized').innerHTML="";  
    }


}
   </script>

	</body>
</html>