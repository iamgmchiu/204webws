$(function() {

	$('.btn-intvDelete').click(function() {
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
					location.href = `./InterViewServletDS?DeleteId=${$(this).val()}`;
				}, 1500)
			}
		})
	})
	
	$('.btn-intvUpdate').click(function() {
		location.href = `./InterViewServletDS?UpdateId=${$(this).val()}`;
	})
	
	
	$('#btn-submit').click(function() {
		let warningStr = "";
		let checkInterviewForm = true;


		let postDate = new Date($("#intTime").val());
		let nowDate = new Date();
		if (postDate > nowDate) {
			warningStr += "刊登開始日期不可於刊登結束日期之後" + "<br>";
			checkInterviewForm = false;

		}

		let userID = /^[A-Z]{1}[1-2]{1}\d{8}$/;
		if (!userID.test($("#userId").val())) {
			warningStr += "身分證格式錯誤!" + "<br>";
			checkInterviewForm = false;

		} if (checkInterviewForm) {
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
