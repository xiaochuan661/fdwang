<!-----------------------------------------------------------------+
     ".navbar" Helper Classes:
  -------------------------------------------------------------------+
     * Positioning Classes:
      '.navbar-static-top' - Static top positioned navbar
      '.navbar-static-top' - Fixed top positioned navbar

     * Available Skin Classes:
       .bg-dark    .bg-primary   .bg-success
       .bg-info    .bg-warning   .bg-danger
       .bg-alert   .bg-system
  -------------------------------------------------------------------+
    Example: <header class="navbar navbar-fixed-top bg-primary">
    Results: Fixed top navbar with blue background
  ------------------------------------------------------------------->
<!-- Start: Header -->
<header id="vueheader" class="navbar navbar-fixed-top">
    <div class="navbar-branding dark">
        <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
        <a class="navbar-brand" href="<@s.url '/'/>">
            <b>FD Wang</b>
        </a>

    </div>
    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown" aria-expanded="false">
                <img src="<@s.url "/assets/images/avatars/1.jpg"/>" alt="avatar" class="mw30 br64 mr15">
                        <b></b>
                <span class="caret caret-tp hidden-xs"></span>
            </a>
            <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                <li class="list-group-item">
                    <a href="<@s.url '/logout'/>" class="animated animated-short fadeInUp">
                        <span class="fa fa-power-off"></span> 登出 </a>
                </li>
            </ul>
        </li>
    </ul>
</header>
<!-- End: Header -->
