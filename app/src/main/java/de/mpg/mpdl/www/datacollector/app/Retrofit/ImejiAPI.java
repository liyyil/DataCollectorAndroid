package de.mpg.mpdl.www.datacollector.app.Retrofit;

import java.util.List;

import de.mpg.mpdl.www.datacollector.app.Model.CollectionLocal;
import de.mpg.mpdl.www.datacollector.app.Model.DataItem;
import de.mpg.mpdl.www.datacollector.app.Model.ImejiModel.ItemImeji;
import de.mpg.mpdl.www.datacollector.app.Model.POI;
import de.mpg.mpdl.www.datacollector.app.Model.User;
import de.mpg.mpdl.www.datacollector.app.utils.DeviceStatus;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

/**
 * Created by allen on 01/04/15.
 */
public interface ImejiAPI {
    //You can use rx.java for sophisticated composition of requests
    //@GET("/users/{user}")
    //public Observable<User> fetchUser(@Path("user") String user);

    //or you can just get your model if you use json api
    @GET("/users/{user}")
    public User fetchUser(@Path("user") String user);

    //or if there are some special cases you can process your response manually
    //@GET("/users/{user}")
    //public Response fetchUsers(@Path("user") String user);

    public static final String BASE_URL = DeviceStatus.BASE_URL;

    @POST("/login")
    User basicLogin();



    /*
     *  For items
    */
    //get all items
    @GET("/items")
    List<DataItem> getItems();

    @GET("/items")
    void getItems(Callback<List<DataItem>> callback);

    //get one item by itemId
    @GET("/items/{id}")
    List<DataItem> getItemById(@Path("id") String itemId,
                               Callback<Response> callback);

    //@POST("/items")
    //void postItem(@Body DataItem item, Callback<DataItem> callback);

    @Multipart
    @POST("/items")
    void postItem(@Part("file") TypedFile file,
                  @Part("json") String json,
                  Callback<ItemImeji> callback);

    //https://dev-faces.mpdl.mpg.de:443/imeji/rest/items/W7e2SSZHwN4dkIAK
    @DELETE("/items/{id}")
    void deleteItemById(@Path("id") String itemId,
                               Callback<Response> callback);



    /*
     *  For collections
    */
    //get all collections
    @GET("/collections")
    void getCollections(Callback<List<CollectionLocal>> callback);

    //get all items by collection id
    @GET("/collections/{id}/items")
    void getCollectionItems(@Path("id") String collectionId, Callback<List<DataItem>> callback);



    /*
     *  For users
    */
    //get all users
    @GET("/users")
    void getUsers(Callback<List<User>> callback);

    //get one User by userId
    @GET("/users/{userId}")
    List<User> getUserById(@Path("userId") String userId, Callback<Response> callback);



    /*
     *  For POI
    */

    //get all items
    @GET("/albums")
    void getPOIs(Callback<List<POI>> callback);

    @GET("/albums")
    void getPOIsByQuery(@Query("q") String query,
                Callback<List<POI>> callback);

    @GET("/albums/{id}")
    void getPOIById(@Path("id") String albumId,
                      Callback<List<POI>> callback);

    @GET("/albums/{id}/members")
    void getPoiMembers(@Path("id") String albumId,
                       Callback<List<DataItem>> callback);

    @POST("/albums")
    void postPOI(@Body POI poi,
                 Callback<POI> callback);

    @PUT("/albums/{id}/members/link")
    void linkItems(@Path("id") String albumId,
                   @Body TypedString body,
                   Callback<List<String>> callback);


}
