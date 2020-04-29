package com.example.app.model.dao;

import android.content.Context;

import com.example.app.model.banco.BaseDAO;
import com.example.app.model.banco.helpers.DaoHelper;
import com.example.app.model.vo.RegiaoVO;

import java.sql.SQLException;
import java.util.List;

public class RegiaoDAO extends DaoHelper<RegiaoVO> implements BaseDAO<RegiaoVO> {

    public RegiaoDAO(Context c, Class className) {
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
    public RegiaoVO consultarPorId(int id) {
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
    public RegiaoVO cadastrar(RegiaoVO object) {
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
    public Integer alterar(RegiaoVO object) {
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
    public Integer excluir(RegiaoVO object) {
        try {
            return getDao().delete(object);
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
    public Integer excluirID_e_Constraint(String... string) {
        return null;
    }

    @Override
    public Integer excluirPorID(RegiaoVO object) {
        try {
            return getDao().deleteById(object.getId());
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
    public List<?> consultarColunas(String... string) {
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
    public Integer inserirDadosEmColunas(String... String) {
        try {
            return getDao().executeRaw("INSERT INTO " + String + " VALUES ("+String+")");
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
