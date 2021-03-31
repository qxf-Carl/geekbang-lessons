package org.geektimes.rest.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClientDemo {

    public static void main(String[] args) {
        doGet();
        doPost();
    }

    private static void doGet() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://www.baidu.com")      // WebTarget
                .request() // Invocation.Builder
                .get();                                     //  Response

        String content = response.readEntity(String.class);

        System.out.println("Get content:\n" + content);
    }


    private static void doPost() {
        Client client = ClientBuilder.newClient();

        Form form = new Form();
        form.param("name", "qingyi");
        Response response = client
                .target("http://www.baidu.com")      // WebTarget
                .request() // Invocation.Builder
                .post(Entity.entity(form, MediaType.MULTIPART_FORM_DATA_TYPE));                                     //  Response
        String content = response.readEntity(String.class);
        System.out.println("Post content:\n" + content);
    }

}
