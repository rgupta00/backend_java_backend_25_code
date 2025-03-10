package com.vault.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@RestController
public class AzureController {

	@GetMapping("/getsecret")
	public String hello() {
		String keyVaultUrl = "https://busycoder-kv.vault.azure.net/";
		String secretName = "mysec";
		String fetchedSecret = null;

		try {
			// Create a SecretClient instance to interact with Azure Key Vault
			SecretClient secretClient = new SecretClientBuilder().vaultUrl(keyVaultUrl)
					.credential(new DefaultAzureCredentialBuilder().build()).buildClient();
			// Retrieve the Base64-encoded secret from Azure Key Vault
			KeyVaultSecret secret = secretClient.getSecret(secretName);
			fetchedSecret = "Fetched Secret Values is " + secret.getValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fetchedSecret;
	}

}