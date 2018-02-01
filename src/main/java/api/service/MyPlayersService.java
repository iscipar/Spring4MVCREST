package api.service;

import java.util.List;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.domain.Player;

@Service("playersService")
@CacheDefaults(cacheName = "players")
public class MyPlayersService {
	
	@CacheResult
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

	@CacheResult
	public Player findOne(@CacheKey String id) {
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
	
	@CachePut
	public void create(@CacheKey String id, @CacheValue Player player) {
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
	
	@CachePut
	public void update(@CacheKey String id, @CacheValue Player player) {
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
	
	@CacheRemove
	public void delete(@CacheKey String id) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpDelete httpDelete = new HttpDelete("http://localhost:3000/players/" + id);

			httpClient.execute(httpDelete);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}