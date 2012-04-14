

import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class HelloClient{
    static Hello HelloImpl;
    
        public static void main(String args[]){
            try{
                ORB orb= ORB.init(args,null);
                org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
                NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);
                String name="Hello";
                
                HelloImpl=HelloHelper.narrow(ncRef.resolve_str(name));
                System.out.println(HelloImpl.sayHello());
                HelloImpl.shutdown();
                
            
            }
            catch(Exception e){
                System.err.println("ERROR: "+e);
                e.printStackTrace(System.out);
            }
        }
}