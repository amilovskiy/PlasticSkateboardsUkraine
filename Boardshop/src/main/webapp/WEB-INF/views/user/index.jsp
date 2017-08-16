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
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<div class="col-md-9">
						<ul class="nav navbar-nav"></ul>
				 	</div>
                	<div class="col-md-2">
	                	 <ul class="nav navbar-nav">
							<a href="/admin"><button class="btn btn-primary navbar-btn">Admin</button></a>
							&nbsp;&nbsp;
	                 	 </ul>
	                 	 <div id="logout">
	                 		<form:form action="/logout" method="POST">
	                    		<button class="btn btn-danger navbar-btn">Logout</button>
	                    	</form:form>
	                 	 </div>
                 	</div>
                 </sec:authorize>
                 <sec:authorize access="hasRole('ROLE_USER')">
					<div class="col-md-10">
						<ul class="nav navbar-nav"></ul>
				 	</div>
                 	<div class="col-md-1">
	                 	<ul class="nav navbar-nav"></ul>
	                 		<div id="logout">
	                 			<form:form action="/logout" method="POST">
	                    			<button class="btn btn-danger navbar-btn">Logout</button>
	                    		</form:form>
	                 		</div>
                 	</div>
                 </sec:authorize>
                 <div class="col-md-1">
				 	<a href="/cart"><span style="margin-top: 17px; color: white;" class="glyphicon glyphicon-shopping-cart"></span></a>
				 </div>
          	</div>
         </div>
    </nav>
        
	<div id="indexContentShopImg" class="col-md-12">  
		<div class="container-fluid">
			<div class="row">
				<a href="/user/shop"><img id="ind" src="/resources/img/shopMain2.jpg"></a>
			</div>
		</div>
		
		<div id="marTop" class="col-md-12"></div>
		
		<div class="col-md-12">
			<div class="row text-center">
				<h1><b>Plastic Skateboards Ukraine</b></h1>
			</div>
			<div class="text-center">
				<p>Integer felis. Commodo fermentum laoreet vel montes aenean. Arcu vulputate magna, porta amet libero sit velit. 
					Eleifend. Vivamus nonummy adipiscing pulvinar luctus. Auctor ac penatibus. 
					Bibendum metus urna id et mollis interdum scelerisque neque integer tortor. Nascetur. 
					Integer pulvinar auctor dis, ac. Pulvinar habitasse cursus rutrum est netus semper ipsum non curabitur. 
					Nunc sagittis nullam neque magnis condimentum ridiculus viverra. Mi pretium a velit malesuada. 
					Facilisi nisi porta enim metus mi, primis cras praesent platea fames blandit velit facilisi nostra 
					nonummy ullamcorper cursus, magna. Id morbi eget purus metus aliquet suspendisse in eleifend pharetra 
					congue blandit molestie curae; dolor porta imperdiet orci urna auctor habitasse suspendisse velit, 
					ultrices ridiculus sed convallis. A velit sapien Natoque malesuada iaculis tellus semper eros, ullamcorper.
					Risus sed per ac libero. Duis urna eleifend eleifend turpis facilisis proin iaculis, urna velit. 
					Orci inceptos leo dis, tempor Cursus blandit facilisi hendrerit integer tempus nostra euismod ipsum, 
					non quisque sit pede nec metus phasellus curabitur pharetra purus duis est purus montes sed convallis. 
					Nisl vel mi risus conubia egestas curae; volutpat. Blandit class. Sit dignissim vitae sociosqu. 
					Viverra suscipit amet arcu vehicula ante at pharetra felis placerat. Turpis molestie dignissim nec leo, 
					diam at placerat curabitur consectetuer pellentesque vivamus sagittis iaculis in aliquet. Nascetur torquent, 
					conubia turpis nostra sapien quisque primis lorem convallis. Tortor Pretium Dolor potenti pharetra.
					Senectus sollicitudin venenatis duis accumsan vitae quisque curabitur libero massa cum accumsan sagittis
					mauris mattis scelerisque vivamus nunc ultrices morbi sapien. Penatibus. Risus sodales porta et. 
					Dignissim pretium suspendisse facilisis Justo. Praesent fermentum in convallis, proin rutrum nam congue 
					ornare porttitor mus phasellus vestibulum ad, commodo. Est lectus viverra malesuada penatibus et lectus 
					lorem vel consectetuer ad a. Mattis rutrum tempor Curae; dignissim nunc. Habitant id sollicitudin parturient 
					congue. Conubia dapibus quisque est faucibus vel. Dui nisl, urna neque natoque metus nonummy etiam 
					elementum in volutpat fusce. Dignissim dignissim purus pretium hymenaeos viverra integer enim diam 
					vehicula tempor leo imperdiet fusce morbi nullam metus id amet eu orci imperdiet nisl hac et viverra 
					mus ut sit vehicula montes vulputate scelerisque vitae amet ornare. Accumsan. Pulvinar, mattis ad urna.</p><br>
				<img  src="/resources/img/Tkjzka627_A.png">
			</div>
		</div>
	</div>              
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
 	<nav class="navbar navbar-inverse" role="navigation">
    	<div class="collapse navbar-collapse" id="myNavbar">
			<div class="container">
				<div class="col-md-10">
					<ul class="nav navbar-nav"></ul>
				</div>
                <ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/registration">Registration</a></li>
				</ul>
			</div>
		</div>
	</nav>
                   
	<div id="indexContentShopImg" class="col-md-12">  
		<div class="container-fluid">
			<div class="row">
				<a href="/user/simple_shop"><img id="ind" src="/resources/img/shopMain2.jpg"></a>
			</div>
		</div>
		
		<div id="marTop" class="col-md-12"></div>
		
		<div class="col-md-12">
			<div class="row text-center">
				<h1><b>Plastic Skateboards Ukraine</b></h1>
			</div>
			<div class="text-center">
				<p>Integer felis. Commodo fermentum laoreet vel montes aenean. Arcu vulputate magna, porta amet libero sit velit. 
					Eleifend. Vivamus nonummy adipiscing pulvinar luctus. Auctor ac penatibus. 
					Bibendum metus urna id et mollis interdum scelerisque neque integer tortor. Nascetur. 
					Integer pulvinar auctor dis, ac. Pulvinar habitasse cursus rutrum est netus semper ipsum non curabitur. 
					Nunc sagittis nullam neque magnis condimentum ridiculus viverra. Mi pretium a velit malesuada. 
					Facilisi nisi porta enim metus mi, primis cras praesent platea fames blandit velit facilisi nostra 
					nonummy ullamcorper cursus, magna. Id morbi eget purus metus aliquet suspendisse in eleifend pharetra 
					congue blandit molestie curae; dolor porta imperdiet orci urna auctor habitasse suspendisse velit, 
					ultrices ridiculus sed convallis. A velit sapien Natoque malesuada iaculis tellus semper eros, ullamcorper.
					Risus sed per ac libero. Duis urna eleifend eleifend turpis facilisis proin iaculis, urna velit. 
					Orci inceptos leo dis, tempor Cursus blandit facilisi hendrerit integer tempus nostra euismod ipsum, 
					non quisque sit pede nec metus phasellus curabitur pharetra purus duis est purus montes sed convallis. 
					Nisl vel mi risus conubia egestas curae; volutpat. Blandit class. Sit dignissim vitae sociosqu. 
					Viverra suscipit amet arcu vehicula ante at pharetra felis placerat. Turpis molestie dignissim nec leo, 
					diam at placerat curabitur consectetuer pellentesque vivamus sagittis iaculis in aliquet. Nascetur torquent, 
					conubia turpis nostra sapien quisque primis lorem convallis. Tortor Pretium Dolor potenti pharetra.
					Senectus sollicitudin venenatis duis accumsan vitae quisque curabitur libero massa cum accumsan sagittis
					mauris mattis scelerisque vivamus nunc ultrices morbi sapien. Penatibus. Risus sodales porta et. 
					Dignissim pretium suspendisse facilisis Justo. Praesent fermentum in convallis, proin rutrum nam congue 
					ornare porttitor mus phasellus vestibulum ad, commodo. Est lectus viverra malesuada penatibus et lectus 
					lorem vel consectetuer ad a. Mattis rutrum tempor Curae; dignissim nunc. Habitant id sollicitudin parturient 
					congue. Conubia dapibus quisque est faucibus vel. Dui nisl, urna neque natoque metus nonummy etiam 
					elementum in volutpat fusce. Dignissim dignissim purus pretium hymenaeos viverra integer enim diam 
					vehicula tempor leo imperdiet fusce morbi nullam metus id amet eu orci imperdiet nisl hac et viverra 
					mus ut sit vehicula montes vulputate scelerisque vitae amet ornare. Accumsan. Pulvinar, mattis ad urna.</p><br>
				<img  src="/resources/img/Tkjzka627_A.png">
			</div>
		</div>
	</div>                         
</sec:authorize>

<div id="mainHeight" class="col-md-6"></div>

