<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
		//버튼 클릭하면 함수호출...
		$('#asynchro').click(function(){
			//비동기 시작..
			$.ajax({
				//요청
				type:'get',
				url:'asynch',
				
				//응답
				success:function(data){ //객체 단위로 데이타를 받아옴(JSON)
					//alert(data);
				     var jsonData=JSON.parse(data);
				     //alert(jsonData);
				     $('#jsonView').html("<h3><font color=tomato>"+jsonData.person.name+
				    		             "님이 사는 곳은 "+jsonData.person.address+" !!</font></h3>");
				}//callback
			});//ajax
		});//click
	});
</script>
</head>
<body>
<h3>${info}</h3>
<p></p>
<hr>
<p></p>
<input type="button" value="비동기통신 시작하기" id="asynchro">
<span id="jsonView"></span>
</body>
</html>














