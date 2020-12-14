package Dynamic_proxy;

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;
    
    @Override
    public void produceCloth() {
        // TODO Auto-generated method stub
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("收尾工作");
    }

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }
    
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        // TODO Auto-generated method stub
        System.out.println("Nike工厂");
    }
    
}


public class static_proxy {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}
