<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="/resources/css/mainStyle.css" rel="stylesheet"/>

<sec:authorize access="isAuthenticated()">
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

	<div id="marTop" class="col-md-12"></div> 

	<div id="indexContent" class="col-md-12">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<img class="img-rounded" width="400px" 
								src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}">
				</div>
				<div class="col-md-4">
					<br>
					<h1><b><c:out value="${commodity.name}" escapeXml="false"/></b></h1>
					<h3><b><c:out value="${commodity.price}" escapeXml="false"/>&#160;$</b></h3><br>
					<a class="btn btn-warning btn-lg" href="/user/product_page/buy/${commodity.id}/${user.id}">Buy</a><br>
					<h2 style="color: #D3D3D3;"><b>Description</b></h2>
					<b>Deck :</b>
					<c:out value="${commodity.deck.name}" escapeXml="false"/><br>
					<b>Truck :</b>
					<c:out value="${commodity.truck.name}" escapeXml="false"/><br>
					<b>Wheels :</b>
					<c:out value="${commodity.wheel.name}" escapeXml="false"/><br>
					<b>Color :</b>
					<c:out value="${commodity.color.name}" escapeXml="false"/><br>
					<b>Category :</b>
					<c:out value="${commodity.category.name}" escapeXml="false"/><br>
				</div>
				<div class="col-md-4">
					<br>
					<h2 style="color: #D3D3D3;"><b>About <c:out value="${commodity.name}" escapeXml="false"/></b></h2>
					<c:out value="${commodity.description}" escapeXml="false"/>
					<h2 style="color: #D3D3D3;"><b>Producer :</b></h2>
					<img class="img-rounded" width="200px" 
								src="/images/producer/${commodity.producer.id}.jpg?version=${commodity.producer.version}">
					
				</div>
			</div>
		</div>	
	</div>
	<div id="productListHeight" class="col-md-6"></div>
</sec:authorize>