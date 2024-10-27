package dev.mariamariana.college_cps.model;

import java.time.LocalDateTime;

public interface BaseModel<T> {

    T safeUpdateInfo(T entity);

    void setCreatedAt(LocalDateTime createdAt);
}
