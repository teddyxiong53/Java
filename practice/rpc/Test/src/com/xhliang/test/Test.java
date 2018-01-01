package com.xhliang.test;



public class Test {
	public static void main(String[] args) {
		HelloService helloService = new HelloServiceImpl();
		RPCServer server = new RPCServer();
		server.resigter(server, 5001);
		System.out.println("test rpc server start");
	}
}
