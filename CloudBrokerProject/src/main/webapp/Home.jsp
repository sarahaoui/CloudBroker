<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/Hom.css" />
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
		<title>Dashboard</title>
	</head>
	<body>
		<div class="container">
			<div class="sidebar">
				<ul class="nav-links">
					<li>
						<a href="Home.jsp">
							<i class="bx bx-grid-alt"></i>
							<span class="link_name">Home</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="Home.jsp">Home</a></li>
						</ul>
					</li>

					<li>
						<a href="#">
							<i class="bx bx-folder-open"></i>
							<span class="link_name">Services</span>
						</a>
						<!--  <i class='bx bxs-chevron-down arrow' ></i> -->

						<ul class="sub-menu blank">
							<li><a class="link_name" href="#">Services</a></li>
						</ul>
					</li>
					<li>
        <div class="iocn-link">
          <a href="#">
            <i class="bx bx-folder-plus"></i>
            <span class="link_name">Add</span>
          </a>
          <i class='bx bxs-chevron-down arrow' ></i>
        </div>
        <ul class="sub-menu">
          <li><a class="link_name" href="#">Add</a></li>
          <li><a href="ApiProvider.jsp">Add with API</a></li>
          <li><a href="DescriptionProvider.jsp">Add without API</a></li>
        </ul>
      </li>

					<li>
						<a href="">
							<i class="bx bx-line-chart"></i>
							<span class="link_name">Statistics</span>
						</a>
						<ul class="sub-menu blank">
							<li>
								<a class="link_name" href="statiqtiques.php">Statistics</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="aide.php">
							<i class="bx bx-help-circle"></i>
							<span class="link_name">Help</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="aide.php">Help</a></li>
						</ul>
					</li>
					<li>
						<a href="">
							<i class="bx bx-message-rounded-dots"></i>
							<span class="link_name">Feedback</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="feedback.php">Feedback</a></li>
						</ul>
					</li>
					<li>
						<a href="">
							<i class="bx bx-history"></i>
							<span class="link_name">History</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="historique.php">History</a></li>
						</ul>
					</li>
					<li>
						<a href="">
							<i class="bx bx-cog"></i>
							<span class="link_name">Settings</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="parametre.php">Settings</a></li>
						</ul>
					</li>
					<li>
						<div class="profile-details">
							<div class="profile-content">
								<a href="#"
									><img src="images/compte.png " alt="profileImg"
								/></a>
							</div>
							<div class="name-job">
        <div class="profile_name">
      <c:if test="${!empty sessionScope.nom}">
		${ sessionScope.nom}
		</c:if>
        </div>
        <div class="job">
        <c:if test="${!empty sessionScope.email}">
		 ${ sessionScope.email}
		</c:if>
        </div>
        
      </div>
							<a href="WebSite.jsp"><i class="bx bx-log-out"></i></a>
						</div>
					</li>
				</ul>
			</div>
			<div class="main">
				<div class="topbar">
					<!--sreach-->
					<div class="sreach">
						<label>
							<input type="text" placeholder="Sreach here" />
							<ion-icon name="search-outline"></ion-icon>
						</label>
					</div>
				</div>
				<!-- cards-->
				<div class="cardBox">
					<div class="card">
						<div>
							<div class="numbers">1,504</div>
							<div class="cardName">Daily Views</div>
						</div>
						<div class="iconBox"><ion-icon name="eye-outline"></ion-icon></div>
					</div>
					<div class="card">
						<div>
							<div class="numbers">1,504</div>
							<div class="cardName">Daily Views</div>
						</div>
						<div class="iconBox"><ion-icon name="eye-outline"></ion-icon></div>
					</div>
					<div class="card">
						<div>
							<div class="numbers">1,504</div>
							<div class="cardName">Daily Views</div>
						</div>
						<div class="iconBox"><ion-icon name="eye-outline"></ion-icon></div>
					</div>
					<div class="card">
						<div>
							<div class="numbers">1,504</div>
							<div class="cardName">Daily Views</div>
						</div>
						<div class="iconBox"><ion-icon name="eye-outline"></ion-icon></div>
					</div>
				</div>

				<div class="details">
					<!-- data list-->
					<div class="recentOrders">
						<div class="cardHeader">
							<h2>Recent Orders</h2>
							<a href="#" class="btn">View All</a>
						</div>
						<table>
							<thead>
								<tr>
									<td>Name</td>
									<td>Price</td>
									<td>Payment</td>
									<td>Status</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
								<tr>
									<td>Service IBM</td>
									<td>$1200</td>
									<td>Paid</td>
									<td>Service IBM</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- Customers list-->
					<div class="recentCustomers">
						<div class="cardHeader">
							<h2>Your progress</h2>
						</div>
						<div class="skill">
							<div class="outer">
								<div class="inner">
									<div id="num"></div>
								</div>
							</div>
							<svg
								xmlns="http://www.w3.org/2000/svg"
								version="1.1"
								width="160px"
								height="160px"
							>
								<defs>
									<linearGradient id="GradientColor">
										<stop offset="0%" stop-color="#1aafeb" />
										<stop offset="100%" stop-color="#083e6f" />
									</linearGradient>
								</defs>
								<circle cx="70" cy="70" r="65" stroke-linecap="round" />
							</svg>
						</div>
						<div class="skills2">
							<span class="name">HTML</span>
							<div class="percent">
								<div class="progress" style="width: 60%"></div>
							</div>
							<span class="value"></span>
						</div>
						<div class="skills2">
							<span class="name">HTML</span>
							<div class="percent">
								<div class="progress" style="width: 60%"></div>
							</div>
							<span class="value"></span>
						</div>
						<div class="skills2">
							<span class="name">HTML</span>
							<div class="percent">
								<div class="progress" style="width: 60%"></div>
							</div>
							<span class="value"></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			let arrow = document.querySelectorAll('.arrow');
			for (var i = 0; i < arrow.length; i++) {
				arrow[i].addEventListener('click', (e) => {
					let arrowParent = e.target.parentElement.parentElement; //selecting main parent of arrow
					arrowParent.classList.toggle('showMenu');
				});
			}
		</script>
		<script
			type="module"
			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
		></script>
		<script
			nomodule
			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
		></script>
		<script>
			let number = document.getElementById('num');
			let number2 = document.querySelector('.value');
			let count = 0;
			setInterval(() => {
				if (count == 65) {
					clearInterval();
				} else {
					count += 1;
					number.innerHTML = count + '%';
					number2.innerHTML = count + '%';
				}
			}, 30);
		</script>
	</body>
</html>