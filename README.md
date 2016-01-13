#WebChat聊天室

##一.所用技术
Java:Spring+Spring MVC+Mybatis+Oracle+WebSocket
前端:Amaze UI,弹窗用的layer,分页用的laypage,还有jquery...
jar管理:maven
开发工具:idea15.01

##二.WebSocket数据交互格式

message{type:"", message:{}, list:{}}

其中type有notice和message两种,notice是提示消息,即xx用户加入了聊天室,xx用户离开了聊天室

##三.实现功能
用户登录,用户信息展示,用户信息修改,上传和修改头像,修改密码, 在线聊天,日志记录及展示等

##四.使用方法
数据库:在resources/sql/webchat.dmp或者webchat.sql
项目直接导入eclipse或者idea即可,注意是maven构建的,非maven自行下载jar包并构建项目即可
