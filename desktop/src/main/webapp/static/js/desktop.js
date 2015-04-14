my.register('my.desktop');
my.desktop = {
    init:function() {
        $("#fileContiner").on('mouseenter', ".file", function (e) {
            $(this).addClass("hover");
        }).on('mouseleave', ".file", function(){
            $(this).removeClass("hover");
        }).on('mousedown', ".file", function (e) {
            //鼠标右键,有选中，且当前即为选中
            if(e.which==3 && !$(this).hasClass("select")){
                $("#fileContiner .file").removeClass("select");
                $(this).addClass("select");
            }
        }).on('click', ".file", function (e) {
            //再次绑定，防止冒泡到html的click事件
            stopEP(e);
            $("#fileContiner .file").removeClass("select");
            $(this).addClass("select");
        }).on('dblclick', ".file", function(e){//双击打开
            //双击事件
            my.desktop.openApp();
        });
        $("html").on('click',function (e) {
            my.desktop.rightMenu.hidden();
            $("#fileContiner .file").removeClass("select");
        });
        $("#ui-desktop").on('click',function (e) {
            if ($("#menuwin").css("display")=='block') {
                $("#menuwin").css("display", "none");
            }
        });
        $(".start").click(function () {
            if ($("#menuwin").css("display")=='block') {
                $("#menuwin").css("display", "none");
            } else {
                $("#menuwin").css("display", "block");
            }
        });
        $("#menuwin").click(function () {
            $("#menuwin").css("display", "none");
        });
        my.desktop.refresh();
    },
    refresh:function() {
    	var background = $.cookie('background')||'7.jpg';
    	var backgroundImageUrl = my.util.global.staticPath+"/images/wallpaper/"+background;
    	if(background.startWith('http')) {
    		backgroundImageUrl = background;
    	}
        my.desktop.setWall(backgroundImageUrl);
        my.desktop.loadApp();
    },
    loadApp:function(param, callback) {
    	$("#fileContiner").html('');
    	var param = {};
    	my.desktop.service.getMyApp(param, function(data) {
    		if(data && data.length > 0) {
    			var html = "";
    			for(var i=0; i<data.length; i++) {
                	var id = data[i]['id'];
                    var name = data[i]['name'] || '--';
                    var icon = data[i]['icon'] || '';
                    var simple = data[i]['simple'] || '0';
                    var resize = data[i]['resize'] || '0';
                    var height = data[i]['height'] || '600';
                    var width = data[i]['width'] || '800';
                    var appUrl = data[i]['appUrl'] || '';
                    var authorize = data[i]['authorize'] || '0';
                    var menuCss = 'menuDefault';
                    if(authorize==1) {
                    	menuCss = 'menuApp';
                    }
                    html += '<div class="file systemBox '+menuCss+'" data-app=\'{"name":"'+name+'","simple":'+simple+',"resize":'+resize+',"width":"'+width+'","height":"'+height+'","content":"'+appUrl+'","icon":"'+icon+'"}\'>'
    				+'<div class="ico" style="background-image:url('+my.util.global.staticPath+'/images/app/'+icon+')"></div>'
    				+'<div class="titleBox"><span>'+name+'</span></div></div>';
                }
    			$("#fileContiner").hide().html(html).fadeIn(200);
    		}
    	});
	},
    setWall:function(imgUrl){
        $('.wallbackground').attr('src',imgUrl).one('load',function(){
            $('#ui-desktop').css('background-image','url('+imgUrl+')');
        });
    },
    openWindow:function(titile,url, width, height) {
        $.dialog.open(url,{
            title:titile,
            fixed:true,
            ico: my.util.global.staticPath+'/images/app/computer.png',
            resize:1,
            width:width,
            height:height
        });
    },
    openApp:function(app) {
        if (app == undefined) {
            var selectObj= $("#fileContiner .file.select");
            var app = $.parseJSON(selectObj.attr('data-app'));
        }
        if(app!=undefined) {
            var icon = app.icon;
            if(icon) {
                icon = my.util.global.staticPath+'/images/app/' + app.icon;
            } else {
                icon = my.util.global.staticPath+'/images/app/computer.png'
            }
            //高宽css px或者*%
            if (typeof(app.width)!='number' 
                && app.width.search('%') == -1){app.width = parseInt(app.width);} 
            if (typeof(app.height)!='number' 
                && app.height.search('%') == -1){app.height = parseInt(app.height);}
            $.dialog.open(app.content,{
                title:app.name,
                fixed:true,
                ico:icon,
                resize:app.resize,
                simple:app.simple,
                width:app.width,
                height:app.height
            });
        } 
    },
    fullScreen:function(){
		if ($('body').attr('fullScreen') == 'true') {
			my.desktop.exitfullScreen();
		}
		$('body').attr('fullScreen','true');
		var docElm = document.documentElement;			
        if (docElm.requestFullscreen) {
            docElm.requestFullscreen();
        }else if (docElm.mozRequestFullScreen) {
            docElm.mozRequestFullScreen();
        } else if (docElm.webkitRequestFullScreen) {
            docElm.webkitRequestFullScreen();
        }
	},
	exitfullScreen:function(){
		$('body').attr('fullScreen','false');
		if (document.exitFullscreen) {
		    document.exitFullscreen();
		}else if(document.mozCancelFullScreen) {
		    document.mozCancelFullScreen();
		}else if(document.webkitCancelFullScreen) {
		    document.webkitCancelFullScreen();
		}
	},
};
//任务栏
my.desktop.task={
    dialog_focus_id:'',
    dialogs:{},
    init:function() {
		$('<div class="task_tab hidden"><div class="tabs"><div class="last" style="clear:both;"></div></div></div>').appendTo('body');
        $(window).bind("resize",function(){
            my.desktop.task._resetWidth('resize');
        });
        $("body").on('mouseenter', ".tabs .tab", function (e) {
			if (!$(this).hasClass('this')){
				$(this).addClass('hover');
			}
		}).on('mouseleave', ".tabs .tab", function(){
			$(this).removeClass('hover');
		}).on('mousedown', ".tabs .tab", function (e) {
            //鼠标右键,有选中，且当前即为选中
            if(e.which==3 && !$(this).hasClass("this")){
                var id = $(this).attr('id');
                my.desktop.task.click(id);
            }
        }).on("click", ".tabs .tab", function () { 
            var id = $(this).attr('id');
            my.desktop.task.click(id);
        });
    },
    click:function(selectID){
        var dialog = art.dialog.list[selectID];
        var dom = $('.'+selectID);
        if (dom.css('visibility') == 'hidden'){
            dialog.display(true);
        }else if(dom.hasClass('aui_state_focus')){
            dialog.display(false);
        }else{
            dialog.zIndex();
        }
    },
    add:function(id,title){
		var title_hover = title.replace(/<[^>]+>/g,"");
		var html_tab = '<div class="tab taskBarMenu" id="'+id+'" title="'+title_hover+'">'+title+'</div>';
		$(html_tab).insertBefore('.task_tab .last');
		my.desktop.task._resetWidth('add');
		my.desktop.task.dialogs[id] = {id:id,name:name};
	},
    focus:function(selectID) {
		//添加最初标签，或者标签不存在
		$('.task_tab .this').removeClass('this');
		$('.task_tab #'+selectID).addClass('this');
		my.desktop.task.dialog_focus_id = selectID;
	},
    close:function(selectID) {
		delete my.desktop.task.dialogs[selectID];
		$('.task_tab #'+selectID).animate({width:0},160,function(){
			$('.task_tab #'+selectID).remove();
			my.desktop.task._resetWidth('close');
			if ($('.tabs .tab').length == 0) {
				$('.task_tab').addClass('hidden');
			}
		});
	},
    _resetWidth:function(action){
        var max_width	= 110;
        var reset_width = max_width;
        var max_width_all = max_width+12;		
        var $tabs		= $('.task_tab .tab');
        var full_width	= $('.task_tab .tabs').width();
        var count		= $tabs.length;
        //不用变化的个数				
        var max_count = Math.floor(full_width/max_width_all);
        if (count > max_count) {
            reset_width = Math.floor(full_width/count)-12;
        }
        switch (action) {
            case 'add':
                $('.task_tab .tabs .this').css('width','0')
                .animate({'width':reset_width+'px'},160);
            case 'close':
                $tabs.animate({width:reset_width+'px'},160);
                break;
            case 'resize':
                $tabs.css('width',reset_width+'px');
                break;
            default:break;
        }
    }
};
//右键菜单
my.desktop.rightMenu={
    init:function() {
        $('<div id="rightMenu" class="hidden"></div>').appendTo('body');
        $('body').on("click", '.context-menu-list', function(e){
            stopEP(e);return false;//屏蔽html点击隐藏
        });
        my.desktop.rightMenu._bindDesktop();
        my.desktop.rightMenu._bindApp();
        my.desktop.rightMenu._bindTask();
    },
    hidden:function(){
        $('.context-menu-list').filter(':visible').trigger('contextmenu:hide');
    },
    contextMenu:function(event){
        my.desktop.rightMenu.hidden();
        if ($("#menuwin").css("display")=='block') {
            $("#menuwin").css("display", "none");
        }
        return false;
    },
    _bindDesktop:function() {
        $.contextMenu({
            selector: "#fileContiner",
            zIndex:9999,
            callback: function(key, options) {
                switch(key){
                    //桌面
                    case 'refresh':my.desktop.refresh();break;
                    case 'full':my.desktop.fullScreen();break;
                    case 'upload':my.desktop.openWindow('上传', my.util.global.contextPath+'common/upload', 300, 400);break;
                    case 'backgroud':my.desktop.openWindow('桌面背景', my.util.global.contextPath+'common/backgroud', 800, 500);break;
                    case 'setting':my.desktop.openWindow('系统设置', my.util.global.contextPath+'common/profile', 800, 500);break;
                    default:break;
                }
            },
            items: {
                "refresh":{name:"刷新",icon:"refresh",accesskey: "e"},
                "full":{name:"全屏",icon:"size-fullscreen",accesskey: "m"},
                "sep1":"--------",   
                "upload":{name:"上传",icon:"cloud-upload",accesskey: "u"},
                "sep2":"--------", 
                "backgroud":{name:"桌面背景",icon:"picture",accesskey: "b"},
                "setting":{name:"系统设置",icon:"settings",accesskey: "s"}
            }
        });
    },
    _bindApp:function() {
        $.contextMenu({
            selector:'.menuDefault',
            zIndex:9999,
            items: {"open":{name:"打开",icon:"action-redo",accesskey: "o"}},
            callback: function(key, options) {
                switch(key){
                    case 'open':my.desktop.openApp();break;
                    default:break;
                }
            }
        });
        $.contextMenu({
            selector:'.menuApp',
            zIndex:9999,
            items: {
                "open":{name:"打开",icon:"action-redo",accesskey: "o"},
                "sep1":"--------",
                "uninstall":{name:"卸载",icon:"close",accesskey: "u"}
            },
            callback: function(key, options) {
                switch(key){
                    case 'open':my.desktop.openApp();break;
                    default:break;
                }
            }
        });
    },
    _bindTask:function(action) {
        $.contextMenu({
            zIndex:9999,
            selector: '.taskBarMenu', 
            items: {
                "quit":{name:"关闭当前窗口",icon:"close",accesskey: "q"},
                "quitOthers":{name:"关闭其他窗口",icon:"close",accesskey: "o"},
                "quitAlls":{name:"关闭所有窗口",icon:"close",accesskey: "a"},
            },
            callback: function(key, options) {
                var id =options.$trigger.attr('id');
                var dialog = art.dialog.list[id];
                switch(key){
                    case 'quit':
                        dialog.close();
                        break;                  
                    case 'quitOthers':
                        $.each(art.dialog.list,function(index,dlg){
                            if(id != index) dlg.close();
                        });
                        break;
                     case 'quitAlls':
                        $.each(art.dialog.list,function(index,dlg){
                            dlg.close();
                        });
                        break;
                    default:break;
                }
            }
        });
    }
}
my.desktop.service = {
	// 获取我的应用
	getMyApp:function(param, callback) {
		$.ajax({
			'url' : my.util.global.contextPath+'common/getUserApplicaions',
			'data' : param,
			'type' : 'GET',
			'dataType' : 'json',
			'async'	   : false,
			'beforeSend' : function() {
			},
			'success' : function(data) {
				callback(data);
			},
			'error'  : function(e) {
			}
		});
	},
	
	
};

$(document).ready(function(){
	my.util.ajaxInit();
    my.desktop.init();
    my.desktop.task.init();
    my.desktop.rightMenu.init();
    $(window).load(function() {
        $('#ui-preloader').delay(350).fadeOut('slow');
    });
});