var xmlRequest;

function getXMLHttpRequestObject() {
		//不同的浏览器创建方式不同
		try {
			xmlRequest = new XMLHttpRequest(); //Firefox ,safari
		} catch (e) {
			//IE
			try {
				xmlRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlRequest;//返回
	}

function callAPI(action) {
	xmlRequest = getXMLHttpRequestObject();
	var url="bpm/case"
	if (action == "caseStart"){
		alert(action);
		if (xmlRequest == null) {
			alert("您的浏览器不支持AJAX!");
			return;
		}
		xmlRequest.open("GET",url,);
		xmlRequest.onreadystatechange = callBack;
			
	}
	else if (action == "lock"){
		alert(action);
		
		
	}
	else if (action == "release"){
		alert(action);
	}
	
	
	
}