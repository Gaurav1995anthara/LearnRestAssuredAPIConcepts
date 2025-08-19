package ssl;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class CustomTrust {
	
	// to disable cert	
 // 	.relaxedHTTPSValidation()  // bypass SSL validation // For dev use, disables SSL validation (optional)

	
	// ===============================================================
	// Custom TrustStore (Server Certificate)
	
	// The server uses a self-signed or private certificate, and your automation doesn't trust it by default. You have to import the server's certificate into a .jks TrustStore and point your code to it.
	
	
	// Step 1: Export the server certificate (if needed)
	// # From browser or curl, export the server certificate as server.crt
	// Step 2: Import it into a .jks TrustStore
	
	@Test
	public void test() {
		 RestAssured.baseURI = "https://selfsigned.example.com";

		 RestAssured.given()
		 .config(RestAssured.config()
				 .sslConfig(
						 new SSLConfig()
						 .trustStore("/path/to/truststore.jks", "changeit")
						 )	 
				 )
		 .when();
	}
	
	// Mutual TLS (mTLS) – Client Certificate
	// Step 1: Your org gives you a .p12 or .jks file (client cert)
	
	
	// This is where the server not only presents a certificate, but also demands one from your client. You must authenticate with your own client certificate.
	@Test
	public void test1() {
		 RestAssured.baseURI = "https://selfsigned.example.com";

		 RestAssured.given()
		 .config(RestAssured.config()
				 .sslConfig(
						 new SSLConfig()
						  .keyStore("/path/to/client-cert.p12", "password") // 👈 client certificate
		                  .trustStore("/path/to/truststore.jks", "changeit") // 👈 optional but recommended
						 )	 
				 )
		 .when();
	}
}
