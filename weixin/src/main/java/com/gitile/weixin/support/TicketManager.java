package com.gitile.weixin.support;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.gitile.weixin.api.TicketAPI;
import com.gitile.weixin.bean.Ticket;

/**
 * TicketManager ticket 自动刷新
 *
 */
public class TicketManager {

	private static Map<String,String> ticketMap = new LinkedHashMap<String,String>();

	private static Map<String,Timer> timerMap = new HashMap<String, Timer>();


	/**
	 * 初始化ticket 刷新，每119分钟刷新一次。
	 * 依赖TokenManager
	 * @param appid
	 */
	public static void init(final String appid){
		if(!timerMap.containsKey(appid)){
			Timer timer = new Timer(true);
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					String access_token = TokenManager.getToken(appid);
					Ticket ticket = TicketAPI.ticketGetticket(access_token);
					ticketMap.put(appid,ticket.getTicket());
				}
			},0,1000*60*119);
			timerMap.put(appid,timer);
		}
	}

	/**
	 * 获取 jsapi ticket
	 * @param appid
	 * @return
	 */
	public static String getTicket(final String appid){
		return ticketMap.get(appid);
	}

	/**
	 * 获取第一个appid 的  jsapi ticket
	 * 适用于单一微信号
	 * @param appid
	 * @return
	 */
	public static String getDefaultTicket(){
		Object[] objs = ticketMap.values().toArray();
		return objs.length>0?objs[0].toString():null;
	}

}
