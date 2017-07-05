package com.task.vasskob.testrx.api;

import com.task.vasskob.testrx.model.ApiResponse;
import com.task.vasskob.testrx.model.Store;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

public interface StoreService {
    String LCBO_API_KEY="MDoxZTlhNDkwMi1mM2FjLTExZTYtYWYwNi0wYmFlYTdiMTUyNjY6MjNxY24zdklFV2lhME5NVzZhYnNydWg4MXpsVlBUVk5OM2VY";
    String AUTH_TOKEN = "Authorization: Token " + LCBO_API_KEY;

    @GET("/stores")
    @Headers(AUTH_TOKEN)
    Observable<ApiResponse<List<Store>>> loadStores(
//            @Query("where")
//                    String where,
//            @Query("page")
//                    Integer pageNumber
    );
}
