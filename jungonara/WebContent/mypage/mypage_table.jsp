<%@page import="dto.sbDto"%>
<%@page import="dto.buyDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%
	request.setCharacterEncoding("UTF-8"); 
	@SuppressWarnings (value="unchecked")		// warning 제거
	ArrayList<buyDto> buy = (ArrayList<buyDto>)request.getAttribute("buylist");
	@SuppressWarnings (value="unchecked")		// warning 제거	
	ArrayList<sbDto> sb = (ArrayList<sbDto>)request.getAttribute("sblist");
	int buycount = (int)request.getAttribute("buycount");
	int sbcount = (int)request.getAttribute("sbcount");
%>
<body>
	<div class="container">
        <div id="basic_table">
            <div class="container-body">
                <div>
					<h2>마이 페이지 <small>글의 수정 및 삭제가 가능 합니다.</small></h2><br>
				</div>
				<div id="buyDiv">
					<h4>삽니다 게시물</h4>
						<table id="buy" class="table table-striped table-hover">
						<thead>
							<tr>
								<td class="col-md-1">번호</td>
								<td class="col-md-4">제목</td>
								<td class="col-md-1">작성자</td>
			                    <td class="col-md-1">거래상태</td>
			                    <td class="col-md-1">최종수정일</td>
			                    <td class="col-md-1"></td>
			                    <td class="col-md-1"></td>
			                    <td class="col-md-1"></td>
							</tr>
						</thead>
						<tbody>
							<% if (buy.isEmpty()) { %>
				                    <tr>
				                    	<td class="col-md-1"></td>
			                            <td class="col-md-4"><p><strong>작성된 글이 존재하지 않습니다</strong></p></td>
			                            <td class="col-md-1"></td>
			                            <td class="col-md-1"></td>
			                            <td class="col-md-1"></td>
			                            <td class="col-md-1"></td>
			                    		<td class="col-md-1"></td>
			                    		<td class="col-md-1"></td>
				                    </tr>
			                <% } else {
			                		for (int i = 0; i<buy.size();i++) {
			                			buyDto buyDto = buy.get(i);
				            %>
				                	<tr style="cursor:pointer;" >
				                        <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getBuy_id() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-4"><%=buyDto.getBuy_title() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getUser_id() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getBuy_status() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"><%=buyDto.getBuy_update() %></td>
			                            <td id="<%=buyDto.getBuy_id() %>"  class="col-md-1">
			                            	<!-- *************************** 모달 ******************************** -->
											<div class="modal fade bs-example-modal-lg" id="buyModal<%=buyDto.getBuy_id()%>" role="dialog">
										    	<div class="modal-dialog modal-lg">
										            <!-- Modal content-->
										            <div class="modal-content">
										                <div class="modal-header" style="padding:15px 50px;">
										                    <button type="button" class="close" data-dismiss="modal">&times;</button>
										                    <h4><span class="glyphicon glyphicon-pencil"></span> 삽니다 게시물 수정</h4></div>
										                <form role="form" action="./buyupdate" method="post">
										                    <div class="modal-body" style="padding:40px 50px;">
										                    	<div class="form-group">
										                    		<label for="user_id"><span class="glyphicon glyphicon-pencil"></span> 작성자 </label>
										                    		<input type="text" name="user_id" class="form-control"  value="<%=id %>" readonly>
										                    	</div>
										                    	<div class="form-group">
										                            <label for="buy_id"><span class="glyphicon glyphicon-pencil"></span> 게시글 번호 </label>
										                            <input type="text" name="buy_id" class="form-control" value="<%=buyDto.getBuy_id() %>" readonly>
										                        </div>
										                        <div class="form-group">
										                            <label for="buy_title"><span class="glyphicon glyphicon-pencil"></span> 글 제목 </label>
										                            <input type="text" name="buy_title" class="form-control"  value="<%=buyDto.getBuy_title() %>">
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
										                        	<input type="text" name="buy_price" class="form-control" placeholder="금액을 다시 입력해주세요 ex)100000">
										                        </div>
										                        <div class="form-group">
										                            <label for="buy_contents"><span class="glyphicon glyphicon-pencil"></span> 글 내용</label>
										                            <textarea class="form-control" rows="10" name="buy_contents" placeholder="수정된 내용을 다시 입력해 주세요" ></textarea>
										                        </div>
										                    </div>
											                <div class="modal-footer">
											                	<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
											                	<button type="submit" class="btn btn-primary">수정하기</button>
											                </div>
											            </form>
										            </div>
										        </div>
										    </div>
										    <!-- ********************************************************************************* -->
			                            	<button data-toggle="modal" data-target="#buyModal<%=buyDto.getBuy_id()%>"  type="button" class="btn btn-success btn-xs">게시글수정</button>
			                            </td>
			                    		<td id="<%=buyDto.getBuy_id() %>"  class="col-md-1">
			                    			<button id="buyDelete" type="button" class="btn btn-warning btn-xs">게시글삭제</button>
			                    		</td>
			                    		<% if (buyDto.getBuy_status().equals("거래중")) { %>
			                    		<td id="<%=buyDto.getBuy_id() %>"  class="col-md-1">
			                    			<button id="buyStatus" type="button" class="btn btn-info btn-xs">거래완료</button>
			                    		</td>
			                    		<% } else { %>
			                    		<td id="<%=buyDto.getBuy_id() %>"  class="col-md-1"></td>
			                    		<% } %>
				                    </tr>
				            <% 
				                	}
				                }
				            %>	
						</tbody>
					</table>
					<div>
						<nav style="display:inline">
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								<% for(int i = 1; i<=Math.ceil(buycount/5.0);i++) { %>
								<li><a href="/jungonara/mypagelist?buypageNum=1&sbpageNum=<%=i%>&id=<%=id %>"><%=i %></a></li>		<!-- 페이지네이션 선언 -->
								<%} %>
								<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</ul>
				        </nav>	
					</div>
				</div>
				<div id="sbDiv">
					<h4>팝니다 게시물</h4>
						<table id="sb" class="table table-striped table-hover">
						<thead>
							<tr>
								<td class="col-md-1">번호</td>
			                    <td class="col-md-4">제목</td>
								<td class="col-md-1">작성자</td>
			                    <td class="col-md-1">거래상태</td>
			                    <td class="col-md-1">최종수정일</td>
			                    <td class="col-md-1"></td>
			                    <td class="col-md-1"></td>
			                    <td class="col-md-1"></td>
							</tr>
						</thead>
						<tbody>
							<% if (sb.isEmpty()) { %>
								<tr>
									<td class="col-md-1"></td>
									<td class="col-md-4"><p><strong>작성된 글이 존재하지 않습니다</strong></p></td>
			                        <td class="col-md-1"></td>
			                        <td class="col-md-1"></td>
			                        <td class="col-md-1"></td>
			                        <td class="col-md-1"></td>
			                    	<td class="col-md-1"></td>
			                    	<td class="col-md-1"></td>
								</tr>
							<% } else {
			                		for (int i = 0; i<sb.size();i++) {
			                			sbDto sbDto = sb.get(i);
							%>
								<tr style="cursor:pointer;" >
									<td id="<%=sbDto.getSb_id() %>"  class="col-md-1"><%=sbDto.getSb_id() %></td>
									<td id="<%=sbDto.getSb_id() %>"  class="col-md-4"><%=sbDto.getSb_title() %></td>
									<td id="<%=sbDto.getSb_id() %>"  class="col-md-1"><%=sbDto.getUser_id() %></td>
									<td id="<%=sbDto.getSb_id() %>"  class="col-md-1"><%=sbDto.getSb_status() %></td>
									<td id="<%=sbDto.getSb_id() %>"  class="col-md-1"><%=sbDto.getSb_update() %></td>
									<td id="<%=sbDto.getSb_id() %>"  class="col-md-1">
										<!-- *************************** 모달 ******************************** -->
											<div class="modal fade bs-example-modal-lg" id="sbModal<%=sbDto.getSb_id()%>" role="dialog">
										        <div class="modal-dialog modal-lg">
										            <!-- Modal content-->
										            <div class="modal-content">
										                <div class="modal-header" style="padding:15px 50px;">
										                    <button type="button" class="close" data-dismiss="modal">&times;</button>
										                    <h4><span class="glyphicon glyphicon-pencil"></span> 팝니다 게시물 수정</h4></div>
										                <form role="form" action="./sbupdate" method="post">
										                    <div class="modal-body" style="padding:40px 50px;">
										                    	<div class="form-group">
										                    		<label for="user_id"><span class="glyphicon glyphicon-pencil"></span> 작성자 </label>
										                    		<input type="text" name="user_id" class="form-control"  value="<%=id %>" readonly>
										                    	</div>
										                    	<div class="form-group">
										                            <label for="sb_id"><span class="glyphicon glyphicon-pencil"></span> 게시글 번호 </label>
										                            <input type="text" name="sb_id" class="form-control"  value="<%=sbDto.getSb_id() %>" readonly>
										                        </div>
										                        <div class="form-group">
										                            <label for="sb_title"><span class="glyphicon glyphicon-pencil"></span> 글 제목 </label>
										                            <input type="text" name="sb_title" class="form-control"  value="<%=sbDto.getSb_title() %>">
										                        </div>
										                        <div class="form-group">
																	<label for="sb_type"><span class="glyphicon glyphicon-th-list"></span> 카테고리 </label>
																	<div class="container-fluid">
																		<div class="row col-xs-3">
																			<select class="form-control" name="sb_type">
																				<option value="생활용품" >생활용품</option>
																				<option value="전자기기">전자기기</option>
																				<option value="의류">의류</option>
																				<option value="기타"  selected="selected">기타</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="form-group">
																	<label for="sb_subtype"><span class="glyphicon glyphicon-th-list"></span> 세부 카테고리 </label>
																	<div class="container-fluid">
																		<div class="row col-xs-3">
																			<select class="form-control" name="sb_subtype">
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
										                            <label for="sb_trade"><span class="glyphicon glyphicon-shopping-cart"></span> 거래 방법</label>
										                            <div class="container-fluid">
																		<div class="row col-xs-3">
																			<select class="form-control" name="sb_trade">
																				<option value="직거래" selected="selected">직거래</option>
																				<option value="택배">택배</option>
																			</select>
																		</div>
																	</div>
										                        </div>
										                        <div class="form-group">
										                        	<label for="sb_price"><span class="glyphicon glyphicon-usd"></span> 가격 </label>
										                        	<input type="text" name="sb_price" class="form-control"  placeholder="금액을 다시 입력해주세요 ex)100000">
										                        </div>
										                        <div class="form-group">
										                            <label for="sb_contents"><span class="glyphicon glyphicon-pencil"></span> 글 내용</label>
										                            <textarea class="form-control" rows="10" name="sb_contents" placeholder="수정된 내용을 다시 입력해 주세요" ></textarea>
										                        </div>
										                    </div>
											                <div class="modal-footer">
											                	<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
											                	<button type="submit" class="btn btn-primary">수정하기</button>
											                </div>
											            </form>
										            </div>
										        </div>
										    </div>
										    <!-- ********************************************************************************* -->
										<button data-toggle="modal" data-target="#sbModal<%=sbDto.getSb_id()%>"  type="button" class="btn btn-success btn-xs">게시글수정</button>
									</td>
			                    	<td id="<%=sbDto.getSb_id() %>"  class="col-md-1">
			                    		<button id="sbDelete" type="button" class="btn btn-warning btn-xs">게시글삭제</button>
			                    	</td>
			                    	<% if (sbDto.getSb_status().equals("거래중")) { %>
			                    	<td id="<%=sbDto.getSb_id() %>"  class="col-md-1">
			                    		<button id="sbStatus" type="button" class="btn btn-info btn-xs">거래완료</button>
			                    	</td>
			                    	<% } else { %>
			                    	<td id="<%=sbDto.getSb_id() %>"  class="col-md-1"></td>
			                    	<% } %>
								</tr>
							<% 
				                	}
				                }
				            %>
						</tbody>
					</table>
					<div>
						<nav style="display:inline">
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								<% for(int i = 1; i<=Math.ceil(sbcount/5.0);i++) { %>
								<li><a href="/jungonara/mypagelist?sbpageNum=1&buypageNum=<%=i%>&id=<%=id %>"><%=i %></a></li>		<!-- 페이지네이션 선언 -->
								<%} %>
								<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</ul>
				        </nav>	
					</div>
				</div>
            </div>
        </div>
    </div>
</body>
<!-- 커스텀 Jquery 파일 선언 -->
<script src="js/mypageJquery.js?ver=1"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>