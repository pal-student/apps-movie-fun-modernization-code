package org.superbiz.moviefun.albumsapi;

import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.List;

public class AlbumsClient {

    private String albumsUrl;
    private RestOperations restOperations;

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }


    public void addAlbum(AlbumInfo album) {
        restOperations.postForObject(albumsUrl + "/albums", album, Void.class);
    }

    public AlbumInfo find(long id) {
        return restOperations.getForObject(albumsUrl + "/albums/find/{id}", AlbumInfo.class, id);
    }

    public List<AlbumInfo> getAlbums() {
        AlbumInfo[] albums = restOperations.getForObject(albumsUrl + "/albums", AlbumInfo[].class);
        return Arrays.asList(albums);
    }

    public void deleteAlbum(AlbumInfo album) {
        restOperations.delete(albumsUrl + "/albums", album);
    }

    public void updateAlbum(AlbumInfo album) {
        restOperations.put(albumsUrl + "/albums", album);
    }
}
