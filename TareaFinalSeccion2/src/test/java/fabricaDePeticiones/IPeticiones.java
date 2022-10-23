package fabricaDePeticiones;

import io.restassured.response.Response;

public interface IPeticiones {

    Response send(PeticionesInfo info);

}
