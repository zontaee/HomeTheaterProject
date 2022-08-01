function updateMember(Vindex){
	var m_id = $("#m_id" + Vindex).val();
	var m_name = $("#m_name" + Vindex).val();
	var m_phonenumber = $("#m_phonenumber" + Vindex).val();
	var m_address = $("#m_address" + Vindex).val();
	var m_email = $("#m_email" + Vindex).val();
	var m_point = $("#m_point" + Vindex).val();
	$.ajax({
		url: "adminUpdateMember",
		type: "POST",
		data: {
			"m_id": m_id,
			"m_name": m_name,
			"m_phonenumber": m_phonenumber,
			"m_address": m_address,
			"m_email": m_email,
			"m_point": m_point
		},
		success: function(update){
			alert("회원수정이 완료되었습니다.");
			location.href="memberList";
		}
	})
}
function deleteMember(Vindex){
	var m_id = $("#m_id" + Vindex).val();
	$.ajax({
		url: "adminDeleteMember",
		type: "GET",
		data: {
			"m_id": m_id
		},
		success: function(){
			alert("회원삭제가 완료되었습니다.");
			location.href="memberList";
		}
	})
}