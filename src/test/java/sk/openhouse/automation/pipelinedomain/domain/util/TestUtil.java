package sk.openhouse.automation.pipelinedomain.domain.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestUtil {

    /**
     * Marshalls jaxb object to string
     * 
     * @param cls class of the object to be marshalled
     * @param object to be marshalled
     * @return string representation of the supplied object
     * @throws JAXBException
     */
    public static String marshall(Class<?> cls, Object object) throws JAXBException {

        StringWriter response = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object, response);

        return response.toString();
    }

    /**
     * Unmarshalls string to jaxb object
     * 
     * @param cls class of the returned objec
     * @param xml string representation of the jaxb object
     * @return jaxb object
     * @throws JAXBException
     */
    public static Object unmarshall(Class<?> cls, String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(new StringReader(xml));
    }
}
