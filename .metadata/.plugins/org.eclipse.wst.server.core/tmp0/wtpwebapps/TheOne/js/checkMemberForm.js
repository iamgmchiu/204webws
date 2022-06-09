function checkMemberForm() {
    let checkResult = true;

   let IdRegex = /^[a-z,A-Z][1-2,8-9]\d{8}$/; 
    if (!IdRegex.test($("#userid").val())) {
		console.log($("#userid").val())
        alert("請輸入正確身分證字號");
        checkResult = false;
        return checkResult;
    }

    let pointRegex = /^\d+$/; 
    if (!pointRegex.test($("#point").val())) {
        alert("會員點數只能輸入阿拉伯整數");
        checkResult = false;
        return checkResult;
    }

	return checkResult;

 }   


$('#wrongInput').click(function () {
    $('#userid').val('33A2345678')
    $('#point').val('三百點')
})

$('#correctInput').click(function () {
    $('#userid').val('Z123456789')
    $('#pwd').val('abc123zzz')
    $('#username').val('唐洋基')
    $('#gender').val('男')
    $('#birth').val('2022-05-20')
    $('#tele').val('02-87654321')
    $('#phone').val('0910654321')
    $('#address').val('台東縣蘭嶼鄉25號')
    $('#email').val('hiremeplz@gmail.com')
    $('#point').val('300')
})
