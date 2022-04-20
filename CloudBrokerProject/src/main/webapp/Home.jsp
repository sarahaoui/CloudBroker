<!DOCTYPE html>

<head>
    <meta charset="UTF-8">

    <title>Home</title>
    <link rel="stylesheet" href="css/Acceuil.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="shortcut icon" href="images/logo.png" />
    <link
			href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
			rel="stylesheet"
		/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
</head>
<body>
    <div class="content">
     
    <!--Body part-->
        <div class="description">  
           <center>
           <h1>Hello</h1>
           <p>What do you want to do today ? </p>
       </center>
    </div>

    <!--side bar section-->

      <div class="sidebar">
    <div class="logo-details">
 
    </div>
    <ul class="nav-links">
      <li>
        <a href="Home.jsp">
          <i class='bx bx-grid-alt' ></i>
          <span class="link_name">Home</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="Home.jsp">Home</a></li>
        </ul>
      </li>
      
      <li>
          <a href="#">
            <i class='bx bx-folder-open'></i>
            <span class="link_name">Services</span>
          </a>
         <!--  <i class='bx bxs-chevron-down arrow' ></i> -->
        
        <ul class="sub-menu blank">
          <li><a class="link_name" href="#">Services</a></li>
          </ul>
         <!--  <li><a href="">Vm</a></li>
          <li><a href="">Storage Space</a></li>
          <li><a href="">PaaS</a></li>
          <li><a href="">SaaS</a></li>  
         -->
      </li>
     <li>
        
          <a href="DescriptionProvider.jsp">
           <i class='bx bx-folder-plus'></i>
            <span class="link_name" href="DP1.jsp">Add</span>
          </a>
      <!--     <i class='bx bxs-chevron-down arrow' ></i> -->
        <ul class="sub-menu blank">
          <li><a class="link_name" href="DescriptionProvider.jsp">Add</a></li>
           </ul>
     <!--<li><a href="">Vm</a></li>
          <li><a href="">Storage Space</a></li>
          <li><a href="">PaaS</a></li>
          <li><a href="">SaaS</a></li> 
         -->
      </li>
      
      <li>
        <a href="">
          <i class='bx bx-line-chart' ></i>
          <span class="link_name">Statistics</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="statiqtiques.php">Statistics</a></li>
        </ul>
      </li>
      <li>
        <a href="aide.php">
          <i class='bx bx-help-circle'></i>
          <span class="link_name">Help</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="aide.php">Help</a></li>
        </ul>
      </li>
      <li>
        <a href="">
          <i class='bx bx-message-rounded-dots'></i>
          <span class="link_name">Feedback</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="feedback.php">Feedback</a></li>
        </ul>
      </li>
      <li>
        <a href="">
          <i class='bx bx-history'></i>
          <span class="link_name">History</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="historique.php">History</a></li>
        </ul>
      </li>
      <li>
        <a href="">
          <i class='bx bx-cog' ></i>
          <span class="link_name">Settings</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="parametre.php">Settings</a></li>
        </ul>
      </li>
      <li>
    <div class="profile-details">
      <div class="profile-content">
       <a href="WebSite.jsp" ><img src="images/compte.png "  alt="profileImg" ></a>
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
      <a href="WebSite.jsp"><i class='bx bx-log-out' ></i></a>
    </div>
  </li>
</ul>
  </div>

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
  
  </script>
</body>

</html>