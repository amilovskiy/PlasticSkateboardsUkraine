<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/mainStyle.css" rel="stylesheet"/>

<nav class="navbar navbar-inverse" role="navigation">
	<div class="collapse navbar-collapse" id="myNavbar">
		<div class="container">
			<div class="col-md-10">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/user/shop">Shop</a></li>
				</ul>
			</div>
			<ul class="nav navbar-nav">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/admin">Admin</a></li>
				</sec:authorize>
			</ul>
			<div id="logout">
				<form:form action="/logout" method="POST">
					<button class="btn btn-danger navbar-btn">Logout</button>
				</form:form>
			</div>
		</div>
	</div>
</nav>

<sec:authorize access="isAuthenticated()">
	<div id="marTop" class="col-md-12"></div> 
	<div id="indexContent" class="col-md-12">
	<div class="container">
   		<h2><b>Commodity details :</b></h2>
   		<div class="row">
					<div class="col-md-3 col-xs-3"><img class="img-rounded" width="100%" 
						src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"></div>
					<div class="row"><div class="col-md-4"><a href="/cart/amount/${commodity.id}"></a><h2><b>${commodity.name}</b></h2>${commodity.price}<b>$</b></div>
						<div class="col-md-1"><a href="/cart/deleteOne/${commodity.id}"><img style ="hight: 50px; width: 50px;" src="/resources/img/removeIcon.png"></a></div></div>
		</div>
   		&nbsp;&nbsp;&nbsp;&nbsp;<div class="row">
			<div class="col-sm-1"><a href="/cart/reduceAmount/${commodity.id}"><img src="/resources/img/arrow-left.svg" style ="height: 40px; width: 40px;"></img></a></div>
  			<div class="col-sm-1"><h1><b>${amount}</b></h1></div>
			<div class="col-sm-1"><a href="/cart/increaseAmount/${commodity.id}"><img src="/resources/img/arrow-right.svg" style ="height: 40px; width: 40px;"></img></a></div>
   		</div> 
	</div>
	</div>
</sec:authorize>

<div id="cartPageHeight" class="col-md-3"></div>