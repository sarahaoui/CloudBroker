<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="sidebar close">
    <div class="logo-details">
      <i class='bx bx-menu'></i>
    </div>
    <ul class="nav-links">
      <li>
        <a href="acceuil.php">
          <i class='bx bx-grid-alt' ></i>
          <span class="link_name">Acceuil</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="">Acceuil</a></li>
        </ul>
      </li>
      
      <li>
        <div class="iocn-link">
          <a href="#">
            <i class='bx bx-folder-open'></i>
            <span class="link_name">Services</span>
          </a>
        <!--   <i class='bx bxs-chevron-down arrow' ></i> -->
        </div>
     <!--   <ul class="sub-menu">
          <li><a class="link_name" href="#">Services</a></li>
           <li><a href="">Vm</a></li>
          <li><a href="">Storage Space</a></li>
          <li><a href="">PaaS</a></li>
          <li><a href="">SaaS</a></li>  
        </ul> -->
      </li>
     <li>
        <div class="iocn-link">
          <a href="DP1.jsp">
           <i class='bx bx-folder-plus'></i>
            <span class="link_name" href="DP1.jsp">Ajouter</span>
          </a>
      <!--     <i class='bx bxs-chevron-down arrow' ></i> -->
        </div>
    <!--    <ul class="sub-menu">
          <li><a class="link_name" href="DP1.jsp">Ajouter</a></li>
     <li><a href="">Vm</a></li>
          <li><a href="">Storage Space</a></li>
          <li><a href="">PaaS</a></li>
          <li><a href="">SaaS</a></li> 
        </ul>  -->
      </li>
      
      <li>
        <a href="">
          <i class='bx bx-line-chart' ></i>
          <span class="link_name">Statistiques</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="statiqtiques.php">Statistiques</a></li>
        </ul>
      </li>
      <li>
        <a href="aide.php">
          <i class='bx bx-help-circle'></i>
          <span class="link_name">Aide</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="aide.php">Aide</a></li>
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
          <span class="link_name">Historique</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="historique.php">Historique</a></li>
        </ul>
      </li>
      <li>
        <a href="">
          <i class='bx bx-cog' ></i>
          <span class="link_name">Parametre</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="parametre.php">Parametre</a></li>
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