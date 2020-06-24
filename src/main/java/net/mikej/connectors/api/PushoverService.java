package net.mikej.connectors.api;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PushoverService {

    @POST("/1/messages.json")
    Call<MessageResult> sendMessage(
            @Query("token") final String token,
            @Query("user") final String userToken,
            @Query("message") final String message,
            @Query("device") final String deviceCsv,
            @Query("title") final String title,
            @Query("url") final String url,
            @Query("url_title") final String urlTitle,
            @Query("priority") final Integer priority,
            @Query("timestamp") final Long timestamp);

}