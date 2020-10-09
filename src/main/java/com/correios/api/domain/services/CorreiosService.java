package com.correios.api.domain.services;

import com.correios.api.adapters.controllers.MaxDeliveryDateRequest;
import com.correios.api.domain.ports.CorreiosPort;
import com.correios.api.application.utils.CorreiosAPIURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CorreiosService implements CorreiosPort {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getMaxDeliveryDate(MaxDeliveryDateRequest dados) {

        String url = CorreiosAPIURL.postPrazoUrl;
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> apiRequest = new LinkedMultiValueMap<>();
        apiRequest.add("nCdServico",dados.getnCdServico());
        apiRequest.add("sCepOrigem",dados.getsCepOrigem());
        apiRequest.add("sCepDestino",dados.getsCepDestino());

        HttpEntity<MultiValueMap<String,String>> entity =
                new HttpEntity<>(apiRequest,header);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result = restTemplate.postForEntity(
                url,
                entity,
                String.class);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;

        try{
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(result.getBody())));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        NodeList nodeList = doc.getElementsByTagName("DataMaxEntrega");
        String maxDeliveryDate = nodeList.item(0).getTextContent();

        return maxDeliveryDate;
    }
}
