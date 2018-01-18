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
                    <li class="crumb-trail">控制台12</li>
                </ol>
            </div>
        </header>
        <!-- End: Topbar -->

        <!-- Begin: Content -->
        <section id="content" class="pn">


        </section>
        <!-- End: Content -->
    <#include 'include/footer.ftl' />
    </section>
    <!-- End: Content-Wrapper -->
</div>
<#include 'include/footer_js.ftl'/>
</body>

</html>
