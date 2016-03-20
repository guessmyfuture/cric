 <%@page contentType="text/html" pageEncoding="UTF-8"%>﻿
 <%
 String limit1=request.getParameter("limit");
 int limit=Integer.parseInt(limit1);
 
 String offset1=request.getParameter("offset");
 int offset=Integer.parseInt(offset1); 
 %>
 
 <%
 if(limit<50)
 { 
 %> 
 {"news":[
 {"postedId":"5","name":"Sundar","postedPicture":"images/member.jpg","message":"My Message text 10","imageUrl":["images/post/img1.jpg"],"caption":"My Caption Text","timestamp":"23/10/2012 12:50pm","likes":[{"count":"167","likedby":"jai"}],"shares":[{"count":"1","sharedby":"jai"}],"comments":[{"id":"1","personid":"1","personname":"mani","personimage":"images/member.jpg","commentText":"hi welcome"}]},
 {"postedid":"1","name":"John","postedPicture":"images/member.jpg","message":"My Message text 10","imageUrl":["images/post/img2.jpg","images/post/img3.jpg"],"caption":"My Caption Text","timestamp":"23/10/2012 12:50pm","likes":[{"count":"12","likedby":"jai"}],"shares":[{"count":"1","sharedby":"jai"}],"comments":[{"id":"1","personid":"1","personname":"mani","personimage":"images/member.jpg","commenttext":"hi welcome"},{"id":"1","personid":"1","personname":"Kailash","personimage":"images/member.jpg","commenttext":"hi welcome"},{"id":"1","personid":"3","personname":"Rajesh","personimage":"images/member.jpg","commenttext":"hi welcome"}]},
 {"postedid":"1","name":"John","postedPicture":"images/member.jpg","message":"My Message text 10","imageUrl":["images/post/img1.jpg","images/post/img2.jpg","images/post/img3.jpg"],"caption":"My Caption Text","timestamp":"23/10/2012 12:50pm","likes":[{"count":"12","likedby":"jai"}],"shares":[{"count":"1","sharedby":"jai"}],"comments":[{"id":"1","personid":"1","personname":"mani","personimage":"images/member.jpg","commenttext":"hi welcome"},{"id":"1","personid":"1","personname":"Kailash","personimage":"images/member.jpg","commenttext":"hi welcome"},{"id":"1","personid":"3","personname":"Rajesh","personimage":"images/member.jpg","commenttext":"hi welcome"}]},
 {"postedid":"1","name":"John","postedPicture":"images/member.jpg","message":"My Message text 10","imageUrl":["images/post/img1.jpg","images/post/img2.jpg","images/post/img3.jpg"],"caption":"My Caption Text","timestamp":"23/10/2012 12:50pm","likes":[{"count":"12","likedby":"jai"}],"shares":[{"count":"1","sharedby":"jai"}],"comments":[{"id":"1","personid":"1","personname":"mani","personimage":"images/member.jpg","commenttext":"hi welcome"},{"id":"1","personid":"1","personname":"Kailash","personimage":"images/member.jpg","commenttext":"hi welcome"},{"id":"1","personid":"3","personname":"Rajesh","personimage":"images/member.jpg","commenttext":"hi welcome"}]}
  ]}
<%
}
%>
<%
 if(false)
 { 
 %> 
 
<%
}
%>
 