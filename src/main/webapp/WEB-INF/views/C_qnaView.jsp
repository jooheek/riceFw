<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  
  

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        <a href="/qna/list">Q&A 게시판</a>
        <small>과목명</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 마이페이지</a></li>
        <li><a href="#">과목명</a></li>
        <li class="active">Q&A 게시판 </li>
      </ol>
    </section>

     <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <div class="box box-info">
            <div class="box-header">
              <h3 class="box-title">글보기
                <small>과목명</small>
              </h3>
            </div>
            <!-- /.box-header -->
			<div class="box-body">
              <!-- boNum -->
              <div class ="form-group">
            	<form name="readForm" role="form" method="post">
              	<label>No.</label>
              	<input class ="form-control" id='boNum'name ='boNum' value ="${read.boNum}" readonly="readonly"/>
              	</form>
              </div>
              <!-- boTitle -->
              <div class="form-group">
                  <label>제목</label>
                  <input class="form-control" id="boTitle" name ="boTitle" value ="${read.boTitle}"readonly ="readonly"/>
              </div>
           		<!-- boContent -->
                <div class="form-group">
                  <label>내용</label>
                  <textarea class="form-control" style="resize: none;"rows="3" id='boContent' name ='boContent' readonly="readonly"><c:out value ="${read.boContent}"/></textarea>
                </div>
				<!--memNum-->
				<div class ="form-group">
             	 	<label>작성자</label>
              		<input class ="form-control"id="memNum" name ="memNum" value ="${read.memNum}" readonly="readonly"/>
              	</div>
              	
              	<div>파일목록</div>
              	<div class ="form-group" style="border :1px solid #bdbdbd;">
					<c:forEach var ="file" items="${file}">
						<a href="#" onclick="fn_fileDown('${file.CLASSFILENUM}'); return false;">${file.FILENAME}</a>(${file.FILESIZE}kb)<br>
					</c:forEach>
              	</div>
	       	    <!-- /.box-body --> 
	       	    <div> 
                	<button data-oper="modify" class="btn btn-primary updateBtn">수정</button>
                   	<button data-oper="delete" class="btn btn-warning deleteBtn">삭제</button>
                    <button data-oper="list" class="btn btn-default listBtn">뒤로가기</button>
                </div>  	
               <!-- /.box-footer -->
               </div>	
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col-->
      </div>
     </section>
    </div>
   <!-- ./row -->
  <!-- /.content -->
  
 
 <form id="readForm" role="form" method="post">
 	<input type='hidden' id='boNum' name="boNum" value='<c:out value="${list.boNum}"/>'>
	<input type='hidden' name='page' value='<c:out value="${cri.page}"/>'>
	<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
	<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
	<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
	<input type='hidden' id="classfileNum" name='classfileNum' value="">
</form>   
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj =$("form[name='readForm']");
		
		//modify
		$(".updateBtn").on("click",function(){
			formObj.attr("action","/mypage/board/qna/modifyView");
			formObj.attr("method","post");
			formObj.submit();
		})
		//delete
		$(".deleteBtn").on("click",function(){
			var deleteYN = confirm("삭제하시겠습니까?");
			
			if(deleteYN == true){			
				formObj.attr("action","/mypage/board/qna/delete");
				formObj.attr("method","post");
				formObj.submit();
			}
		})
		//list
		$(".listBtn").on("click",function(){
			/* formObj.attr("action","/mypage/board/qna/list").attr("method","get"); */
			
			/* history.replaceState({}, null, location.pathname); */
			history.go(-1);
			
			location.href="/qna/list?page=${cri.page}"
						+"&amount=${cri.amount}"
						+"&type=${cri.type}&keyword=${cri.keyword}";
			/* var pageTag=$("input[name='page']").clone();
			var amountTag=$("input[name='amount']").clone();
			var keywordTag=$("input[name='keyword']").clone();
			var typeTag=$("input[name='type']").clone();
						
			formObj.empty();
			formObj.append(pageTag);
			formObj.append(amountTag);
			formObj.append(keywordTag);
			formObj.append(typeTag);
			
			formObj.submit(); */
		})
	});
	
	function fn_fileDown(fileno){
		var formObj=$("form[name='readForm']");
		
		$("#classfileNum").attr("value",fileno);
		formObj.attr("action","/mypage/board/fileDown");
		formObj.submit();
	}
</script>
<%@ include file = "footer.jsp" %>
</body>
</html>
