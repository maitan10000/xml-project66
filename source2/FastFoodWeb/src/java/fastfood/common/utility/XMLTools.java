/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.utility;

import fastfood.common.addtionbean.ResultBean;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Everything
 */
public class XMLTools {

    /**
     * Marshalling object to xml
     * @param obj
     * @param filePath
     */
    public static void JAXBMarshalling(Object obj, String filePath) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(obj, new File(filePath));
            String path = new File(filePath).getCanonicalPath();
            System.out.println("Path: " + path);
        } catch (IOException ex) {
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Marshalling object to output stream
     * @param obj
     * @param outStream
     */
    public static void JAXBMarshalling(Object obj, OutputStream outStream) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(obj, outStream);
        } catch (JAXBException ex) {
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Validattion DOM Source
     * @param schemaFile
     * @param xmlFile
     */
    public static ResultBean ValidationFrameworkDOMSource(String schemaFile, String xmlString) {
        ResultBean result = new ResultBean();
        result.setSuccess(true);
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(schemaFile));
            Validator validator = schema.newValidator();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlString));
            Document doc = db.parse(is);
            validator.validate(new DOMSource(doc));
        } catch (ParserConfigurationException ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static byte[] PrintPDF(String xmlPath, String xslPath, String foPath) {
        try {
            //tranform xml to fo
            TransformerFactory tf = TransformerFactory.newInstance();
            StreamSource xsltFile = new StreamSource(xslPath);
            Transformer trans = tf.newTransformer(xsltFile);

            StreamSource xmlFile = new StreamSource(xmlPath);
            StreamResult foFile = new StreamResult(new FileOutputStream(foPath));
            trans.transform(xmlFile, foFile);

            //create pdf from fo
            FopFactory ff = FopFactory.newInstance();
            FOUserAgent fua = ff.newFOUserAgent();
            ByteArrayOutputStream ous = new ByteArrayOutputStream();
            Fop fop = ff.newFop(MimeConstants.MIME_PDF, fua, ous);

            trans = tf.newTransformer();
            File fo = new File(foPath);
            Source src = new StreamSource(fo);
            Result result = new SAXResult(fop.getDefaultHandler());
            trans.transform(src, result);
            return ous.toByteArray();
        } catch (TransformerException ex) {
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FOPException ex) {
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
