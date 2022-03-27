<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exclusive Paramaters</title>
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
          <h1> Exclusive Paramaters : </h1>
           <form action="AjouterVM.php" method="get">
                   <div class="corps-formulaire">
                       <div class="left1">
                           <div class="boite">
                             <label for="">Functional functionality</label>
                              <select name="Exper" >
                    <option selected="selected" >Streaming And Multimedia</option>
                     <option>Human Resource Management</option>
                    </select>
                           </div>  
                       </div>                  
                   </div>

               <!----------------->
                   <div class="corps-formulairee">
                   <p>Data Storage Paramaters :</p>
                    <div class="corps-formulaire2">   
                       <div class="left2">                  
                           <div class="boite">
                              <select name="Contrainte" id="Contrainte">
									              <option>SAS</option>
									              <option>SSD</option>
                                <option>HDD</option>
								               </select>
                           </div>
                           
                            
                                                  
                       </div>
                       <div class="right2">
                           <div class="boite">
                               <select name="Contrainte" id="Contrainte">
                                <option>Disk Space</option>
                                <option>Disk Transfer Rate</option>
                               </select>
                           </div>
                          
                       </div>
                   </div>
        
                   <div class="corps-formulaire3">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Space UP TO 2GB :</label>
                               <input type="text">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 4GB :</label>
                                <input type="text">
                           </div>
                            <div class="boite">
                               <label for="">Space UP TO 8GB :</label>
                               <input type="text">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 16GB :</label>
                               <input type="text">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 32GB :</label>
                               <input type="text">
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Space UP TO 64GB :</label>
                               <input type="text">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 128GB :</label>
                               <input type="text">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 256GB :</label>
                               <input type="text">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 512GB :</label>
                               <input type="text">
                           </div>

                       </div>
                   </div>
           <!--- --->
                   <div class="pied-formulaire">
                       <button type="submit">Cancel</button>
                       <button type="reset">Add</button>
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