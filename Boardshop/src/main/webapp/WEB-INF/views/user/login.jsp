<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/mainStyle.css" rel="stylesheet"/>

<div class="row">
	<c:if test="${param.fail}">
		<div class="col-sm-12 col-xs-12 text-center">
			<h2><b>Fail to autorize</b></h2>
		</div>
	</c:if>
</div>
 
<nav class="navbar navbar-inverse" role="navigation">
	<div class="collapse navbar-collapse" id="myNavbar">
		<div class="container">
			<div class="col-md-10"></div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/login">Login</a></li>
				<li><a href="/registration">Registration</a></li>
			</ul>
		</div>
	</div>
</nav>

<div id="marTop" class="col-md-12"></div>

<div id="indexContent" class="col-md-12">
	<div class="col-md-12">
		<form:form class="form-horizontal" action="/login" method="POST">
			<div class="form-group">
    			<label for="login" class="col-sm-2 control-label">Login</label>
    			<div class="col-sm-3">
      				<input class="form-control" name="login" id="login">
    			</div>
  			</div>
			<div class="form-group">
    			<label for="password" class="col-sm-2 control-label">Password</label>
    			<div class="col-sm-3">
      				<input type="password" class="form-control" name="password" id="password">
    			</div>
  			</div>
  			<div class="form-group">
  				<div class="col-sm-offset-2 col-sm-3">
  					<div class="checkbox">
  						<label>
  							<input name="remember-me" type="checkbox"> Remember me
  						</label>
  					</div>
  				</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-3">
      				<button type="submit" class="btn btn-default">Sign in</button>
    			</div>
  			</div>
		</form:form>
		<div id="logRegHeight" class="col-md-6"></div>
	</div>
</div>