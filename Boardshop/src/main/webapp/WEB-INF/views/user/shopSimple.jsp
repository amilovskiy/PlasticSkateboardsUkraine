<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/mainStyle.css" rel="stylesheet"/>

<sec:authorize access="!isAuthenticated()">
	<nav class="navbar navbar-inverse" role="navigation">
    	<div class="collapse navbar-collapse" id="myNavbar">
			<div class="container">
				<div class="col-md-10">
					<ul class="nav navbar-nav">
						<c:forEach items="${items}" var="item">
							<li role="presentation" class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"
   									aria-haspopup="true" aria-expanded="false">${item.name}</a>
    							<ul class="dropdown-menu">
    								<c:forEach items="${item.categories}" var="category">  
    									<li><a href="/user/simple_shop/${category.id}">${category.name}</a></li>   
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
	
	<div id="marTop" class="col-md-12"></div>
	
	<div id="indexContent" class="col-md-12">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<form:form class="form-inline" action="/user/simple_shop" method="GET" modelAttribute="filter">
						<custom:hiddenInputs excludeParams="min, max, search, producer, color, deck. wheel, truck"/>
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Sort by name" paramValue="name" />
								<custom:sort innerHtml="Sort by price" paramValue="price" />
							</ul>
						</div><br>
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
						<h3><label for="search" class="control-label">Search :</label></h3>
						<div class="form-group">
							<form:input path="search" style="width: 150px;" class="form-control" placeholder="name"/>
						</div><br>
						<h3><label for="deckIds" class="control-label">Deck :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${decks}" path="deckIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="colorIds" class="control-label">Color :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${colors}" path="colorIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="truckIds" class="control-label">Truck :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${trucks}" path="truckIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="wheelIds" class="control-label">Wheels :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${wheels}" path="wheelIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="producerIds" class="control-label">Producer :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${producers}" path="producerIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="min" class="control-label">Price :</label></h3>
						<div class="form-group">
							<form:input path="min" style="width: 60px;" class="form-control" placeholder="min"/>
							<form:input path="max" style="width: 60px;" class="form-control" placeholder="max"/>
						</div><br>
						<div class="form-group"><br>
							<button type="submit" class="btn btn-success">Search</button>
							<a href  = "/user/simple_shop/cancel" class="btn btn-primary" >Cancel</a>
						</div>
					</form:form>
				</div>			
				
				<div class="col-md-9">
					<c:forEach items="${page.content}" var="commodity">								
						<div class="row">
							<div class="col-md-3 col-xs-3">
								<a href="/user/simple_product_page/${commodity.id}">
									<img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}
										.jpg?version=${commodity.version}">
								</a>
							</div>
							<div class="col-md-5">
								<div class="row">
									<h2><b><a href="/user/simple_product_page/${commodity.id}">
										${commodity.name}</a></b></h2>
								</div>
								<div class="row">
									<h4>${commodity.price}<b>&#8372;</b></h4>
								</div>
								${commodity.description}
							</div>										
						</div>
						<div id="marTop" class="col-md-12"></div>
					</c:forEach>
				</div>	
			
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12 col-xs-12 text-center">
				<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
			</div>
		</div>
				
	</div>  
</sec:authorize>