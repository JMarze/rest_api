package basicMetodoRest;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestVericarCrearProyecto {

    @Test
    public void verificarCrearProyectoJSONObject(){

        JSONObject body = new JSONObject();
        body.put("Content","MarcosJSON");
        body.put("Icon",1);

        Response response = given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@gmail.com","67890")
                .body(body.toString())
                .log() .all()
         .when()
                .post("https://todo.ly/api/projects.json");


        //Verificamos la creacion de los proyectos
        response.then()
                .log() .all()
                .statusCode(200)
                .body("Content", equalTo("MarcosJSON"))
                .body("Icon", equalTo(1));
    }


}
