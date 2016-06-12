package facade;
import model.Model;


public class Facade {

   private Model mod;
   
   public Facade(Model m)
   {
	   mod = m;
   }
    
   public void initializeModel(){
	   mod = mod.getInstance();
   }
    
}
