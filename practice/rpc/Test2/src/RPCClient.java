import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class RPCClient {
	public static void main(String[] args) {
		HelloService helloService = getClient(HelloService.class, "127.0.0.1", 5001);
		System.out.println(helloService.sayHello("xhl"));
	}
	
	private static <T> T getClient(Class<T> clazz, String server, int port) {
		// TODO Auto-generated method stub
		return (T)Proxy.newProxyInstance(RPCClient.class.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				Socket socket = new Socket(server, port);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				out.writeUTF(method.getName());
				out.writeObject(method.getParameterTypes());
				out.writeObject(args);
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				return in.readObject();
				//return null;
			}
		});
		//return null;
	}
	
	
}
