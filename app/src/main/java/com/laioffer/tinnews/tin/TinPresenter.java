package com.laioffer.tinnews.tin;

import com.laioffer.tinnews.retrofit.response.News;

import java.util.List;

public class TinPresenter implements TinContract.Presenter {
    //hold the reference
    private TinContract.View view;

    //link the model with presenter
    private TinContract.Model model;

    public TinPresenter() {
        this.model = new TinModel();
        //link the model with presenter
        this.model.setPresenter(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(TinContract.View view) {
        //hold the reference
        this.view = view;
        //5.7 start to fetchData
        this.model.fetchData();
    }

    @Override
    public void onViewDetached() {
        //clear the reference
        this.view = null;
    }

    //5.7 implement the showNewsCard, return the data to the view
    @Override
    public void showNewsCard(List<News> newsList) {
        if (this.view != null) {
            view.showNewsCard(newsList);
        }
    }

    @Override
    public void saveFavoriteNews(News news) {
        model.saveFavoriteNews(news);

    }
}

