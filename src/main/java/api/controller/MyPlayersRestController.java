package api.controller;

import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.domain.Player;

@RestController
@RequestMapping("/players")
public class MyPlayersRestController {

	@RequestMapping(method = RequestMethod.GET)
	public List<Player> findAll() {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet("http://localhost:3000/players");

			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

			int statusCode = httpResponse.getStatusLine().getStatusCode();

			if (statusCode != 200) {
				return null;
			}

			ObjectMapper objectMapper = new ObjectMapper();
			Player playerArray[] = objectMapper.readValue(httpResponse.getEntity().getContent(), Player[].class);

			if (playerArray != null && playerArray.length > 0) {
				List<Player> playerList = CollectionUtils.arrayToList(playerArray);
				return playerList;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Player findOne(@PathVariable("id") Long id) {
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
				return playerArray[0];
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void create(@PathVariable("id") Long id, @RequestBody Player player) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost("http://localhost:3000/players");

			httpPost.setEntity(new StringEntity("{\"id\":\"" + id + "\","
					+ "\"name\":\"" + player.getName() + "\","
					+ "\"nationality\":\"" + player.getNationality() + "\","
					+ "\"position\":\"" + player.getPosition() + "\","
					+ "\"current\":\"" + player.getCurrent() + "\"}",
					ContentType.create("application/json")));

			httpClient.execute(httpPost);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Long id, @RequestBody Player player) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpPut httpPut = new HttpPut("http://localhost:3000/players/" + id);

			httpPut.setEntity(new StringEntity("{\"id\":\"" + id + "\","
					+ "\"name\":\"" + player.getName() + "\","
					+ "\"nationality\":\"" + player.getNationality() + "\","
					+ "\"position\":\"" + player.getPosition() + "\","
					+ "\"current\":\"" + player.getCurrent() + "\"}",
					ContentType.create("application/json")));

			httpClient.execute(httpPut);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpDelete httpDelete = new HttpDelete("http://localhost:3000/players/" + id);

			httpClient.execute(httpDelete);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}