<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Signup</title>
		<!-- Font Icon -->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
			rel="stylesheet"
		/>
		<!-- Main css -->
		<link rel="stylesheet" href="css/Inscrire.css" />
		<link rel="shortcut icon" href="images/logo.png" />
	</head>

	<body>
		<div class="main">
			<!-- Sign up form -->
			<section class="signup">
				<div class="container">
					<div class="signup-content">
						<div class="signup-form">
							<h2 class="form-title">SignUp</h2>
						
						<form  method="POST" action="Inscrire.php" name="myForm" onsubmit="return validateForm()">
							
								<div class="form-group">
									<label for="name"> <span class="material-icons">person</span></label>
									<input
										type="text" name="nom"  placeholder="Username" />
										<span class="error" id="nom"></span>
								
								</div>
								<div class="form-group">
									<label for="pass"><span class="material-icons">lock</span></label>
									<input type="password" name="motdepasse" placeholder="Password" />
									<span class="error" id="motdepasse"></span>
								</div>
								<div class="form-group">
									<label for="email"><span class="material-icons">mail</span></label>
									<input type="email" name="email" placeholder="E-mail" />
									<span class="error" id="email"></span>
								</div>
								<div class="form-group">
									<label for="tlf"><span class="material-icons">phone</span></label>
									<input
										type="text" name="telephone" placeholder="telephone" />
										<span class="error" id="telephone"></span>
								</div>
								<div class="form-group">
									<label for="name"><span class="material-icons">business</span></label>
									<input type="text" name="nom_entreprise" placeholder="Company name" />
									<span class="error" id="nom_entreprise"></span>
								</div>
								<div class="form-group">
									<label for="pays"><span class="material-icons">location_on</span> </label>
									<input type="text" name="pays" placeholder="Country" />
									<span class="error" id="pays"></span>
								</div>
								<div class="form-group form-button">
								
									<input type="submit" name="signup" id="signup" class="form-submit" value="Create an account"/>
								</div>
								<p>Already have an account? <a href="Connexion.jsp"> Login </a></p>
							</form>
						</div>
					</div>
				</div>
				<div class="signup-image">
					<figure>
						<img src="images/4457.png" alt="sing up image" />
					</figure>
				</div>
			</section>
		</div>
<script> 
            function validateForm()                                    
{  
    var nom = document.forms["myForm"]["nom"];
    var motdepasse = document.forms["myForm"]["motdepasse"];
    var email = document.forms["myForm"]["email"];
    var telephone = document.forms["myForm"]["telephone"];
    var nom_entreprise = document.forms["myForm"]["nom_entreprise"];
    var pays = document.forms["myForm"]["pays"];
   
    ////////////////////////////////
    if (nom.value == "")                                  
    { 
        document.getElementById('nom').innerHTML="Please enter a valid name";  
        nom.focus(); 
        return false; 
    }else{
        document.getElementById('nom').innerHTML="";  
    }

    ////////////////////////////////
    if (motdepasse.value == "")                                  
    { 
        document.getElementById('motdepasse').innerHTML="Please enter a valid password";  
        motdepasse.focus(); 
        return false; 
    }else{
        document.getElementById('motdepasse').innerHTML="";  
    }

    ///////////////////////////////
    if (email.value == "")                                   
    { 
        document.getElementById('email').innerHTML="Please enter your email address"; 
        email.focus(); 
        return false; 
    }else{
        document.getElementById('email').innerHTML="";  
    }
   
    if (email.value.indexOf("@", 0) < 0)                 
    { 
        document.getElementById('email').innerHTML="Please enter your email address"; 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf(".", 0) < 0)                 
    { 
        document.getElementById('email').innerHTML="Please enter your email address"; 
        email.focus(); 
        return false; 
    }


    ///////////////////////
    if (telephone.value == "")                                  
    { 
        document.getElementById('telephone').innerHTML="Please enter a valid phone number";  
        telephone.focus(); 
        return false; 
    }else{
        document.getElementById('telephone').innerHTML="";  
    } 

    ///////////////////////

    if (nom_entreprise.value == "")                                  
    { 
        document.getElementById('nom_entreprise').innerHTML="enter your business name";  
        nom_entreprise.focus(); 
        return false; 
    }else{
        document.getElementById('nom_entreprise').innerHTML="";  
    }   
    /////////////////////////////////
   if (pays.value == "")                                  
    { 
        document.getElementById('pays').innerHTML="Enter your country";  
        pays.focus(); 
        return false; 
    }else{
        document.getElementById('pays').innerHTML="";  
    }
}
   </script>


	</body>
	</html>