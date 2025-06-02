package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import banco.Conexao;
import entities.NotasEntity;

public class NotasRepository extends Conexao{
    public NotasRepository() throws Exception{}

    public boolean incluir(NotasEntity nota) throws
    Exception {
        String sql= "insert into tbnotas "+
                    "(aluno,disciplina, nota) "+
                    "values (?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, nota.getAluno());
        ps.setString(2, nota.getDisciplina());
        ps.setFloat(3, nota.getNota());
        if(ps.executeUpdate()>0) return true;
        return false;
    }
    public boolean editar(NotasEntity nota) throws
    Exception {
        String sql= "update tbnotas "+
                    " set aluno=?,disciplina=?, nota=?" +
                    " where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, nota.getAluno());
        ps.setString(2, nota.getDisciplina());
        ps.setFloat(3, nota.getNota());
        ps.setInt(4, nota.getId());
        if(ps.executeUpdate()>0) return true;
        return false;
    }
    public ArrayList<NotasEntity> listarTodos() throws Exception{
        ArrayList<NotasEntity> dados = new ArrayList<>();
        String sql = "Select * from tbnotas order by aluno";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            dados.add(new NotasEntity(rs.getInt("id"), 
            rs.getString("aluno"), 
            rs.getString("disciplina"), rs.getFloat("nota")));
        }
        return dados;
    }
    public ArrayList<NotasEntity> pesquisar(String nome) throws Exception{
        ArrayList<NotasEntity> dados = new ArrayList<>();
        String sql = "Select * from tbnotas "+
                    " where aluno like ?"+
                    " order by aluno";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, nome + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            dados.add(new NotasEntity(rs.getInt("id"), 
            rs.getString("aluno"), 
            rs.getString("disciplina"), rs.getFloat("nota")));
        }
        return dados;
    }
    public boolean excluir(int id) throws Exception {
        String sql = "Delete from tbnotas where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        return (ps.executeUpdate()>0);

    }
}
