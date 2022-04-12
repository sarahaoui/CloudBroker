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
      rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="content">
       
        <!--Body part-->
        <div class="description">
          <h1> Streaming And Multimedia Paramaters : </h1>
           <form action="DataStorage.php" method="Post">
                 <!--    <div class="corps-formulaire">
                       <div class="left1">
                           <div class="boite">
                             <label for="">Streaming And Multimedia</label>
                             <select name="Exper" >
                    <option selected="selected" >Human Resource Management</option>
                     <option>Streaming And Multimedia</option>
                    </select> 
                           </div>  
                       </div>                  
                   </div> -->

               <!----------------->
                   <div class="corps-formulairee">
                   <p>Data Storage Paramaters :</p>
                    <div class="corps-formulaire2">   
                       <div class="left2">                  
                           <div class="boite">
                              <select name="data" id="Contrainte">
                                <option value="SAS">SAS</option>
                                <option value="SSD">SSD</option>
                                <option value="HDD">HDD</option>
                               </select>
                           </div>
                             
                       </div>
                   </div>
                   <div class="corps-formulairee">
                   <p>Disk Space :</p>
                   <div class="corps-formulaire3">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Space UP TO 2GB :</label>
                               <input type="text" name="2GB">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 4GB :</label>
                                <input type="text" name="4GB">
                           </div>
                            <div class="boite">
                               <label for="">Space UP TO 8GB :</label>
                               <input type="text" name="8GB">
                           </div>
                            <div class="boite">
                               <label for="">Space UP TO 16GB :</label>
                                <input type="text" name="16GB">
                           </div>
                            <div class="boite">
                               <label for="">Space UP TO 32GB :</label>
                               <input type="text" name="32GB">
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Space UP TO 64GB :</label>
                               <input type="text" name="64GB">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 128GB :</label>
                               <input type="text" name="128GB">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 256GB :</label>
                               <input type="text" name="256GB">
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 512GB :</label>
                               <input type="text" name="512GB">
                           </div>

                       </div>
                   </div>

                <!----- ---->

            <div class="corps-formulairee">
                   <p>Disk Transfer Rate :</p>
                   <div class="corps-formulaire4">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Rate UP TO 50MBps :</label>
                               <input type="text" name="50MB">
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 100MBps:</label>
                                <input type="text" name="100MB">
                           </div>
                            <div class="boite">
                               <label for="">Rate UP TO 200MBps :</label>
                               <input type="text" name="200MB">
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 400MBps :</label>
                               <input type="text" name="400MB">
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Rate UP TO 600MBps :</label>
                               <input type="text" name="600MB">
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 1200MBps :</label>
                               <input type="text" name="1200MB">
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 2400MBps :</label>
                               <input type="text" name="2400MB">
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 3000MBps :</label>
                               <input type="text" name="3000MB">
                           </div>

                       </div>
                   </div>

                <!--- --->
                   <div class="pied-formulaire">
                 <!--       <button type="submit">Cancel</button>
                       <button type="reset">Add</button> --> 
                       <button type="reset" name="signup" id="signup" class="form-submit" value="Cancel"> Cancel </button>
						<button type="submit" name="signup" id="signup" class="form-submit" value="Next"> Next </button>
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