/**
 * 
 */
 function bookingCheck() {
	var check_in = document.getElementById("checkin_date").value;
	var check_out = document.getElementById("checkout_date").value;
	var room_no = document.getElementById("room_no").value;
	var cname = document.getElementById("name").value;
	var phone = document.getElementById("phone").value;
	var adult = document.getElementById("adult").value;
	
	if (check_in == "") {
		alert("체크인 날짜를 입력해 주세요.");
		document.getElementById("checkin_date").focus();
		return false;
	} else if (check_out == "") {
		alert("체크아웃 날짜를 입력해 주세요.");
		document.getElementById("checkout_date").focus();
		return false;
	} else if (room_no == "") {
		alert("객실번호를 선택해 주세요.");
		document.getElementById("room_no").focus();
		return false;
	} else if (cname == "") {
		alert("예약자명을 입력해 주세요.");
		document.getElementById("name").focus();
		return false;
	} else if (phone == "") {
		alert("연락처를 입력해 주세요.");
		document.getElementById("phone").focus();
		return false;
	} else if (adult == "") {
		alert("성인인원수를 입력해 주세요.");
		document.getElementById("adult").focus();
		return false;
	}
	
	return true;
}