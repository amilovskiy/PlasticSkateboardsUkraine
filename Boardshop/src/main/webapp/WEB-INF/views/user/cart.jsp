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
			<div class="col-md-9">
				<ul class="nav navbar-nav">
					<li><a href="/user/shop">Shop</a></li>
				</ul>
			</div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
                	<div class="col-md-2">
	                	 <ul class="nav navbar-nav">
							<a href="/admin"><button class="btn btn-primary navbar-btn">Admin</button></a>&nbsp;&nbsp;
	                 	 </ul>
	                 	 <div id="logout">
	                 		<form:form action="/logout" method="POST">
	                    		<button class="btn btn-danger navbar-btn">Logout</button>
	                    	</form:form>
	                 	 </div>
                 	</div>
                 </sec:authorize>
                 <sec:authorize access="hasRole('ROLE_USER')">
                	<div class="col-md-1"></div>
                	<div class="col-md-1">
	                 	 <div id="logout">
	                 		<form:form action="/logout" method="POST">
	                    		<button class="btn btn-danger navbar-btn">Logout</button>
	                    	</form:form>
	                 	 </div>
                 	</div>
                 </sec:authorize>
                <div class="col-md-1">
				 	<a href="/cart"><span style="margin-top: 17px; color: white;" class="glyphicon glyphicon-shopping-cart"></span></a>
				 	<span style="color: white;">(${amount})</span>
				 </div>
		</div>
	</div>
</nav>

<sec:authorize access="isAuthenticated()">
	<div id="marTop" class="col-md-12"></div> 
	<div id="indexContent" class="col-md-12">
		<div class="row"><h2><b>Order :</b></h2></div>
 		<div class="col-md-9">
  			<c:forEach items="${commodities}" var="commodity">
				<div class="row">
					<div class="col-md-3 col-xs-3">
						<img class="img-rounded" width="100%" 
							src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}">
					</div>
					<div class="row">
						<div class="col-md-4">
							<h2><b>${commodity.name}</b></h2> ${commodity.price} <b>x</b> ${commodity.count} <b>=</b> ${commodity.price * commodity.count}<b>&#160;$</b>
							<div>amount:&#160;<b>${commodity.count}</b></div>
						</div>
						<div class="col-md-1"><a href="/cart/deleteOne/${commodity.id}"><img style ="hight: 50px; width: 50px;" src="/resources/img/removeIcon.png"></a></div></div>
				</div>
			</c:forEach>
			<div id="marTop" class="col-md-12"></div> 
		</div>
		<div id="cartPageHeight" class="col-md-3">
			<a class="btn btn-danger btn-lg" href="/cart/delete">Delete list</a>
			<a class="btn btn-primary btn-lg" href="/cart/confirm">Confirm</a>
			<div id="marTop" class="col-md-12"></div>
			<div class="row">
				<h3><b>Total price :</b></h3> 
				<h3><b>${price} $</b></h3>
			</div>
		</div> 
	</div>	
</sec:authorize>