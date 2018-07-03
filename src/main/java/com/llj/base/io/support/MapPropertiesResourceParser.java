package com.llj.base.io.support;

import com.llj.base.io.ResourceParseException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author lu
 */
public class MapPropertiesResourceParser extends AbstractPropertiesResourceParser {

    public MapPropertiesResourceParser() {
        super();
    }

    public MapPropertiesResourceParser(String encoding, ResourcePatternResolver resourceLoader) {
        super(encoding, resourceLoader);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> parse(String path) throws ResourceParseException, IOException {
        if (path == null)
            throw new ResourceParseException("待解析的属性资源文件的路径不能为空!");
        this.loadProperties(getResourceLoader().getResources(path));
        return getResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> parse(Resource[] resources) throws ResourceParseException {
        if (resources == null)
            throw new ResourceParseException("无法待解析的空的属性资源!");
        this.loadProperties(resources);
        return getResult();
    }

    private Map<String, String> getResult() throws ResourceParseException {
        Map<String, String> result = new HashMap<String, String>();
        for (Properties inst : this.getLoadedPropertiesInstances()) {
            for (Enumeration<Object> keys = inst.keys(); keys.hasMoreElements(); ) {
                String key = (String) keys.nextElement();
                String value = inst.getProperty(key);
                result.put(key, value);
            }
        }
        return result;
    }
}
