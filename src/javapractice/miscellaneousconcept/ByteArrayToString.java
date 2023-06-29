/*
package javapractice.miscellaneousconcept;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javapractice.collection.Employee;
import org.apache.commons.io.IOUtils;

public class ByteArrayToString {

    public static void main(String[] args) {
        System.out.println("platform encoding :"+System.getProperty("file.encoding"));
        try {
            FileInputStream fis = new FileInputStream("G:\\project\\datastructure\\encodingPractice.xml");
            // Using Apache Commons IOUtils to read file into byte array
            byte[] fileData = IOUtils.toByteArray(fis);
            String str = new String(fileData, StandardCharsets.UTF_8);
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
