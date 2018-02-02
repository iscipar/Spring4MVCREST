package api.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.domain.CustomPerson;
import api.domain.Person;
import api.domain.Player;

@Service("peopleService")
public class MyPeopleService {

	@Autowired
	MyConvertService service;

	public Person convertOne(String id) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet("http://localhost:3000/players?id=" + id);

			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

			int statusCode = httpResponse.getStatusLine().getStatusCode();

			if (statusCode != 200) {
				return null;
			}

			ObjectMapper objectMapper = new ObjectMapper();
			Player playerArray[] = objectMapper.readValue(httpResponse.getEntity().getContent(), Player[].class);

			if (playerArray != null && playerArray.length > 0) {
				return service.convertOne(playerArray[0]);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public CustomPerson customConvertOne(String id) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet("http://localhost:3000/players?id=" + id);

			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

			int statusCode = httpResponse.getStatusLine().getStatusCode();

			if (statusCode != 200) {
				return null;
			}

			ObjectMapper objectMapper = new ObjectMapper();
			Player playerArray[] = objectMapper.readValue(httpResponse.getEntity().getContent(), Player[].class);

			if (playerArray != null && playerArray.length > 0) {
				return service.customConvertOne(playerArray[0]);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}