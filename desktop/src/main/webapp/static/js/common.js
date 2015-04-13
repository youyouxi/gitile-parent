//申明用于命名空间注册
my={};
my.register= function(fname){
	var nArray = fname.split('.');//分置方法
	var tfn = '';
	var feval= '';
	
	for(var i= 0; i< nArray.length;i++){
		if(i!=0){tfn += '.';}
		tfn += nArray[i];
		feval += "if (typeof("+tfn+") == 'undefined'){" + tfn + "={};}";
	}
	//alert(feval);
	if(feval!=''){eval(feval);}
};
my.register('my.util');//公用方法
my.util.global={
		contextPath:'/',
		staticPath:'/static'
};//全局变量

// 日期格式化
my.util.dateFormat=function(time,format) {
    if(!time) return null;
    var date = new Date(time);
    var o = {
        "M+" : date.getMonth()+1, //month
        "d+" : date.getDate(), //day
        "h+" : date.getHours(), //hour
        "m+" : date.getMinutes(), //minute
        "s+" : date.getSeconds(), //second
        "q+" : Math.floor((date.getMonth()+3)/3), //quarter
        "S" : date.getMilliseconds() //millisecond
    };
    if(/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if(new RegExp("("+ k +")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        }
    }
    return format;
};
//防止事件冒泡
function stopEP(e) {
    e = e || window.event;
	if (e.stopPropagation) {
		e.stopPropagation();
	}
	if (e.preventDefault) {
		e.preventDefault();
	}
	e.cancelBubble = true;
	e.keyCode = 0;  
    e.returnValue = false;  
}
// 判断字符串是否为空
function isNotEmpty(str) {
    if(str!=null&&str.length>0) {
    	return true;
    }
    return false;
}
function isEmpty(str) {
    return !isNotEmpty(str);
}
my.util.ajaxInit=function() {
	jQuery(document).ajaxSend(function(e,XHR,options){
		// 开始发送
	}).ajaxError(function(e,XHR,settings,thrownError){
		$.gritter.add({
			title:	'提示',
			text:	'连接服务器时发生错误.请再试一次！',
			sticky: true
		});
	}).ajaxComplete(function(e, XHR, options){
		try {
			var str = XHR.getAllResponseHeaders();
			if (str.indexOf("sessionstatus") >= 0) {
				//提示消息
				$.gritter.add({
					title:	'提示',
					text:	'登录超时.请重新登录！',
					sticky: true
				});
			} else if (str.indexOf("authstatus") >= 0) {
				//提示消息
				$.gritter.add({
					title:	'提示',
					text:	'对不起，您没有操作权限,请联系管理员！',
					sticky: true
				});
			} else {
				if (XHR.status == 200) {
					// 成功返回结果
				}
			}
		} catch (e) {
			$.gritter.add({
				title:	'提示',
				text:	'连接服务器时发生错误.请再试一次！',
				sticky: true
			});
		}
	});
}
//添加startWith原生方法
String.prototype.startWith=function(s){
  if(s==null||s==""||this.length==0||s.length>this.length) {
	  return false;
  }
  if(this.substr(0,s.length)==s) {
	  return true;
  } else {
	  return false;
  }
  return true;
 }