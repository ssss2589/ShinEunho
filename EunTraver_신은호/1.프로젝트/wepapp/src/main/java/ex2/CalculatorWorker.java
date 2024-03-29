package ex2;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorWorker extends Thread {
	static int count;
	Socket socket;
	Scanner in;
	PrintStream out;
	int workerId;

	public CalculatorWorker(Socket socket) throws Exception {
		workerId = ++count;
		this.socket = socket;
		in = new Scanner(socket.getInputStream());
		out = new PrintStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		System.out.println("[thread-"+workerId+"] processing the client request.");
		String operator =null;
		double a,b,r;
		while(true) {
			try {
				operator = in.nextLine();
				
				if(operator.equals("goobye")) {
					out.println("goodbye");
					break;
				}else {
					a = Double.parseDouble(in.nextLine());
					b = Double.parseDouble(in.nextLine());
					r = 0;
					
					switch(operator) {
					case "+" : r = a+b; break;
					case "-" : r = a-b; break;
					case "*" : r = a*b; break;
					case "/" :
						if(b ==0) throw new Exception("Exception!");
						r=a/b;
						break;
					default:
						throw new Exception ("Exceiption!");
				}
					out.println("success");
					out.println(r);
				}
			}catch(Exception err) {
				out.println("failure");
				out.println(err.getMessage());
			}
		}
		try {out.close(); } catch(Exception e) {}
		try {in.close(); } catch(Exception e) {}
		try {socket.close(); } catch(Exception e) {}
		
		System.out.println("[thread-"+workerId+"] closed client.");
	}
}
