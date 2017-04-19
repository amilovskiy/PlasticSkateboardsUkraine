<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
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
<!--                               <li><a href="/login">Login</a></li>
                               <li><a href="/registration">Registration</a></li> -->
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
						<c:forEach items="${commodities}" var="commodity">								
							<div class="row">
								<div class="col-md-3 col-xs-3"><a href="/user/productPage/${commodity.id}"><img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"></a></div>
								<div class="col-md-4"><div class="row"><h2><b><a href="/user/productPage/${commodity.id}">${commodity.name}</a></b></h2></div><div class="row">${commodity.price}<b> $</b></div>${commodity.description}</div>										
							</div>
							<div id="marTop" class="col-md-12">
								<div class="col-md-6"></div>
							</div>
						</c:forEach>
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
						<c:forEach items="${commodities}" var="commodity">								
							<div class="row">
								<div class="col-md-3 col-xs-3"><a href="/user/productPage/notUser/${commodity.id}"><img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"></a></div>
								<div class="col-md-4"><div class="row"><h2><b><a href="/user/productPage/notUser/${commodity.id}">${commodity.name}</a></b></h2></div><div class="row">${commodity.price}<b> $</b></div>${commodity.description}</div>										
							</div>
							<div id="marTop" class="col-md-12">
								<div class="col-md-6"></div>
							</div>
						</c:forEach>
					</div>
			</div>
		</div>	
	</div>
</sec:authorize>













