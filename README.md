# Songr Application
Spring application with routes.
## How to Run the Application
1. Clone repo
2. `./gradlew bootRun` on terminal or Run the App class in IDE
3. Go to localhost:8080 and test routes
   + default route
   + /hello
   + /hello/stringToCapitalize
   +/reverse?sentence=stringToReverse

## Album
1. Added class Album. Connects to DB and shows all albums,
allows user to add to DB.
   + /albums
   + /oneAlbum/{id}
2. Added class Song. Has foreign key to Album.
    Able to add a song to the album.