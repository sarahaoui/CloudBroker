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
		<link rel="stylesheet" href="css/select.css" />
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
							<form method="POST" class="register-form" id="register-form" action="select.php">
								<div class="form-group">
									<select name="select" id="Contrainte">
									<option selected disabled>OPEN</option>
									<option value="Provider">Provider</option>
									<option value="User">User</option>
								</select>
								</div>


								<div class="form-group form-button">
									<input type="submit" name="signup" id="signup" class="form-submit" value="Next" />
								</div>
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