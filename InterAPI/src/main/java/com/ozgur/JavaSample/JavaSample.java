package com.ozgur.JavaSample;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GZIPInputStreamFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings({ "restriction", "unused" })
public class JavaSample {
	public static void main(String[] args) {
		HttpClient httpclient = HttpClients.createDefault();

		try {
			URIBuilder builder = new URIBuilder(
					"http://localhost:8080/infleks/rest/TradeFonPayIslemleriEntegrasyonu/vkgGetir/");

			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			HttpGet requestGet = new HttpGet(uri);
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", "{subscription key}");

			requestGet.setHeader("Content-Type", "text/xml");
			requestGet.setHeader("Ocp-Apim-Subscription-Key", "{subscription key}");

			// Request body
			StringEntity reqEntity = new StringEntity("{body}");
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(requestGet);
			HttpEntity entity = response.getEntity();

			System.out.println(entity.getContentType());
			InputStream is = entity.getContent();

			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Result mkvgb = (Result) jaxbUnmarshaller.unmarshal(entity.getContent());
				for (MKVkg liste : mkvgb.getListe())
					System.out.println("ISIN:" + liste.getIsin() + " Tarih:" + liste.getTarih());
			} catch (JAXBException ex) {
				Logger.getLogger(JavaSample.class.getName()).log(Level.SEVERE, null, ex);
			}
			String content = EntityUtils.toString(entity);
			System.out.println(content);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
