$(document).ready(function() {
	if(customer!=null){
		$('#customerName').val(customer.customerName)
		$('#customerName').attr('readonly','true')
		$('#customerBirth').val(customer.customerBirth)
		$('#customerBirth').attr('readonly','true')
		$("input:radio[name='customerGender']:radio[value='"+customer.customerGender+"']").attr("checked",true)
		$("input:radio[name='customerGender']").attr('onclick','return(false)')
		$('#customerPhoneInput').val(customer.customerPhone)
		$("#customerPhoneInput").attr('id','customerPhone')
		$('#customerPost').val(customer.customerPost)
		$('#address').val(customer.customerAddr)
		$('#address').val(customer.customerAddr)
		$('#addr1').attr('class','col-lg-12')
		$('#address').attr('id','customerAddr')
		$('#addr2').empty()
		$('#memo').append('<div class="col-lg-12"><input class="form-control" type="text" name="customerMemo" id="customerMemo" placeholder="메모"></div>')
		$('#customerMemo').val(customer.customerMemo)
	}
});