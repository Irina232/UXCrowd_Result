package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class VersionTest {
    private final static String URL = "https://dev-t.uxcrowd.ru/";

    @Test
    public void getAllVersions() {
        Specifications.InstallSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        List<Versions> versions = given()
                .when()
                .get( "api/v2/plugin/getVersions")
                .then().log().all()
                .extract().body().jsonPath().getList(".", Versions.class);

        // Проверяем, что все plugin'ы соответствуют версии 2.0.xx
        versions.forEach(x -> Assertions.assertTrue(x.getVersion().startsWith("2.0.")));
    }

}
