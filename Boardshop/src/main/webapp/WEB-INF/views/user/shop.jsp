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
				        		<c:forEach items="${items}" var="item">
				        		<li role="presentation" class="dropdown">
   									 <a class="dropdown-toggle" data-toggle="dropdown" href="/user/shop/${item.id}" role="button" aria-haspopup="true" aria-expanded="false">${item.name}<span class="caret"></span></a>
     								 <ul class="dropdown-menu">
     									<c:forEach items="${categories}" var="category">
    										<li><a href="#">${category.name}</a></li>
    									</c:forEach>
    								</ul>
    							</li>
    							</c:forEach>
    						</ul>
				        </div>
                            <ul class="nav navbar-nav">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
								<a href="/admin"><button class="btn btn-primary navbar-btn">Admin</button></a>&nbsp;&nbsp;
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
        
   <div id="adminPageHeight" class="col-md-12"></div>       
  
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<nav class="navbar navbar-inverse" role="navigation">
                    <div class="collapse navbar-collapse" id="myNavbar">
				        <div class="container">
				        <div class="col-md-10">
				        	<ul class="nav navbar-nav">	
				        		<c:forEach items="${items}" var="item">
									<li role="presentation" class="dropdown">
   									 <a href="#" class="dropdown-toggle" data-toggle="dropdown"
   									 aria-haspopup="true" aria-expanded="false">${item.name}<span class="caret"></span></a>
    								<ul class="dropdown-menu">
    									<c:forEach items="${item.categories}" var="category">  
    										<li><a href="#">${category.name}</a></li>   
       	 								</c:forEach> 
    								</ul>
    							</li>
    							</c:forEach>
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
  
  <div id="adminPageHeight" class="col-md-12"></div>    
	    

</sec:authorize>                      
                