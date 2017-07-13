package com.task.vasskob.testrx.presentation.view;

interface BaseView {
    void showLoadingSuccessToast();

    void showLoadingErrorToast();

    void showConnectionFailedToast();

    void showConnectionSuccessToast();
}