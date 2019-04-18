package com.navin.wallpaper.model;

import java.util.List;

public interface IMessageListener {

    public void onSuccess(List<Wallpaper> wallpaperList);
    public void onError(String errorResponse);


}
