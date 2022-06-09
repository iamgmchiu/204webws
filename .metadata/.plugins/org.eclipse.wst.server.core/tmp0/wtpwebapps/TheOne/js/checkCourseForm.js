//DataTable
$(document).ready(function() {
	$('#table_id').DataTable(
		{
			columnDefs: [
				{ orderable: false, targets: 7 }
			]
		}
	)
});

//form check
function checkCourseForm() {
	let checkResult = true;

	let scoreRegex = /^[\d.]+$/;
	//let scoreRegex = /[0-9]+(.[0-9])/; 
	if (!scoreRegex.test($("#score").val())) {
		Swal.fire({
			title: '提示!',
			text: "\"評分\"只能輸入有效數字(0.0 ~ 9.9)",
			icon: 'warning',
		})
		checkResult = false;
		return checkResult;
	}

	let score = $("#score").val();
	if (score >= 10) {
		Swal.fire({
			title: '提示!',
			text: "\"評分\"只能輸入有效數字(0.0 ~ 9.9)，需小於10",
			icon: 'warning',
		})
		checkResult = false;
	}
    
	let priceRegex = /^\d+$/;
	if (!priceRegex.test($("#price").val())) {
		Swal.fire({
			title: '提示!',
			text: "\"價格\"只能輸入有效數字",
			icon: 'warning',
		})
		checkResult = false;
		return checkResult;
	}

	let postDate = new Date($("#date").val());
	let nowDate = new Date();
	if (postDate < nowDate) {
		Swal.fire({
			title: '提示!',
			text: "\"上架日期\"不可在今日之前",
			icon: 'warning',
		})
        checkResult = false;
    }
	return checkResult;
 } 
 
 //圖片上傳同步顯示
$("#imgInput").change(function() {
	readURL(this);
});

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#preview_img").attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

//一鍵輸入
$('#correctInput').click(function () {
    $('#courseName').val('面試必勝10招')
    $('#courseCategory').val('求職技巧')
    $('#courseIntroduction').val('畢業季將近，即將踏入社會的準畢業生們開始尋找自己未來的出路，積極查找各種工作資訊，許多公司也紛紛開出職缺，想趁著畢業求職潮廣招人才。面對各種夢幻職缺，你知道企業面試官們最在意哪些地方嗎？')
    $('#lecturer').val('王大陸')
    $('#date').val('2022-08-01')
    $('#coursePic').val('url')
    $('#courseVedio').val('url')
    $('#score').val('9.9')
    $('#price').val('1999')
})
