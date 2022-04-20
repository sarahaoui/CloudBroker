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
           <form name="myForm" onsubmit="return validateForm()" method="POST" action="DP3.php">                 
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
                               <span class="error" id="archive"></span>
                           </div>
                           
                            <div class="boite">
                               <label for="">Cool :</label>
                               <input type="text" name="cool">
                               <span class="error" id="cool"></span>
                           </div>
                                            
                       </div>
                       <div class="right2">
                           <div class="boite">
                               <label for="">Hot :</label>
                              <input type="text" name="hot">
                              <span class="error" id="hot"></span>
                           </div>
                           <div class="boite">
                               <label for="">Premium :</label>
                               <input type="text" name="premium">
                               <span class="error" id="premium"></span>
                           </div>
                          
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
                               <span class="error" id="Qte1"></span>
                           </div>
                           <div class="boite">
                               <label for=""> Up To 10K Operations Per Month :</label>
                                <input type="text" name="Qte10">
                                <span class="error" id="Qte10"></span>
                           </div>
                            <div class="boite">
                               <label for=""> Up To 25K Operations Per Month :</label>
                               <input type="text" name="Qte25">
                               <span class="error" id="Qte25"></span>
                           </div>

                           <div class="boite">
                               <label for=""> Up To 50K Operations Per Month :</label>
                                <input type="text" name="Qte50">
                                <span class="error" id="Qte50"></span>
                           </div>
                            <div class="boite">
                               <label for=""> Up To 100K Operations Per Month :</label>
                               <input type="text" name="Qte100">
                               <span class="error" id="Qte100"></span>
                           </div>
                          
                       </div>
                      
                       <div class="right2">
                           <div class="boite">
                               <label for="">Up To 250K Operations Per Month :</label>
                               <input type="text" name="Qte250">
                                 <span class="error" id="Qte250"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 500K Operations Per Month :</label>
                               <input type="text" name="Qte500">
                                 <span class="error" id="Qte500"></span>
                           </div>
                          <div class="boite">
                               <label for="">Up To 1M Operations Per Month :</label>
                               <input type="text" name="Qte1M">
                               <span class="error" id="Qte1M"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 2M Operations Per Month :</label>
                               <input type="text" name="Qte2M">
                               <span class="error" id="Qte2M"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 5M Operations Per Month :</label>
                               <input type="text" name="Qte5M">
                               <span class="error" id="Qte5M"></span>
                           </div>

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
                               <span class="error" id="volume50"></span>
                           </div>
                           <div class="boite">
                               <label for=""> Up To 100GB :</label>
                                <input type="text" name="volume100">
                                <span class="error" id="volume100"></span>
                           </div>
                            <div class="boite">
                               <label for=""> Up To 200GB :</label>
                               <input type="text" name="volume200">
                               <span class="error" id="volume200"></span>
                           </div>
                            <div class="boite">
                               <label for=""> Up To 400GB :</label>
                               <input type="text" name="volume400">
                               <span class="error" id="volume400"></span>
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Up To 800GB :</label>
                               <input type="text" name="volume800">
                               <span class="error" id="volume800"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 1TB :</label>
                               <input type="text" name="volume1t">
                               <span class="error" id="volume1t"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 2TB :</label>
                               <input type="text" name="volume2t">
                               <span class="error" id="volume2t"></span>
                           </div>

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



<script> 
            function validateForm()                                    
{  
    var archive = document.forms["myForm"]["archive"]; 
    var cool = document.forms["myForm"]["cool"]; 
    var hot = document.forms["myForm"]["hot"];  
    var premium = document.forms["myForm"]["premium"];

    var Qte1 = document.forms["myForm"]["Qte1"]; 
    var Qte10 = document.forms["myForm"]["Qte10"];  
    var Qte25 = document.forms["myForm"]["Qte25"];  
    var Qte50 = document.forms["myForm"]["Qte50"]; 
    var Qte100 = document.forms["myForm"]["Qte100"]; 

    var Qte250 = document.forms["myForm"]["Qte250"];
    var Qte500 = document.forms["myForm"]["Qte500"]; 
    var Qte1M = document.forms["myForm"]["Qte1M"];  
    var Qte2M = document.forms["myForm"]["Qte2M"];  
    var Qte5M = document.forms["myForm"]["Qte5M"]; 

    var volume50 = document.forms["myForm"]["volume50"]; 
    var volume100 = document.forms["myForm"]["volume100"];
    var volume200 = document.forms["myForm"]["volume200"]; 
    var volume400 = document.forms["myForm"]["volume400"];
    var volume800 = document.forms["myForm"]["volume800"]; 
    var volume1t = document.forms["myForm"]["volume1t"];
    var volume2t = document.forms["myForm"]["volume2t"]; 
    ////////////////////////////////
    if (archive.value == "")                                  
    { 
        document.getElementById('archive').innerHTML="Enter your Archive";  
        archive.focus(); 
        return false; 
    }else{
        document.getElementById('archive').innerHTML="";  
    }
        ////////////////////////////////
    if (cool.value == "")                                  
    { 
        document.getElementById('cool').innerHTML="Enter your Cool";  
        cool.focus(); 
        return false; 
    }else{
        document.getElementById('cool').innerHTML="";  
    }
            ////////////////////////////////
    if (hot.value == "")                                  
    { 
        document.getElementById('hot').innerHTML="Enter your Hot";  
        hot.focus(); 
        return false; 
    }else{
        document.getElementById('hot').innerHTML="";  
    }

            ////////////////////////////////
    if (premium.value == "")                                  
    { 
        document.getElementById('premium').innerHTML="Enter your Premium";  
        premium.focus(); 
        return false; 
    }else{
        document.getElementById('premium').innerHTML="";  
    }
            ////////////////////////////////
    if (Qte1.value == "")                                  
    { 
        document.getElementById('Qte1').innerHTML="Enter your Up To 5K Operations Per Month";  
        Qte1.focus(); 
        return false; 
    }else{
        document.getElementById('Qte1').innerHTML="";  
    }

        ////////////////////////////////
    if (Qte10.value == "")                                  
    { 
        document.getElementById('Qte10').innerHTML="Enter your Up To 10K Operations Per Month";  
        Qte10.focus(); 
        return false; 
    }else{
        document.getElementById('Qte10').innerHTML="";  
    }
        ////////////////////////////////
    if (Qte25.value == "")                                  
    { 
        document.getElementById('Qte25').innerHTML="Enter your Up To 25K Operations Per Month";  
        Qte25.focus(); 
        return false; 
    }else{
        document.getElementById('Qte25').innerHTML="";  
    }
            ////////////////////////////////
    if (Qte50.value == "")                                  
    { 
        document.getElementById('Qte50').innerHTML="Enter your Up To 50K Operations Per Month";  
        Qte50.focus(); 
        return false; 
    }else{
        document.getElementById('Qte50').innerHTML="";  
    }

            ////////////////////////////////
    if (Qte100.value == "")                                  
    { 
        document.getElementById('Qte100').innerHTML="Enter your Up To 100K Operations Per Month";  
        Qte100.focus(); 
        return false; 
    }else{
        document.getElementById('Qte100').innerHTML="";  
    }
            ////////////////////////////////
    if (Qte250.value == "")                                  
    { 
        document.getElementById('Qte250').innerHTML="Enter your Up To 250K Operations Per Month";  
        Qte250.focus(); 
        return false; 
    }else{
        document.getElementById('Qte250').innerHTML="";  
    }

        ////////////////////////////////
    if (Qte500.value == "")                                  
    { 
        document.getElementById('Qte500').innerHTML="Enter your Up To 500K Operations Per Month";  
        Qte500.focus(); 
        return false; 
    }else{
        document.getElementById('Qte500').innerHTML="";  
    }
        ////////////////////////////////
    if (Qte1M.value == "")                                  
    { 
        document.getElementById('Qte1M').innerHTML="Enter your Up To 1M Operations Per Month";  
        Qte1M.focus(); 
        return false; 
    }else{
        document.getElementById('Qte1M').innerHTML="";  
    }
            ////////////////////////////////
    if (Qte2M.value == "")                                  
    { 
        document.getElementById('Qte2M').innerHTML="Enter your Up To 2M Operations Per Month";  
        Qte2M.focus(); 
        return false; 
    }else{
        document.getElementById('Qte2M').innerHTML="";  
    }

            ////////////////////////////////
    if (Qte5M.value == "")                                  
    { 
        document.getElementById('Qte5M').innerHTML="Enter your Up To 5M Operations Per Month";  
        Qte5M.focus(); 
        return false; 
    }else{
        document.getElementById('Qte5M').innerHTML="";  
    }


            ////////////////////////////////
    if (volume50.value == "")                                  
    { 
        document.getElementById('volume50').innerHTML="Enter your Up To 50GB";  
        volume50.focus(); 
        return false; 
    }else{
        document.getElementById('volume50').innerHTML="";  
    }
                ////////////////////////////////
    if (volume100.value == "")                                  
    { 
        document.getElementById('volume100').innerHTML="Enter your Up To 100GB";  
        volume100.focus(); 
        return false; 
    }else{
        document.getElementById('volume100').innerHTML="";  
    }

                ////////////////////////////////
    if (volume200.value == "")                                  
    { 
        document.getElementById('volume200').innerHTML="Enter your Up To 200GB";  
        volume200.focus(); 
        return false; 
    }else{
        document.getElementById('volume200').innerHTML="";  
    }
                ////////////////////////////////
    if (volume400.value == "")                                  
    { 
        document.getElementById('volume400').innerHTML="Enter your Up To 400GB";  
        volume400.focus(); 
        return false; 
    }else{
        document.getElementById('volume400').innerHTML="";  
    }

                    ////////////////////////////////
    if (volume800.value == "")                                  
    { 
        document.getElementById('volume800').innerHTML="Enter your Up To 800GB";  
        volume800.focus(); 
        return false; 
    }else{
        document.getElementById('volume800').innerHTML="";  
    }
                ////////////////////////////////
    if (volume1t.value == "")                                  
    { 
        document.getElementById('volume1t').innerHTML="Enter your Up To 1TB";  
        volume1t.focus(); 
        return false; 
    }else{
        document.getElementById('volume1t').innerHTML="";  
    }
                    ////////////////////////////////
    if (volume2t.value == "")                                  
    { 
        document.getElementById('volume2t').innerHTML="Enter your Up To 2TB";  
        volume2t.focus(); 
        return false; 
    }else{
        document.getElementById('volume2t').innerHTML="";  
    }

}
 </script>


</body>
</html>