
import com.mysql.cj.xdevapi.DbDoc;
import java.util.Properties;
import com.vmm.JHTTPServer;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class my_web_server extends JHTTPServer {

    public my_web_server(int portno) throws Exception {
        super(portno);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {

        Response res = new Response(HTTP_OK, "text/plain", "Hi");
        System.out.println("uri--------------->" + uri);
        if (uri.equals("/login")) {
            String user = parms.getProperty("username");
            String pass = parms.getProperty("password");
            try {
                ResultSet rs = db_loader.executeSQL("select *  from admin where username='" + user + "' and password='" + pass + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/admin_change_password")) {
            String op = parms.getProperty("old_password");
            String np = parms.getProperty("new_password");
            String u = parms.getProperty("username");

            try {
                ResultSet rs = db_loader.executeSQL("select *  from admin where username='" + u + "' and  password='" + op + "'");
                if (rs.next()) {
                    rs.updateString("password", np);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/admin_add_category")) {
            String cn = parms.getProperty("category_name");
            String des = parms.getProperty("description");

            try {
                ResultSet rs = db_loader.executeSQL("select *  from category where category_name='" + cn + "' ");
                if (rs.next()) {

                    res = new Response(HTTP_OK, "text/plain", "fails");
                } else {

                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/bingeflixPhotos");
                    System.out.println("photoname   " + filename);
                    String photoname = "src/bingeflixPhotos/" + filename;
                    rs.moveToInsertRow();
                    rs.updateString("category_name", cn);
                    rs.updateString("description", des);
                    rs.updateString("photo", photoname);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "success");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/getAllCategories")) {

            String ans = "";

            try {
                ResultSet rs = db_loader.executeSQL("select *  from category");
                while (rs.next()) {
                    String category_name = rs.getString("category_name");
                    String description = rs.getString("description");
                    String photo = rs.getString("photo");

                    ans += category_name + "**" + description + "**" + photo + "#$#";
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/admindeletecategory")) {
            String category_name = parms.getProperty("catname");
            ResultSet rs = db_loader.executeSQL("select *  from category where category_name='" + category_name + "'");
            try {
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (uri.equals("/admindeletemovie")) {
            String movie_id = parms.getProperty("movieId");
            ResultSet rs = db_loader.executeSQL("select *  from movie where movie_id='" + movie_id + "'");
            try {
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.equals("/admindeletevideo")) {
            String video_id = parms.getProperty("vidoe_id");
            ResultSet rs = db_loader.executeSQL("select *  from videotable where video_id='" + video_id + "'");
            try {
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.equals("/getCategory")) {
            //getcategories from database and append them in a string 
            String ans = "";
            try {
                ResultSet rs = db_loader.executeSQL("select * from category");
                while (rs.next()) {
                    String catname = rs.getString("category_name");

                    ans += catname + "**";
                }
                //ans==== demo**photo**pic
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/addmovie")) {
            String cat = parms.getProperty("category");
            String mn = parms.getProperty("movie_name");
            String desc = parms.getProperty("description");

            int amt = Integer.parseInt(parms.getProperty("amount"));
            try {

                ResultSet rs = db_loader.executeSQL("select *  from movie where movie_name='" + mn + "' and category='" + cat + "'");

                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                } else {
                    System.out.println("category  " + cat);
                    String filename = saveFileOnServerWithRandomName(files, parms, "square_photo", "src/bingeflixPhotos");
                    System.out.println("photoname   " + filename);
                    String photoname = "src/bingeflixPhotos/" + filename;

                    String filename2 = saveFileOnServerWithRandomName(files, parms, "wide_photo", "src/bingeflixPhotos");
                    System.out.println("photoname2   " + filename2);
                    String photoname2 = "src/bingeflixPhotos/" + filename2;

                    String filename3 = saveFileOnServerWithRandomName(files, parms, "sample_video", "src/bingeflixPhotos");
                    System.out.println("sample_video   " + filename3);
                    String photoname3 = "src/bingeflixPhotos/" + filename3;

                    rs.moveToInsertRow();
                    rs.updateString("category", cat);
                    rs.updateString("movie_name", mn);
                    rs.updateString("description", desc);
                    rs.updateInt("amount", amt);
                    rs.updateString("square_photo", photoname);
                    rs.updateString("wide_photo", photoname2);
                    rs.updateString("sample_video", photoname3);

                    rs.insertRow();

                    res = new Response(HTTP_OK, "text/plain", "success");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.equals("/getAllMovies")) {
            String cat = parms.getProperty("cat");
            String ans = "";

            try {
                ResultSet rs = db_loader.executeSQL("select *  from movie where category ='" + cat + "'");
                while (rs.next()) {
                    String movieid = rs.getString("movie_id");

                    String movieName = rs.getString("movie_name");
                    String description = rs.getString("description");
                    String squarePhoto = rs.getString("square_photo");
                    String wide_photo = rs.getString("wide_photo");
                    String sample_video = rs.getString("sample_video");
                    String amount = rs.getString("amount");

                    ans += movieid + "**" + movieName + "**" + description + "**" + squarePhoto + "**" + wide_photo + "**" + sample_video + "**" + amount + "#$#";
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/addvideos")) {
            String cs = parms.getProperty("category_select");
            String sm = parms.getProperty("select_movie");
            String en = parms.getProperty("episode_number");
            String tl = parms.getProperty("title");
            String dt = parms.getProperty("duration");

            try {

                ResultSet rs = db_loader.executeSQL("select *  from videotable where movie='" + sm + "' and episode_number='" + en + "'");

                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                } else {

                    String filename = saveFileOnServerWithRandomName(files, parms, "thumbnail", "src/bingeflixPhotos");
                    System.out.println("photoname   " + filename);
                    String photoname = "src/bingeflixPhotos/" + filename;

                    String filename2 = saveFileOnServerWithRandomName(files, parms, "video", "src/bingeflixPhotos");
                    System.out.println("photoname2   " + filename2);
                    String photoname2 = "src/bingeflixPhotos/" + filename2;

                    rs.moveToInsertRow();
                    rs.updateString("category", cs);
                    rs.updateString("movie", sm);
                    rs.updateString("episode_number", en);
                    rs.updateString("title", tl);
                    rs.updateString("duration", dt);
                    rs.updateString("thumbnail", photoname);
                    rs.updateString("video", photoname2);

                    rs.insertRow();

                    res = new Response(HTTP_OK, "text/plain", "success");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.equals("/getMoviesFromCategory")) {
            String cat = parms.getProperty("cat");
            String ans = "";
            try {
                ResultSet rs = db_loader.executeSQL("select * from movie where category='" + cat + "'");
                while (rs.next()) {
                    ans += rs.getString("movie_name") + "#$#";
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/getAllVideos")) {
            String cs = parms.getProperty("category_select");
            String sm = parms.getProperty("select_movie");
            String ans = "";
            try {
                ResultSet rs = db_loader.executeSQL("select * from videotable where category='" + cs + "' and movie ='" + sm + "'");
                while (rs.next()) {
                    ans += rs.getString("video_id") + "**";
                    ans += rs.getString("category") + "**";
                    ans += rs.getString("movie") + "**";
                    ans += rs.getString("episode_number") + "**";
                    ans += rs.getString("title") + "**";
                    ans += rs.getString("duration") + "**";
                    ans += rs.getString("thumbnail") + "**";
                    ans += rs.getString("video") + "#$#";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/signup")) {

            String u = parms.getProperty("username");
            String p = parms.getProperty("password");
            String cp = parms.getProperty("confirm_password");
            String e = parms.getProperty("email");
            String ph = parms.getProperty("phone_number");
            System.out.println(u + " " + p + " " + cp + " " + e + " " + ph);

            try {

                ResultSet rs = db_loader.executeSQL("select *  from user where user_name='" + u + "'");

                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                } else {

                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/bingeflixPhotos");
                    System.out.println("photoname   " + filename);
                    String photoname = "src/bingeflixPhotos/" + filename;

                    rs.moveToInsertRow();
                    rs.updateString("user_name", u);
                    rs.updateString("password", p);
                    rs.updateString("email", e);
                    rs.updateString("phone_number", ph);
                    rs.updateString("photo", photoname);

                    rs.insertRow();

                    res = new Response(HTTP_OK, "text/plain", "success");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.equals("/userlogin")) {
            String user = parms.getProperty("username");
            String pass = parms.getProperty("password");
            try {
                ResultSet rs = db_loader.executeSQL("select *  from user where user_name='" + user + "' and password='" + pass + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/user_change_password")) {
            String op = parms.getProperty("old_password");
            String np = parms.getProperty("new_password");
            String u = parms.getProperty("username");

            try {
                ResultSet rs = db_loader.executeSQL("select *  from user where user_name='" + u + "' and  password='" + op + "'");
                if (rs.next()) {
                    rs.updateString("password", np);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/getresource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);
            res = sendCompleteFile(uri);
        } else if (uri.contains("/getsamplevideo")) {
            String svideo = "";
            String movie = parms.getProperty("movie");
            ResultSet rs = db_loader.executeSQL("select * from movie where movie_name='" + movie + "'");
            try {
                if (rs.next()) {
                    svideo = rs.getString("sample_video");
                }
                res = new Response(HTTP_OK, "text/plain", svideo);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/StreamMedia")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);
            res = streamFile(uri, method, header);

        } else if (uri.equals("/buysubscription")) {
            String movieName = parms.getProperty("movie");
            String user = parms.getProperty("username");
            System.out.println(user);
            System.out.println(movieName);

            try {
                ResultSet rs = db_loader.executeSQL("select * from user_subscription");
                rs.moveToInsertRow();
                rs.updateString("movie_name", movieName);
                rs.updateString("username", user);
                rs.insertRow();
                res = new Response(HTTP_OK, "text/plain", "success");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("check_subscription")) {
            String movieName = parms.getProperty("movie");
            String user = parms.getProperty("username");
            try {
                ResultSet rs = db_loader.executeSQL("select * from user_subscription where username='" + user + "' and movie_name='" + movieName + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/getCategoryDetails")) {
            String catname = parms.getProperty("catname");
            try {
                ResultSet rs = db_loader.executeSQL("select * from category where category_name= '" + catname + "'");
                if (rs.next()) {
                    String description = rs.getString("description");
                    String photo = rs.getString("photo");
                    String ans = description + "~~" + photo;
                    res = new Response(HTTP_OK, "text/plain", ans);
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/getMovieDetail")) {
            String movie_name = parms.getProperty("moviename");
            try {
                ResultSet rs = db_loader.executeSQL("select * from movie where movie_name= '" + movie_name + "'");
                if (rs.next()) {
                    String description = rs.getString("description");
                    String squarephoto = rs.getString("square_photo");
                    String wide_photo = rs.getString("wide_photo");
                    String amount = rs.getString("amount");

                    String ans = description + "~~" + squarephoto + "~~" + wide_photo + "~~" + amount;
                    res = new Response(HTTP_OK, "text/plain", ans);
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/getUserDetail")) {
            String user = parms.getProperty("user");
            try {
                ResultSet rs = db_loader.executeSQL("select * from user where user_name= '" + user + "'");
                if (rs.next()) {
                    String photo = rs.getString("photo");
                    res = new Response(HTTP_OK, "text/plain", photo);
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

}
