<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="/resources/css/mainStyle.css" rel="stylesheet"/>

<sec:authorize access="!isAuthenticated()">
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="collapse navbar-collapse" id="myNavbar">
			<div class="container">
				<div class="col-md-10">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/user/shop/notUser">Shop</a></li>
					</ul>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/registration">Registration</a></li> 
				</ul>
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
					<div class="jumbotron">
					  		<h4><b>Want to buy something?</b></h4>
					 		 <h5>Please sign up or enter login!</h5>
					  		 <p><a class="btn btn-info btn-md" href="/registration" role="button">Sign Up</a>
					  		 <a class="btn btn-warning btn-md" href="/login" role="button">Login</a></p>
						</div>
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