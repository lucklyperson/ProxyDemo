1.静态代理：由程序员创建或特定工具自动生成源代码，在对其编译。在程序运行前，代理类的.class文件就已经存在了。
2.动态代理：在程序运行时，运用反射机制动态创建。

静态代理：
1.业务接口
public interface IDao {

    void method(String str, int age);
}


 2.目标对象（实现业务接口）
    
public class Dao implements IDao {

    private Context context;

    public Dao(Context context) {
        this.context = context;
    }

    @Override
    public void method(String str, int age) {
        Toast.makeText(context, "method方法" + str, Toast.LENGTH_SHORT).show();
    }
}

3.代理对象（实现业务接口，并且持有目标对象的引用）
     

public class ProxyDao implements IDao {

    private IDao dao;

    public ProxyDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public void method(String str, int age) {
        if (age > 10) {
            dao.method(str, age);
        } else {
            Log.e("111", "你的年龄稍微有点小哈");
        }

    }

}



4.在函数中的使用
//静态代理
Dao dao = new Dao(this);
ProxyDao proxyDao = new ProxyDao(dao);
proxyDao.method("wzq", 20);



动态代理

1.业务接口（同上）
2.目标对象（同上）
3.创建代理工厂
   
public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Log.e("111", "开始事务1");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        Log.e("111", "开始事务2");
                        return returnValue;
                    }
                }
        );

    }

}


4.在函数中的使用
//动态代理

//目标对象
IDao target = new Dao(this);
//原始的类型
Log.e("222", "class=" + target.getClass());

//给目标对象，创建代理对象
IDao proxy = (IDao) new ProxyFactory(target).getProxyInstance();

proxy.method("张学友", 20);





