<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <h1>Forgot Your Password?</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form class="form-horizontal form-without-legend" role="form" action="/ltweb/forgotpassword" method="post">                    
                    <div class="form-group">
                      <label for="email" class="col-lg-4 control-label">Email</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="email" name="email"><br>
                        ${alert}<br>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-5">
                        <button type="submit" class="btn btn-primary">Send</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->    