package com.choupangxia.protobuf;

import com.choupangxia.protobuf.message.Person;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

/**
 * @author sec
 * @version 1.0
 * @date 2021/7/29
 **/
public class Test {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        Person.PersonProto sourcePersonProto = Person.PersonProto.newBuilder().setId(123).setName("Tom").build();

        // 序列化
        byte[] binaryInfo = sourcePersonProto.toByteArray();
        System.out.println("序列化字节码内容：" + Arrays.toString(binaryInfo));
        System.out.println("序列化字节码长度：" + binaryInfo.length);

        System.out.println("-----------以下为接收方反序列化操作-------------");
        // 反序列化
        Person.PersonProto targetPersonProto = Person.PersonProto.parseFrom(binaryInfo);

        System.out.println("反序列化结果：" + targetPersonProto.toString());
    }
}
