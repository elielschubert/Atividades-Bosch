package DTO;

import DAO.ClienteDAO;
import DAO.EstadoDAO;


public class Main {
    public static void main(String[] args) {

        //Cria estado
        EstadoDAO dao = new EstadoDAO();
        Estado novoEstado = new Estado();

        novoEstado.setSigla("SP");
        novoEstado.setDescricao("São Paulo");
        dao.adicionarEstado(novoEstado);

        //Lista estado
        for(Estado estado : dao.listarEstados()) {
            System.out.println(estado.getSigla() + " - " + estado.getDescricao());
        }

        //Atualiza estado
        novoEstado.setDescricao("São Paulo - Atualizado");
        dao.atualizaEstado(novoEstado);

        //Deleta estado
        dao.deletarEstado(novoEstado.getSigla());

        //Cria cliente
        ClienteDAO daoCli = new ClienteDAO();
        Cliente novoCliente = new Cliente();

        novoCliente.setCpf("12345678910");
        novoCliente.setNome("Jorge");
        novoCliente.setEndereco1("Rua Tal");
        novoCliente.setEndereco2("Tal Rua");
        novoCliente.setBairro("Orriab");
        novoCliente.setCidade("Ellivnioj");
        novoCliente.setEstado("SC");
        novoCliente.setCep("89999999");
        novoCliente.setIdade(21);
        novoCliente.setPrimeiraCompra(false);
        novoCliente.setDataNascimento("2001-07-22");
        daoCli.adicionarCliente(novoCliente);

        //Lista cliente
        for (Cliente cliente : daoCli.listarClientes()){
            System.out.println("---------------\n" + cliente.getCpf() + "\n" + cliente.getNome() + "\n" + cliente.getEndereco1() + "\n" + cliente.getEndereco2() + "\n" + cliente.getBairro() + "\n" + cliente.getCidade() + "\n" + cliente.getEstado() + "\n" + cliente.getCep() + "\n" + cliente.getIdade() + "\n" + cliente.getPrimeiraCompra() + "\n" + cliente.getDataNascimento());
        }

        //Atualiza cliente
        novoCliente.setCpf("12345678910");
        novoCliente.setNome("Cláudio");
        novoCliente.setEndereco1("Rua Tal");
        novoCliente.setEndereco2("Tal Rua");
        novoCliente.setBairro("Orriab");
        novoCliente.setCidade("Ellivnioj");
        novoCliente.setEstado("SC");
        novoCliente.setCep("89999999");
        novoCliente.setIdade(19);
        novoCliente.setPrimeiraCompra(true);
        novoCliente.setDataNascimento("2001-07-22");
        daoCli.atualizarCliente(novoCliente);

        //Deleta cliente
        daoCli.deletarCliente(novoCliente.getCpf());
    }
}
