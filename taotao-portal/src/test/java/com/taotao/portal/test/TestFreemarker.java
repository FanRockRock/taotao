package com.taotao.portal.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/20.
 */
public class TestFreemarker {
    public class Student {
        private int id;
        private String name;
        private String address;

        public Student(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    @Test
    public void testFreemarker() throws Exception {
        //创建Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //告诉configuration对象模板文件存放的路径
        configuration.setDirectoryForTemplateLoading(new File("E:\\IdeaProjects\\taotao\\taotao-portal\\src\\main\\webapp\\WEB-INF\\ftl"));
        //设置config的默认字符集
        configuration.setDefaultEncoding("utf-8");
        //从config对象中获取模板对象，需要制定一个模板
        Template template = configuration.getTemplate("second.ftl");
        //创建模板需要的数据集。可以是一个map，也可以是一个pojo
        Map<Object, Object> root = new HashMap<>();
        //root.put("hello","hello freemarker");
        root.put("title", "标题");
        Student student = new Student(111, "王帆", "华中科技大学沁园东十");
        Student student1 = new Student(222, "王帆2", "华中科技大学沁园东十2");
        Student student2 = new Student(333, "王帆3", "华中科技大学沁园东十3");
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);

        root.put("studentList", students);
        root.put("cur_time", new Date());

        //创建一个writer对象，指定生成的文件保存的路径和文件名
        Writer out = new FileWriter(new File("E:\\third.html"));
        //调用模板的process方法生成静态文件
        template.process(root, out);
        //关闭writer对象
        out.flush();
        out.close();
    }
}
