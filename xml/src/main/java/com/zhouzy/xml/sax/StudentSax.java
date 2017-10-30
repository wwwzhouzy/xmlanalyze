package com.zhouzy.xml.sax;

import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentSax extends DefaultHandler {
    private Lesson lesson;
    private Set<Lesson> lessons;
    private Student student;
    private Set<Student> students;
    private String preTag;

    @Override
    public void startDocument() throws SAXException {
        lessons = new HashSet<Lesson>();
        students = new HashSet<Student>();
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (student != null) {
            String data = new String(ch, start, length);
            if ("name".equals(preTag)) {
                student.setName(data);
            }
            if ("sex".equals(preTag)) {
                student.setSex(data);
            }
            if ("lessonName".equals(preTag)) {
                lesson.setLessonName(data);
            }
            if ("lessonScore".equals(preTag)) {
                lesson.setLessonScore(Integer.parseInt(data));
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attr) throws SAXException {
        if ("student".equals(name)) {
            student = new Student();
        }
        if ("lesson".equals(name)) {
            lesson = new Lesson();
        }
        preTag = name;

    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if (student != null && "student".equals(name)) {
            student.setLessons(lessons);
            students.add(student);
            student = null;
            lessons = new HashSet<Lesson>();
        }
        if (lesson != null && "lesson".equals(name)) {
            lessons.add(lesson);
            lesson = null;
        }
        preTag = null;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }
}