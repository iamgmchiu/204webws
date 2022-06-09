//Form rule
$(function () {

	$('#form').validate({
		rules: {
			user: {
				required: true,
			},

			user_id: {
				required: true,
			},
			job_name: {
				required: true,
			},
			job_description: {
				required: true,
			},
			std_hour: {
				required: true,
				number: true,
				range: [0, 24],
			},
			real_hour: {
				required: true,
				number: true,
				range: [0, 24],
			},
			over_freq: {
				required: true,
				digits: true,
				range: [0, 7],
			},
			seniority: {
				required: true,
				number: true,
				range: [0, 100],
			},
			total_seniority: {
				required: true,
				number: true,
				range: [0, 100],
			},
			monthly_salary: {
				required: true,
				digits: true,
				min: 0,
			},
			yearly_salary: {
				required: true,
				number: true,
				min: 0,
			},
			bonus_count: {
				required: true,
				digits: true,
				min: 0,
			},
		},
		messages: {
			job_description: {
				required: '請選擇類別',
			},
			monthly_salary: {
				digits: '請輸入大於0的整數',
			},
		},
	})

})

//Star rating js
$.raty.path = 'img';

$(function () {

	$('#compScore').raty({
		targetScore: '#comp_score',
	});

	$('#jobScore').raty({
		targetScore: '#job_score',
	});

	$('#oneInput').raty({
		score: 5
	});

	$('td.listComp').raty({
		readOnly: true,
		starOff: 'star-off-small.png',
		starOn: 'star-on-small.png'
	});

	$('td.listJob').raty({
		readOnly: true,
		starOff: 'star-off-small.png',
		starOn: 'star-on-small.png'
	});

	$('#confirmJob').raty({
		readOnly: true
	});

	$('#confirmComp').raty({
		readOnly: true
	});
})


//One key input js
$('#OneInput').click(function () {
	$('#user_id').val('A123456789')
	$('#comp_name').val('狗來富寵物廣場')
	//$(':input #comp_score').val('5');
	//$('#compScore').attr('data-score', '5')

	$('#job_name').val('美容師')
	$('#job_description option[value="全職"]').attr('selected', 'selected')
	$('#user_id').show()
	$('#user').attr('checked', 'checked')
	$('#std_hour').val('10')
	$('#real_hour').val('12')
	$('#over_freq').val('2')
	$('#seniority').val('5')
	$('#total_seniority').val('7')
	$('#seniority').val('5')
	$('#monthly_salary').val('40000')
	$('#yearly_salary').val('55')
	$('#bonus_count').val('2')
	$('#share').val('老闆親切，加班可報')
})

//anonymous/user show

$(function () {
	$('#anonymous').click(function () {
		$('#user_id').val('匿名');
		$('#user_id').hide();
	})

	$('#user').click(function () {
		$('#user_id').val('');
		$('#user_id').show();
	});

})



//DashBoard Search
$(function () {
	(function (document) {

		// 建立 LightTableFilter
		var LightTableFilter = (function (Arr) {

			var _input;

			// 資料輸入事件處理函數
			function _onInputEvent(e) {
				_input = e.target;
				var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
				Arr.forEach.call(tables, function (table) {
					Arr.forEach.call(table.tBodies, function (tbody) {
						Arr.forEach.call(tbody.rows, _filter);
					});
				});
			}

			// 資料篩選函數，顯示包含關鍵字的列，其餘隱藏
			function _filter(row) {
				var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
				row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
			}

			return {
				// 初始化函數
				init: function () {
					var inputs = document.getElementsByClassName('searchBar');
					Arr.forEach.call(inputs, function (input) {
						input.oninput = _onInputEvent;
					});
				}
			};
		})(Array.prototype);


		// 網頁載入完成後，啟動 LightTableFilter
		document.addEventListener('readystatechange', function () {
			if (document.readyState === 'complete') {
				LightTableFilter.init();
			}
		});

	})(document);
})

//Data Table
$(document).ready(function () {
	var table = $('#myTable').DataTable({
		//don't display search bar
		searching: false,
		//position of entire
		dom: '<"bottom"i>rt<"bottom"flp><"clear">',
		buttons: [
            {
                extend:    'copyHtml5',
                text:      '<i class="fa fa-files-o"></i>',
                titleAttr: 'Copy'
            },
            {
                extend:    'excelHtml5',
                text:      '<i class="fa fa-file-excel-o"></i>',
                titleAttr: 'Excel'
            },
            {
                extend:    'csvHtml5',
                text:      '<i class="fa fa-file-text-o"></i>',
                titleAttr: 'CSV'
            },
            {
                extend:    'pdfHtml5',
                text:      '<i class="fa fa-file-pdf-o"></i>',
                titleAttr: 'PDF'
            }
        ]
	});
	table.buttons().container()
		.appendTo('#example_wrapper .col-sm-6:eq(0)');
});
