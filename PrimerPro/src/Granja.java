import java.util.ArrayList;
public class Granja {
    private  String nombre;
    private  ArrayList<Animal> listaAnimales;

    public Granja(String nombre,ArrayList<Animal> listaAnimales ){
        this.nombre=nombre;
        this.listaAnimales=listaAnimales;
    }

    public void agregarAnimal(Animal animaleEJ){
        this.listaAnimales.add(animaleEJ);
    }
    public void actualizarGastoAlimentacion(int nIdAnimal,long nGasto){
    for (int i =0;i<this.listaAnimales.size();i++)
           if( this.listaAnimales.get(i).getId().equals(nIdAnimal.toString())){

           }
    }
    public void actualizarGastoVeterinario(int nIdAnimal,long nGasto){

    }



}
