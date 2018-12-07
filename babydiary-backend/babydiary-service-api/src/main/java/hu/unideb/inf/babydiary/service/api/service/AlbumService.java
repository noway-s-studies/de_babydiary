package hu.unideb.inf.babydiary.service.api.service;

import hu.unideb.inf.babydiary.commons.pojo.request.AlbumRequest;
import hu.unideb.inf.babydiary.service.api.domain.Album;

import java.util.List;

public interface AlbumService {

    void saveAlbum(AlbumRequest albumRequest);

    void deleteAlbum(Long id);

    Album findAlbumById(Long id);

    List<Album> findAllAlbum();

}
