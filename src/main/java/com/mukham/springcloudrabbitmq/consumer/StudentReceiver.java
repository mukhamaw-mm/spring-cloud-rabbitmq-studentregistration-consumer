package com.mukham.springcloudrabbitmq.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mukham.springcloudrabbitmq.model.Student;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class StudentReceiver {
    @StreamListener(target = Sink.INPUT)
    public void processRegisterStudents(String student) {
        System.out.println("Students Registered by Teacher " + student);
        ObjectMapper mapper = new ObjectMapper();
        Student student1 = new Student();
        try {
            student1 = mapper.readValue(student, Student.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Student address :"+student1.getAddress());

    }
}
