package com.permission.service;


import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Configuration
@Controller
public class BaseController {
    public final static Logger logger = LoggerFactory.getLogger(BaseController.class);


    public static Map<String, String> getParams(HttpServletRequest request) {
        Map properties = request.getParameterMap();
        HashMap returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        String name = "";

        for (String value = ""; entries.hasNext(); returnMap.put(name, value)) {
            Map.Entry entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (!(valueObj instanceof String[])) {
                value = valueObj.toString();
            } else {
                StringBuilder tmpVal = new StringBuilder();
                String[] values = (String[]) ((String[]) valueObj);

                for (int i = 0; i < values.length; ++i) {
                    tmpVal.append(",").append(values[i]);
                }

                if (name.indexOf("[]") != -1) {
                    name = name.replaceAll("\\[\\]", "");
                }

                if (StringUtils.isNotBlank(tmpVal.toString())) {
                    value = tmpVal.substring(1);
                } else {
                    value = "";
                }
            }
        }

        return returnMap;
    }
}
