// 우편번호 찾기 화면을 넣을 element
var element_layer = null;
	element_layer=document.getElementById('layer');
var btn = document.getElementById('btnCloseLayer');

$(document).ready(function() {
	$(element_layer).css('display','none')
	$(element_layer).css('position','fixed')
	$(element_layer).css('overflow','hidden')
	$(element_layer).css('z-index','1')
	$(element_layer).css('-webkit-overflow-scrolling','touch')
	
	$(btn).css('cursor','pointer')
	$(btn).css('position','absolute')
	$(btn).css('right','-3px')
	$(btn).css('top','-3px')
	$(btn).css('z-index','1')
});

function closeDaumPostcode() {
    // iframe을 넣은 element를 안보이게 한다.
    element_layer.style.display = 'none';
    if($('#address').val()=='' && customer!=null){
    	$('#addr1').attr('class','col-lg-12')
		$('#address').attr('id','customerAddr')
		$('#addr2').empty()
		$('#customerAddr').val(customer.customerAddr)
    }
}

function DaumPostcode() {
	$('#addr1').attr('class','col-lg-6')
	$('#customerAddr').attr('id','address')
	if(!$('#addr2').find("#detailAddress").length){
		$('#addr2').append('<input class="form-control" type="text" name="addr2" id="detailAddress" placeholder="상세주소"><br>')
	}
	$('#address').val('')
	$('#detailAddress').val('')
	new daum.Postcode({
        oncomplete: function(data) {
        	  // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('customerPost').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
            
            // iframe을 넣은 element를 안보이게 한다.
            // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
            element_layer.style.display = 'none';
        },
        width : '100%',
        height : '100%',
        maxSuggestItems : 5
    }).embed(element_layer);

    // iframe을 넣은 element를 보이게 한다.
    element_layer.style.display = 'block';

    // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
    initLayerPosition();
}

// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
var width = 350; //우편번호서비스가 들어갈 element의 width
var height = 400; //우편번호서비스가 들어갈 element의 height
var borderWidth = 5; //샘플에서 사용하는 border의 두께

element_layer.style.width = width + 'px';
element_layer.style.height = height + 'px';
element_layer.style.border = borderWidth + 'px solid';
function initLayerPosition(){

    // 위에서 선언한 값들을 실제 element에 넣는다.
    // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
    element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
    element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
}

// 화면 크기 변화시 따라서 레이어 창 이동
window.addEventListener('resize', function() {
	element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
	element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
}, true);