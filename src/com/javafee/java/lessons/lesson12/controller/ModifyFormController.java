package com.javafee.java.lessons.lesson12.controller;

import com.javafee.java.lessons.lesson12.view.ModifyClientForm;

import java.util.function.Consumer;

public class ModifyFormController {
    private ModifyClientForm modifyClientForm;
    private Consumer reload;

    public void control(Consumer reload){
        init();
        this.reload = reload;

        modifyClientForm.getButtonAcccept().addActionListener(e -> onClickButtonAccept());
    }

    private void onClickButtonAccept() {

    }

    public void init() {
        modifyClientForm.getFrame().setVisible(true);
    }
}
