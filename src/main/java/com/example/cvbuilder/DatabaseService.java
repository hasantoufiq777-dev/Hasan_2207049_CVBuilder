package com.example.cvbuilder;

import javafx.concurrent.Task;

import java.util.List;

public class DatabaseService {

    public static Task<Integer> insertCVAsync(CVModel cv) {
        return new Task<>() {
            @Override
            protected Integer call() {
                return DatabaseHelper.insertCV(cv);
            }
        };
    }

    public static Task<List<CVModel>> loadAllCVsAsync() {
        return new Task<>() {
            @Override
            protected List<CVModel> call() {
                return DatabaseHelper.getAllCVs();
            }
        };
    }

    public static Task<Boolean> updateCVAsync(int id, String name, String email) {
        return new Task<>() {
            @Override
            protected Boolean call() {
                return DatabaseHelper.updateCV(id, name, email);
            }
        };
    }

    public static Task<Boolean> deleteCVAsync(int id) {
        return new Task<>() {
            @Override
            protected Boolean call() {
                return DatabaseHelper.deleteCV(id);
            }
        };
    }
}
