<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
  <h1>Update your profile</h1>
  <div class="content-form-page">
    <div class="row">
      <div class="col-md-7 col-sm-7">
      <c:if test ="${message != null}">
      <h3 class="alert alert danger">${message}</h3>
      </c:if>
        <form action="/ltweb/profile" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
          <fieldset>
            <legend>Your personal details</legend>
             <div class="form-group">
              <label for="avatar" class="col-lg-4 control-label">Avatar <span class="require">*</span></label>
              <div class="col-lg-8">
                <input type="file" class="form-control" id="fullname" name="multiPartServlet">
              </div>
            </div>
            <div class="form-group">
              <label for="fullname" class="col-lg-4 control-label">Full Name <span class="require">*</span></label>
              <div class="col-lg-8">
                <input type="text" class="form-control" id="fullname" name="fullname">
              </div>
            </div>
            <div class="form-group">
              <label for="Phone" class="col-lg-4 control-label">Phone <span class="require">*</span></label>
              <div class="col-lg-8">
                <input type="text" class="form-control" id="phone" name="phone">
              </div>
            </div>
            <div class="form-group">
              <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
              <div class="col-lg-8">
                <input type="text" class="form-control" id="email" name="email">
              </div>
            </div>
          </fieldset>
          <div class="row">
            <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">                        
              <button type="submit" class="btn btn-primary">Update</button>
              <button type="button" class="btn btn-default">Cancel</button>
            </div>
          </div>
        </form>
      </div>

    </div>
  </div>
</div>
          <!-- END CONTENT -->