<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Human Resource Management Paramaters</title>
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
        	<h1> Human Resource Management Paramaters : </h1>
           		 	<form name="myForm" onsubmit="return validateForm()" method="POST" action="DP2.php">         
               <!----------------->
                   <div class="corps-formulairee">
                   <p>Num Of Users :</p>
                   	<div class="corps-formulaire2">   
                       <div class="left2">                  
                           <div class="boite">
                               <label for="">Up To 10 :</label>
                               <input type="text" name="upto10">
                               <span class="error" id="upto10"></span>
                           </div>
                           
                            <div class="boite">
                               <label for="">Up To 50 :</label>
                               <input type="text" name="upto50">
                               <span class="error" id="upto50"></span>
                           </div>
                           
                           <div class="boite">
                               <label for="">Up To 100 :</label>
                                <input type="text" name="upto100">
                                <span class="error" id="upto100"></span>
                           </div>
                                                  
                       </div>
                       <div class="right2">
                           <div class="boite">
                               <label for="">Up To 500 :</label>
                              <input type="text"  name="upto500" >
                              <span class="error" id="upto500"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 1000 :</label>
                               <input type="text"  name="upto1000">
                               <span class="error" id="upto1000"></span>
                           </div>
                          
                       </div>
                   </div>
                    </div>
                   <div class="corps-formulairee">
                   <p>Num Of Session Per User :</p>
                   <div class="corps-formulaire3">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Up To 1 :</label>
                               <input type="text" name="session1">
                               <span class="error" id="session1"></span>
                           </div>
                           <div class="boite">
                               <label for=""> Up To 5 :</label>
                                <input type="text"  name="session5">
                                <span class="error" id="session5"></span>
                           </div>
                            <div class="boite">
                               <label for=""> Up To 10 :</label>
                               <input type="text"  name="session10">
                              <span class="error" id="session10"></span>
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Up To 20 :</label>
                               <input type="text"  name="session20">
                               <span class="error" id="session20"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 50 :</label>
                               <input type="text"  name="session50">
                               <span class="error" id="session50"></span>
                           </div>

                       </div>
                   </div>
                  </div>
                <!----- ---->

            <div class="corps-formulairee">
                   <p>Num Of Operation Per Session :</p>
                   <div class="corps-formulaire4">
                       <div class="left2">
                          <div class="boite">
                               <label for="">Up To 50 :</label>
                               <input type="text"   name="operation50">
                               <span class="error" id="operation50"></span>
                           </div>
                           <div class="boite">
                               <label for=""> Up To 100 :</label>
                                <input type="text" name="operation100">
                                <span class="error" id="operation100"></span>
                           </div>
                            <div class="boite">
                               <label for=""> Up To 300 :</label>
                               <input type="text"  name="operation300">
                               <span class="error" id="operation300"></span>
                           </div>
                          
                       </div>

                       <div class="right2">
                           <div class="boite">
                               <label for="">Up To 500 :</label>
                               <input type="text"  name="operation500">
                               <span class="error" id="operation500"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 1000 :</label>
                               <input type="text"  name="operation1000">
                               <span class="error" id="operation1000"></span>
                           </div>
                           <div class="boite">
                               <label for="">Up To 1500 :</label>
                               <input type="text" name="operation1500">
                               <span class="error" id="operation1500"></span>
                           </div>

                       </div>
                   </div>
                   </div>
                <!--- --->
                   <div class="pied-formulaire">
					<button type="reset" name="signup" id="signup" class="form-submit" value="Cancel"> Cancel </button>
					<button type="submit" name="signup" id="signup" class="form-submit" value="Next"> Next </button>
               <!---         <button type="submit">Cancel</button>
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
    var upto10 = document.forms["myForm"]["upto10"]; 
    var upto50 = document.forms["myForm"]["upto50"]; 
    var upto100 = document.forms["myForm"]["upto100"];  
    var upto500 = document.forms["myForm"]["upto500"]; 
    var upto1000 = document.forms["myForm"]["upto1000"]; 
    var session1 = document.forms["myForm"]["session1"];  
    var session5 = document.forms["myForm"]["session5"];  
    var session10 = document.forms["myForm"]["session10"]; 
    var session20 = document.forms["myForm"]["session20"]; 
    var session50 = document.forms["myForm"]["session50"];
    var operation50 = document.forms["myForm"]["operation50"]; 
    var operation100 = document.forms["myForm"]["operation100"];  
    var operation300 = document.forms["myForm"]["operation300"];  
    var operation500 = document.forms["myForm"]["operation500"]; 
    var operation1000 = document.forms["myForm"]["operation1000"]; 
    var operation1500 = document.forms["myForm"]["operation1500"];    
    ////////////////////////////////
    if (upto10.value == "")                                  
    { 
        document.getElementById('upto10').innerHTML="Enter your UpTo10";  
        upto10.focus(); 
        return false; 
    }else{
        document.getElementById('upto10').innerHTML="";  
    }
        ////////////////////////////////
    if (upto50.value == "")                                  
    { 
        document.getElementById('upto50').innerHTML="Enter your UpTo50";  
        upto50.focus(); 
        return false; 
    }else{
        document.getElementById('upto50').innerHTML="";  
    }
            ////////////////////////////////
    if (upto100.value == "")                                  
    { 
        document.getElementById('upto100').innerHTML="Enter your UpTo100";  
        upto100.focus(); 
        return false; 
    }else{
        document.getElementById('upto100').innerHTML="";  
    }

            ////////////////////////////////
    if (upto500.value == "")                                  
    { 
        document.getElementById('upto500').innerHTML="Enter your UpTo500";  
        upto500.focus(); 
        return false; 
    }else{
        document.getElementById('upto500').innerHTML="";  
    }
            ////////////////////////////////
    if (upto1000.value == "")                                  
    { 
        document.getElementById('upto1000').innerHTML="Enter your UpTo1000";  
        upto1000.focus(); 
        return false; 
    }else{
        document.getElementById('upto1000').innerHTML="";  
    }

        ////////////////////////////////
    if (session1.value == "")                                  
    { 
        document.getElementById('session1').innerHTML="Enter your UpTo1";  
        session1.focus(); 
        return false; 
    }else{
        document.getElementById('session1').innerHTML="";  
    }
        ////////////////////////////////
    if (session5.value == "")                                  
    { 
        document.getElementById('session5').innerHTML="Enter your UpTo5";  
        session5.focus(); 
        return false; 
    }else{
        document.getElementById('session5').innerHTML="";  
    }
            ////////////////////////////////
    if (session10.value == "")                                  
    { 
        document.getElementById('session10').innerHTML="Enter your UpTo10";  
        session10.focus(); 
        return false; 
    }else{
        document.getElementById('session10').innerHTML="";  
    }

            ////////////////////////////////
    if (session20.value == "")                                  
    { 
        document.getElementById('session20').innerHTML="Enter your UpTo20";  
        session20.focus(); 
        return false; 
    }else{
        document.getElementById('session20').innerHTML="";  
    }
            ////////////////////////////////
    if (session50.value == "")                                  
    { 
        document.getElementById('session50').innerHTML="Enter your UpTo50";  
        session50.focus(); 
        return false; 
    }else{
        document.getElementById('session50').innerHTML="";  
    }



        ////////////////////////////////
    if (operation50.value == "")                                  
    { 
        document.getElementById('operation50').innerHTML="Enter your UpTo50";  
        operation50.focus(); 
        return false; 
    }else{
        document.getElementById('operation50').innerHTML="";  
    }
        ////////////////////////////////
    if (operation100.value == "")                                  
    { 
        document.getElementById('operation100').innerHTML="Enter your UpTo100";  
        operation100.focus(); 
        return false; 
    }else{
        document.getElementById('operation100').innerHTML="";  
    }
            ////////////////////////////////
    if (operation300.value == "")                                  
    { 
        document.getElementById('operation300').innerHTML="Enter your UpTo300";  
        operation300.focus(); 
        return false; 
    }else{
        document.getElementById('operation300').innerHTML="";  
    }

            ////////////////////////////////
    if (operation500.value == "")                                  
    { 
        document.getElementById('operation500').innerHTML="Enter your UpTo500";  
        operation500.focus(); 
        return false; 
    }else{
        document.getElementById('operation500').innerHTML="";  
    }
            ////////////////////////////////
    if (operation1000.value == "")                                  
    { 
        document.getElementById('operation1000').innerHTML="Enter your UpTo1000";  
        operation1000.focus(); 
        return false; 
    }else{
        document.getElementById('operation1000').innerHTML="";  
    }
                ////////////////////////////////
    if (operation1500.value == "")                                  
    { 
        document.getElementById('operation1500').innerHTML="Enter your UpTo1500";  
        operation1500.focus(); 
        return false; 
    }else{
        document.getElementById('operation1500').innerHTML="";  
    }


}
 </script>
</body>
</html>