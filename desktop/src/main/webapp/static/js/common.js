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
		tips('连接服务器时发生错误.请再试一次！', 'error');
	}).ajaxComplete(function(e, XHR, options){
		try {
			var str = XHR.getAllResponseHeaders();
			if (str.indexOf("sessionstatus") >= 0) {
				//提示消息
				tips('登录超时.请重新登录！', 'warning');
			} else if (str.indexOf("authstatus") >= 0) {
				//提示消息
				tips('对不起，您没有操作权限,请联系管理员！', 'warning');
			} else {
				if (XHR.status == 200) {
					// 成功返回结果
				}
			}
		} catch (e) {
			tips('连接服务器时发生错误.请再试一次！', 'error');
		}
	});
}
// 通用左边菜单
my.util.leftMenuInit=function() {
	$(".setting li").hover(function(){
		$(this).addClass("hover");
	},  function(){ 
		$(this).removeClass("hover");
	});
	$(".setting li").on('click',function (e) {
		var url = $(this).attr("target_url");
		top.artDialog.focus.refreshUrl(url);
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

/*
* iframe之间函数调用
*
* main frame中每个frame需要name和id，以便兼容多浏览器
* 如果需要提供给其他frame调用，则需要在body中加入
* <input id="FrameCall" type='hidden' action='' value='' onclick='FrameCall.api()'/>
* 调用例子：Frame.doFunction('main','goUrl','"'+url+'"');该frame调用id为main的兄弟frame的goUrl方法，参数为后面的
* 参数为字符串时需要加引号，否则传过去会被理解成一个未定义变量
*/
var FrameCall = (function(){
	var idName 		= "FrameCall";
	var idNameAll	= "#"+idName;
	var ie = !-[1,];//是否ie
	return{
		apiOpen:function(){
			var html = '<input id="FrameCall" type="hidden" action="1" value="1" onclick="FrameCall.api()" />';
			$(html).prependTo('body');
		},
		//其他窗口调用该窗口函数，调用另一个frame的方法
		api:function(){
			var action = $(idNameAll).attr('action');
			var value=$(idNameAll).attr('value');
			
			if (action == 'get') {//获取变量
				share.data('create_app_path',eval(value));
				return;
			}			
			var fun=action+'('+value+');';//拼装执行语句，字符串转换到代码
			try{
				eval(fun);
			} catch(e) {};
		},
		//该窗口调用顶层窗口的子窗口api,调用iframe框架的js函数.封装控制器。
		top:function(iframe,action,value){
			if (!window.parent.frames[iframe]) return;
			//var obj = window.top.frames[iframe].document;
			var obj = window.parent.frames[iframe].document;
			obj=obj.getElementById(idName);		
			$(obj).attr("action",action);
			$(obj).attr("value",value);
			obj.click();
		},
		//该窗口调用父窗口的api
		father:function(action,value){
			if (ie){//获取兄弟frame的dom树
				var obj=window.parent.document;//IE
			}else{
				var obj=window.parent.document;//chrome safari firefox...
			}
			obj=obj.getElementById(idName);	
			$(obj).attr("action",action);
			$(obj).attr("value",value);
			obj.click();	
		},
		//___自定义通用方法，可在页面定义更多提供给接口使用的api。
		goUrl:function(url){
			window.location.href=url;
		},
		goRefresh:function(){
			window.location.reload(); 
		}
	}
})();


//通用提示信息框
var tips = function(msg,code){
	Tips.tips(msg,code);
}
var Tips =  (function(){
	var in_time  = 600;
	var delay = 1200;
	var opacity  = 0.7;
	var _init = function(msg,code){
		var tipsIDname = "messageTips";
		var tipsID = "#"+tipsIDname;
		if ($(tipsID).length ==0) {
			var html = '<div id="'+tipsIDname+'" style="z-index:50;min-width:60px;position:fixed;padding:2px 2em;text-align:center;line-height:30px;border-bottom-right-radius:0px;border-bottom-left-radius:0px;"><i style="padding: 0 6px;font-size: 15px;"></i><span></span></div>'
			$('body').append(html);	
			$(window).bind('resize',function(){
				if ($(tipsID).css('display') =="none") return;
				self.stop(true,true)
				$(tipsID).css({'left':($(window).width() - $(tipsID).width()) / 2});
			});
		}
		var self = $(tipsID),icon,color;
		switch(code){
			case 100://加长时间 5s
			case true:
			case undefined:
			case 'success':color = '#5cb85c';icon = 'icon-check';break;
			case 'info':color = '#519AF6';icon = 'icon-info';break;
			case 'warning':color = '#ed9c28';icon = 'icon-bulb';break;
			case false:
			case 'error':color = '#d9534f';icon = 'icon-close';break;
			default:color = '';icon = '';break;
		}

		if (color != '') {
			self.css({'background':color,'color':'#fff'});
			self.find('i').removeClass().addClass(icon);		
		}
		if (msg != undefined) self.find('span').html(msg);
		return self;
	};
	var tips = function(msg,code,offset_top){
		if (typeof(msg) == 'object'){
			code=msg.code;msg = msg.data;
		}
		if (offset_top == undefined) offset_top = 0;
		var self = _init(msg,code);
		if(code == 100){delay = 3500;}
		self.stop(true,true)
			.css({'display':'block','opacity':'0','top':offset_top-self.height(),
				'left':($(window).width() - self.width()) / 2})
			.animate({opacity:opacity,top:offset_top},in_time,0)
			.delay(delay)
			.animate({opacity:0,top:'-='+(offset_top+self.height())},in_time,0,function(){
				$(this).css('display','none');
			});
	};
	var loading = function(msg,code,offset_top){
		if (typeof(msg) == 'object'){
			code=msg.code;msg = msg.data;
		}
		if (offset_top == undefined) offset_top = 0;
		if (msg == undefined) msg = 'loading...'
		msg+= "&nbsp;&nbsp; <img src='"+my.util.global.staticPath+"/images/loading.gif'/>";

		var self = _init(msg,code);
		self.stop(true,true)
			.css({'display':'block','opacity':'0','top':offset_top-self.height(),
				'left':($(window).width() - self.width()) / 2})
			.animate({opacity:opacity,top:offset_top},in_time,0);
	};
	var close = function(msg,code,offset_top){
		if (typeof(msg) == 'object'){
			code=msg.code;msg = msg.data;
		}
		if (offset_top == undefined) offset_top = 0;
		var self = _init(msg,code);

		self.delay(delay)
			.animate({
				opacity:0,
				top:'-='+(offset_top+self.height())},
				in_time,0,function(){
					$(this).css('display','none');
			});
	};
	return{
		tips:tips,
		loading:loading,
		close:close
	}
})();