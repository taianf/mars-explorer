package br.com.taian.marsexplorer.api;

import org.javatuples.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationTests {

    static final HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    static void setupTests() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    @ParameterizedTest
    @ArgumentsSource(TestCasesProvider.class)
    void firstTest(Pair<String, String> testPayload) {
        HttpEntity<String> request = new HttpEntity<>(testPayload.getValue0(), httpHeaders);
        ResponseEntity<String> entity = restTemplate.postForEntity("/api/mission", request, String.class);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assertions.assertEquals(testPayload.getValue1(), entity.getBody());
    }

}

class TestCasesProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Stream<Arguments> pairStream = null;
        try {
            URL url = ApiApplicationTests.class.getClassLoader().getResource("payload.txt");
            Path path = Paths.get(url.toURI());
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
            pairStream = lines.map(s -> {
                String[] split = s.split("::");
                if (split.length == 0) {
                    return null;
                } else {
                    return Arguments.of(new Pair<>(split[0], split[1]));
                }
            }).filter(Objects::nonNull);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return pairStream;
    }
}
