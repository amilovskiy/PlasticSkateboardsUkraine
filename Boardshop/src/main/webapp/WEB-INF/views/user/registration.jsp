<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="/resources/css/styleHeader.css" rel="stylesheet"/>

 	<nav class="navbar navbar-inverse" role="navigation">
                    <div class="collapse navbar-collapse" id="myNavbar">
				        <div class="container">
				        <div class="col-md-10"></div>
                            <ul class="nav navbar-nav">
                               <li><a href="/login">Login</a></li>
                               <li class="active"><a href="/registration">Registration</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
                
<div id="marTop" class="col-md-12">
	<div class="col-md-6"></div>
</div>

<div id="indexContent" class="col-md-12">
	<div class="col-md-12">
		<div class="row">
	<div class="col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/registration" method="POST" modelAttribute="user">
  			<div class="form-group">
				<label for="email" style="color: #A02525; text-align: left;" class="col-sm-offset-2 col-sm-5"><form:errors path="email"/></label>
			</div>
			<div class="form-group">
    			<label for="email" class="col-sm-2 control-label">Email</label>
    			<div class="col-sm-3">
      				<form:input class="form-control" path="email" id="email"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="email" style="color: #A02525; text-align: left;" class="col-sm-offset-2 col-sm-5"><form:errors path="password"/></label>
			</div>
			<div class="form-group">
    			<label for="password" class="col-sm-2 control-label">Password</label>
    			<div class="col-sm-3">
      				<form:password class="form-control" path="password" id="password"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-3">
      				<button type="submit" class="btn btn-default">Register</button>
    			</div>
  			</div>
		</form:form>
		<div id="logRegHeight" class="col-md-6"></div>
	</div>
</div>
	</div>
</div>

<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>