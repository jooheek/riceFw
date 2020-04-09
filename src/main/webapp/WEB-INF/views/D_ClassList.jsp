<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>장소관리</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Tables</a></li>
			<li class="active">Data tables</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">강의실 리스트</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div style="float: right;">
							<select id="getListWithPaging" name="sel" onchange="selChange()">
								<option value="5"
									<c:if test="${pageMaker.cri.amount == 5}">selected</c:if>>5개씩보기</option>
								<option value="10"
									<c:if test="${pageMaker.cri.amount == 10}">selected</c:if>>10개씩보기</option>
								<option value="15"
									<c:if test="${pageMaker.cri.amount == 15}">selected</c:if>>15개씩보기</option>
								<option value="20"
									<c:if test="${pageMaker.cri.amount == 20}">selected</c:if>>20개씩보기</option>
							</select>
						</div>
						<!-- 옵션선택 끝 -->
						<div class="box-body table-responsive no-padding">
							<table class="table table-hover" id="example2"
								class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>강의실 종류</th>
										<th>강의실 호수</th>
										<th>강의실 층수</th>
										<th>수용인원</th>
										<th>건물ID</th>
										<th>강의실 ID</th>
										<th>강의실 비고</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="listC" items="${listC}">
										<tr>
											<td><c:out value="${listC.classCode}" /></td>
											<td><a
												href='../../classMng/MngBld/classrdesc?classId=<c:out value="${listC.classId}"/>'>
													<c:out value="${listC.classNumber}" />
											</a></td>
											<td><c:out value="${listC.classFloorNum}" /></td>
											<td><c:out value="${listC.classCapacity}" /></td>
											<td><c:out value="${listC.bulId}" /></td>
											<td><c:out value="${listC.classId}" /></td>
											<td><c:out value="${listC.classRemark}" /></td>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div>
							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li class="page-item"><a class="page-link"
										href="/classMng/MngBld/classr?page=${pageMaker.startPage-1 }&amount=${ pageMaker.cri.amount}">Previous</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="pnum">
									<li class="page-item ${pnum == pageMaker.cri.page? "active":"" }">
										<a class="page-link"
										href="/classMng/MngBld/classr?page=${pnum }&amount=${ pageMaker.cri.amount}">${pnum}</a>
									</li>
								</c:forEach>
								<c:if test="${pageMaker.next}">
									<li class="page-item"><a class="page-link"
										href="/classMng/MngBld/classr?page=${pageMaker.endPage+1 }&amount=${ pageMaker.cri.amount}">Next</a></li>
								</c:if>
							</ul>
						</div>
						<div class="offset-md-8">
							<form action="#" method="get" class="sidebar-form">
								<div class="input-group">
									<input type="text" name="q" class="form-control"
										placeholder="Search..."> <span class="input-group-btn">
										<button type="submit" name="search" id="search-btn"
											class="btn btn-flat">
											<i class="fa fa-search"></i>
										</button>
									</span>
								</div>
							</form>
						</div>
						<div class="offset-md-8">
							<form action="/classMng/MngBld/classadd">
								<button type="submit" class="btn pull-right">강의실등록</button>
							</form>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->

	</section>
	<!-- /.content -->
</div>



<form id="actionForm" action="/classMng/MngBld/classr" method='get'>
	<input type="hidden" name="page" value='${pageMaker.cri.page}'>
	<input type="hidden" name="amount" value='${pageMaker.cri.amount}'>
</form>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		var actionForm = $("actionForm");

		$(".page-item").on("click", function(e) {
			e.preventDafault();

			console.log('click');
			actionForm.find("input[name='page']").val($(this).attr("href"));
			actionForm.submit();
		});
	});

	function selChange() {
		var sel = document.getElementById('getListWithPaging').value;
		var page = 1;
		location.href = "/classMng/MngBld/classr?page=" + page + "&amount=" + sel;

	}
</script>


<%@ include file="footer.jsp"%>

</body>
</html>
