package com.task.vasskob.testrx.data.api;


import com.task.vasskob.testrx.data.entity.ProductEntity;
import com.task.vasskob.testrx.data.entity.StoreEntity;

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
    Observable<ApiResponse<List<StoreEntity>>> loadStores(
//            @Query("where")
//                    String where,
//            @Query("page")
//                    Integer pageNumber
    );

    @GET("/products")
    @Headers(AUTH_TOKEN)
    Observable<ApiResponse<List<ProductEntity>>> loadAllProducts();
//            @Query("q") String query,
//            @Query("where") String where,
//            @Query("page") Integer page);

    @GET("/stores/{id}/products")
    @Headers(AUTH_TOKEN)
    Observable<ApiResponse<List<ProductEntity>>> loadProductsInStore(
            @Path("id") long storeId);
//            @Query("page") int page,
//            @Query("q") String query);
}
