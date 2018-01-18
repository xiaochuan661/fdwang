<#import "/spring.ftl" as s>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>Mr. Wang , The Best Chef</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<#include '../include/baselink.ftl'>
</head>

<body class="error-page sb-l-o sb-r-c onload-check">
<!-- Start: Main -->
<div id="main">
<#include '../include/header.ftl'>
<#include '../include/sidebar.ftl'>
    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">
        <!-- Start: Topbar -->
        <header id="topbar" class="alt">
            <div class="topbar-left">
                <ol class="breadcrumb">
                    <li class="crumb-active">
                        <a href="<@s.url '/'/>">Fd Wang</a>
                    </li>
                    <li class="crumb-icon">
                        <a href="<@s.url '/'/>">
                            <span class="glyphicon glyphicon-home"></span>
                        </a>
                    </li>
                    <li class="crumb-link">
                        <a href="<@s.url '/'/>">首页</a>
                    </li>
                    <li class="crumb-trail">食材列表</li>
                </ol>
            </div>
        </header>
        <!-- End: Topbar -->

        <!-- Begin: Content -->
        <section id="content" class="pn">
            <div class="row">
                <div class="col-md-6">
                    <div class="panel">
                        <div class="panel-heading">
                            <span class="panel-title">填写食材的基本信息</span>
                            <span class="panel-title"> <button class="btn btn-system btn-gdark pull-right" v-on:click="saveOrUpdate">保存</button></span>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="inputStandard" class="col-lg-3 control-label">食材名称</label>
                                    <div class="col-lg-8">
                                        <div class="bs-component">
                                            <input type="text" v-model="fdMaterial.name" class="form-control" placeholder="请填写食材名称">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputStandard" class="col-lg-3 control-label">分量单位</label>
                                    <div class="col-lg-8">
                                        <div class="bs-component">
                                            <input type="text" v-model="fdMaterial.unit" class="form-control" placeholder="请填写食材分量单位">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputStandard" class="col-lg-3 control-label">食材描述</label>
                                    <div class="col-lg-8">
                                        <div class="bs-component">
                                            <textarea v-model="fdMaterial.description" class="form-control" id="textArea2" rows="3" style="margin-top: 0px; margin-bottom: 0px; height: 108px;"></textarea>
                                        </div>
                                    </div>
                                </div>


                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="col-xs-12 pl30">
                                <div class="tray-bin pl10 mb10" style="min-height: 250px;">
                                    <h5 class="text-muted mt10 fw600 pl10">
                                        <i class="fa fa-exclamation-circle text-info fa-lg pr10"></i>请输入食材图片（点击空白或拖拽上传）</h5>
                                   <form v-bind:action="contentPath+'/rest/image/upload'" class="dropzone dropzone-sm dz-clickable" id="dropZone">
                                        <div class="dz-default dz-message">
                                            <span>
                                                <i class="fa fa-cloud-upload"></i>
                                                <span class="main-text"><b>Drop Files</b> to upload</span> <br>
                                                <span class="sub-text">(or click)</span>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End: Content -->
    <#include '../include/footer.ftl' />
    </section>
    <!-- End: Content-Wrapper -->
</div>
<#include '../include/footer_js.ftl'/>
<script type="text/javascript">
    var vue = new Vue({
        el: '#main',
        data:{
            fdMaterial:{}
        },
        methods:{
            saveOrUpdate : function(){
                this.$http.post(contentPath + "/rest/material/saveOrUpdate", this.fdMaterial).then(function (resp) {
                    sweetAlert("食材信息添加成功", "success");
                }, function (error) {
                    sweetAlert(error.data.message);
                })
            }
        }
    })
</script>
</body>

</html>
