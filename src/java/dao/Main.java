/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.UsuarioImpl;
import java.util.List;
import java.util.Scanner;

import modelo.Usuario;
/**
 *
 * @author Marlon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
       

            UsuarioImpl usuarioImpl = new UsuarioImpl() {
                
                };
		
                Scanner in = new Scanner(System.in);
                for (int i = 0; i < 3; i++) {
                    Usuario u = new Usuario();
                    System.out.print("Nome: ");
                    u.setNome(in.next());
                    
                    System.out.print("Telefone: ");
                    u.setPhone(in.next());
                    
                     System.out.print("Cpf: ");
                    u.setCpf(in.next());
                    
                     System.out.print("Sexo: ");
                    u.setSexo(in.next());
                    
                       System.out.print("Senha: ");
                    u.setSenha(in.next());
                    
                    System.out.print("Endereço: ");
                    u.setLogradouro(in.next());
                    
                    System.out.print("Cep: ");
                    u.setCep(in.next());
                    
                    System.out.print("Bairro: ");
                    u.setBairo(in.next());
                    
          
                    
                    usuarioImpl.salvar(u);
                }
                List<Usuario> list = usuarioImpl.getListAll();
		String msg = ("ID\t"+f("Nome")+"\t"+f("Telefone")
                        +"\t"+f("Cpf")+"\t"+f("sexo")+"\t"+f("login")+"\t"+f("senha")+"t"+f("Endereço")+"\t"+f("cep")+"\t"+f("bairro"));
		System.out.println(msg);
		
                for (int i = 0; i < msg.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
		out(list);
		
                System.out.print("Escolha um id para pesquisa: ");
                Usuario usuario = usuarioImpl.findById(in.nextInt());
				
		System.out.println("\n"+msg);
		for (int i = 0; i < msg.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(usuario.getId()+"\t"+f(usuario.getNome())+"\t"+usuario.getPhone()
                +"\t"+f(usuario.getCpf())+"\t"+f(usuario.getSexo())+"\t"+f(usuario.getLogin())+"\t"+f(usuario.getSenha())+"\t"+f(usuario.getLogradouro())+"\t"+f(usuario.getCep())+
                        "\t"+f(usuario.getBairro()));
	}

	private static String f(String s) {
			for (int i = s.length(); i < 30; i++) {
				s+=" ";
			}
		return s;
	}

	private static void out(List<Usuario> list) {
		for (Usuario usuario : list) {
			System.out.println(usuario.getId()+"\t"+f(usuario.getNome()+"\t"+usuario.getPhone()
                        +"\t"+usuario.getCpf()+"\t")+usuario.getSexo()+"\t"+f(usuario.getLogin()+
                                "\t"+usuario.getSenha()+"\t"+usuario.getLogradouro()+
                                "t"+usuario.getCep()+"\t"+usuario.getBairro()));
		}
		
	}

}

