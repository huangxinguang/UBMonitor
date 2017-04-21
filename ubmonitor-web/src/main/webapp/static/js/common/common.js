var baseurl = (window.location + '').split('/');
var basePath = baseurl[0] + '//' + baseurl[2] + '/';
$(top.hangge());
(function ($) {
    $.extend({
        ajaxSubmit: function (param, showMsg, callback, errorback) {
            param.async = (param.async == null || param.async == "" || typeof(param.async) == "undefined") ? "true" : param.async;
            param.type = (param.type == null || param.type == "" || typeof(param.type) == "undefined") ? "post" : param.type;
            param.dataType = (param.dataType == null || param.dataType == "" || typeof(param.dataType) == "undefined") ? "json" : param.dataType;
            param.data = (param.data == null || param.data == "" || typeof(param.data) == "undefined") ? {"date": new Date().getTime()} : param.data;
            $.ajax({
                type: param.type,
                async: param.async,
                data: param.data,
                url: param.url,
                dataType: param.dataType,
                success: function (d) {
                    if (d.result == 'failture' && showMsg) {
                        ajaxCommonMsg(JSON.parse(d.tipsMsg));
                    } else {
                        callback(d);
                    }
                },
                beforeSend: function (XHR) {
                    $("#pageContent").hide();
                    $("#loading").show();
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#pageContent").show();
                    $("#loading").hide();
                }
            });
        }
    })
})(jQuery)


function ajaxCommonMsg(jsonMsg) {
    if (jsonMsg.style == 'page') {
        alert(jsonMsg.msg);
    } else if (jsonMsg.style == 'tips') {
        alert(jsonMsg.msg);
    } else if (jsonMsg.style == 'error') {
        alert(jsonMsg.msg);
    } else {
        alert(jsonMsg.msg);
    }
}


