<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style> 
.flex-container {
    display: -webkit-flex;
    display: flex;
    width: auto;
    height: auto;
    font-family: Courier;
    margin: 8px;
   
}

.flex-item {
   
    width: 33.33%;
    height: auto;

}
.flex-item1 {
    width: 11.11%;
    height: auto;
    text-align: right;
}
.center {
    text-align: center;
    width: 33.33%;
    height: auto;
}


</style>
</head>
<body>
 
<div class="flex-container">
  <div class="flex-item">${meta}flex item </div>
  <div class="center">flex item </div>
  <div class="flex-item"></div>  
</div>

<div class="flex-container">
  <div class="flex-item">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div> 
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div>  
</div>

<div class="flex-container">
  <div class="flex-item">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div> 
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div>  
</div>

<div class="flex-container">
  <div class="flex-item">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div> 
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div>  
</div>

<div class="flex-container">
  <div class="flex-item">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div> 
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div>  
</div>

<div class="flex-container">
  <div class="flex-item">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div> 
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div>  
</div>

<div class="flex-container">
  <div class="flex-item">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div> 
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div>  
</div>

<div class="flex-container">
  <div class="flex-item">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div> 
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item </div>
  <div class="flex-item1">flex item</div>  
</div>

</body>
</html>