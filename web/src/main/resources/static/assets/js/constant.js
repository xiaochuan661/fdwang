var contentPath = "/fdwang";


jQuery(document).ready(function() {
    "use strict";
    Core.init();
    $('.admin-panels').adminpanel({
        grid: '.admin-grid',
        draggable: true,
        preserveGrid: true,
        mobile: true,
        onStart: function() {
            // Do something before AdminPanels runs
        },
        onFinish: function() {
            $('.admin-panels').addClass('animated fadeIn').removeClass('fade-onload');
        },
        onSave: function() {
            $(window).trigger('resize');
        }
    });
    $(".ui-spinner-input").spinner();
    setActiveClassForMenu();


});
function setActiveClassForMenu() {
    var pathname = location.pathname;
    if(pathname.length>0){
        var lastChar = pathname.charAt(pathname.length-1);
        if(lastChar === '/'){
            pathname = pathname.substring(0, pathname.length-1);
        }
    }

    var result = setActive(pathname);
    if(result==false){
        var referrer = document.referrer.replace(location.protocol+'//'+location.host,'');
        setActive(referrer);
    }
    function setActive(pathname){
        var $menu = $("[href='"+pathname+"']");
        if($menu.length>=1){
            $menu.parent('li').addClass('active')
                .parent('ul').prev('.accordion-toggle').addClass('menu-open');
            return true;
        }
        return false;
    }
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    var context = "";
    if (r != null) {
        context = r[2];
    }
    reg = null;
    r = null;
    return context == null || context == "" || context == "undefined" ? "" : context;
}

function imageInit() {
    var appTemp = this;
    var id ="";
    if (appTemp.id != undefined){
        id = appTemp.id;
    }
    $( id + ' .fileupload-btn').each(function () {
        var key = $(this).data('key');
        var type = $(this).data('type');
        var groupName = $(this).data('group');
        var myDropzone = new Dropzone(this, {
            url: contentPath+"/images/fileUpload?loanOrderNo=" + appTemp.orderNo + "&category="
                 + type,
            previewsContainer: $(this).attr('_target'),
            previewTemplate: '<div class="custom-dz-preview-box"><img data-dz-thumbnail /><a class="custom-dz-preview-box-delete" href="javascript:;">删除</a></div>'
        });
        myDropzone.on("success", function (file, resp) {
            var data = {
                orderNo: appTemp.orderNo,
                videoKey: key,
                imageType: type,
                groupName: groupName,
                videoValue: resp.data.fileUrl
            };
            appTemp.$http.post(contentPath+"/api/v1/order/proof", data).then(function (response) {
                appTemp.uploadedFiles[file.name] = response.data.data;
            }, function (response) {
                sweetAlert(response.data.message, "错误码" + response.data.code, "error");
            });
        });
    });

    $('body').on('click', id + ' .custom-dz-preview-box-delete', function () {
        var name = $(this).prev().attr('alt');
        var imageId = $(this).data('id') || appTemp.uploadedFiles[name].id;
        var thisTemp = $(this);
        appTemp.$http.post(contentPath+"/api/v1/order/del?imageId=" + imageId)
            .then(function (response) {
                thisTemp.parent('.custom-dz-preview-box').remove();
            }, function (response) {
                sweetAlert(response.data.message, "错误码" + response.data.code, "error");
            });
    });

    $('body').on('click', id +  ' .custom-dz-preview-box img', function () {
        var localPath = $(this).attr('alt');
        var remotePath = '';
        if (localPath && appTemp.uploadedFiles[localPath].videoValue) {
            remotePath = appTemp.uploadedFiles[localPath].videoValue;
            remotePath = contentPath+"/images/view/" + remotePath;
        } else {
            remotePath = $(this).attr('src');
        }
        layer.open({
                       type: 1,
                       title: '图片信息',
                       area: ['480px', '300px'],
                       shade: 0,
                       offset: [Math.random() * ($(window).height() - 480),
                                Math.random() * ($(window).width() - 300)
                       ],
                       maxmin: true,
                       content: '<div id="viewImg' + appTemp.imgBox
                                + '" class="viewer iviewer_cursor"></div>',
                       zIndex: layer.zIndex,
                       success: function (layero) {
                           layer.setTop(layero);
                           $("#viewImg" + appTemp.imgBox).iviewer({src: remotePath});
                       }
                   });
        appTemp.imgBox = appTemp.imgBox + 1;
    });
};

var digitUppercase = function(n) {
    var fraction = ['角', '分'];
    var digit = [
        '零', '壹', '贰', '叁', '肆',
        '伍', '陆', '柒', '捌', '玖'
    ];
    var unit = [
        ['元', '万', '亿'],
        ['', '拾', '佰', '仟']
    ];
    var head = n < 0 ? '欠' : '';
    n = Math.abs(n);
    var s = '';
    for (var i = 0; i < fraction.length; i++) {
        s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
    }
    s = s || '整';
    n = Math.floor(n);
    for (var i = 0; i < unit[0].length && n > 0; i++) {
        var p = '';
        for (var j = 0; j < unit[1].length && n > 0; j++) {
            p = digit[n % 10] + unit[1][j] + p;
            n = Math.floor(n / 10);
        }
        s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
    }
    return head + s.replace(/(零.)*零元/, '元')
            .replace(/(零.)+/g, '零')
            .replace(/^整$/, '零元整');
};

Array.prototype.contain = function (item) {
    for (var i = 0; i < this.length; i++) {
        // 严格比较，即类型与数值必须同时相等。
        if (this[i] === item) {
            return true;
        }
    }
    return false;
};
Array.prototype.delete = function (varElement) {
    for (var i = 0; i < this.length; i++) {
        // 严格比较，即类型与数值必须同时相等。
        if (this[i] === varElement) {
            this.splice(i, 1);
            break;
        }
    }
    return this;
};
String.prototype.format = function () {

    if (arguments.length <= 0) return this;

    var ref = this;

    for (var i = 0; i < arguments.length; i++) {
        ref = ref.replace(new RegExp("\\{" + i + "\\}", "gm"), arguments[i]);
    }

    return ref;
};