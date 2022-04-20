<!DOCTYPE html>

<head>
    <meta charset="UTF-8">

    <title>Sreach Service</title>
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
        <form method="GET" class="register-form" id="register-form" action="Inscrire.php">
                <div class="form-group">
                  <label for="email"><i class="zmdi zmdi-email"></i></label>         
                  <textarea id="msg" name="user_message" placeholder="Enter your Query here"></textarea>
                </div>
                <div class="form-group form-button">         
                  <input 
                    type="submit"
                    name="signup"
                    id="signup"
                    class="form-submit"
                    value="Search"
                  />
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