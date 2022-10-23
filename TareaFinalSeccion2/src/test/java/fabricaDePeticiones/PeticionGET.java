package fabricaDePeticiones;

import io.restassured.response.Response;
import utilitarios.GetPropiedades;

import static io.restassured.RestAssured.given;

public class PeticionGET implements IPeticiones{
    @Override
    public Response send(PeticionesInfo info) {
        Response response = given()
                .auth()
                .preemptive()
                .basic(GetPropiedades.instance.getUser(),
                        GetPropiedades.instance.getPwd())
                .log() .all()
          .when()
                .get(info.getUrl());

        response.then().log().all();
        return response;
    }
}
