$(function() {

	$('#eventWrongInput').click(function() {
		$('#compId').val('1234567A')
		$('#price').val('500W')
		$('#eventLinkURL').val('https://www.google.com.tw/')
		$('#postStart').val('2022-05-20')
		$('#postEnd').val('2022-05-15')
	})

	$('#eventCorrectInput').click(function() {
		$('#compId').val('12345678')
		$('#price').val('500')
		$('#eventLinkURL').val('https://www.google.com.tw/')
		$('#postStart').val('2022-05-15')
		$('#postEnd').val('2022-05-20')
	})

	$("#imgInp").change(function() {
		readURL(this);
	});
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview_progressbarTW_img").attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$('.btn-eventDelete').click(function() {
		Swal.fire({
			title: '確認是否刪除?',
			text: "刪除後將無法回復!",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '永久刪除',
			cancelButtonText: '取消'
		}).then((result) => {
			if (result.isConfirmed) {
				Swal.fire({
					icon: 'success',
					title: '已刪除!',
					showConfirmButton: false,
					timer: 1500
				})
				setTimeout(() => {
					location.href = `./EventsManager?DeleteId=${$(this).val()}`;
				}, 1500)
			}
		})
	})

	$('.btn-eventUpdate').click(function() {
		location.href = `./EventsManager?UpdateId=${$(this).val()}`;
	})

	$('#btn-submit').click(function() {
		let warningStr = "";
		let checkEventForm = true;

		let compIdRegex = /^\d{8}$/;
		if (!compIdRegex.test($("#compId").val())) {
			warningStr += "刊登公司統編為8位數字" + "<br>";
			checkEventForm = false;
		}

		let priceRegex = /^\d+$/;
		if (!priceRegex.test($("#price").val())) {
			warningStr += "價格只能輸入有效數字" + "<br>";
			checkEventForm = false;
		}

		if ($('#imgInp').val() == "" && $('#eventId').val() == 0) {
			warningStr += "請輸入廣告圖" + "<br>";
			checkEventForm = false;
		}

		if ($('#eventLinkURL').val() == "") {
			warningStr += "請輸入廣告連結" + "<br>";
			checkEventForm = false;
		}

		if ($('#postStart').val() == "" || $('#postEnd').val() == "") {
			warningStr += "請輸入日期" + "<br>";
			checkEventForm = false;
		}

		let postStartDate = new Date($("#postStart").val());
		let postEndDate = new Date($("#postEnd").val());
		if (postStartDate > postEndDate) {
			warningStr += "刊登開始日期不可於刊登結束日期之後" + "<br>";
			checkEventForm = false;
		}

		let confirmStr = '確認修改廣告?';
		if ($('#eventId').val() == 0) {
			confirmStr = '確認新增廣告?';
		}

		if (checkEventForm) {
			Swal.fire({
				title: confirmStr,
				text: "",
				icon: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: '確認',
				cancelButtonText: '取消'
			}).then((result) => {
				if (result.isConfirmed) {
					Swal.fire({
						icon: 'success',
						title: '已完成!',
						showConfirmButton: false,
						timer: 1500
					})
					setTimeout(() => {
						$('#form').submit();
					}, 1500)
				}
			})
		} else {
			Swal.fire({
				icon: 'error',
				title: '格式錯誤',
				html: warningStr,
			})
		}
	})

});

