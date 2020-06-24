package net.mikej.connectors.internal.operations;

import net.mikej.connectors.api.MessageResult;
import net.mikej.connectors.api.Priority;
import net.mikej.connectors.api.PushoverClient;
import org.joda.time.DateTime;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import java.io.IOException;

public class PushoverOperations {

    public MessageResult sendMessage(
            @Connection PushoverClient client,
            @DisplayName("Target user's token") String userToken,
            @DisplayName("Message") String message,
            @DisplayName("Title") @Optional String title,
            @DisplayName("URL") @Optional String url,
            @DisplayName("URL Title") @Optional String urlTitle,
            @DisplayName("Message Priority") @Optional Priority priority,
            @DisplayName("Override Message Unix Timestamp") @Optional Long timestamp,
            @DisplayName("Comma Separated Device List") @Optional String deviceCsv
    ) throws IOException {
        MessageResult result = client.sendMessage(userToken, title, message, deviceCsv, url, urlTitle, priority, timestamp);
        return result;
    }

}