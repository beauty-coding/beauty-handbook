<script>
export default {
    data() {
        return {
            socket:null,
            userId:localStorage.getItem("ms_uuid"),
            toUserId:'2',
            content:'3'
        }
    },
  methods: {
    openSocket() {
      if (typeof WebSocket == "undefined") {
        console.log("您的浏览器不支持WebSocket");
      } else {
        console.log("您的浏览器支持WebSocket");
        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        //等同于socket = new WebSocket("ws://localhost:8888/xxxx/im/25");
        //var socketUrl="${request.contextPath}/im/"+$("#userId").val();
        var socketUrl =
          "http://localhost:8081/imserver/" + this.userId;
        socketUrl = socketUrl.replace("https", "ws").replace("http", "ws");
        console.log(socketUrl);
        if (this.socket != null) {
          this.socket.close();
          this.socket = null;
        }
        this.socket = new WebSocket(socketUrl);
        //打开事件
        this.socket = new WebSocket(socketUrl);
        //打开事件
        this.socket.onopen = function() {
          console.log("websocket已打开");
          //socket.send("这是来自客户端的消息" + location.href + new Date());
        };
        //获得消息事件
        this.socket.onmessage = function(msg) {
          console.log(msg.data);
          //发现消息进入    开始处理前端触发逻辑
        };
        //关闭事件
        this.socket.onclose = function() {
          console.log("websocket已关闭");
        };
        //发生了错误事件
        this.socket.onerror = function() {
          console.log("websocket发生了错误");
        };
      }
    },
    sendMessage() {
      if (typeof WebSocket == "undefined") {
        console.log("您的浏览器不支持WebSocket");
      } else {
        console.log("您的浏览器支持WebSocket");
        console.log(
          '{"toUserId":"' +
             this.toUserId +
            '","contentText":"' +
             this.content +
            '"}'
        );
        this.socket.send(
          '{"toUserId":"' +
             this.toUserId +
            '","contentText":"' +
             this.content +
            '"}'
         );

    }
}
