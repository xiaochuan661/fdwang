<#import "/spring.ftl" as s>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>Mr. Wang , The Best Chef</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<#include 'include/baselink.ftl'>
</head>

<body class="error-page sb-l-o sb-r-c onload-check">
<!-- Start: Main -->
<div id="main">
<#include 'include/header.ftl'>
<#include 'include/sidebar.ftl'>
    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">
        <!-- Start: Topbar -->
        <header id="topbar" class="alt">
            <div class="topbar-left">
                <ol class="breadcrumb">
                    <li class="crumb-active">
                        <a href="<@s.url '/'/>">FdWang</a>
                    </li>
                    <li class="crumb-icon">
                        <a href="<@s.url '/'/>">
                            <span class="glyphicon glyphicon-home"></span>
                        </a>
                    </li>
                    <li class="crumb-link">
                        <a href="<@s.url '/'/>">首页</a>
                    </li>
                    <li class="crumb-trail">控制台</li>
                </ol>
            </div>
        </header>
        <!-- End: Topbar -->

        <!-- Begin: Content -->
        <section id="content" class="pn">

            <div class="center-block mt50 mw800">
                <h1 class="error-title"> 404! </h1>
                <h2 class="error-subtitle">Page Not Found.</h2>
            </div>

            <div class="mid-section">
                <div class="mid-content clearfix">
                    <input type="text" class="form-control" placeholder="Ask me a question!" value="Let Me Help You Search!">
                    <div class="pull-left">
                        <#--<img src="<@s.url 'assets/img/logos/logo_grey.png'/>" class="img-responsive mt20 w225" alt="logo">-->
                    </div>
                    <div class="pull-right mt20">
                        <a href="#" title="facebook link">
                            <i class="fa fa-facebook-square fs40 text-primary mr15"></i>
                        </a>
                        <a href="#" title="twitter link">
                            <i class="fa fa-twitter-square fs40 text-info mr15"></i>
                        </a>
                        <a href="#" title="google plus link">
                            <i class="fa fa-google-plus-square fs40 text-danger-light mr15"></i>
                        </a>
                        <a href="#" title="email link">
                            <i class="fa fa-envelope-square fs40 text-warning"></i>
                        </a>
                    </div>

                </div>
            </div>

        </section>
        <!-- End: Content -->
    <#include 'include/footer.ftl' />
    </section>
    <!-- End: Content-Wrapper -->
</div>
<#include 'include/footer_js.ftl'/>
</body>

</html>
