package ma.projet.restclient;

import ma.projet.restclient.config.RetrofitClient;
import org.junit.Test;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

public class RetrofitClientTest {

    @Test
    public void testRetrofitClientSwitching() {
        Retrofit jsonClient = RetrofitClient.getClient("JSON");
        assertNotNull(jsonClient);
        assertEquals("http://10.0.2.2:8082/", jsonClient.baseUrl().toString());

        Retrofit xmlClient = RetrofitClient.getClient("XML");
        assertNotNull(xmlClient);
        assertEquals("http://10.0.2.2:8082/", xmlClient.baseUrl().toString());

        Retrofit jsonClientAgain = RetrofitClient.getClient("JSON");
        assertNotNull(jsonClientAgain);
    }
}

