package com.muzadev.asistenpemrogramanaplikasimobile.adapter;

import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

public interface AdapterCallback {
    void menuEdit(Todo todo);

    void menuDelete(Todo todo);
}
