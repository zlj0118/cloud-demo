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
                // var total_price_cart_preferential =0;
                var product_list = $('#product-list');
                product_list.empty();
                for (let i of resp.data) {
                    var product_item = $('<div id="product_item" data-bind="rowid:1" class="item item_selected " style=" background:#ff9900; color:#7bb1f1"></div>');
                    var item_form = $('<div class="item_form clearfix"></div>');
                    var cell_p_checkbox = $('<div class="cell p-checkbox"></div>');
                    var input1 = $('<input data-bind="cbid:1" class="checkbox" type="checkbox" name="checkItem">');
                    input1.attr("value",i.item.id);
                    input1.attr("itemNum",i.itemNum);
                    cell_p_checkbox.append(input1);
                    var cell_p_goods = $('<div class="cell p-goods"></div>');
                    var p_img = $('<div class="p-img"></div>');
                    var a1 = $('<a target="_blank"></a>');
                    a1.attr("href", "/item/" + i.item.id);
                    var image1 = $('<image  clstag="clickcart|keycount|xincart|p-imglistcart" width="52" height="52">');
                    image1.attr("src",  i.item.image);
                    // console.log(i.item.image);
                    image1.attr("alt", i.item.title);
                    p_img.append(image1);
                    var p_name = $('<div class="p-name"></div>');
                    var a2 = $('<a  clstag="clickcart|keycount|xincart|productnamelink" target="_blank" class="goodContent"></a>');
                    a2.attr("href", "javascript:void(0);");
                    a2.text(i.item.title);
                    a2.attr("itemId",i.item.id);
                    var span1 = $('<span class="promise411 promise411_11345721" id="promise411_11345721"></span>');
                    p_name.append(a2);
                    p_name.append(span1);

                    var cell_p_price = $('<div class="cell p-price"></div>');
                    var span2 = $('<span class="price" ></span>');
                    span2.text("¥" + " " + i.item.price/100);
                    cell_p_price.append(span2);
                    var cell_p_promotion = $('<div class="cell p-promotion" style="text-align: center; line-height: 52px ;color:greenyellow ;"></div>');
                    if(i.item.price>100000){
                    cell_p_promotion.text(i.item.price*0.2*i.itemNum/100);
                    }else {
                        cell_p_promotion.text(0)
                    }
                    // let discount = $("font").text(i.item.price*0.2);
                    // discount1 += discount;
                    // $("font").text(discount1);
                    var cell_p_inventory_stock_11345721 = $('<div class="cell p-inventory stock-11345721"></div>');
                    if(i.item.num>i.itemNum){
                    cell_p_inventory_stock_11345721.text("有货");
                    }else {
                        cell_p_inventory_stock_11345721.text("库存不足");
                    }
                    var cell_p_quantity = $('<div class="cell p-quantity" for-stock="for-stock-11345721"></div>');
                    var quantity_form = $('<div class="quantity-form" data-bind=""></div>');
                    cell_p_quantity.append(quantity_form);
 // 数量变化
                    var a3 = $('<a  class="decrement" clstag="clickcart|keycount|xincart|diminish1" id="decrement" ></a>');
                    a3.attr("href", "javascript:void(0);");
                    quantity_form.append(a3);
                    var input2 = $('<input type="text" class="quantity-text"  id="changeQuantity-11345721-1-1-0">');
                    a3.text("-");
                    input2.attr("itemPrice", i.item.price/100);
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

            }
        });
    $('.cart-rem').click(function (e) {
        e.preventDefault();
        let itemId= $(this).attr("itemId");
        params = {
            itemId:itemId,
            userId :23
        };
        // console.log("好使");
        $.get("http://localhost:8770/cart/delete",params,function () {
                window.location.reload();
        })
    });
  $('.checkbox').click(function (e) {
      console.log(e);
      TTCart.refreshTotalPrice();
  });
    $('.goodContent').click(function () {
        let  itemId= $(this).attr("itemId");
        window.localStorage.setItem("itemId",itemId);
        window.location.href="/cart/item.html";
    });



});
