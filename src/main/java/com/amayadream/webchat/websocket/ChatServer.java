package com.amayadream.webchat.websocket;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * NAME   :  restdemo/com.amayadream.rest.controller
 * Author :  Amayadream
 * Date   :  2016.01.08 09:50
 * TODO   :  ChatServer
 */
@ServerEndpoint(value = "/chatServer", configurator = HttpSessionConfigurator.class)
public class ChatServer {
    Logger logger = LoggerFactory.getLogger(ChatServer.class);

    private static int onlineCount = 0; //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebsocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<ChatServer> webSocketSet = new CopyOnWriteArraySet<ChatServer>();

    private Session session;    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private String userid;      //用户名
    private HttpSession httpSession;    //request的session

    private static List list = new ArrayList<>();   //在线列表,记录用户名称

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.userid=(String) httpSession.getAttribute("userid");    //获取当前用户
        list.add(userid);
        String message = getNotice("[" + userid + "]加入聊天室,当前在线人数为"+getOnlineCount()+"位", list, "notice");
        broadcast(message);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        list.remove(userid);
        String message = getNotice("[" + userid +"]离开了聊天室,当前在线人数为"+getOnlineCount()+"位", list, "notice");
        broadcast(message);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message) {
        broadcast(message);
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
    }

    /**
     * 广播消息
     * @param message
     */
    public void broadcast(String message){
        for(ChatServer chat: webSocketSet){
            try {
                chat.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 对message进行组装
     * @param message
     * @param type
     * @return
     */
    public String getNotice(String message, List list, String type){
        JSONObject member = new JSONObject();
        member.put("message", message);
        member.put("list", list);
        member.put("type", type);
        return member.toString();
    }

    public  int getOnlineCount() {
        return onlineCount;
    }

    public  void addOnlineCount() {
        ChatServer.onlineCount++;
    }

    public  void subOnlineCount() {
        ChatServer.onlineCount--;
    }
}
