<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Streaming And Multimedia Paramaters</title>
    <link rel="stylesheet" href="css/DP2.css">
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
        	<h1> Streaming And Multimedia Paramaters : </h1>
           <form method="POST" class="register-form" id="register-form" action="DP3.php">                 
              <!--     <div class="corps-formulaire">
                       <div class="left1">
                           <div class="boite">
                             <label for="">Functional functionality</label>
                              <select name="Exper" >
						        <option selected="selected" >Streaming And Multimedia</option>
						         <option>Human Resource Management</option>
					          </select>
                           </div>  
                       </div>                  
                   </div> -->

               <!----------------->
                   <div class="corps-formulairee">
                   <p>Data Redundancy Support :</p>
                   	<div class="corps-formulaire2">   
                       <div class="left2">                  
                           <div class="boite">
                               <label for="">Archive :</label>
                               <input type="text" name="archive" >
                           </div>
                           
                            <div class="boite">
                               <label for="">Cool :</label>
                               <input type="text" name="cool">
                           </div>
                                            
                       </div>
                       <div class="right2">
                           <div class="boite">
                               <label for="">Hot :</label>
                              <input type="text" name="hot">
                           </div>
                           <div class="boite">
                               <label for="">Premium :</label>
                               <input type="text" name="premium">
                           </div>
                          
                       </div>
                   </div>
                   <div class="corps-formulairee">
                   <p>Quantity Of Operations :</p>
                   <div class="corps-formulaire3">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Up To 5K Operations Per Month :</label>
                               <input type="text" name="Qte1">
                           </div>
                           <div class="boite">
                               <label for=""> Up To 10K Operations Per Month :</label>
                                <input type="text" name="Qte10">
                           </div>
                            <div class="boite">
                               <label for=""> Up To 25K Operations Per Month :</label>
                               <input type="text" name="Qte25">
                           </div>

                           <div class="boite">
                               <label for=""> Up To 50K Operations Per Month :</label>
                                <input type="text" name="Qte50">
                           </div>
                            <div class="boite">
                               <label for=""> Up To 100K Operations Per Month :</label>
                               <input type="text" name="Qte100">
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Up To 250K Operations Per Month :</label>
                               <input type="text" name="Qte250">
                           </div>
                           <div class="boite">
                               <label for="">Up To 500K Operations Per Month :</label>
                               <input type="text" name="Qte500">
                           </div>
                          <div class="boite">
                               <label for="">Up To 1M Operations Per Month :</label>
                               <input type="text" name="Qte1M">
                           </div>
                           <div class="boite">
                               <label for="">Up To 2M Operations Per Month :</label>
                               <input type="text" name="Qte2M">
                           </div>
                           <div class="boite">
                               <label for="">Up To 5M Operations Per Month :</label>
                               <input type="text" name="Qte5M">
                           </div>

                       </div>
                   </div>

                <!----- ---->

            <div class="corps-formulairee">
                   <p>Volume Of Data :</p>
                   <div class="corps-formulaire4">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Up To 50GB :</label>
                               <input type="text" name="volume50">
                           </div>
                           <div class="boite">
                               <label for=""> Up To 100GB :</label>
                                <input type="text" name="volume100">
                           </div>
                            <div class="boite">
                               <label for=""> Up To 200GB :</label>
                               <input type="text" name="volume200">
                           </div>
                            <div class="boite">
                               <label for=""> Up To 400GB :</label>
                               <input type="text" name="volume400">
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Up To 800GB :</label>
                               <input type="text" name="volume800">
                           </div>
                           <div class="boite">
                               <label for="">Up To 1TB :</label>
                               <input type="text" name="volume1t">
                           </div>
                           <div class="boite">
                               <label for="">Up To 2TB :</label>
                               <input type="text" name="volume2t">
                           </div>

                       </div>
                   </div>

                <!--- --->
                   <div class="pied-formulaire">
                   <button type="reset" name="signup" id="signup" class="form-submit" value="Cancel"> Cancel </button>
					<button type="submit" name="signup" id="signup" class="form-submit" value="Next"> Next </button>
                     <!--  <button type="submit">Cancel</button>
                       <button type="reset">Add</button> -->
                   </div>
               
            </form>
        </div>
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