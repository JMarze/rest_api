package fabricaDePeticiones;

import io.restassured.response.Response;
import utilitarios.GetPropiedades;

import static io.restassured.RestAssured.given;

public class PeticionPOST implements IPeticiones{
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
                .post(info.getUrl());

        response.then().log().all();
        return response;
    }
}
