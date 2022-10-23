package fabricaDePeticiones;

import io.restassured.response.Response;
import utilitarios.GetPropiedades;

import static io.restassured.RestAssured.given;

public class PeticionPUT implements IPeticiones{
    @Override
    public Response send(PeticionesInfo info) {
        Response response = given()
                .auth()
                .preemptive()
                .basic(GetPropiedades.instance.getUser(),
                        GetPropiedades.instance.getPwd())
                .body(info.getBody())
                .log() .all()
          .when()
                .put(info.getUrl());

        response.then().log().all();
        return response;
    }
}
