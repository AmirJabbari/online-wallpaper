package com.navin.wallpaper.model;

import java.util.List;

public interface IMessageAlbumListener {

    public void onSuccess(List<Album> albumList);
    public void onError(String Error);


}
