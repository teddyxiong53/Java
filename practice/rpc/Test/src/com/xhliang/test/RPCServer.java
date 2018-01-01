package com.xhliang.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCServer {
	private ExecutorService threadPool;
	
	public RPCServer() {
		threadPool = Executors.newFixedThreadPool(10);
	}
	public void resigter(Object service, int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			Socket socket = null;
			while((socket = server.accept()) != null) {
				threadPool.execute(new Processor(socket, service));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	class Processor implements Runnable {
		Socket socket ;
		Object service;
		public Processor(Socket socket, Object service) {
			this.socket = socket;
			this.service = service;
		}
		public void process() {
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				String methodName = in.readUTF();
				Class<?>[] parameterTypes = (Class<?>[])in.readObject();
				Object[] parameters = (Object[])in.readObject();
				Method method = service.getClass().getMethod(methodName, parameterTypes);
				
				Object result = method.invoke(service, parameters);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				
				out.writeObject(result);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}