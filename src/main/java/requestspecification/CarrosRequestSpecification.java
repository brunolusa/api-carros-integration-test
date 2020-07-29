package requestspecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.PropertyLoader.retornarValorArquivoConfiguracao;

public class CarrosRequestSpecification {

    private static final String BASEURI = retornarValorArquivoConfiguracao("baseUri");
    private static final String PORT = retornarValorArquivoConfiguracao("port");
    private static final String BASEPATH = retornarValorArquivoConfiguracao("basePath");

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                                .sslConfig(
                                        new SSLConfig().relaxedHTTPSValidation()
                                )
                )
                .setContentType(ContentType.JSON)
                .setBaseUri(BASEURI)
                .setPort(Integer.parseInt(PORT))
                .setBasePath(BASEPATH)
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

}
