package com.bankonus.temperatureconverter.service;

import java.io.File;
import java.util.concurrent.CompletableFuture;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author setubauva
 *
 *         Service class to convert Temperature
 */
@Service
public class TemperatureConverterService {

	RestTemplate restTemplate = new RestTemplate();

	/**
	 * This method is used to call the webservice using restTemplate and unmarshall
	 * the xml response
	 * 
	 * @param conversion
	 * @param temp
	 * @return response which is unmarshalled
	 */
	@Async
	public CompletableFuture<TemperatureConverterResponse> getTemp(String conversion, String temp) {

		TemperatureConverterResponse response = null;
		try {
			String result = restTemplate
					.getForObject("http://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=" + conversion
							+ "&val=" + temp, String.class, 200);

			java.io.FileWriter filewriter = new java.io.FileWriter("response.xml");
			filewriter.write(result);
			filewriter.close();

			response = unmarshalXMLResponse();

		} catch (Exception e) {
			e.getMessage();
		}

		return CompletableFuture.completedFuture(response);

	}

	/**
	 * Method used to unmarshall the response from xml and returning to controller
	 * 
	 * @return TemperatureConverterResponse
	 * @throws XMLStreamException
	 * @throws JAXBException
	 */
	public TemperatureConverterResponse unmarshalXMLResponse() throws XMLStreamException, JAXBException {

		File xmlFile = new File("response.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(TemperatureConverterResponse.class);
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
		StreamSource source = new StreamSource(xmlFile);
		XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(source);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (TemperatureConverterResponse) unmarshaller.unmarshal(xmlStreamReader);
	}

}
