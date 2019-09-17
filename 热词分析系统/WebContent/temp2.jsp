<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.model.Key" %>
    <%@ page import="com.dao.KeyDao" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="cloudJs/echarts.min.js"></script>
<script src="cloudJs/echarts-wordcloud.min.js"></script>
</head>
<body>
<%
KeyDao keyDao=new KeyDao();
List<Key> keys=keyDao.loadKey(); 
%>
<div class="panel panel-default">	 
	<div class="panel-body" style="width: auto;height: 450px;">		  
	   <div id="worldCloud" style="width: 100%;height: 100%">
	   </div>	 	
    </div>
</div>
<script type="text/javascript"> 		 		 	
var worldCloudcharts=echarts.init(document.getElementById('worldCloud')); 
var worldCloudoption = { 			 
		title: { 			     
			text: '热词TOP50', 	
			x: 'center', 	
			textStyle: { 	
				fontSize: 50, 
				color:'#FFFFFF' 
				}  			 
}, 			   
tooltip: { 	
	show: true 			
	}, 			  
	series: [{ 
		name: '热词TOP50', 
		type: 'wordCloud', 
		sizeRange: [6, 66], 
		rotationRange: [-45, 90], 
		textPadding: 0, 	
		autoSize: { 	
			enable: true, 	
			minSize: 6 			 
			}, 			      
			textStyle: { 
				normal: { 	
					color: function() { 
						return 'rgb(' + [ 	
							Math.round(Math.random() * 160), 
							Math.round(Math.random() * 160), 	
							Math.round(Math.random() * 160) 	
							].join(',') + ')'; 			       
						} 			          
			}, 			           
			emphasis: { 	
				shadowBlur: 10, 	
				shadowColor: '#333' 	
				} 			     
			}, 			      
			data: [
				<%
				int i=0;
				for(Key key:keys)
				{%>
				{ 	
					name: "<%=key.getKey()%>", 	
					value: "<%=key.getNum()%>"
					<%i++;%>
					}
				<%
				if(i!=keys.size())
					{%>
						,
						<%
					}
				}
				%>
			] 	
			}] 	
	};  	
var JosnList = [];  	
JosnList.push(
		<%
		i=0;
		for(Key key:keys)
		{%>
		{ 	
			name: "<%=key.getKey()%>", 	
			value: "<%=key.getNum()%>"
			<%i++;%>
			}
		<%
		if(i!=keys.size())
			{%>
				,
				<%
			}
		}
		%>

	); 
worldCloudoption.series[0].data = JosnList;  	
worldCloudcharts.setOption(worldCloudoption);
//添加点击事件（单击），还有其他鼠标事件和键盘事件等等
worldCloudcharts.on("click",function(param){  
	  var name=param.name;
	  window.location.href="index.jsp?name="+name;
 	  });
</script>
<!--点击按钮-->








</body>
</html>