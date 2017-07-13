package com.task.vasskob.testrx.presentation.api;

import com.task.vasskob.testrx.presentation.model.ApiResponse;
import com.task.vasskob.testrx.presentation.model.Product;
import com.task.vasskob.testrx.presentation.model.Store;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

interface ApiService {
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

    @GET("/products")
    @Headers(AUTH_TOKEN)
    Observable<ApiResponse<List<Product>>> loadAllProducts();
//            @Query("q") String query,
//            @Query("where") String where,
//            @Query("page") Integer page);

    @GET("/stores/{id}/products")
    @Headers(AUTH_TOKEN)
    Observable<ApiResponse<List<Product>>> loadProductsInStore(
            @Path("id") long storeId);
//            @Query("page") int page,
//            @Query("q") String query);
}
