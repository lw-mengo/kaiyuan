"use strict";
!function (n, e) {
    function i() {
        function i(n) {
            localStorage.setItem(configService.appName + ".token", n), configService.HEADERS = {Authorization: "Bearer " + n}
        }

        function o() {
            return hieknjs.kgLoader({
                type: 1,
                url: configService.RESTFUL_SERVICE_BASE_URL + "/sys/login/get/person",
                headers: configService.HEADERS,
                success: function (n) {
                    var e = configService.dealResponse(n);
                    if (e && e.rsData && e.rsData.length) return Promise.resolve(e.rsData[0])
                },
                error: function (n) {
                    return Promise.reject(n)
                }
            })
        }

        function t(n) {
            var i = '\n                <div class="login-success">\n                    <div class="login-success-content">\n                        <div class="success-icon">\n                            <i class="icon hufont ic-check"></i>\n                        </div>\n                        <div class="txt">登录成功 , 欢迎您 ' + n + '</div>\n                        <div class="time">\n                            <span>3</span>s 后跳转\n                        </div>\n                    </div>\n                </div>';
            e(".loginBox").empty().html(i), c()
        }

        function c() {
            var i = 3, o = setInterval(function () {
                e(".login-success .time span").text(i), i--, 0 === i && n.clearInterval(o)
            }, 1e3);
            setTimeout(function () {
                n.location.href = a.goLink
            }, 3e3)
        }

        var a = {};
        if (commonService.getQuery("link")) {
            var r = decodeURIComponent(commonService.getQuery("link"));
            a.goLink = r, a.weChatLink = "https://open.weixin.qq.com/connect/qrconnect?appid=wx8a817657d591dbc2&redirect_uri=http%3A%2F%2Frobot.plantdata.ai%2Fsys%2Flogin%2Fwx%2Fcallback&response_type=code&scope=snsapi_login&state=" + r + "#wechat_redirect"
        } else a.goLink = "../index.html", a.weChatLink = "https://open.weixin.qq.com/connect/qrconnect?appid=wx8a817657d591dbc2&redirect_uri=http%3A%2F%2Frobot.plantdata.ai%2Fsys%2Flogin%2Fwx%2Fcallback&response_type=code&scope=snsapi_login&state=personalCenter#wechat_redirect";
        return e(function () {
            a.initLoginEvent()
        }), a.initLoginPage = function () {
            var n = '<a href="#">\n                                <!--<i></i>-->\n                                <!--<span>微信登录</span>-->\n                            </a>\n                            <a href="./apply.html">\n                                <span>立即注册</span>\n                                <i class="icon hufont ic-chevron-right"></i>\n                            </a>';
            e("#loginForm").find(".other").html(n)
        }, a.initLoginEvent = function () {
            var n = e(".loginForm");
            n.on("click", ".login-btn", function () {
                if (commonService.checkData(e("#loginForm"))) {
                    var n = {phone: e("#_login-inputPhone").val(), pwd: e("#_login-inputPwd").val()};
                    hieknjs.kgLoader({
                        type: 1,
                        url: configService.RESTFUL_SERVICE_BASE_URL + "/sys/login/pwd",
                        data: n,
                        success: function (n) {
                            if (0 !== n.ErrorCode) return layer.msg("" + n.ErrorInfo), !1;
                            var e = configService.dealResponse(n);
                            if (e && e.rsData && e.rsData.length) {
                                var c = e.rsData[0];
                                document.cookie = "plantdata.token=" + encodeURIComponent(c) + ";  path=/; domain=" + configService.RESTFUL_SERVICE_BASE_COOKIE, i(c), o().then(function (n) {
                                    var e = n.data[0];
                                    localStorage.setItem(configService.appName + ".user", JSON.stringify(e));
                                    var i = {name: e.name, phone: e.phone, userId: e.userId}, o = [];
                                    e.applyTrialList.forEach(function (n) {
                                        o.push({systemName: n.systemName, status: n.status, expireTime: n.expireTime})
                                    }), i.applyTrialList = o, i = JSON.stringify(i), document.cookie = "plantdata.user=" + encodeURIComponent(i) + ";  path=/; domain=" + configService.RESTFUL_SERVICE_BASE_COOKIE, t(e.name)
                                })
                            }
                        },
                        error: function (n) {
                        }
                    })
                }
            }), e("#_login-inputPwd").on("keypress", function (n) {
                13 === n.keyCode && e(".login-btn").trigger("click")
            })
        }, a
    }

    n.loginService = i()
}(window, jQuery);