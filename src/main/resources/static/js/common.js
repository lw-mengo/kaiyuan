"use strict";
!function (e, t) {
    function a() {
        function a() {
            var a = n.user();
            t("#productList").on("click", "li", function () {
                if (layer.closeAll("tips"), !a) return layer.tips("请先登录", t(this), {tips: [4, "#00b38a"]}), !1;
                var i = t(this).find("a").data("href");
                i ? e.open(i) : layer.tips("即将开放", t(this), {tips: [4, "#00b38a"]})
            }), t("#navHeader").on("click", ".nav-list", function () {
                t(this).next().toggle()
            }).on("click", ".dropSelect", function () {
                t(this).hasClass("mbActive") || t(this).hasClass("user") || (t(this).siblings().removeClass("mbActive"), t(this).addClass("mbActive"))
            })
        }

        function i(e) {
            var t = void 0;
            switch (!0) {
                case e.indexOf("/home/") > -1:
                    t = 1;
                    break;
                case e.indexOf("/plan/") > -1:
                    t = 2;
                    break;
                case e.indexOf("/gallery/") > -1:
                    t = 3;
                    break;
                case e.indexOf("/dynamic/") > -1:
                    t = 4;
                    break;
                case e.indexOf("/about/") > -1:
                    t = 5;
                    break;
                case e.indexOf("/user/personal") > -1:
                    t = 6
            }
            return t
        }

        var n = {initFunction: void 0};
        return t(function () {
            n.renderProLink(), n.loginCheck(), n.initNavActive(), a()
        }), n.initNavActive = function () {
            var e = i(document.URL);
            if (e) {
                var a = t("#navHeader .nav-tab .items:nth-child(" + e + ")");
                a.siblings().removeClass("active"), a.addClass("active")
            }
        }, n.loginCheck = function () {
            if (n.user()) {
                var e = t("#navHeader .nav-tab"), a = n.user();
                e.find(".item-btn").remove(), e.append('<div class="items dropSelect user" id="logined">\n                <a href="../user/personalCenter.html">\n                    <span>' + (a.name ? a.name : a.phone ? a.phone : "") + '<i class="icon"></i></span>\n                </a>\n                <ul class="schemeList">\n                    <li><a href="#" onclick="commonService.loginOut()" >退出</a></li>\n                </ul>\n                </div>')
            }
        }, n.checkData = function (e) {
            var a = !0;
            e.find("input[musthave]").each(function (e) {
                t(this).val() ? (t(this).parent().removeClass("is-error"), t(this).next().text("")) : (t(this).parent().addClass("is-error"), t(this).next().text("必填"), a = !1)
            }), e.find("textarea[musthave]").each(function (e) {
                t(this).val() ? (t(this).parent().removeClass("is-error"), t(this).next().text("")) : (t(this).parent().addClass("is-error"), t(this).next().text("必填"), a = !1)
            });
            var i = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
            e.find("input[idc]").each(function (e) {
                "" == t(this).val() || i.test(t(this).val()) || (t(this).parent().addClass("is-error"), t(this).next().text("身份证格式不正确"), a = !1)
            });
            var n = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
            e.find("input[email]").each(function (e) {
                "" == t(this).val() || n.test(t(this).val()) || (t(this).parent().addClass("is-error"), t(this).next().text("邮箱格式不正确"), a = !1)
            });
            var r = /^1[34578]\d{9}$/;
            e.find("input[phone]").each(function (e) {
                "" == t(this).val() || r.test(t(this).val()) || (t(this).parent().addClass("is-error"), t(this).next().text("手机格式不正确"), a = !1)
            });
            var s = e.find("input[password]");
            return e.find('input[password="confirm"]').each(function (e) {
                "" !== t(this).val() && s.val() && s.val() !== t(this).val() && (t(this).parent().addClass("is-error"), t(this).next().text("两次密码不一致"), a = !1)
            }), a
        }, n.user = function (e) {
            var t = document.cookie.split(";"), a = "", i = !0, n = !1, r = void 0;
            try {
                for (var s, o = t[Symbol.iterator](); !(i = (s = o.next()).done); i = !0) {
                    var l = s.value;
                    l = l.trim(), 0 === l.indexOf("plantdata.user") && (a = decodeURIComponent(l.split("=")[1]))
                }
            } catch (c) {
                n = !0, r = c
            } finally {
                try {
                    !i && o["return"] && o["return"]()
                } finally {
                    if (n) throw r
                }
            }
            return !!a && JSON.parse(a)
        }, n.loginOut = function (t) {
            var a = new Date;
            a.setTime(a.getTime() - 1e4), document.cookie = "plantdata.token='';  path=/; domain=" + configService.RESTFUL_SERVICE_BASE_COOKIE + "; expires=" + a.toGMTString(), document.cookie = "plantdata.user='';  path=/; domain=" + configService.RESTFUL_SERVICE_BASE_COOKIE + "; expires=" + a.toGMTString(), localStorage.removeItem(configService.appName + ".user"), e.location.href = "../index.html"
        }, n.getQuery = function (t) {
            var a = new RegExp("(^|&)" + t + "=([^&]*)(&|$)"), i = e.location.search.substr(1).match(a);
            return null !== i ? decodeURIComponent(i[2]) : null
        }, n.renderProLink = function () {
            var a = "", i = !0, n = !1, r = void 0;
            try {
                for (var s, o = configService.PRODUCT[Symbol.iterator](); !(i = (s = o.next()).done); i = !0) {
                    var l = s.value;
                    configService.OPEN.indexOf(l.toLowerCase()) > -1 ? a += e.location.host === configService.formal || "plantdata.ai" === e.location.host ? '<li class="' + l.toLowerCase() + '"><a data-href="' + e.location.protocol + "//" + l.toLowerCase() + '.plantdata.ai" target="_blank">' + l + "</a></li>" : '<li class="' + l.toLowerCase() + '"><a data-href="' + e.location.protocol + "//" + e.location.host + "/" + l.toLowerCase() + '" target="_blank">' + l + "</a></li>" : "Demo Gallery" !== l && (a += '<li class="' + l.toLowerCase() + '"><a data-href="" target="_blank">' + l + "</a></li>")
                }
            } catch (c) {
                n = !0, r = c
            } finally {
                try {
                    !i && o["return"] && o["return"]()
                } finally {
                    if (n) throw r
                }
            }
            t("#productList").empty().html(a)
        }, n
    }

    e.commonService = new a
}(window, jQuery);