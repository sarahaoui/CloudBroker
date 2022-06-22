<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="sidebar close">
    <div class="logo-details">
      <i class='bx bx-menu'></i>
    </div>
    <ul class="nav-links">
      <li>
        <a href="Home.php">
          <i class='bx bx-grid-alt' ></i>
          <span class="link_name">Dashboard</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="Home.php">Dashboard</a></li>
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
        <div class="iocn-link">
          <a href="#">
            <i class="bx bx-folder-plus"></i>
            <span class="link_name">Add</span>
          </a>
          <i class='bx bxs-chevron-down arrow' ></i>
        </div>
        <ul class="sub-menu">
          <li><a class="link_name" href="#">Add</a></li>
          <li><a href="DescriptionProviderAPI.jsp">Add with API</a></li>
          <li><a href="DescriptionProvider.jsp">Add without API</a></li>
        </ul>
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