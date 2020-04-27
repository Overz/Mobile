package com.example.app.model.dao;

import android.content.Context;

import com.example.app.model.banco.BaseDAO;
import com.example.app.model.banco.helpers.DaoHelper;
import com.example.app.model.vo.PaisVO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class PaisDAO extends DaoHelper<PaisVO> implements BaseDAO<PaisVO> {

    public PaisDAO(Context c, Class className) {
        super(c, className);
    }

    @Override
    public List<?> consultarTodos() {
        try {
            return getDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n"
                    + e.getCause() + "\n"
                    + e.getNextException() + "\n"
                    + e.getClass().getSimpleName()
            );
        }
        return null;
    }

    @Override
    public PaisVO consultarPorId(int id) {
        try {
            return getDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n"
                    + e.getCause() + "\n"
                    + e.getNextException() + "\n"
                    + e.getClass().getSimpleName()
            );
        }
        return null;
    }

    @Override
    public Integer cadastrar(PaisVO object) {
        try {
            return getDao().create(object);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n"
                    + e.getCause() + "\n"
                    + e.getNextException() + "\n"
                    + e.getClass().getSimpleName()
            );
        }
        return null;
    }

    @Override
    public Integer alterar(PaisVO object) {
        try {
            return getDao().update(object);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n"
                    + e.getCause() + "\n"
                    + e.getNextException() + "\n"
                    + e.getClass().getSimpleName()
            );
        }
        return null;
    }

    @Override
    public Integer excluir(Collection<Integer> id) {
        try {
            return getDao().deleteIds(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n"
                    + e.getCause() + "\n"
                    + e.getNextException() + "\n"
                    + e.getClass().getSimpleName()
            );
        }
        return null;
    }
}
