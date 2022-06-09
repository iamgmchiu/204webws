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
	
	
	$('.btn-intvsubmit').click(function() {
		let warningStr = "";
		let checkInterviewForm = true;


		let postDate = new Date($("#intTime").val());
		let nowDate = new Date();
		if (postDate > nowDate) {
			warningStr += "刊登開始日期不可於刊登結束日期之後" + "<br>";
			checkInterviewForm = false;

		}

		
		if (checkInterviewForm) {
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
						$('#intvForm').submit();
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
