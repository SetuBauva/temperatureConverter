package com.bankonus.temperatureconverter.service;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TemperatureConverterService {

//		private static final Logger log = LoggerFactory
//				.getLogger(GreetingLookUpService.class);

    RestTemplate restTemplate = new RestTemplate();

    @Async
    public CompletableFuture<TemperatureConverterResponse> getTemp(String conversion, float temp) {
        // TempResponse result = new TempResponse();
        TemperatureConverterResponse response = null;
        try {
            System.out.println("In Service------>");
//			log.info("Looking up " + name);
            String result = restTemplate
                    .getForObject("http://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=" + conversion
                            + "&val=" + temp, String.class, 200);
            System.out.println("In Service later------>" + result);
            // System.out.println("result --- >>>"+result.getFahrenheit());

//			StringReader sr = new StringReader(result);
//			JAXBContext jaxbContext = JAXBContext.newInstance(TempResponse.class);
//			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//			TempResponse response = (TempResponse) unmarshaller.unmarshal(sr);
//			Thread.sleep(1000L);
            java.io.FileWriter fw = new java.io.FileWriter("my-file.xml");

            fw.write(result);
            fw.close();

            File xmlFile = new File("my-file.xml");
            JAXBContext jc = JAXBContext.newInstance(TemperatureConverterResponse.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false); // this is the magic line
            StreamSource source = new StreamSource(xmlFile);
            XMLStreamReader xsr = xif.createXMLStreamReader(source);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            response = (TemperatureConverterResponse) unmarshaller.unmarshal(xsr);

        } catch (Exception e) {
            System.out.println("ERRORRRRRRRRRRRR :::::: " + e.getMessage());
            // return null;
            // TODO: handle exception
        }
        System.out.println("Response--->" + response);
        // TODO Auto-generated catch block
        System.out.println("result--->>>" + response.getFahrenheit() + "-----" + response.getCelsius());

        return CompletableFuture.completedFuture(response);

    }

}
