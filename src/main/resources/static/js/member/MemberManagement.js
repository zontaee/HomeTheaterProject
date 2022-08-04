function updateMember(Vindex){
	var memberId = $("#memberId" + Vindex).val();
	var memberName = $("#memberName" + Vindex).val();
	var memberPhonenumber = $("#memberPhonenumber" + Vindex).val();
	var memberAddress = $("#memberAddress" + Vindex).val();
	var memberEmail = $("#memberEmail" + Vindex).val();
	var m_point = $("#m_point" + Vindex).val();
	$.ajax({
		url: "adminUpdateMember",
		type: "POST",
		data: {
			"memberId": memberId,
			"memberName": memberName,
			"memberPhonenumber": memberPhonenumber,
			"memberAddress": memberAddress,
			"memberEmail": memberEmail,
			"m_point": m_point
		},
		success: function(update){
			alert("회원수정이 완료되었습니다.");
			location.href="memberList";
		}
	})
}
function deleteMember(Vindex){
	var memberId = $("#memberId" + Vindex).val();
	$.ajax({
		url: "adminDeleteMember",
		type: "GET",
		data: {
			"memberId": memberId
		},
		success: function(){
			alert("회원삭제가 완료되었습니다.");
			location.href="memberList";
		}
	})
}