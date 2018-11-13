var TTCart = {
	load : function(){ // 加载购物车数据
		
	},
	itemNumChange : function(){
		$(".increment").click(function(){//＋
			var _thisInput = $(this).siblings("input");
			_thisInput.val(eval(_thisInput.val()) + 1);
			$.get("http://localhost:8770/cart/update/num?"+"itemId="+_thisInput.attr("itemId")+"&itemNum="+_thisInput.val() ,function(data){
				TTCart.refreshTotalPrice();
			});
		});
		$(".decrement").click(function(){//-
			var _thisInput = $(this).siblings("input");
			if(eval(_thisInput.val()) == 1){
				return ;
			}
			_thisInput.val(eval(_thisInput.val()) - 1);
            $.get("http://localhost:8770/cart/update/num?"+"itemId="+_thisInput.attr("itemId")+"&itemNum="+_thisInput.val() ,function(data){

                TTCart.refreshTotalPrice();
			});
		});
		$(".quantity-text").rnumber(1);//限制只能输入数字
		$(".quantity-text").blur(function(){
			var _thisInput = $(this);
            console.log("==========itemId"+_thisInput.attr("itemId"));
            $.get("http://localhost:8770/cart/update/num?"+"itemId="+_thisInput.attr("itemId")+"&itemNum="+_thisInput.val() ,function(data){
                TTCart.refreshTotalPrice();
			});
		});
	},
	refreshTotalPrice : function(){ //重新计算总价
		var total = 0;
		$(".quantity-form .quantity-text").each(function(i,e){
			var _this = $(e);
			total += (eval(_this.attr("itemPrice")) * 10000 * eval(_this.val())) / 10000;
		});
		$(".totalSkuPrice").html(new Number(total).toFixed(2)).priceFormat({ //价格格式化插件
			 prefix: '￥',
			 thousandsSeparator: ',',
			 centsLimit: 2
		});
	}
};

$(function(){
	TTCart.load();
	TTCart.itemNumChange();

});