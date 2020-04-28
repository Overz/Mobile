package com.example.app.model.dao;

import android.content.Context;

import com.example.app.model.banco.BaseDAO;
import com.example.app.model.banco.helpers.DaoHelper;
import com.example.app.model.vo.PaisVO;

import java.sql.SQLException;
import java.util.List;

public class PaisDAO extends DaoHelper<PaisVO> implements BaseDAO<PaisVO> {

    public PaisDAO(Context c, Class className) {
        super(c, className);
    }

    @Override
    public List<PaisVO> consultarTodos() {
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
    public PaisVO cadastrar(PaisVO object) {
        try {
            return getDao().createIfNotExists(object);
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
    public Integer excluir(PaisVO pais) {
        try {
            return getDao().delete(pais);
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
    public List<PaisVO> consultarColuna(String string) {
        try {
            return getDao().queryBuilder().selectColumns(string).query();
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
    public Integer inserirDadosEmColuna(String table, String value) {
        try {
            return getDao().executeRaw("INSERT INTO " + table + " VALUES ("+value+")");
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
