var TTCart = {
    load: function () { // 加载购物车数据

    },
    itemNumChange: function () {
        $(".increment").click(function () {//＋

            var _thisInput = $(this).siblings("input");
            _thisInput.parent().parent().parent().children().eq(0).children().eq(0).prop("checked", "checked");
            _thisInput.val(eval(_thisInput.val()) + 1);
            $.get("http://localhost:8770/cart/update/num?" + "itemId=" + _thisInput.attr("itemId") + "&itemNum=" + _thisInput.val(), function (data) {
                TTCart.refreshTotalPrice();
            });
        });
        $(".decrement").click(function () {//-
            var _thisInput = $(this).siblings("input");
            if (eval(_thisInput.val()) == 1) {
                return;
            }
            _thisInput.val(eval(_thisInput.val()) - 1);
            $.get("http://localhost:8770/cart/update/num?" + "itemId=" + _thisInput.attr("itemId") + "&itemNum=" + _thisInput.val(), function (data) {

                TTCart.refreshTotalPrice();
            });
        });
        $(".quantity-text").rnumber(1);//限制只能输入数字
        $(".quantity-text").blur(function () {
            var _thisInput = $(this);
            // console.log("==========itemId"+_thisInput.attr("itemId"));
            $.get("http://localhost:8770/cart/update/num?" + "itemId=" + _thisInput.attr("itemId") + "&itemNum=" + _thisInput.val(), function (data) {
                TTCart.refreshTotalPrice();
            });
        });
    },
    refreshTotalPrice: function () { //重新计算总价
        var total = 0;
        var discount = 0;
        var count = 0;
        $(".p-promotion").each(function (i, e) {
            var _this1 = $(e);
            // console.log(e);
            // console.log(_this1.parent().children().eq(0).children().eq(0).prop("checked"));
            if (_this1.parent().children().eq(0).children().eq(0).prop("checked") == true) {
                discount += Math.abs(eval(_this1.text()));
            }
        });
        $(".quantity-form .quantity-text").each(function (i, e) {
            var _this = $(e);
            // console.log("条件checked="+_this.parent().parent().parent().children().eq(0).children().eq(0).prop("checked"));
            if (_this.parent().parent().parent().children().eq(0).children().eq(0).prop("checked") == true) {
                count += +_this.val();
                total += (eval(_this.attr("itemPrice")) * 10000 * eval(_this.val())) / 10000;
            }
        });
        $(".font4").html(new Number(total - discount).toFixed(2));
        // window.localStorage.setItem("totalPrice", $(".font4").html().toFixed(2));
        $(".font3").html(new Number(total).toFixed(2));
        $('.font1').html(new Number(discount).toFixed(2));
        $('.font2').html(count);

    }
};

// 去结算
$('.checkout').click(function (e) {
    // var a = document.getElementById("toSettlement");
    //  var a = $(e);
    //   console.log("sddddddddddddddddd"+a);
    var itemIdList = [];

    $('.checkbox').each(function (i, e) {

        let _check = $(e);
        // console.log(itemNumList);
        if (_check.prop("checked") === true) {
            // console.log("============"+_check.val());
            itemIdList.push(_check.val());
        }

    });

    if (itemIdList.length === 0) {
        alert("请选中商品");
        window.location.reload();

    } else {
        let totalPrice = $(".font4").html();
        // console.log(totalPrice);
        window.localStorage.setItem("totalPrice", totalPrice);
        window.localStorage.setItem("itemIdList", itemIdList);
        window.location.href = "/cart/order-cart.html";
    }
});


$(function () {
    TTCart.load();
    TTCart.itemNumChange();

});