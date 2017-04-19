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
	<div class="container">
			<div class="row">
				<div class="col-md-10">
						<c:forEach items="${page.content}" var="category">								
							<div class="row">
								<div class="col-md-2 col-xs-2"><a href="/shop/productList/${category.id}"><img class="img-rounded" width="100%" src="/images/category/${category.id}.jpg?version=${category.version}"></a></div>
								<div class="col-md-2"><h3><b>${category.name}</b></h3></div>										
							</div>
							<div id="marTop" class="col-md-12">
								<div class="col-md-6"></div>
							</div>
						</c:forEach>

						<div class="col-md-2 col-xs-12"></div>
							<div class="row">
								<div class="col-md-12 col-xs-12 text-center">
									<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
								</div>
							</div>
						</div>
				<div class="col-md-2">
					<div class="row">
						<a class="btn btn-success btn-lg" href="/cart">Cart</a>&nbsp;<b>${amount}</b>
					</div>
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
	<div class="container">
			<div class="row">
				<div class="col-md-11">
						<c:forEach items="${page.content}" var="category">								
							<div class="row">
								<div class="col-md-2 col-xs-2"><a href="/user/shop/productList/notUser/${category.id}"><img class="img-rounded" width="100%" src="/images/category/${category.id}.jpg?version=${category.version}"></a></div>
								<div class="col-md-2"><h3><b>${category.name}</b></h3></div>										
							</div>
							<div id="marTop" class="col-md-12">
								<div class="col-md-6"></div>
							</div>
						</c:forEach>

						<div class="col-md-2 col-xs-12"></div>
							<div class="row">
								<div class="col-md-12 col-xs-12 text-center">
									<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
								</div>
							</div>
						</div>
			</div>
		</div>	
	</div>    
	    

</sec:authorize>                      
                