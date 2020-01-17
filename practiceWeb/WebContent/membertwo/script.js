/**
 * 
 */
function idCheck(id){
	console.log("버튼 누름");
	url = "idCheck.jsp?id=" + id;
	//함수안에는 문자열이 들어가야 한다.
	window.open(url,"post","width=400,height=300");
}

function zipCheck(){
	url = "zipCheck.jsp";
	window.open(url,"post","width=400,height=300");
}

function dongCheck(dong){
	if(dong == ""){
		alert('동 이름을 입력하세요');
		document.zipForm.zip.focus();
		return false;
	}
	document.zipForm.submit();
}

function sendAddress(zip,sido,gugun,dong,ri,bunji){
	var address = sido + " " + gugun + " " + dong + " " + ri + " " + bunji;
	opener.document.regForm.zipcode.value = zip;
	opener.document.regForm.address1.value = address;
	self.close();
}

function inputCheck(){
	
	if(document.regForm.id.value ==""){
		alert('아이디를 입력하십시오');
		document.regForm.id.focus();
		return;
	}
	if(document.regForm.pass.value ==""){
		alert('비밀번호를 입력하십시오');
		document.regForm.pass.focus();
		return;
	}
	if(document.regForm.repass.value ==""){
		alert('비밀번호를 확인하십시오');
		document.regForm.repass.focus();
		return;
	}
	if(document.regForm.pass.value != document.regForm.repass.value){
		alert('비밀번호가 일치하지 않습니다');
		document.regForm.repass.focus();
		return;
	}
	if(document.regForm.name.value ==""){
		alert('이름을 입력하십시오');
		document.regForm.name.focus();
		return;
	}
	if(document.regForm.phone1.value ==""){
		alert('통신사를 선택하십시오');
		document.regForm.phone1.focus();
		return;
	}
	if(document.regForm.phone2.value ==""){
		alert('전화번호를 입력하십시오');
		document.regForm.phone2.focus();
		return;
	}
	if(document.regForm.phone3.value ==""){
		alert('전화번호를 입력하십시오');
		document.regForm.phone3.focus();
		return;
	}
	if(document.regForm.email.value ==""){
		alert('전화번호를 입력하십시오');
		document.regForm.email.focus();
		return;
	}
	if(document.regForm.zipcode.value ==""){
		alert('우편번호를 입력하십시오');
		document.regForm.zipcode.focus();
		return;
	}
	if(document.regForm.address1.value ==""){
		alert('주소를 입력하십시오');
		document.regForm.address1.focus();
		return;
	}
	if(document.regForm.address2.value ==""){
		alert('주소를 입력하십시오');
		document.regForm.address2.focus();
		return;
	}

	document.regForm.submit();
}

function modifyCheck(){
	
	document.modiForm.submit();
}