package com.zhouzy.xml.xml;
import java.io.InputStream;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.zhouzy.xml.Lesson;
import com.zhouzy.xml.Student;
import com.zhouzy.xml.StudentSax;

public class StudentSaxTest {
    public static void main(String[] args) throws Exception {
        Set<Student> students = new StudentSaxTest().parseXMLFile();
        for(Student stu : students){
            System.out.println("name=" + stu.getName());
            System.out.println("sex=" + stu.getSex());
            Set<Lesson> lessons = stu.getLessons();
            for(Lesson lesson : lessons){
                System.out.println("LessonName = " + lesson.getLessonName());
                System.out.println("LessonScore = " + lesson.getLessonScore());
                System.out.println("---------------");
            }
            System.out.println("==========");
        }
    }

    // 解析文档
    private Set<Student> parseXMLFile() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        InputStream is = StudentSaxTest.class.getClassLoader()
                .getResourceAsStream("student.xml");
        StudentSax handle = new StudentSax();
        saxParser.parse(is, handle);
        is.close();
        return handle.getStudents();
    }

}
