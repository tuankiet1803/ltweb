<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <h1>Create an account</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                <c:if test ="${alert != null}">
                <h3 class="alert alert danger">${alert}</h3>
                </c:if>
                  <form action="/ltweb/register" method="post" class="form-horizontal" role="form">
                    <fieldset>
                      <legend>Your personal details</legend>
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
                    <fieldset>
                      <legend>Your Account</legend>
                      <div class="form-group">
                        <label for="username" class="col-lg-4 control-label">Username <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="username" name="username">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="password" name="password">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="confirm-password" class="col-lg-4 control-label">Confirm password <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="confirm-password">
                        </div>
                      </div>
                    </fieldset>
                    <fieldset>
                      <legend>Newsletter</legend>
                      <div class="checkbox form-group">
                        <label>
                          <div class="col-lg-4 col-sm-4">Singup for Newsletter</div>
                          <div class="col-lg-8 col-sm-8">
                          <input type="checkbox">
                          </div>
                        </label>
                      </div>
                    </fieldset>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">                        
                        <button type="submit" class="btn btn-primary">Create an account</button>
                        <button type="button" class="btn btn-default">Cancel</button>
                      </div>
                    </div>
                  </form>
                </div>

              </div>
            </div>
          </div>
          <!-- END CONTENT -->