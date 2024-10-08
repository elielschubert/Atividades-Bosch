package DAO;

import Conexao.ConexaoDB;
import DTO.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO tbcliente (cpf, nome, endereco1, endereco2, bairro, cidade, estado, cep, idade, primeira_compra, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco1());
            stmt.setString(4, cliente.getEndereco2());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getEstado());
            stmt.setString(8, cliente.getCep());
            stmt.setInt(9, cliente.getIdade());
            stmt.setBoolean(10, cliente.getPrimeiraCompra());
            stmt.setString(11, cliente.getDataNascimento());

            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM tbcliente";

        try {
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco1(rs.getString("endereco1"));
                cliente.setEndereco2(rs.getString("endereco2"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCep(rs.getString("cep"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setPrimeiraCompra(rs.getBoolean("primeira_compra"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
            return null;
        }
        return clientes;
    }

    public boolean atualizarCliente(Cliente cliente){
        String sql = "UPDATE tbcliente SET nome = ?, endereco1 = ?, endereco2 = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, idade = ?, primeira_compra = ?, data_nascimento = ? " +
                "WHERE cpf = ?";

        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco1());
            stmt.setString(3, cliente.getEndereco2());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getCidade());
            stmt.setString(6, cliente.getEstado());
            stmt.setString(7, cliente.getCep());
            stmt.setInt(8, cliente.getIdade());
            stmt.setBoolean(9, cliente.getPrimeiraCompra());
            stmt.setString(10, cliente.getDataNascimento());
            stmt.setString(11, cliente.getCpf());

            stmt.executeUpdate();
            connection.close();
            stmt.close();
            return true;
        }
        catch (SQLException e){
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
        return false;
    }

    public void deletarCliente(String cpf){
        String sql = "DELETE FROM tbcliente WHERE cpf = ?";

        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cpf);
            stmt.executeUpdate();
            connection.close();
            stmt.close();
            System.out.println("DTO.Cliente deletado com sucesso!");
        }
        catch (SQLException e){
            System.out.println("Erro ao deletar cliente: "+ e.getMessage());
        }
    }
}
