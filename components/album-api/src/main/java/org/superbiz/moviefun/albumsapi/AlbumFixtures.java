package org.superbiz.moviefun.albumsapi;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class AlbumFixtures {

    public List<AlbumInfo> load() {
        return asList(
            new AlbumInfo("Massive Attack", "Mezzanine", 1998, 9),
            new AlbumInfo("Radiohead", "OK Computer", 1997, 10),
            new AlbumInfo("Radiohead", "Kid A", 2000, 2)
        );
    }
}
