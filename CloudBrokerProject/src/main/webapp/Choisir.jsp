<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Functional functionality</title>
    <link rel="stylesheet" href="css/Choisir.css">
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
  <body>

    <div class="modal-container">

      <div class="overlay modal-trigger"></div>
     
      <div class="modal" role="dialog" aria-labelledby="modalTitle" aria-describedby="dialogDesc">
        <button 
        aria-label="close modal"
        class="close-modal modal-trigger">X</button>
        <p>Functional functionality
      <!--    <ul>
          <li class="choisir"><a href="HRM.jsp">Human Resource Management</a></li>
          <li class="choisir"><a href="SM.jsp">Streaming And Multimedia</a></li>
        </ul> -->
        <form action="Choisir.php" method="POST">
                   <div class="corps-formulaire">
                       <div class="left1">
                           <div class="boite">
                            <!--    <label for="">Functional functionality</label> -->
                              <select name="choisir" >
                      <option selected disabled>OPEN</option>
						        <option value="Human Resource Management">Human Resource Management</option>
						         <option value="Streaming And Multimedia">Streaming And Multimedia</option>
					          </select>
                           </div>  
                       </div>
                       <div class="pied-formulaire">
        <button type="submit" name="signup" id="signup" class="form-submit" value="Next"> Next </button>
          </div>   
                     </form>
      </div>

    </div>
                          
                   </div>


    <button class="modal-btn modal-trigger">Functional functionality</button>




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
    <script src="js/app.js"></script>
  </body>
</html>
