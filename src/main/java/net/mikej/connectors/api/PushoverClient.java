package net.mikej.connectors.api;

import org.joda.time.DateTime;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class PushoverClient {

    private final String token;
    private final PushoverService service;

    public PushoverClient(
            final String token,
            final PushoverService service
    ) {
        this.token = token;
        this.service = service;
    }

    public MessageResult sendMessage(
            final String userToken,
            final String title,
            final String message
    ) throws IOException {
        return sendMessage(userToken, title, message, null, null, null, null, null);
    }

    public MessageResult sendMessage(
            final String userToken,
            final String title,
            final String message,
            final String deviceCsv,
            final String url,
            final String urlTitle,
            final Priority priority,
            final Long timestamp) throws IOException {
        Call<MessageResult> messageCall = service.sendMessage(token, userToken, message, deviceCsv, title, url, urlTitle, priority == null ? null : priority.getValue(), timestamp);
        Response<MessageResult> messageResponse = messageCall.execute();
        if (messageResponse.isSuccessful()) return messageResponse.body();
        else throw new IOException("Failed to send message: " + messageResponse.errorBody().string());
    }

}
