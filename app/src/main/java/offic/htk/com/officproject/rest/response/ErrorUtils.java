package offic.htk.com.officproject.rest.response;

/**
 * Created by nguyen on 27/07/2016.
 */
import java.io.IOException;
import java.lang.annotation.Annotation;

import offic.htk.com.officproject.rest.ConstantsRest;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ErrorUtils {
    public static APIErrors parseError(Response<?> response) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsRest.sBASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Converter<ResponseBody, APIErrors> converter =
                retrofit.responseBodyConverter(APIErrors.class, new Annotation[0]);
        APIErrors error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIErrors();
        }

        return error;
    }
}
