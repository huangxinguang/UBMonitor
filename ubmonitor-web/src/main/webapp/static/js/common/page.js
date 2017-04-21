function nextPage(page) {
    top.jzts();
    if (true && document.forms[0]) {
        var url = document.forms[0].getAttribute("action");
        if (url.indexOf('?') > -1) {
            url += "&currentPage=";
        }
        else {
            url += "?currentPage=";
        }
        url = url + page + "&showCount=10";
        document.forms[0].action = url;
        document.forms[0].submit();
    } else {
        var url = document.location + '';
        if (url.indexOf('?') > -1) {
            if (url.indexOf('currentPage') > -1) {
                var reg = /currentPage=\d*/g;
                url = url.replace(reg, 'currentPage=');
            } else {
                url += "&currentPage=";
            }
        } else {
            url += "?currentPage=";
        }
        url = url + page + "&showCount=10";
        document.location = url;
    }
}
function changeCount(value) {
    top.jzts();
    if (true && document.forms[0]) {
        var url = document.forms[0].getAttribute("action");
        if (url.indexOf('?') > -1) {
            url += "&currentPage=";
        }
        else {
            url += "?currentPage=";
        }
        url = url + "1&showCount=" + value;
        document.forms[0].action = url;
        document.forms[0].submit();
    } else {
        var url = document.location + '';
        if (url.indexOf('?') > -1) {
            if (url.indexOf('currentPage') > -1) {
                var reg = /currentPage=\d*/g;
                url = url.replace(reg, 'currentPage=');
            } else {
                url += "1&currentPage=";
            }
        } else {
            url += "?currentPage=";
        }
        url = url + "&showCount=" + value;
        document.location = url;
    }
}
function toTZ() {
    var toPaggeVlue = document.getElementById("toGoPage").value;
    if (toPaggeVlue == '') {
        document.getElementById("toGoPage").value = 1;
        return;
    }
    if (isNaN(Number(toPaggeVlue))) {
        document.getElementById("toGoPage").value = 1;
        return;
    }
    nextPage(toPaggeVlue);
}