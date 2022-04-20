<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
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
				<h1> Functional functionality : </h1>
				
		 	<form method="POST" action="Choisir.php" name="myForm" onsubmit="return validateForm()"> 
		
					<div class="corps-formulaire">
							<div class="boite">
								
								<select name="choisir" id="FF">
								<c:forEach items="${model.FF}" var="p">
						          <option value="${p}">${p}</option>
						          </c:forEach>
								</select>
								<span class="error" id="limited"></span>
							</div>
							</div>
					<div class="pied-formulaire">
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