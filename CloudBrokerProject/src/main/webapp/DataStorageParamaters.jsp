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
      rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="content">
       
        <!--Body part-->
        <div class="description">
          <h1> Streaming And Multimedia Paramaters : </h1>
           <form name="myForm" onsubmit="return validateForm()" action="DataStorage.php" method="Post">

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
                    </div>
                   <div class="corps-formulairee">
                   <p>Disk Space :</p>
                   <div class="corps-formulaire3">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Space UP TO 2GB :</label>
                               <input type="text" name="to2GB">
                               <span class="error" id="to2GB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 4GB :</label>
                                <input type="text" name="to4GB">
                                <span class="error" id="to4GB"></span>
                           </div>
                            <div class="boite">
                               <label for="">Space UP TO 8GB :</label>
                               <input type="text" name="to8GB">
                               <span class="error" id="to8GB"></span>
                           </div>
                            <div class="boite">
                               <label for="">Space UP TO 16GB :</label>
                                <input type="text" name="to16GB">
                                <span class="error" id="to16GB"></span>
                           </div>
                            <div class="boite">
                               <label for="">Space UP TO 32GB :</label>
                               <input type="text" name="to32GB">
                               <span class="error" id="to32GB"></span>
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Space UP TO 64GB :</label>
                               <input type="text" name="to64GB">
                               <span class="error" id="to64GB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 128GB :</label>
                               <input type="text" name="to128GB">
                               <span class="error" id="to128GB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 256GB :</label>
                               <input type="text" name="to256GB">
                               <span class="error" id="to256GB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Space UP TO 512GB :</label>
                               <input type="text" name="to512GB">
                               <span class="error" id="to512GB"></span>
                           </div>

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
                               <input type="text" name="to50MB">
                               <span class="error" id="to50MB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 100MBps:</label>
                                <input type="text" name="to100MB">
                                <span class="error" id="to100MB"></span>
                           </div>
                            <div class="boite">
                               <label for="">Rate UP TO 200MBps :</label>
                               <input type="text" name="to200MB">
                               <span class="error" id="to200MB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 400MBps :</label>
                               <input type="text" name="to400MB">
                               <span class="error" id="to400MB"></span>
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Rate UP TO 600MBps :</label>
                               <input type="text" name="to600MB">
                               <span class="error" id="to600MB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 1200MBps :</label>
                               <input type="text" name="to1200MB">
                               <span class="error" id="to1200MB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 2400MBps :</label>
                               <input type="text" name="to2400MB">
                               <span class="error" id="to2400MB"></span>
                           </div>
                           <div class="boite">
                               <label for="">Rate UP TO 3000MBps :</label>
                               <input type="text" name="to3000MB">
                               <span class="error" id="to3000MB"></span>
                           </div>

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

<script> 
            function validateForm()                                    
{  
    var to2GB = document.forms["myForm"]["to2GB"]; 
    var to4GB = document.forms["myForm"]["to4GB"]; 
    var to8GB = document.forms["myForm"]["to8GB"];  
    var to16GB = document.forms["myForm"]["to16GB"]; 
    var to32GB = document.forms["myForm"]["to32GB"]; 
    var to64GB = document.forms["myForm"]["to64GB"];  
    var to128GB = document.forms["myForm"]["to128GB"];  
    var to256GB = document.forms["myForm"]["to256GB"]; 
    var to512GB = document.forms["myForm"]["to512GB"];

    var to50MB = document.forms["myForm"]["to50MB"];
    var to100MB = document.forms["myForm"]["to100MB"]; 
    var to200MB = document.forms["myForm"]["to200MB"];  
    var to400MB = document.forms["myForm"]["to400MB"];  
    var to600MB = document.forms["myForm"]["to600MB"]; 
    var to1200MB = document.forms["myForm"]["to1200MB"]; 
    var to2400MB = document.forms["myForm"]["to2400MB"];
    var to3000MB = document.forms["myForm"]["to3000MB"];        
    ////////////////////////////////
    if (to2GB.value == "")                                  
    { 
        document.getElementById('to2GB').innerHTML="Enter your Space UP TO 2GB";  
        to2GB.focus(); 
        return false; 
    }else{
        document.getElementById('to2GB').innerHTML="";  
    }
        ////////////////////////////////
    if (to4GB.value == "")                                  
    { 
        document.getElementById('to4GB').innerHTML="Enter your Space UP TO 4GB";  
        to4GB.focus(); 
        return false; 
    }else{
        document.getElementById('to4GB').innerHTML="";  
    }
            ////////////////////////////////
    if (to8GB.value == "")                                  
    { 
        document.getElementById('to8GB').innerHTML="Enter your Space UP TO 8GB";  
        to8GB.focus(); 
        return false; 
    }else{
        document.getElementById('to8GB').innerHTML="";  
    }

            ////////////////////////////////
    if (to16GB.value == "")                                  
    { 
        document.getElementById('to16GB').innerHTML="Enter your Space UP TO 16GB";  
        to16GB.focus(); 
        return false; 
    }else{
        document.getElementById('to16GB').innerHTML="";  
    }
            ////////////////////////////////
    if (to32GB.value == "")                                  
    { 
        document.getElementById('to32GB').innerHTML="Enter your Space UP TO 32GB";  
        to32GB.focus(); 
        return false; 
    }else{
        document.getElementById('to32GB').innerHTML="";  
    }

        ////////////////////////////////
    if (to64GB.value == "")                                  
    { 
        document.getElementById('to64GB').innerHTML="Enter your Space UP TO 64GB";  
        to64GB.focus(); 
        return false; 
    }else{
        document.getElementById('to64GB').innerHTML="";  
    }
        ////////////////////////////////
    if (to128GB.value == "")                                  
    { 
        document.getElementById('to128GB').innerHTML="Enter your Space UP TO 128GB";  
        to128GB.focus(); 
        return false; 
    }else{
        document.getElementById('to128GB').innerHTML="";  
    }
            ////////////////////////////////
    if (to256GB.value == "")                                  
    { 
        document.getElementById('to256GB').innerHTML="Enter your Space UP TO 256GB";  
        to256GB.focus(); 
        return false; 
    }else{
        document.getElementById('to256GB').innerHTML="";  
    }

            ////////////////////////////////
    if (to512GB.value == "")                                  
    { 
        document.getElementById('to512GB').innerHTML="Enter your Space UP TO 256GB";  
        to512GB.focus(); 
        return false; 
    }else{
        document.getElementById('to512GB').innerHTML="";  
    }
            ////////////////////////////////
    if (to50MB.value == "")                                  
    { 
        document.getElementById('to50MB').innerHTML="Enter your Rate UP TO 50MBps";  
        to50MB.focus(); 
        return false; 
    }else{
        document.getElementById('to50MB').innerHTML="";  
    }



        ////////////////////////////////
    if (to100MB.value == "")                                  
    { 
        document.getElementById('to100MB').innerHTML="Enter your Rate UP TO 100MBps";  
        to100MB.focus(); 
        return false; 
    }else{
        document.getElementById('to100MB').innerHTML="";  
    }
        ////////////////////////////////
    if (to200MB.value == "")                                  
    { 
        document.getElementById('to200MB').innerHTML="Enter your Rate UP TO 200MBps";  
        to200MB.focus(); 
        return false; 
    }else{
        document.getElementById('to200MB').innerHTML="";  
    }
            ////////////////////////////////
    if (to400MB.value == "")                                  
    { 
        document.getElementById('to400MB').innerHTML="Enter your Rate UP TO 400MBps";  
        to400MB.focus(); 
        return false; 
    }else{
        document.getElementById('to400MB').innerHTML="";  
    }

            ////////////////////////////////
    if (to600MB.value == "")                                  
    { 
        document.getElementById('to600MB').innerHTML="Enter your Rate UP TO 600MBps";  
        to600MB.focus(); 
        return false; 
    }else{
        document.getElementById('to600MB').innerHTML="";  
    }
            ////////////////////////////////
    if (to1200MB.value == "")                                  
    { 
        document.getElementById('to1200MB').innerHTML="Enter your Rate UP TO 1200MBps";  
        to1200MB.focus(); 
        return false; 
    }else{
        document.getElementById('to1200MB').innerHTML="";  
    }
                ////////////////////////////////
    if (to2400MB.value == "")                                  
    { 
        document.getElementById('to2400MB').innerHTML="Enter your Rate UP TO 2400MBps";  
        to2400MB.focus(); 
        return false; 
    }else{
        document.getElementById('to2400MB').innerHTML="";  
    }
                    ////////////////////////////////
    if (to3000MB.value == "")                                  
    { 
        document.getElementById('to3000MB').innerHTML="Enter your Rate UP TO 3000MBps";  
        to3000MB.focus(); 
        return false; 
    }else{
        document.getElementById('to3000MB').innerHTML="";  
    }


}
 </script>

</body>

</html>