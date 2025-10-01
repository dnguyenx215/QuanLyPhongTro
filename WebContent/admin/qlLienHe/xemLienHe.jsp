<%@page import="model.bean.LienHe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../headerAdmin.jsp" %>
 <!-- Main content -->
    <!-- Tạo form và table vào đây ==========================================================-->
    <%
    LienHe xemLienHeLH=(LienHe) request.getAttribute("xemLienHeLH");
    %>
    <section class="content container-fluid">
        <div class="row">
          <div class="box box-info col-sm-8 col-sm-offset-2">
            <div class="box-header with-border pull-center">
              <h3 class="box-title ">Chi tiết liên hệ</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal" action="mailto:<%=xemLienHeLH.getEmail()%>">
              <div class="box-body">

                <div class="form-group">
                  <label for="contactID" class="col-sm-3 control-label">ID:</label>

                  <div class="col-sm-8">
                     <input type="text" readonly="readonly" class="form-control" id="contactID" value="<%=xemLienHeLH.getId()%>" required>
                 
                  </div>
                  
                </div>

                <div class="form-group">
                  <label for="nameSend" class="col-sm-3 control-label">Họ tên </label>

                  <div class="col-sm-8">
                    <input type="text" readonly="readonly" class="form-control" id="nameSend"  value="<%=xemLienHeLH.getHoTen() %>" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="emailSend" class="col-sm-3 control-label">Email</label>

                  <div class="col-sm-8">
                    <input type="text" readonly="readonly" class="form-control" id="emailSend"  value="<%=xemLienHeLH.getEmail() %>" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="subjectSend" class="col-sm-3 control-label">Chủ đề</label>

                  <div class="col-sm-8">
                    <input type="text" readonly="readonly" class="form-control" id="subjectSend"  value="<%=xemLienHeLH.getChuDe() %>" required>
                  </div>
                </div>
               <div class="form-group">
                  <label class="col-sm-3 control-label" for="noiDung">Nội dung:</label>
                  <div class="col-sm-8">
                    <textarea class="form-control" rows="5" id="noiDung" name="noiDung"  readonly= ><%=xemLienHeLH.getNoiDung() %></textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label for="dateSend" class="col-sm-3 control-label">Ngày gửi</label>

                  <div class="col-sm-8">
                    <input type="date" readonly="readonly" class="form-control" id="dateSend" placeholder="Ngày gửi" value="<%=xemLienHeLH.getNgayGui() %>" required>
                  </div>
                </div>
              </div>
              
              <!-- /.box-body -->
              <div class="box-footer n10_box_footer col-sm-8 col-sm-offset-3" >
                <button type="submit" class=" btn btn-info pull-left">Trả lời</button>
                <a href="#" class="btn_back btn btn-default pull-right">Quay lại</a>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        </div>        
    </section>
    <!-- Thêm xong =====================================================================-->
	<%@include file="../footerAdmin.jsp" %>