package com.example.app.model.dao;

import android.content.Context;

import com.example.app.model.banco.BaseDAO;
import com.example.app.model.banco.helpers.DaoHelper;
import com.example.app.model.vo.EstadoVO;
import com.example.app.util.Constantes;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class EstadoDAO extends DaoHelper<EstadoVO> implements BaseDAO<EstadoVO> {

    public EstadoDAO(Context c, Class className) {
        super(c, className);
    }

    @Override
    public List<?> consultarTodos() {
        try {
            if (getDao().queryForAll() == null) {
                throw new SQLException("Erro ao Consultar Todos os Estados");
            } else {
                return getDao().queryForAll();
            }
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
            if (getDao().queryForId(id) == null){
                throw new SQLException("Erro ao Consultar Estado por ID(" + id + ")");
            } else {
                return getDao().queryForId(id);
            }
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
    public Integer cadastrar(EstadoVO object) {
        try {
            if (getDao().create(object) == Constantes.CODIGO_RETORNO_ERRO) {
                throw new SQLException("Erro ao Cadastrar um Estado(" + object.toString() + ")");
            } else {
                return getDao().create(object);
            }
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
            if (getDao().update(object) == Constantes.CODIGO_RETORNO_ERRO) {
                throw new SQLException("Erro ao tentar Alterar um Estado(" + object.toString() + ")");
            } else {
                return getDao().update(object);
            }
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
            if (getDao().deleteIds(id) == Constantes.CODIGO_RETORNO_ERRO){
                throw new SQLException("Erro ao tentar Excluir o/os Estados(" + id.size() + ")");
            } else {
                return getDao().deleteIds(id);
            }
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
