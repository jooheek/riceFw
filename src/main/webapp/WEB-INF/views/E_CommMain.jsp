<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>


<style>
.box-body {
	background-color: white;
}

.box-tools {
	margin: auto;
	display: flex;
}

.select {
	float: left;
}

.input-group {
	float: left;
	width: 170px;
}
</style>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>커뮤니티</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> 마이페이지</a></li>
			<li class="active">커뮤니티</li>
		</ol>
	</section>


	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-3">
				<!-- Main content -->
				<!-- general form elements -->
				<div class="box">
					<!-- box body -->
					<div class="box-body">
						<!-- top -->
						<form action="/comm/makecomm" method="get">
							<section>
								<div class="row">
									<div style="padding: 20px;">
										<input id='regBtn' type="submit"
											class="btn btn-block btn-primary" value="게시판 만들기">
									</div>
								</div>
							</section>
						</form>
						<!-- /top -->

						<!-- Main row -->
						<div>
							<div class="box">
								<div class="box-header with-border">
									<h3 class="box-title">반별 커뮤니티</h3>

									<div class="box-tools pull-right">
										<button type="button" class="btn btn-box-tool"
											data-widget="collapse">
											<i class="fa fa-minus"></i>
										</button>
									</div>
									<!-- /.box-tools -->
								</div>
								<!-- /.box-header -->
								<div class="box-body">
									<div class="col-md-12">

										<%-- <c:forEach var="listB" items='${listB}'>
											<tr>
												<div class="progress-group">
					                    		<a href="/comm/'${commurl}'">커뮤니티1</a> 
					                    		</div>
					                    	</tr>
										</c:forEach> --%>
										
										<div class="progress-group">
					                    		<a href="/comm/final">커뮤니티1</a> 
					                    </div>
										<!-- /.progress-group -->
									</div>
									<!-- /.col -->
								</div>
								<!-- /ROW -->
							</div>
							<!-- ./box-body -->
							<div class="box">
								<div class="box-header with-border">
									<h3 class="box-title">가입한 커뮤니티 목록</h3>

									<div class="box-tools pull-right">
										<button type="button" class="btn btn-box-tool"
											data-widget="collapse">
											<i class="fa fa-minus"></i>
										</button>
									</div>
									<!-- /.box-tools -->
								</div>
								<!-- /.box-header -->
								<div class="box-body">
									<div class="col-md-12">
										<div class="progress-group">
											<a href="#">커뮤니티1</a>
										</div>
										<!-- /.progress-group -->
										<div class="progress-group">
											<a href="#">커뮤니티2</a>
										</div>
										<!-- /.progress-group -->
										<div class="progress-group">
											<a href="#">커뮤니티3</a>
										</div>
										<!-- /.progress-group -->
										<div class="progress-group">
											<a href="#">커뮤니티4</a>
										</div>
										<!-- /.progress-group -->
									</div>
									<!-- /.col -->
								</div>
								<!-- /ROW -->
							</div>
							<!-- /.box-body -->
						</div>
					</div>
				</div>
			</div>
			<!-- tab& search -->
			<div class="col-md-9">
				<!-- Custom tabs (Charts with tabs)-->
				<!-- general form elements -->
				<div class="box">
					<!-- box body -->
					<div class="box-body">
						<!-- top -->
						<section>
							<!-- 	<div class="row"> -->
							<div class="box-tools pull-right" style="padding: 20px;">
								<form id='searchForm' action="/comm/searchcomm" method="get">
									<div class='select'>
										<select name='type' style="width: 100px; height: 30px;">
											<option value="TWCN"
												<c:out value="${pageMaker.cri.type eq 'TWCN'?'selected':''}"/>>전체</option>
											<option value="T"
												<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
											<option value="C"
												<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
											<option value="W"
												<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
											<option value="N"
												<c:out value="${pageMaker.cri.type eq 'N'?'selected':''}"/>>커뮤니티명</option>
										</select>
									</div>
									<!-- /select option -->
									<div class="input-group input-group-sm hidden-xs">
										<input type="text" name='keyword' class="form-control pull-right">
										<input type='hidden' name='page' value='${pageMaker.cri.page}'>
										<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
										<div class="input-group-btn">
											<button type="submit" class="btn btn-primary btn-flat">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div> 
								</form>
							</div>
							<!--       </div> -->
						</section>
						<!-- /top -->
						<div class="nav-tabs-custom">
							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-left">
								<li class="active"><a href="#popular" data-toggle="tab">최신글/인기글</a></li>
								<li><a href="#wholecomm" data-toggle="tab"
									style="width: 120px;">전체커뮤니티</a></li>
							</ul>
							<div class="tab-content padding">
								<!-- Morris chart - Sales -->
								<div class="chart tab-pane active" id="popular"
									style="position: relative; height: 300px;">
									<table id="example2" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th style="width: 60px;">글번호</th>
												<th>제목</th>
												<th style="width: 120px;">커뮤티니 명</th>
												<th style="width: 100px;">작성일자</th>
												<th style="width: 60px;">조회수</th>
												<th style="width: 80px;">좋아요수</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="commboardlist" items="${commboardlist}">
												<tr>
													<td><c:out value="${commboardlist.boNum}" /></td>
													<td><a
														href='/comm/viewwritings?boNum=<c:out value="${commboardlist.boNum}"/>'>
															<c:out value="${commboardlist.boTitle}" />
													</a></td>
													<td><c:out value="${commboardlist.memNum}" /></td>
													<td><c:out value="${commboardlist.boRegDate}" /></td>
													<td><c:out value="${commboardlist.boViews}" /></td>
													<td><c:out value="${commboardlist.boLikes}" /></td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="chart tab-pane" id="wholecomm"
									style="position: relative; height: 300px;">
									<table id="example2" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th style="width: 110px;">커뮤니티 번호</th>
												<th style="width: 200px;">커뮤니티 명</th>
												<th>커뮤니티 설명</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="commboardlist" items="${commboardlist}">
												<tr>
													<td><c:out value="${commboardlist.boNum}" /></td>
													<td><a
														href='/comm/viewwritings?boNum=<c:out value="${commboardlist.boNum}"/>'>
															<c:out value="${commboardlist.boTitle}" />
													</a></td>
													<td><c:out value="${commboardlist.memNum}" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- /main -->
				</div>
				<!-- /content -->
			</div>
		</div>
	</section>
</div>





<form id="actionForm" action="/comm/searchcomm " method='get'>
	<input type="hidden" name="page" value='${pageMaker.cri.page}'>
	<input type="hidden" name="amount" value='${pageMaker.cri.amount}'>
	<input type="hidden" name="keyword" value='${pageMaker.cri.keyword}'>
	<input type="hidden" name="type" value='${pageMaker.cri.type}'>
</form>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>


<script>
$(document).ready(function() {

	var actionForm = $("actionForm");

	$(".page-item").on("click", function(e) {
		e.preventDafault();

		console.log('click');
		actionForm.find("input[name='page']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	var searchForm=$("#searchForm");
	
	$("#searchForm button").on("click",function(e){
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요");
			return false;
		}
		
		searchForm.find("input[name=page]").val("1");
		searchForm.submit();
	});
});

function selChange() {
	var sel = document.getElementById('getListWithPaging').value;
	var page = 1;
	location.href = "board.do?page=" + page + "&amount=" + sel;

}

</script>
<%@ include file="footer.jsp"%>

</body>
</html>
