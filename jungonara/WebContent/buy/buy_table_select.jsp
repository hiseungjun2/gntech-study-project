<%@page import="dto.buyDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	@SuppressWarnings (value="unchecked")		// warning 제거
	ArrayList<buyDto> buy = (ArrayList<buyDto>)request.getAttribute("buyselectlist");
	int count = (int)request.getAttribute("buyselectcount");
	String open = (String)request.getAttribute("buyopenselect");
	String input = (String)request.getAttribute("buyinputselect");
%>
				<!-------------------------------------------------------모달 ------------------------------------------------------->
				<div class="modal fade bs-example-modal-lg" id="buyModal" role="dialog">
			        <div class="modal-dialog modal-lg">
			            <!-- Modal content-->
			            <div class="modal-content">
			                <div class="modal-header" style="padding:15px 50px;">
			                    <button type="button" class="close" data-dismiss="modal">&times;</button>
			                    <h4><span class="glyphicon glyphicon-pencil"></span> 게시물 등록</h4>
			                </div>
			                <form role="form" action="./buyinsert" method="post">
			                    <div class="modal-body" style="padding:40px 50px;">
			                    	<div class="form-group">
			                    		<label for="user_id"><span class="glyphicon glyphicon-pencil"></span> 작성자 </label>
			                    		<input type="text" name="user_id" class="form-control"  value="<%=id %>" readonly>
			                    	</div>
			                        <div class="form-group">
			                            <label for="buy_title"><span class="glyphicon glyphicon-pencil"></span> 글 제목 </label>
			                            <input type="text" name="buy_title" class="form-control" placeholder="글 제목을 입력하세요">
			                        </div>
			                        <div class="form-group">
										<label for="buy_type"><span class="glyphicon glyphicon-th-list"></span> 카테고리 </label>
										<div class="container-fluid">
											<div class="row col-xs-3">
												<select class="form-control" name="buy_type">
													<option value="생활용품" >생활용품</option>
													<option value="전자기기">전자기기</option>
													<option value="의류">의류</option>
													<option value="기타"  selected="selected">기타</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="buy_subtype"><span class="glyphicon glyphicon-th-list"></span> 세부 카테고리 </label>
										<div class="container-fluid">
											<div class="row col-xs-3">
												<select class="form-control" name="buy_subtype">
													<option value="주방" >주방</option>
													<option value="도서" >도서</option>
													<option value="문구" >문구</option>
													<option value="휴대폰" >휴대폰</option>
													<option value="컴퓨터" >컴퓨터</option>
													<option value="가전기기" >가전기기</option>
													<option value="유아용" >유아용</option>
													<option value="속옷" >속옷</option>
													<option value="패션의류" >패션의류</option>
													<option value="신발" >신발</option>
													<option value="기타"  selected="selected">기타</option>
												</select>
											</div>
										</div>
									</div>
			                        <div class="form-group">
			                            <label for="buy_trade"><span class="glyphicon glyphicon-shopping-cart"></span> 거래 방법</label>
			                            <div class="container-fluid">
											<div class="row col-xs-3">
												<select class="form-control" name="buy_trade">
													<option value="직거래" selected="selected">직거래</option>
													<option value="택배">택배</option>
												</select>
											</div>
										</div>
			                        </div>
			                        <div class="form-group">
			                        	<label for="buy_price"><span class="glyphicon glyphicon-usd"></span> 가격 </label>
			                        	<input type="text" name="buy_price" class="form-control" id="buyprice" placeholder="ex) 1000000">
			                        </div>
			                        <div class="form-group">
			                            <label for="buy_contents"><span class="glyphicon glyphicon-pencil"></span> 글 내용</label>
			                            <textarea class="form-control" rows="10" placeholder="내용을 입력해주세요" name="buy_contents"></textarea>
			                        </div>
			                    </div>
				                <div class="modal-footer">
				                	<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				                	<button type="submit" class="btn btn-primary">작성하기</button>
				                </div>
				            </form>
			            </div>
			        </div>
			    </div>
			    <!-- ********************************************************************************* -->
	<div class="container">
        <div id="basic_table">
            <div class="container-body">
				<h2>삽니다<small> 삽니다 게시글 작성 및 검색이 가능합니다.</small></h2>
				<button type="button" class="btn btn-default pull-right" data-toggle="modal" data-target="#buyModal">글쓰기</button>
					<!----------------------------------------------------테이블 생성----------------------------------------------->
					<div>
						<table id="buy" class="table table-striped table-hover">
							<thead>
								<tr>
									<td class="col-md-1">번호</td>
									<td class="col-md-6">제목</td>
									<td class="col-md-1">작성자</td>
			                        <td class="col-md-1">거래상태</td>
			                        <td class="col-md-2">최종수정일</td>
			                        </tr>
							</thead>
							<tbody>
			                <% if (buy.isEmpty()) { 		// 글 개수가 0개 일 경우%>		
				                    <tr>
				                    	<td class="col-md-1"></td>
			                            <td class="col-md-6"><p><strong>작성된 글이 존재하지 않습니다</strong></p></td>
			                            <td class="col-md-1"></td>
			                            <td class="col-md-1"></td>
			                            <td class="col-md-2"></td>
				                    </tr>
			                <% } else {
			                		for (int i = 0; i<buy.size();i++) {
			                			buyDto buyDto = buy.get(i);
			                			if (buyDto.getBuy_status().equals("거래완료")) {	// 거래완료 된 항목은 색칠하기
				            %>
				                	<tr class="danger" style="cursor:pointer;" >
				                        <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getBuy_id() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-6"><%=buyDto.getBuy_title() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getUser_id() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getBuy_status() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-2"><%=buyDto.getBuy_update() %></td>
				                    </tr>
				            <%		 } else { %>
				            		<tr style="cursor:pointer;" >
				                        <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getBuy_id() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-6"><%=buyDto.getBuy_title() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getUser_id() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getBuy_status() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-2"><%=buyDto.getBuy_update() %></td>
				                    </tr>
				            <%   		}
				                	}
			                }
				            %>	
							</tbody>
						</table>
					</div>
					<!----------------------------------------------------------------------------------------------------------------------->
					<!----------------------------------------------------페이지네이션 선언----------------------------------------------->
					<div>
						<nav style="display:inline">
							<ul class="pagination">	
								<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								<% for(int i = 1; i<=Math.ceil(count/12.0);i++) { 	// 페이지 내 글 개수 10개로 조정 %>
								<li><a href="/jungonara/buyselect?pageNum=<%=i%>&optionSelect=<%=open %>&inputSelect=<%=input%>"><%=i %></a></li>		
								<%   }	 %>
								<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</ul>
				        </nav>	
				        <form action="./buyselect" method="get" class="form-inline pull-right" style="margin-top : 20px;">
				        <input type="hidden" name="pageNum" value="1">
				        	<div class="form-group">
				        		<div class="row col-xs-2">
				        			<select class="form-control" name="optionSelect">
										<option value="user_id">작성자</option>
										<option value="buy_title">제목</option>
									</select>
				        		</div>
				        	</div>
				        	<div class="form-group" >
				        		<div class="row col-xs-3">
				        			<input name="inputSelect" type="text" class="form-control" placeholder="검색어 입력">
				        		</div>
				        	</div>
				        	<button type="submit" class="btn btn-default">검색</button>
				        </form>
					</div>
					<!-------------------------------------------------------------------------------------------------------------------->
            </div>
        </div>
    </div>
</body>
<!-- 커스텀 Jquery 파일 선언 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$("#buy tbody tr td").click(function() {
			var num = $(this).attr('id');
			$(location).attr("href", "/jungonara/buyselectinfo?num=" + num);
		})
	})
</script>
</html>