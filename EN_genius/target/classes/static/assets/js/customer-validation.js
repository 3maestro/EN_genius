$(document).ready(function() {
	$('#detailAddress').change(function() {
		if($('#customerPost').val()==''){
			$('#detailAddress').val('');
			alert('우편번호를 먼저 입력해주세요.');
		}
	});

	var phoneRegex = /^([0-9]{11})$/;
	
	$('#customerPhoneInput').change(function() {
		if(!phoneRegex.test($("#customerPhoneInput").val())) {
			alert('숫자 11자리를 입력해주세요.');
			$("#customerPhoneInput").focus();
		}else{
			$("#customerPhoneInput").val($("#customerPhoneInput").val().replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3'));
			$("#customerPhoneInput").attr('id','customerPhone')
		}
	});
	
	$(document).on('click','#customerPhone',function() {
		console.log($("#customerPhone").val())
		$("#customerPhone").val($("#customerPhone").val().replace(/-/g, ''));
		$("#customerPhone").attr('id','customerPhoneInput')
	})
	
	$('#Registration-submit').click(function(e) {
		e.preventDefault();
		
		if ($("#customerName").val() == '') {
			alert('고객명을 입력해주세요.');
			$("#customerName").focus();
			return false;
		}else if ($("#customerBirth").val() == '') {
			alert('고객생일을 입력해주세요.');
			$("#customerBirth").focus();
			return false;
		}else if ($("input:radio[name='customerGender']").is(":checked") == false) {
			alert('고객성별을 입력해주세요.');
			$("[name='customerGender']").focus();
			return false;
		}else if (!$("#customerPhoneInput").val() == '') {
			alert('고객연락처을 제대로 입력해주세요.');
			$("#customerPhoneInput").focus();
			return false;
		}else if ($("#detailAddress").val() == '') {
			alert('주소를 입력해주세요.');
			return false;
		}else {
			var request = $.ajax({
				url : '/customerInsertAjax',
				method : "POST",
				data : {name:$("#customerName").val(),birth:$("#customerBirth").val(),phone:$("#customerPhone").val()},
				dataType : "text"
			});

			request.done(function(data) {
				console.log(data)
				if(data=='미가입'){
					var addr1 = document.getElementById('address').value;
					var addr2 = document.getElementById('detailAddress').value;
					$("<input type='hidden' name='customerAddr' value='"+addr1+" "+addr2+"'>").appendTo("form");
					$('#form').attr('action','/customerInsert');
					$('#form').submit();
				}else{
					alert("이미 가입된 고객입니다.");
					return false;
				}
			});

			request.fail(function(jqXHR, textStatus) {
				alert("검색 실패!")
			})
		}
	});
});