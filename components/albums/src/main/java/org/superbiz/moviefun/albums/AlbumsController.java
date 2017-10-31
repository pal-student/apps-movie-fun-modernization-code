package org.superbiz.moviefun.albums;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Controller
public class AlbumsController {

    private AlbumsBean albumsBean;

    public AlbumsController(AlbumsBean albumsBean) {
        this.albumsBean = albumsBean;
    }

    @PostMapping("/albums")
    public @ResponseBody void addAlbum(@RequestBody Album album) {
        albumsBean.addAlbum(album);
    }

    @GetMapping("/albums/find/{id}")
    public @ResponseBody Album find(@PathVariable long id) {
        return albumsBean.find(id);
    }

    @GetMapping("/albums")
    public @ResponseBody List<Album> getAlbums() {
        return albumsBean.getAlbums();
    }

    @DeleteMapping("/albums")
    public @ResponseBody void deleteAlbum(@RequestBody Album album) {
        albumsBean.deleteAlbum(album);
    }

    @PutMapping("/albums")
    public @ResponseBody void updateAlbum(@RequestBody Album album) {
        albumsBean.deleteAlbum(album);
    }
}
