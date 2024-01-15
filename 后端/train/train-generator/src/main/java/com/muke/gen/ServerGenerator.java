package com.muke.gen;

import freemarker.template.TemplateException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 生成器启动类
 *
 * @author tangcj
 * @date 2024/01/15 09:44
 **/
public class ServerGenerator {

    static String toPath="train-generator\\src\\main\\java\\com\\muke\\test\\";
    static String pomPath = "train-generator/pom.xml";

    static {
        new File(toPath).mkdirs();
    }

    public static void main(String[] args) throws IOException, TemplateException, DocumentException {
        String generatorPath = getGeneratorPath();

        // 读取table节点
        Document document = new SAXReader().read("train-generator/" + generatorPath);
        Node table = document.selectSingleNode("//table");
        System.out.println(table);
        Node tableName = table.selectSingleNode("@tableName");
        Node domainObjectName = table.selectSingleNode("@domainObjectName");
        System.out.println(tableName.getText() + "/" + domainObjectName.getText());
//        FreemarkerUtil.initConfig("test.ftl");
//        HashMap<String, Object> param = new HashMap<>();
//        param.put("domain","Test");
//        FreemarkerUtil.generator(toPath+"Test.java",param);
    }

    private static String getGeneratorPath() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        HashMap<String, String> map = new HashMap<>();
        map.put("pom","http://maven.apache.org/POM/4.0.0");
        saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
        Document document = saxReader.read(pomPath);
        Node node = document.selectSingleNode("//pom:configurationFile");
        return node.getText();
    }
}
