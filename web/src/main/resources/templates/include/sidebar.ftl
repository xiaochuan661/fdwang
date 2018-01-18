<!-----------------------------------------------------------------+
   "#sidebar_left" Helper Classes:
-------------------------------------------------------------------+
   * Positioning Classes:
    '.affix' - Sets Sidebar Left to the fixed position

   * Available Skin Classes:
     .sidebar-dark (default no class needed)
     .sidebar-light
     .sidebar-light.light
-------------------------------------------------------------------+
   Example: <aside id="sidebar_left" class="affix sidebar-light">
   Results: Fixed Left Sidebar with light/white background
------------------------------------------------------------------->

<!-- Start: Sidebar -->
<aside id="sidebar_left" class="nano nano-primary affix has-scrollbar sidebar-default">

    <!-- Start: Sidebar Left Content -->
    <div class="sidebar-left-content nano-content">
        <!-- Start: Sidebar Menu -->
        <ul class="nav sidebar-menu">
            <li class="sidebar-label pt20">首页</li>
            <li class="active">
                <a href="<@s.url '/' />">
                    <span class="glyphicon glyphicon-home"></span>
                    <span class="sidebar-title">控制台</span>
                </a>
            </li>
            <li class="sidebar-label pt15">系统管理</li>
            <li>
                <a class="accordion-toggle" href="#">
                    <span class="glyphicon glyphicon-fire"></span>
                    <span class="sidebar-title">订单管理</span>
                    <span class="caret"></span>
                </a>
                <ul class="nav sub-nav">
                    <li>
                        <a href="<@s.url '/product/publish'/>">
                            <span class="glyphicon glyphicon-list-alt"></span> 订单列表
                        </a>
                    </li>
                    <li>
                        <a href="<@s.url '/product/publish'/>">
                            <span class="glyphicon glyphicon-tags"></span> 添加订单
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a class="accordion-toggle" href="#">
                    <span class="glyphicon glyphicon-fire"></span>
                    <span class="sidebar-title">菜谱管理</span>
                    <span class="caret"></span>
                </a>
                <ul class="nav sub-nav">
                    <li>
                        <a href="<@s.url '/product/publish'/>">
                            <span class="glyphicon glyphicon-list-alt"></span> 菜品列表
                        </a>
                    </li>
                    <li>
                        <a href="<@s.url '/product/publish'/>">
                            <span class="glyphicon glyphicon-tags"></span> 添加菜品
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a class="accordion-toggle" href="#">
                    <span class="glyphicon glyphicon-fire"></span>
                    <span class="sidebar-title">食材管理</span>
                    <span class="caret"></span>
                </a>
                <ul class="nav sub-nav">
                    <li>
                        <a href="<@s.url '/material/list'/>">
                            <span class="glyphicon glyphicon-list-alt"></span> 食材列表
                        </a>
                    </li>
                    <li>
                        <a href="<@s.url '/material/add'/>">
                            <span class="glyphicon glyphicon-tags"></span> 添加食材
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- End: Sidebar Menu -->

        <!-- Start: Sidebar Collapse Button -->
        <div class="sidebar-toggle-mini">
            <a href="#">
                <span class="fa fa-sign-out"></span>
            </a>
        </div>
        <!-- End: Sidebar Collapse Button -->

    </div>
    <!-- End: Sidebar Left Content -->

</aside>
<!-- End: Sidebar Left -->