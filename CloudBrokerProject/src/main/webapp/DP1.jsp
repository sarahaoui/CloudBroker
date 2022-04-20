<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8" />
		<title>General Paramaters</title>
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
		
			
			<div class="description">
				<h1> General Paramaters : </h1>
				
		 	<form method="POST" action="DP1.php" name="myForm" onsubmit="return validateForm()"> 
				
					<div class="corps-formulaire1">
						<div class="left1">
							<div class="boite">
								<label for="">Service Title :</label>
								<input type="text" name="title" />
								<span class="error" id="title"></span>
							</div>
							<div class="boite">
								<label for="">SubscriptionFee :</label>
								<input type="text" name="fee" />
								<span class="error" id="fee"></span>
							</div>
							<div class="boite">
								<label for="">Version :</label>
								<input type="text" name="version" />
								<span class="error" id="version"></span>
							</div>	
						</div>
						<div class="right1">
							<div class="boite">
								<label for="">Short Description :</label>
								<textarea name="description"></textarea>
								<span class="error" id="description"></span>
							</div>
							
						</div>
					</div>
					<div class="corps-formulaire1">
						<div class="left1">
							<div class="boite">
								<label for="">Service URL :</label>
								<input type="text" name="url" />
								<span class="error" id="url"></span>
							</div>							
						</div>
						<div class="right1">
							<div class="boite">						
								<label>Import SLA : </label>
									<input type="file" name="import" class="import" >
									<span class="error" id="sla"></span>
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
								<span class="error" id="free"></span>
							</div>
							<div class="boite">
								<label for="">PerUnit :</label>
								<select name="unit" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="unit"></span>
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
								<span class="error" id="tie"></span>
							</div>
							<div class="boite">
								<label for="">Subscription :</label>
								<select name="sub" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="sub"></span>
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
								<span class="error" id="limited"></span>
							</div>
							<div class="boite">
								<label for="">CompleteLevel :</label>
								<select name="complete" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="complete"></span>
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
								<span class="error" id="basic"></span>
							</div>
							<div class="boite">
								<label for="">ModerateLevel :</label>
								<select name="moderate" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="moderate"></span>
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
								<span class="error" id="web"></span>
							</div>
							<div class="boite">
								<label for="">API :</label>
								<select name="api" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="api"></span>
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
								<span class="error" id="cli"></span>
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
								<span class="error" id="africa"></span>
							</div>
							<div class="boite">
								<label for="">Australlia :</label>
								<select name="australlia" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="australlia"></span>
							</div>
							<div class="boite">
								<label for="">MiddleeastNorthAfrica :</label>
								<select name="north" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="north"></span>
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
								<span class="error" id="asia"></span>
							</div>
							<div class="boite">
								<label for="">Europe_UK :</label>
								<select name="uk" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="uk"></span>
							</div> 
							<div class="boite">
								<label for="">US_Canada :</label>
								<select name="us" id="Contrainte">
									<option selected disabled></option>
									<option value="Support">Support</option>
									<option value="Not Support">Not Support</option>
								</select>
								<span class="error" id="us"></span>
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
								<span class="error" id="prop"></span>
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
								<span class="error" id="open"></span>
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
								<span class="error" id="individu"></span>
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
								<span class="error" id="orga"></span>
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


<script> 
            function validateForm()                                    
{  
    var title = document.forms["myForm"]["title"];
    var fee = document.forms["myForm"]["fee"];
    var version = document.forms["myForm"]["version"];
    var description = document.forms["myForm"]["description"];
    var url = document.forms["myForm"]["url"]; 
    var free = document.forms["myForm"]["free"];
    var unit = document.forms["myForm"]["unit"];
    var tie = document.forms["myForm"]["tie"];
    var sub = document.forms["myForm"]["sub"];
    var limited = document.forms["myForm"]["limited"];
    var complete = document.forms["myForm"]["complete"];
    var basic = document.forms["myForm"]["basic"];
    var moderate = document.forms["myForm"]["moderate"];
    var web = document.forms["myForm"]["web"];
    var api = document.forms["myForm"]["api"];
    var cli = document.forms["myForm"]["cli"];
    var africa = document.forms["myForm"]["africa"];
    var australlia = document.forms["myForm"]["australlia"];
    var north = document.forms["myForm"]["north"];
    var asia = document.forms["myForm"]["asia"];
    var uk = document.forms["myForm"]["uk"];
    var us = document.forms["myForm"]["us"];
    var prop = document.forms["myForm"]["prop"];
    var open = document.forms["myForm"]["open"];

    var individu = document.forms["myForm"]["individu"];
    var orga = document.forms["myForm"]["orga"];
   
    ////////////////////////////////
    if (title.value == "")                                  
    { 
        document.getElementById('title').innerHTML="Please enter your service title";  
        title.focus(); 
        return false; 
    }else{
        document.getElementById('title').innerHTML="";  
    }

    ////////////////////////////////
    if (fee.value == "")                                  
    { 
        document.getElementById('fee').innerHTML="Please enter your SubscriptionFee";  
        fee.focus(); 
        return false; 
    }else{
        document.getElementById('fee').innerHTML="";  
    }


    ///////////////////////
    if (version.value == "")                                  
    { 
        document.getElementById('version').innerHTML="Please enter the version";  
        version.focus(); 
        return false; 
    }else{
        document.getElementById('version').innerHTML="";  
    } 

    ///////////////////////

    if (description.value == "")                                  
    { 
        document.getElementById('description').innerHTML="enter the description";  
        description.focus(); 
        return false; 
    }else{
        document.getElementById('description').innerHTML="";  
    }   
    /////////////////////////////////
   if (url.value == "")                                  
    { 
        document.getElementById('url').innerHTML="Enter the URL";  
        url.focus(); 
        return false; 
    }else{
        document.getElementById('url').innerHTML="";  
    }
        /////////////////////////////////
   if (free.value == "")                                  
    { 
        document.getElementById('free').innerHTML="Enter the Free";  
        free.focus(); 
        return false; 
    }else{
        document.getElementById('free').innerHTML="";  
    }
            /////////////////////////////////
   if (unit.value == "")                                  
    { 
        document.getElementById('unit').innerHTML="Enter the PerUnit";  
        unit.focus(); 
        return false; 
    }else{
        document.getElementById('unit').innerHTML="";  
    }
                /////////////////////////////////
   if (tie.value == "")                                  
    { 
        document.getElementById('tie').innerHTML="Enter the Tiered";  
        tie.focus(); 
        return false; 
    }else{
        document.getElementById('tie').innerHTML="";  
    }
                    /////////////////////////////////
   if (sub.value == "")                                  
    { 
        document.getElementById('sub').innerHTML="Enter the TieredLevel";  
        sub.focus(); 
        return false; 
    }else{
        document.getElementById('sub').innerHTML="";  
    }
                        /////////////////////////////////
   if (limited.value == "")                                  
    { 
        document.getElementById('limited').innerHTML="Enter the LimitedLevel";  
        limited.focus(); 
        return false; 
    }else{
        document.getElementById('limited').innerHTML="";  
    }
                    /////////////////////////////////
   if (complete.value == "")                                  
    { 
        document.getElementById('complete').innerHTML="Enter the CompleteLevel";  
        complete.focus(); 
        return false; 
    }else{
        document.getElementById('complete').innerHTML="";  
    }
                    /////////////////////////////////
   if (basic.value == "")                                  
    { 
        document.getElementById('basic').innerHTML="Enter the BasicLevel";  
        basic.focus(); 
        return false; 
    }else{
        document.getElementById('basic').innerHTML="";  
    }
                /////////////////////////////////
   if (moderate.value == "")                                  
    { 
        document.getElementById('moderate').innerHTML="Enter the moderate";  
        moderate.focus(); 
        return false; 
    }else{
        document.getElementById('moderate').innerHTML="";  
    }
             /////////////////////////////////
   if (web.value == "")                                  
    { 
        document.getElementById('web').innerHTML="Enter the WebPortal";  
        web.focus(); 
        return false; 
    }else{
        document.getElementById('web').innerHTML="";  
    }
                    /////////////////////////////////
   if (api.value == "")                                  
    { 
        document.getElementById('api').innerHTML="Enter the API";  
        api.focus(); 
        return false; 
    }else{
        document.getElementById('api').innerHTML="";  
    }
                /////////////////////////////////
   if (cli.value == "")                                  
    { 
        document.getElementById('cli').innerHTML="Enter the CLI";  
        cli.focus(); 
        return false; 
    }else{
        document.getElementById('cli').innerHTML="";  
    }
                        /////////////////////////////////
   if (africa.value == "")                                  
    { 
        document.getElementById('africa').innerHTML="Enter the Africa";  
        africa.focus(); 
        return false; 
    }else{
        document.getElementById('africa').innerHTML="";  
    }
                /////////////////////////////////
   if (australlia.value == "")                                  
    { 
        document.getElementById('australlia').innerHTML="Enter the Australlia";  
        australlia.focus(); 
        return false; 
    }else{
        document.getElementById('australlia').innerHTML="";  
    }
                    /////////////////////////////////
   if (north.value == "")                                  
    { 
        document.getElementById('north').innerHTML="Enter the MiddleeastNorthAfrica ";  
        north.focus(); 
        return false; 
    }else{
        document.getElementById('north').innerHTML="";  
    }
                        /////////////////////////////////
   if (asia.value == "")                                  
    { 
        document.getElementById('asia').innerHTML="Enter the Asia";  
        asia.focus(); 
        return false; 
    }else{
        document.getElementById('asia').innerHTML="";  
    }

                 /////////////////////////////////
   if (uk.value == "")                                  
    { 
        document.getElementById('uk').innerHTML="Enter the Europe_UK";  
        uk.focus(); 
        return false; 
    }else{
        document.getElementById('uk').innerHTML="";  
    }
                     /////////////////////////////////
   if (us.value == "")                                  
    { 
        document.getElementById('us').innerHTML="Enter the US_Canada";  
        us.focus(); 
        return false; 
    }else{
        document.getElementById('us').innerHTML="";  
    }

                     /////////////////////////////////
   if (prop.value == "")                                  
    { 
        document.getElementById('prop').innerHTML="Enter the Proprietary";  
        prop.focus(); 
        return false; 
    }else{
        document.getElementById('prop').innerHTML="";  
    }
                     /////////////////////////////////
   if (open.value == "")                                  
    { 
        document.getElementById('open').innerHTML="Enter the Open Source";  
        open.focus(); 
        return false; 
    }else{
        document.getElementById('open').innerHTML="";  
    }

                         /////////////////////////////////
   if (individu.value == "")                                  
    { 
        document.getElementById('individu').innerHTML="Enter the Individuals";  
        individu.focus(); 
        return false; 
    }else{
        document.getElementById('individu').innerHTML="";  
    }
                     /////////////////////////////////
   if (orga.value == "")                                  
    { 
        document.getElementById('orga').innerHTML="Enter the Organizations";  
        orga.focus(); 
        return false; 
    }else{
        document.getElementById('orga').innerHTML="";  
    }











}
   </script>


	</body>
</html>