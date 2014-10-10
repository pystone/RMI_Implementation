/**
 * 
 */
package main;

import rmi.RMIException;
import rmi.RMIObjectReference;
import rmi.client.RMIClientRegistry;
import stub.Hello_stub;
import stub.MyName_stub;

/**
 * @author PY
 *
 */
public class RMIClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RMIClientRegistry registry = new RMIClientRegistry();
		
		try {
			RMIObjectReference ror = registry.lookup("Hello");
			Hello_stub h = (Hello_stub)ror.localize();
			System.out.println(h.haha("eeeee"));
			String arg1 = "aa";
			String arg2 = "bb";
			double[] zzz = {2.2, 3.3};
			System.out.println(h.test(arg1, arg2, 33, zzz));
			
			MyName_stub myname = h.whatsMyName();
			System.out.println(myname.getName());
			myname.setName("CKL");
			System.out.println(myname.getName());
		} catch (RMIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
	}

}
