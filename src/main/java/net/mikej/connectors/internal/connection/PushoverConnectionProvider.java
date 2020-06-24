package net.mikej.connectors.internal.connection;

import net.mikej.connectors.api.MessageResult;
import net.mikej.connectors.api.PushoverClient;
import net.mikej.connectors.api.PushoverService;
import okhttp3.OkHttpClient;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PushoverConnectionProvider implements CachedConnectionProvider<PushoverClient> {

    @Parameter
    @DisplayName("Application Token")
    private String token;

    @Parameter
    @Optional
    @DisplayName("User token (for connection verification)")
    private String userToken;

    @Override
    public PushoverClient connect() throws ConnectionException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.pushover.net")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        PushoverService service = retrofit.create(PushoverService.class);
        return new PushoverClient(token, service);
    }

    @Override
    public void disconnect(PushoverClient connection) {

    }

    @Override
    public ConnectionValidationResult validate(PushoverClient connection) {
        if (userToken == null) return ConnectionValidationResult.failure("User token not provided - can not test connection", null);
        try {
            MessageResult result = connection.sendMessage(userToken, "Connection Testing", "Test message from Pushover connector");
            return result.getStatus() == 1 ?
                    ConnectionValidationResult.success() :
                    ConnectionValidationResult.failure("Failed to send message", null);
        } catch (Exception ex) {
            return ConnectionValidationResult.failure("Failed to send message", ex);
        }
    }
}
