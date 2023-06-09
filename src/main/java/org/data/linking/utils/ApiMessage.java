package org.data.linking.utils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;

public class ApiMessage {
    public static void Error(Logger logger, Exception ex) {
        String messageJson = StringUtils.substring(ex.getMessage(), 7, ex.getMessage().length() - 1).trim();
        JSONObject json = new JSONObject(messageJson);
        JSONObject jsonHeader = json.getJSONObject("header");
        logger.error(jsonHeader.get("statut") + " : " + jsonHeader.get("message"));
    }
}
