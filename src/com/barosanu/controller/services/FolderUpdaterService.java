package com.barosanu.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.Folder;
import java.util.List;

public class FolderUpdaterService extends Service {

    private List<Folder> folderList;

    public FolderUpdaterService(List<Folder> folderList) {
        this.folderList = folderList;
    }


    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (;;){
                   try {
                       Thread.sleep(5000);
                       for (Folder folder: folderList){
                            if(folder.getType() != Folder.HOLDS_FOLDERS && folder.isOpen()){
                                folder.getMessageCount();
                            }
                       }
                   } catch (Exception e){
                       e.printStackTrace();
                   }
                }
            }
        };
    }
}
