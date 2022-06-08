function checkForm() {
    let checkResult = true;

    let compIdRegex = /^\d{8}$/;
    if (!compIdRegex.test($("#compId").val())) {
        alert("刊登公司統編為8位數字");
        checkResult = false;
        return checkResult;
    }

    let priceRegex = /^\d+$/;
    if (!priceRegex.test($("#price").val())) {
        alert("價格只能輸入有效數字");
        checkResult = false;
        return checkResult;
    }

    let postStartDate = new Date($("#postStart").val());
    let postEndDate = new Date($("#postEnd").val());
    if (postStartDate > postEndDate) {
        alert("刊登開始日期不可於刊登結束日期之後");
        checkResult = false;
        return checkResult;
    }

    return checkResult;
}


$('#wrongInput').click(function () {
    $('#compId').val('1234567A')
    $('#price').val('500W')
    $('#eventLinkURL').val('https://www.google.com.tw/')
    $('#postStart').val('2022-05-20')
    $('#postEnd').val('2022-05-15')
})

$('#correctInput').click(function () {
    $('#compId').val('12345678')
    $('#price').val('500')
    $('#eventLinkURL').val('https://www.google.com.tw/')
    $('#postStart').val('2022-05-15')
    $('#postEnd').val('2022-05-20')
})

