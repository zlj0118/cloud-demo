$(()=>{
    $.ajaxSetup({
        async: false
    });
        $.ajax({
            type: "Get",
            url: "http://localhost:8770/cart/showCart",
            data: {
                "userId": 23
            },
            success: function (resp) {

                var total_price_cart = 0;
                var total_price_cart_preferential =0;
                var product_list = $('#product-list');
                product_list.empty();
                for (let i of resp.data) {
                    var product_item = $('<div id="product_item" data-bind="rowid:1" class="item item_selected "></div>');
                    var item_form = $('<div class="item_form clearfix"></div>');
                    var cell_p_checkbox = $('<div class="cell p-checkbox"></div>');
                    var input1 = $('<input data-bind="cbid:1" class="checkbox" type="checkbox" name="checkItem" checked="" >');
                    input1.attr("value",i.item.id);
                    input1.attr("itemNum",i.itemNum);
                    cell_p_checkbox.append(input1);
                    var cell_p_goods = $('<div class="cell p-goods"></div>');
                    var p_img = $('<div class="p-img"></div>');
                    var a1 = $('<a target="_blank"></a>');
                    a1.attr("href", "/item/" + i.item.id);
                    var image1 = $('<image  clstag="clickcart|keycount|xincart|p-imglistcart" width="52" height="52">');
                    image1.attr("src",  i.item.image);
                    console.log(i.item.image);
                    image1.attr("alt", i.item.title);
                    p_img.append(image1);
                    var p_name = $('<div class="p-name"></div>');
                    var a2 = $('<a  clstag="clickcart|keycount|xincart|productnamelink" target="_blank"></a>');
                    a2.attr("href", "/cart/item.html");
                    a2.text(i.item.title);
                    var span1 = $('<span class="promise411 promise411_11345721" id="promise411_11345721"></span>');
                    p_name.append(a2);
                    p_name.append(span1);
                    var cell_p_price = $('<div class="cell p-price"></div>');
                    var span2 = $('<span class="price" ></span>');
                    span2.text("¥" + " " + i.item.price);
                    cell_p_price.append(span2);
                    var cell_p_promotion = $('<div class="cell p-promotion"></div>');
                    var cell_p_inventory_stock_11345721 = $('<div class="cell p-inventory stock-11345721"></div>');
                    cell_p_inventory_stock_11345721.text("有货");
                    var cell_p_quantity = $('<div class="cell p-quantity" for-stock="for-stock-11345721"></div>');
                    var quantity_form = $('<div class="quantity-form" data-bind=""></div>');
                    cell_p_quantity.append(quantity_form);
 // 数量变化
                    var a3 = $('<a  class="decrement" clstag="clickcart|keycount|xincart|diminish1" id="decrement" ></a>');
                    a3.attr("href", "javascript:void(0);");
                    quantity_form.append(a3);
                    var input2 = $('<input type="text" class="quantity-text"  id="changeQuantity-11345721-1-1-0">');
                    a3.text("-");
                    input2.attr("itemPrice", i.item.price);
                    input2.attr("itemId", i.item.id);
                    input2.attr("value", i.itemNum);
                    quantity_form.append(input2);
                    var a4 = $('<a href="javascript:void(0);" class="increment" clstag="clickcart|keycount|xincart|add1" id="increment"></a>')
                    a4.attr("href", "javascript:void(0);");
                    a4.text("+");
                    quantity_form.append(a4);
//删除
                    var cell_p_remove = $('<div class="cell p-remove"></div>');
                    var a5 = $('<a id="remove-11345721-1" data-more="removed-87.20-1" clstag="clickcart|keycount|xincart|btndel318558" class="cart-rem" ></a>')
                    a5.attr("href",  "javascript:void(0);");
                    a5.attr("itemId",i.item.id);
                    a5.text("删除");
                    cell_p_remove.append(a5);

                    cell_p_goods.append(p_img)
                        .append(p_name);
                    cell_p_quantity.append(quantity_form);
                    product_list.append(product_item).append(item_form);
                    product_item.append(item_form);
                    item_form.append(cell_p_checkbox)
                        .append(cell_p_goods)
                        .append(cell_p_price)
                        .append(cell_p_promotion)
                        .append(cell_p_inventory_stock_11345721)
                        .append(cell_p_quantity)
                        .append(cell_p_remove);

                    total_price_cart = total_price_cart + (i.item.price) * (i.itemNum);

                }

                // var cart_toolbar_clearfix = $('#cart_toolbar_clearfix');
                // var total_fr = $('<div class="total fr"></div>');
                // cart_toolbar_clearfix.append(total_fr);
                // var p1 = $('<p></p>');
                // p1.text("总计");
                // var span3 = $('<span class="totalSkuPrice"></span>');
                // p1.append(span3);
                // span3.text("¥"+" "+total_price_cart);
                // total_fr.append(p1);
                // var p2 = $('<p></p>');
                // p2.text("优惠");
                // var span4 = $('<span id="totalRePrice"></span>');
                // span4.text("- ¥10.00");
                // p2.append(span4);
                // total_fr.append(p2);
                // var amout_fr = $('<div class="amout fr"></div>');
                // amout_fr.text("件商品");
                // cart_toolbar_clearfix.append(amout_fr);
                // var span5 = $('<span id="selectedCount"></span>');
                // span5.text(1);
                // var ui_ceilinglamp_1 = $('#ui_ceilinglamp_1');
                // var cart_dibu_ui_ceilinglamp_current = $('<div class="cart-dibu ui-ceilinglamp-current" style="width: 988px; height: 49px;"></div>')
                // ui_ceilinglamp_1.append(cart_dibu_ui_ceilinglamp_current);
                // var control_fdibu_fdibucurrent = $('<div class="control fdibu fdibucurrent"></div>')
                // cart_dibu_ui_ceilinglamp_current.append(control_fdibu_fdibucurrent);
                // var span6 = $('<span class="column t-checkbox form"></span>');
                // control_fdibu_fdibucurrent.append(span6);
                // var input3 = $('<input data-cart="toggle-cb" name="toggle-checkboxes" id="toggle-checkboxes_down" type="checkbox" checked="" value="" class="jdcheckbox">');
                // span6.append(input3);
                // var label1 = $('<label for="toggle-checkboxes_down"></label>');
                // span6.append(label1);
                // var span7 = $('<span class="delete"></span>');
                // control_fdibu_fdibucurrent.append(span7);
                // var b1 = $('<b></b>');
                // span7.append(b1);
                // var a6 = $('<a href="javascript:void(0);" clstag="clickcart|keycount|xincart|clearcartlink" id="remove-batch"></a>');
                // span7.append(a6);
                // a6.text("删除选中的商品");
                // var span8 = $('<span class="shopping"></span>');
                // control_fdibu_fdibucurrent.append(span8);
                // var b2 = $('<b></b>');
                // span8.append(b2);
                // var a7 = $('<a href="/" target="_blank" clstag="clickcart|keycount|xincart|coudanlink" id="continue"></a>');
                // a7.text("继续购物");
                // span8.append(a7);
                // var cart_total_2014 = $('<div class="cart-total-2014"></div>');
                // cart_dibu_ui_ceilinglamp_current.append(cart_total_2014);
                // var cart_button = $('<div class="cart-button"></div>');
                // cart_total_2014.append(cart_button);
                // var span9 = $('<span class="check-comm-btns" id="checkout-jd"></span>');
                // cart_button.append(span9);
                // var a8 = $('<a class="checkout" href="../order-cart.html" clstag="clickcart|keycount|xincart|gotoOrderInfo" id="toSettlement"></a>');
                // a8.text("去结算");
                // span9.append(a8);
                // var span10 = $('<span class="combine-btns" style="display:none"></span>');
                // cart_button.append(span10);
                // var span11 = $('<span class="fore1" style="display: none;"></span>');
                // span10.append(span11);
                // var a9 = $('<a href="#" class="combine-btn"></a>');
                // span11.append(a9);
                // a9.text("不支持合并付款");
                // var span12 = $('<span class="fore2 hide" style="display: inline;"></span>')
                // span10.append(span12);
                // var a10 = $('<a href="javascript:goToOverseaOrder();" class="checkout-jdInt"></a>')
                // span12.append(a10);
                // a10.text('<b></b>' + "请到shop国际结算");
                // var a11 = $('<a> href="javascript:goToOrder();" class="checkout-jd"</a>')
                // span12.append(a11);
                // a11.text('<b></b>' + "请到shop结算");
                // var total_fr2 = $('<div class="total fr"></div>');
                // cart_total_2014.append(total_fr2);
                // total_fr2.text("总计（不含运费）：");
                // var span13 = $('<span class="totalSkuPrice"></span>');
                // total_fr2.append(span13);
                //
                // total_price_cart_preferential = total_price_cart - 10;
                //
                // span13.text("¥" +" "+ total_price_cart_preferential);
            }
        });


    $('.cart-rem').click(function (e) {
        e.preventDefault();
        let itemId= $(this).attr("itemId");
        params = {
            itemId:itemId,
            userId :23
        };
        console.log("好使");
        $.get("http://localhost:8770/cart/delete",params,function () {
                window.location.reload();
        })
    });



});
