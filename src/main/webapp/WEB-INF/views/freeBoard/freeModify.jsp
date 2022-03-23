<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form action="updateForm" method="post" name="updateForm">
                            <div>
                                <label>DATE</label>
                                <p><fmt:formatDate value="${bo.regdate }" pattern="yy년MM월dd일hh시mm분ss초"/></p>
                            </div>   
                            <!-- readonly는 폼전송시 값이 넘어감, disabled는 안넘어감 -->
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' readonly value="${vo.bno }">
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='writer' readonly value="${vo.writer }">
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${vo.title }">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content'>${vo.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-dark" onclick="location.href='freeList'">목록</button>    
                            <button type="button" class="btn btn-primary" onclick="updateHandler()">변경</button>
                            <button type="button" class="btn btn-info" onclick="deleteHandler()">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
        
        
        <script>
        	
        function updateHandler() {
			//document.폼이름.인풋이름   form의 input에 접근하는방법
			
			document.updateForm.action = "updateForm";
        	if(document.updateForm.writer.value == ''){
        		alert("작성자는 필수입니다");
        		document.updateForm.writer.focus();
        		return;
        	}else if(document.updateForm.title.value ==''){
        		alert("제목은 필수입니다");
        		document.updateForm.title.focus();
        		return;
        	} else if(document.updateForm.content.value ==''){
        		alert("내용은 필수입니다");
        		document.updateForm.content.focus();
        		return;
        	} else {
        		document.updateForm.submit();
        	}
		}
        	
        function deleteHandler() {
        	
        	document.updateForm.action = "deleteForm";  //액션값 변경
        	document.updateForm.submit();
        	
        	
        }
        </script>
      