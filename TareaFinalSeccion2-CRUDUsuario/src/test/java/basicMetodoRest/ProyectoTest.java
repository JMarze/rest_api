package basicMetodoRest;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProyectoTest {

    @Test
    public void verificarUsuario() {
        JSONObject body = new JSONObject();
        body.put("FullName","PruebaCreaUsuario");


        Response response = given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@outlook.com", "12345")
                .body("{\n" +
                        "\"Email\":\"mmsalazar21k@outlook.com\",\n" +
                        "\"FullName\":\"PruebaCreaUsuario\",\n" +
                        "\"Password\":\"12345\"\n" +
                        "}")
                .log().all()
                .when()
                .post("https://todo.ly/api/user.json");


        //Verificamos la creacion de los Usuario
        response.then()
                .log().all()
                .statusCode(200)
                .body("FullName", equalTo("PruebaCreaUsuario"));
        String Usuario = response.then().extract().path("Email");


        //////Read
        response = given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@outlook.com", "12345")
                .body("{\n" +
                        "\"Email\":\"mmsalazar21k@outlook.com\"\n" +
                        "}")
                .log().all()
         .when()
                .get("https://todo.ly/api/user.json");


        //Verificamos la creacion de los Usuario
        response.then()
                .log().all()
                .statusCode(200)
                .body("FullName", equalTo("PruebaCreaUsuario"));

        //////Update

        body.put("FullName","PruebaModificarUsuario");
        response = given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@outlook.com", "12345")
                .body("{\n" +
                        "\"FullName\":\"PruebaModificarUsuario\",\n" +
                        "}")
                .log().all()
                .when()
                .put("https://todo.ly/api/user/0.json");


        //Verificamos la creacion de los Usuario
        response.then()
                .log().all()
                .statusCode(200)
                .body("FullName", equalTo("PruebaModificarUsuario"));

        /////Delete
        response = given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@outlook.com", "12345")
                .body("{\n" +
                        "\"Email\":\"mmsalazar21k@outlook.com\"\n" +
                        "}")
                .log().all()
                .when()
                .delete("https://todo.ly/api/user/0.json");


        //Verificamos la creacion de los Usuario
        response.then()
                .log().all()
                .statusCode(200)
                .body("Email", equalTo("mmsalazar21k@outlook.com"));

    }
}
