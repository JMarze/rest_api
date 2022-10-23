package fabricaDePeticiones;

public class FabricaDePeticiones {

    public static IPeticiones make(String requestType){
        IPeticiones peticiones;

        switch (requestType.toLowerCase()){
            case "post":
                peticiones = new PeticionPOST();
                break;
            case "put":
                peticiones = new PeticionPUT();
                break;
            case "delete":
                peticiones = new PeticionDELETE();
                break;
            default:
                peticiones = new PeticionGET();
                break;
        }
      return peticiones;

    }
}
