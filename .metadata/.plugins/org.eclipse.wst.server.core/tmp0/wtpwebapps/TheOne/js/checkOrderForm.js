function checkOrderForm() {
    let checkResult = true;

      let IdRegex = /^[a-z,A-Z]{1}[1-2,8-9]{1}\d{8}$/; 
    if (!IdRegex.test($("#userId").val())) {
			Swal.fire(
  				'格式錯誤',
  				'請輸入正確身分證字號',
  				'error'
			)
        checkResult = false;
        return checkResult;
    }

    let priceRegex = /^\d*$/;
    if (!priceRegex.test($("#totalPrice").val())) {
		Swal.fire(
  				'格式錯誤',
  				'總價只能輸入有效數字',
  				'error'
			)
        checkResult = false;
        return checkResult;
    }  
    
    return checkResult;
}


$('#OrderwrongInput').click(function () {
    $('#userId').val('12A345675')
    $('#orderDate').val('2022-05-20')
    $("#state").val(2);
    $('#productId').val('1,2,3,4')
    $('#totalPrice').val('6666K')
})

$('#OrdercorrectInput').click(function () {
    $('#userId').val('J123456789')
    $('#orderDate').val('2022-05-23')
    $("#state").val(1); 
    $('#productId').val('1,2,3,4,5')
    $('#totalPrice').val('86000')
})

