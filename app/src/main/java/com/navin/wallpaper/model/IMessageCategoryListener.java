package com.navin.wallpaper.model;

import java.util.List;

public interface IMessageCategoryListener {

    public void onSuccess(List<Category> categoryList);

    public void onError(String Error);


}
