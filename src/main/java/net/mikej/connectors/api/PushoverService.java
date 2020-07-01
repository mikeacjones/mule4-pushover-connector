package net.mikej.connectors.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PushoverService {

    @POST("/1/messages.json")
    @FormUrlEncoded
    Call<MessageResult> sendMessage(
            @Field("token") final String token,
            @Field("user") final String userToken,
            @Field("message") final String message,
            @Field("device") final String deviceCsv,
            @Field("title") final String title,
            @Field("url") final String url,
            @Field("url_title") final String urlTitle,
            @Field("priority") final Integer priority,
            @Field("timestamp") final Long timestamp);

}