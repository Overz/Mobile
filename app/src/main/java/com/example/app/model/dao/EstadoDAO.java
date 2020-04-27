package com.example.app.model.dao;

import android.content.Context;

import com.example.app.model.banco.BaseDAO;
import com.example.app.model.banco.helpers.DaoHelper;
import com.example.app.model.vo.EstadoVO;
import com.example.app.util.Constantes;

import java.sql.SQLException;
import java.util.List;

public class EstadoDAO extends DaoHelper<EstadoVO> implements BaseDAO<EstadoVO> {

    private Integer i;
    private EstadoVO e;
    private List<EstadoVO> list;

    public EstadoDAO(Context c, Class className) {
        super(c, className);
    }

    @Override
    public List<EstadoVO> consultarTodos() {
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
    public EstadoVO consultarPorId(int id) {
        try {
            e = getDao().queryForId(id);
            if (e != null) return e;
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
    public EstadoVO cadastrar(EstadoVO object) {
        try {
            e = getDao().createIfNotExists(object);
            if (e != null) return e;
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
    public Integer alterar(EstadoVO object) {
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
    public Integer excluir(EstadoVO estado) {
        try {
            i = getDao().delete(estado);
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
