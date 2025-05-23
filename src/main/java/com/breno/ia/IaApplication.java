package com.breno.ia;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IaApplication.class, args);
	}

	@Override
	public void run(String... args) {

		// Cria o modelo Ollama apontando para a instância local
		ChatLanguageModel chatModel = OllamaChatModel.builder()
				.baseUrl("http://localhost:11434") // Porta padrão da API Ollama
				.options(OllamaOptions.builder()
						.model(OllamaModel.LLAMA3_1) // ou "llama3" como string direta
						.temperature(0.4)
						.build())
				.build();

		// Faz uma pergunta
		ChatMessage response = chatModel.generate(UserMessage.from("Generate the names of 5 famous pirates."));

		// Exibe a resposta
		System.out.println("Resposta do LLaMA:");
		System.out.println(response.text());
	}
}