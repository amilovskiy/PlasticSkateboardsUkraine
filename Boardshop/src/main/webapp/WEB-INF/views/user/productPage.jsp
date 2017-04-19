<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="/resources/css/styleHeader.css" rel="stylesheet"/>

<sec:authorize access="isAuthenticated()">
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

 <div id="marTop" class="col-md-12">
	<div class="col-md-6"></div>
</div> 

<div id="indexContent" class="col-md-12">
	<div class="row text-center">
		
	</div>
	<div class="container">
			<div class="row">
				<div class="col-md-10">
						<b>Image</b>
	<div class="row">
		<div class="col-md-6">
			<div class="col-md-5 col-xs-5"><img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"></div> 
		</div>
	</div> 
	<b>Name</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.name}" escapeXml="false"/>
		</div>
	</div>
	<b>Price</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.price}" escapeXml="false"/>
		</div>
	</div>
	<b>Description</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.description}" escapeXml="false"/>
		</div>
	</div>
	<b>Producer</b>
	<div class="row">
		<div class="col-md-5">
			<div class="col-md-3 col-xs-3"><img class="img-rounded" width="100%" src="/images/producer/${commodity.producer.id}.jpg?version=${commodity.producer.version}"></div>
		</div>
	</div>
	<b>Category</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.category.name}" escapeXml="false"/>
		</div>
	</div>
	<div id="marTop" class="col-md-12">
		<div class="col-md-6"></div>
	</div> 
	<div class="row">
			<a class="btn btn-warning btn-lg" href="/user/productPage/buy/${commodity.id}/${user.id}">Buy</a>
		</div>	
<c:forEach items="${commodities}" var="commodity">		
	<div class="col-md-3 col-xs-3">${commodity}</div>
</c:forEach>	
<div id="productListHeight" class="col-md-6"></div>		
</div>
				<div class="col-md-2">
					<a class="btn btn-success btn-lg" href="/cart">Cart</a>&nbsp;<b>${amount}</b>
				</div>
			</div>
		</div>	
	</div>
</sec:authorize>

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

 <div id="marTop" class="col-md-12">
	<div class="col-md-6"></div>
</div> 

<div id="indexContent" class="col-md-12">
	<div class="row text-center">
		
	</div>
	<div class="container">
			<div class="row">
				<div class="col-md-11">
	<b>Image</b>
	<div class="row">
		<div class="col-md-6">
			<div class="col-md-5 col-xs-5"><img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"></div> 
		</div>
	</div> 
	<b>Name</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.name}" escapeXml="false"/>
		</div>
	</div>
	<b>Price</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.price}" escapeXml="false"/>
		</div>
	</div>
	<b>Description</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.description}" escapeXml="false"/>
		</div>
	</div>
	<b>Producer</b>
	<div class="row">
		<div class="col-md-5">
			<div class="col-md-3 col-xs-3"><img class="img-rounded" width="100%" src="/images/producer/${commodity.producer.id}.jpg?version=${commodity.producer.version}"></div>
		</div>
	</div>
	<b>Category</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.category.name}" escapeXml="false"/>
		</div>
	</div>
	<div id="marTop" class="col-md-12">
		<div class="col-md-6"></div>
	</div> 	
	<div class="col-md-7">
	<div class="jumbotron">
  		<h3>You want to buy something?</h3>
 		 <p>Please sign up or enter login</p>
  		 <p><a class="btn btn-info btn-lg" href="/registration" role="button">Sign Up</a>
  		 <a class="btn btn-warning btn-lg" href="/login" role="button">Login</a></p>
	</div>	
	</div>
<c:forEach items="${commodities}" var="commodity">		
	<div class="col-md-3 col-xs-3">${commodity}</div>
</c:forEach>	
<div id="productListHeight" class="col-md-6"></div>		
</div>
			</div>
		</div>	
	</div>
</sec:authorize>

















