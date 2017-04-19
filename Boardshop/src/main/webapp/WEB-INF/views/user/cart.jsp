<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/styleHeader.css" rel="stylesheet"/>

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
<div id="marTop" class="col-md-12">
	<div class="col-md-6"></div>
</div> 

<div id="indexContent" class="col-md-12">
	<div class="row"><h2><b>Order :</b></h2></div>
 	<div class="col-md-7">
		<c:forEach items="${commodities}" var="commodity">
			<div class="row">
				<div class="col-md-3 col-xs-3"><img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"></div>
				<div class="col-md-4"><div class="row"><h2><b>${commodity.name}</b></h2></div><div class="row">${commodity.price}<b>$</b></div></div>
			</div>
			
		</c:forEach> 
	</div>
	<div id="cartPageHeight" class="col-md-3">
		<a class="btn btn-danger btn-lg" href="/cart/delete">Delete list</a>
		<a class="btn btn-primary btn-lg" href="/cart/confirm">Confirm</a>
		<div id="marTop" class="col-md-12">
			<div class="col-md-6"></div>
		</div>
		<div class="row">
			<h3><b>Total price :</b></h3> 
			<h3><b>${price} $</b></h3>
		</div>
	</div> 
</div>	
</sec:authorize>


