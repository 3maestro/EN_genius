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
		$('#post').val(customer.customerPost)
		$('#address').val(customer.customerAddr)
		$('#addr1').attr('class','col-lg-12')
		$('#addr2').css('display','none')
		$('#memo').append('<div class="col-lg-12"><input class="form-control" type="text" name="customerMemo" id="customerMemo" placeholder="메모"></div>')
		$('#customerMemo').val(customer.customerMemo)
	}
	
	$('.post').click(function(){
		$('#post').val('');
		$('#addr1').attr('class','col-lg-6')
		$('#address').val('');
		$('#addr2').css('display','block')
	})
	
	$('#btnCloseLayer').click(function(){
		if($('#address').val()==''){
			$('#addr1').attr('class','col-lg-12')
			$('#post').val(customer.customerPost)
			$('#address').val(customer.customerAddr);
			$('#addr2').css('display','none')
		}
	})
});