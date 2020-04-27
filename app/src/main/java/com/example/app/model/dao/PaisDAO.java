package com.example.app.model.dao;

import android.content.Context;

import com.example.app.model.banco.BaseDAO;
import com.example.app.model.banco.helpers.DaoHelper;
import com.example.app.model.vo.PaisVO;
import com.example.app.util.Constantes;

import java.sql.SQLException;
import java.util.List;

public class PaisDAO extends DaoHelper<PaisVO> implements BaseDAO<PaisVO> {

    private Integer i;
    private PaisVO p;
    private List<PaisVO> list;

    public PaisDAO(Context c, Class className) {
        super(c, className);
    }

    @Override
    public List<PaisVO> consultarTodos() {
        try {
            list = getDao().queryForAll();
            if (list != null) return list;
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
            p = getDao().queryForId(id);
            if (p != null) return p;
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
            p = getDao().createIfNotExists(object);
            if (p != null) return p;
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
            i = getDao().update(object);
            if (i.equals(Constantes.CODIGO_RETORNO_SUCESSO)) return i;
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
            i = getDao().delete(pais);
            if (i.equals(Constantes.CODIGO_RETORNO_SUCESSO)) return i;
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
