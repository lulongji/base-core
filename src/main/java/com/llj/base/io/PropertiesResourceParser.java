package com.llj.base.io;

import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author lu
 */
public interface PropertiesResourceParser {

    /**
     * 解析指定的属性资源resources
     *
     * @param resource 待解析的属性文件资源
     * @return
     * @throws ResourceParseException 解析属性资源时出现的异常
     */
    <T> T parse(Resource[] resource) throws ResourceParseException;

    /**
     * 解析path路径下的属性文件
     *
     * @param path 待解析属性文件路径
     * @return
     * @throws ResourceParseException 解析属性资源时出现的异常
     * @throws IOException            读取 path路径下的属性文件时抛出异常
     */
    <T> T parse(String path) throws ResourceParseException, IOException;
}
