// client code 
// RUN all the 3 codes seperately
import java.rmi.Naming;
import java.util.Scanner;

public class RMI_Client {

    public static void main(String[] args) {
        Scanner sc = null; 
        try {
            RMI_interface remoteObject = (RMI_interface) Naming.lookup("rmi://localhost:1878/hello");

            sc = new Scanner(System.in);
            System.out.print("Enter a number to calculate its square root: ");
            double number = sc.nextDouble();

            double result = remoteObject.calculateSquareRoot(number);
            
            System.out.println("Square root of " + number + " is: " + result);

        } catch (Exception e) {
            System.out.println("The RMI APP is Not running...");
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}

//server code



// import java.nio.channels.AlreadyBoundException;
// import java.rmi.RemoteException;
// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;
// import java.rmi.server.UnicastRemoteObject;

// public class RMI_Server extends UnicastRemoteObject implements RMI_interface {

//     protected RMI_Server() throws RemoteException {
//         super();
//     }

    

//     public static void main(String[] args)throws RemoteException, AlreadyBoundException {
//         try {
//             Registry registry = LocateRegistry.createRegistry(1878);
//             registry.bind("hello", new RMI_Server());
//             System.out.println("The RMI_Server is running and ready...");
//         } 
//         catch (Exception e) {
//             System.out.println("The RMI_Server is not running...");
//         } 
//     }

//     @Override
//     public double calculateSquareRoot(double number) throws RemoteException {
//         double result = Math.sqrt(number);
//         System.out.println("Square Root of"+ number+ "is: "+result);
//         return result;
//     }
// }

//interface code



// import java.rmi.Remote;
// import java.rmi.RemoteException;

// public interface RMI_interface extends Remote {
//     double calculateSquareRoot(double number) throws RemoteException;
// }

