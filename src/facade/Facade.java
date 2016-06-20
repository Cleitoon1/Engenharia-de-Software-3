package facade;
import model.Model;


public class Facade {

   public Facade(Model m)
   {
   }
    
   public void initializeModel(){
	   Model.getInstance();
   }
    
}
