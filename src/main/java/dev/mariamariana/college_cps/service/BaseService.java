package dev.mariamariana.college_cps.service;

import dev.mariamariana.college_cps.model.BaseModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public abstract class BaseService<T extends BaseModel<T>,ID> implements IBaseService<T,ID> {

    private final JpaRepository<T, ID> repository;

    public BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Page<T> findPageable(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public T findById(ID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recurso não encontrado."));
    }

    @Override
    public T create(T entity) {
        entity.setCreatedAt(LocalDateTime.now());
        return this.repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        T t = this.findById(id);
        return this.repository.save(this.beforeUpdate(t, entity));
    }

    @Override
    public void deleteById(ID id) {
        if (this.beforeDelete(id)) {
            T entity = this.findById(id);
            this.repository.delete(entity);
        }
    }

    // hooks
    @Override
    public T beforeUpdate(T found, T toUpdate) {
        return found.safeUpdateInfo(toUpdate);
    }

    @Override
    public boolean beforeDelete(ID id) {
        return true;
    }
}
