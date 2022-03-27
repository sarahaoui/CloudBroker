<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Inscription</title>
		<!-- Font Icon -->
		<link
			rel="stylesheet"
			href="fonts/material-icon/css/material-design-iconic-font.min.css"
		/>
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
						
							<form method="POST" class="register-form" id="register-form" action="Inscrire.php">
							
								<div class="form-group">
									<label for="name"
										><i class="zmdi zmdi-account material-icons-name"></i
									></label>
									<input
										type="text" name="nom" id="name"  placeholder="Nom d'utilisateur"
									/>
								
								</div>
								<div class="form-group">
									<label for="pass"><i class="zmdi zmdi-lock"></i></label>
									<input
										type="password"
										name="motdepasse"
										id="pass"
										placeholder="Mot de passe" 
									/>
								</div>
								<div class="form-group">
									<label for="email"><i class="zmdi zmdi-email"></i></label>
									<input
										type="email"
										name="email"
										id="email"
										placeholder="Email"
									/>
								</div>
								<div class="form-group">
									<label for="tlf"><i class="zmdi zmdi-phone"></i></label>
									<input
										type="text"
										name="telephone"
										id="tlf"
										placeholder="Téléphone"
									/>
								</div>
								<div class="form-group">
									<label for="name"><i class="zmdi zmdi-case"></i></label>
									<input
										type="text"
										name="nom_entreprise"
										id="name"
										placeholder="Nom d'entréprise"
									/>
								</div>
								<div class="form-group">
									<label for="pays"
										><i class="zmdi zmdi-google-maps"></i
									></label>
									<input type="text" name="pays" id="pays" placeholder="Pays" />
								</div>
								<div class="form-group form-button">
								
									<input 
										type="submit"
										name="signup"
										id="signup"
										class="form-submit"
										value="Créer un compte" />
								</div>
								<p>Vous avez déjà un compte? <a href="Connexion.jsp"> Login </a></p>
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