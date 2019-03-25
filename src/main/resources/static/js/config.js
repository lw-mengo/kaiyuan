"use strict";
!function (o, a) {
    function t() {
        function o(o) {
            if (0 === o.ErrorCode) return o.data || {};
            if (50013 === o.ErrorCode || 50008 === o.ErrorCode || 50012 === o.ErrorCode) {
                localStorage.setItem("plantdata.user", "");
                var a = new Error("登录失效，请重新登录", o.ErrorCode);
                return Promise.reject(a)
            }
            var t = new Error(o.ErrorInfo, o.ErrorCode);
            return Promise.reject(t)
        }

        var a = localStorage.getItem("plantdata.token"), t = {};
        return a && (t.Authorization = "Bearer " + a), {
            RESTFUL_SERVICE_BASE_URL: r[e].baseUrl,
            RESTFUL_SERVICE_BASE_COOKIE: r[e].cookieDomain,
            formal: "www.plantdata.ai",
            appName: "plantdata",
            HEADERS: t ? t : null,
            dealResponse: o,
            PRODUCT: ["KGMS", "KGRobot", "KGPro", "KGAssist", "KGBuilder", "Demo Gallery"],
            OPEN: ["kgms", "kgrobot", "kgpro"]
        }
    }

    var r = {
        local: {baseUrl: "http://192.168.1.59:9998/plantdata-manage/api", cookieDomain: "192.168.1.211"},
        157: {
            baseUrl: "http://hiekn.hiekn.com:19001/plantdata-manage/api",
            urlPrefixes: o.location.host,
            cookieDomain: o.location.hostname
        },
        prod: {
            baseUrl: document.location.protocol + "//" + o.location.host + "/plantdata-manage/api",
            cookieDomain: "plantdata.ai"
        },
        test: {
            baseUrl: document.location.protocol + "//" + o.location.host + "/plantdata-manage/api",
            cookieDomain: "plantdata.ai"
        },
        out: {
            baseUrl: document.location.protocol + "//" + o.location.host + "/plantdata-manage/api",
            cookieDomain: o.location.hostname
        }
    }, e = "prod";
    o.configService = new t
}(window, jQuery);