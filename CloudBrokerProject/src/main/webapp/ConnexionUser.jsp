<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Login</title>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
			rel="stylesheet"
		/>
		<!-- Main css -->
		<link rel="stylesheet" href="css/Connexion.css" />
		<link rel="shortcut icon" href="images/logo.png" />
	</head>

	<body>
		<div class="main">
			<!-- Sign up form -->
			<section class="signup">
				<div class="container">
					<div class="signup-content">
						<div class="signup-form">
							<h2 class="form-title">Login</h2>
							<form method="POST" class="register-form" id="register-form" action="ConnexionUser.php">
								<div class="form-group">
									<label for="name"> <span class="material-icons">person</span></label>
									<input type="text" name="Nom" id="name" placeholder="Username" />
								</div>
								<div class="form-group">
									<label for="pass"><span class="material-icons">lock</span></label>
									<input type="password" name="Motdepasse" id="pass" placeholder="Password" />
								</div>

								<div class="form-group form-button">
									<input type="submit" name="signup" id="signup" class="form-submit" value="Login" />
								</div>
	                            <p> <a href="InscrireUser.jsp"> Create a new account ? </a></p>
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
	</body>
</html>