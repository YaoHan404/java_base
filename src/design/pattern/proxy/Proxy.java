package design.pattern.proxy;

public class Proxy {
    public static void main(String[] args){
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse(); //虽然用的是代理类的方法，但是实际用了被代理类的方法
    }
}

interface NetWork{
    public void browse();
}

//被代理类
class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}

//代理类, 在调用自己的brose()时用的是被代理的
class ProxyServer implements NetWork{

    private NetWork work;

    public ProxyServer(NetWork work){
        this.work = work;
    }

    public void check(){
        System.out.println("联网之前的检查工作");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}