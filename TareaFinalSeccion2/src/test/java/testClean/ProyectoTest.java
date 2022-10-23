package testClean;

import fabricaDePeticiones.FabricaDePeticiones;
import fabricaDePeticiones.PeticionesInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mozilla.javascript.xml.XMLLib;
import utilitarios.ApiConfiguracion;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProyectoTest {
    Response response;
    JSONObject body = new JSONObject();
    PeticionesInfo peticionInfo = new PeticionesInfo();

    @Test
    public void verifyCRUDProject(){

        body.put("Content","Marcos2022");
        peticionInfo.setUrl(ApiConfiguracion.CREATE_PROJECT);
        peticionInfo.setBody(body.toString());

        response = FabricaDePeticiones.make("post").send(peticionInfo);
        response.then().body("Content", equalTo(body.get("Content"))).statusCode(200);
        int idproy = response.then().extract().path("Id");


        body.put("Content","MarcosUpdate2022");
        peticionInfo.setUrl(String.format(ApiConfiguracion.UPDATE_PROJECT,idproy));
        peticionInfo.setBody(body.toString());
        response = FabricaDePeticiones.make("put").send(peticionInfo);
        response.then().body("Content", equalTo(body.get("Content"))).statusCode(200);

        peticionInfo.setUrl(String.format(ApiConfiguracion.READ_PROJECT,idproy));
        peticionInfo.setBody(body.toString());
        response = FabricaDePeticiones.make("get").send(peticionInfo);
        response.then().body("Content", equalTo(body.get("Content"))).statusCode(200);

        ///////>>>>>>>>Token
        body.put("UserEmail","mmsalazar21k@gmail.com");
        peticionInfo.setUrl(String.format(ApiConfiguracion.GET_TOKEN));
        peticionInfo.setBody(body.toString());
        response = FabricaDePeticiones.make("get").send(peticionInfo);
        response.then().body("UserEmail", equalTo("mmsalazar21k@gmail.com")).statusCode(200);
        //////<<<<<<<<<

        body.put("Content","MarcosUpdate2022");
        peticionInfo.setUrl(String.format(ApiConfiguracion.DELETE_PROJECT,idproy));
        peticionInfo.setBody(body.toString());
        response = FabricaDePeticiones.make("delete").send(peticionInfo);
        response.then().body("Content", equalTo(body.get("Content"))).statusCode(200);



    }

////////////////////////////////////
@Test
public void  createProject(){

    given()
            //.header("Token","2a3f92f2200f4d2a8b61465f1680dff9")
            .header("Token","bW1zYWxhemFyMjFrQGdtYWlsLmNvbTo2Nzg5MA")
            .body("{\n" +
                    "  \"Content\":\"Marcos2022\",\n" +
                    "  \"Icon\":\"4\"\n" +
                    "}")
            .log().all()
            .when()
            .post("https://todo.ly/api/projects.json")
            .then()
            .log().all();
}


}
