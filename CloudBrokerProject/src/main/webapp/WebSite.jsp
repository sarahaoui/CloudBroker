<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />

    <link
      href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="css/style.css" />
    <title>CloudBroker</title>

    <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
  </head>
  <body>
    <header class="header" id="section--0">
      <nav class="nav">
        <img
          src="images/logo.png"
          alt="Bankist logo"
          class="nav__logo"
          id="logo"
        />
        <ul class="nav__links">
          <li class="nav__item">
            <a class="nav__link" href="#section--0">Home</a>
          </li>
          <li class="nav__item">
            <a class="nav__link" href="#section--1">About Us</a>
          </li>
          <li class="nav__item">
            <a class="nav__link" href="#section--2">Services</a>
          </li>
          <li class="nav__item">
            <a class="nav__link" href="#section--4">Contact Us</a>
          </li>
          <li class="nav__item">
            <a class="nav__link nav__link--btn btn--show-modal" href="#">
              Register</a
            >
          </li>
        </ul>
      </nav>

      <div class="header__title">
        <h1>The Leading Cloud Commerce Solution</h1>
        <h4>Streamline the buying, selling and management of services.</h4>
        <button class="btn--text "> <a href="#section--1">Learn more &DownArrow;</a></button>
        <img src="images/image1.gif" class="header__img" />
      </div>
    </header>

    <section class="section" id="section--1">
      <div class="section__title">
        <h2 class="section__description">About Us</h2>
        <h3 class="section__header">Why CloudBroker?</h3>
      </div>

      <div class="features">
        <div class="features__feature">
          <div class="features__icon">
            <ion-icon name="person-outline"></ion-icon>
          </div>
          <h5 class="features__header">For Sellers</h5>
          <p>One place to sell, manage and deploy your services.</p>
        </div>
        <div class="features__feature">
          <div class="features__icon">
            <ion-icon name="cart-outline"></ion-icon>
          </div>
          <h5 class="features__header">For Buyers</h5>
          <p>
            Solve the procurement challenge for recurring and metered services.
          </p>
        </div>
        <div class="features__feature">
          <div class="features__icon">
            <ion-icon name="trending-up-outline"></ion-icon>
          </div>
          <h5 class="features__header">Self-Service Portal</h5>
          <p>
            Users can self serve to discover and acquire the services they need.
          </p>
        </div>

        <div class="features__feature">
          <div class="features__icon">
            <ion-icon name="cloud-download-outline"></ion-icon>
          </div>
          <h5 class="features__header">Marketplace</h5>
          <p>
            Showcase and sell your services in an internal or external
            marketplace
          </p>
        </div>
        <div class="features__feature">
          <div class="features__icon">
            <ion-icon name="flash-outline"></ion-icon>
          </div>
          <h5 class="features__header">Faster cloud adoption</h5>
          <p>
            Native cloud services provide elasticity, agility, and availability to customer applications.
          </p>
        </div>
        <div class="features__feature">
          <div class="features__icon">
            <ion-icon name="cloud-done-outline"></ion-icon>
          </div>
          <h5 class="features__header">Guided deployment</h5>
          <p>
            Employs best practices for high availability and data retention when deploying services.
          </p>
        </div>
      </div>
    </section>

    <section class="section" id="section--2">
      <div class="section__title">
        <h2 class="section__description">Services</h2>
        <h3 class="section__header">
          We provide services to our customers anywhere and anytime
        </h3>
      </div>
      <div class="cards">
				<!--1-->
				<div class="card">
          <div class="icon">
            <ion-icon name="cash-outline" class="ion-icon"></ion-icon>
          </div>
          <h4>Price Management</h4>
          <p>Manage pricing on a global or per customer basis. Create offers and quotes from your service catalog.</p>
        </div>
        <div class="card">
          <div class="icon">
            <ion-icon name="trending-up-outline" class="ion-icon"></ion-icon>
          </div>
          <h4>Self-service</h4>
          <p>Your admin users can discover, provision and manage services and view monthly billing details.</p>
        </div>
        <div class="card">
          <div class="icon">
            <ion-icon name="stats-chart-outline" class="ion-icon"></ion-icon>
          </div>
          <h4>Reports and BI</h4>
          <p>Reports and exports give you a single, consolidated view of utilization, costs, and charges.</p>
        </div>
        <div class="card">
          <div class="icon">
            <ion-icon name="shield-checkmark-outline" class="ion-icon"></ion-icon>
          </div>
          <h4>Security</h4>
          <p>Secure and harden infrastructure, including physical and software measures.</p>
        </div>
         <div class="card">
          <div class="icon">
            <ion-icon name="server-outline" class="ion-icon"></ion-icon>
          </div>
          <h4>Billing & Chargeback</h4>
          <p>Reports and exports provide all the information you need to  detailed cost and billing reports.</p>
        </div>
        <div class="card">
          <div class="icon">
            <ion-icon name="analytics-outline" class="ion-icon"></ion-icon>
          </div>
          <h4>Automation</h4>
          <p>The procurement and provisioning of any product or service can be partially or fully automated.</p>
        </div>
				</div>
				

      </div>
    </section>

    <section class="section" id="section--3">
      <div class="section__title section__title--testimonials">
        <h2 class="section__description">Client FeedBack</h2>
        <h3 class="section__header">What Do People Say About Us?</h3>
      </div>

      <div class="slider">
        <div class="slide">
          <div class="testimonial">
            <h5 class="testimonial__header">Best financial decision ever!</h5>
            <blockquote class="testimonial__text">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit.
              Accusantium quas quisquam non? Quas voluptate nulla minima
              deleniti optio ullam nesciunt, numquam corporis et asperiores
              laboriosam sunt, praesentium suscipit blanditiis. Necessitatibus
              id alias reiciendis, perferendis facere pariatur dolore veniam
              autem esse non voluptatem saepe provident nihil molestiae.
            </blockquote>
            <address class="testimonial__author">
              <img src="images/user-1.jpg" alt="" class="testimonial__photo" />
              <h6 class="testimonial__name">Aarav Lynn</h6>
              <p class="testimonial__location">San Francisco, USA</p>
            </address>
          </div>
        </div>

        <div class="slide">
          <div class="testimonial">
            <h5 class="testimonial__header">
              The last step to becoming a complete minimalist
            </h5>
            <blockquote class="testimonial__text">
              Quisquam itaque deserunt ullam, quia ea repellendus provident,
              ducimus neque ipsam modi voluptatibus doloremque, corrupti
              laborum. Incidunt numquam perferendis veritatis neque repellendus.
              Lorem, ipsum dolor sit amet consectetur adipisicing elit. Illo
              deserunt exercitationem deleniti.
            </blockquote>
            <address class="testimonial__author">
              <img src="images/user-2.jpg" alt="" class="testimonial__photo" />
              <h6 class="testimonial__name">Miyah Miles</h6>
              <p class="testimonial__location">London, UK</p>
            </address>
          </div>
        </div>

        <div class="slide">
          <div class="testimonial">
            <h5 class="testimonial__header">
              Finally free from old-school banks
            </h5>
            <blockquote class="testimonial__text">
              Debitis, nihil sit minus suscipit magni aperiam vel tenetur
              incidunt commodi architecto numquam omnis nulla autem,
              necessitatibus blanditiis modi similique quidem. Odio aliquam
              culpa dicta beatae quod maiores ipsa minus consequatur error sunt,
              deleniti saepe aliquid quos inventore sequi. Necessitatibus id
              alias reiciendis, perferendis facere.
            </blockquote>
            <address class="testimonial__author">
              <img src="images/user-3.jpg" alt="" class="testimonial__photo" />
              <h6 class="testimonial__name">Francisco Gomes</h6>
              <p class="testimonial__location">Lisbon, Portugal</p>
            </address>
          </div>
        </div>

        <button class="slider__btn slider__btn--left">&larr;</button>
        <button class="slider__btn slider__btn--right">&rarr;</button>
        <div class="dots"></div>
      </div>
    </section>

    <footer class="footer">
      <ul class="footer__nav">
        <li class="footer__item">
          <a class="footer__link" href="#">About</a>
        </li>
        <li class="footer__item">
          <a class="footer__link" href="#">Pricing</a>
        </li>
        <li class="footer__item">
          <a class="footer__link" href="#">Terms of Use</a>
        </li>
        <li class="footer__item">
          <a class="footer__link" href="#">Privacy Policy</a>
        </li>
        <li class="footer__item">
          <a class="footer__link" href="#">Careers</a>
        </li>
        <li class="footer__item">
          <a class="footer__link" href="#">Contact Us</a>
        </li>
      </ul>
      <img src="images/white.png" alt="Logo" class="footer__logo" />
      
      <p class="footer__copyright">
        &copy; Copyright 2022, Powered by
        <a
          class="footer__link "
          target="_blank"
          href="#"
          >AouinaSarah</a
        >. 
      </p>
    </footer>

    <div class="overlay hidden"></div>
    
    <script defer src="js/script.js"></script>
  </body>
</html>