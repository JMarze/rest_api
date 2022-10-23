package basicMetodoRest;


import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CrearProyectoTest {

    @Test
    public void verificarCrearProyecto(){

        given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@gmail.com","67890")
                .body("{\n" +
                        "  \"Content\":\"Marcos\",\n" +
                        "  \"Icon\":3\n" +
                        "}")
                .log() .all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log() .all();

    }


    @Test
    public void verificarCrearProyectoJSONObject(){

        JSONObject body = new JSONObject();
        body.put("Content","MarcosJSON");
        body.put("Icon",1);

        given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@gmail.com","67890")
                .body(body.toString())
                .log() .all()
                .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log() .all();

    }


    @Test
    public void verificarCrearProyectoFile(){
        String jsonFile = new File("").getAbsolutePath()+"/src/test/resources/ProyectoCreado.json";


        JSONObject body = new JSONObject();
        body.put("Content","MarcosJS");
        body.put("Icon",1);

        given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@gmail.com","67890")
                .body(new File(jsonFile))
                .log() .all()
                .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log() .all();

    }


}
