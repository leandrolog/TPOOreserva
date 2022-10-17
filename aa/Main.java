import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        new Thread().sleep(1000);
        System.out.println("--------------------------------------------");

        System.out.println("i para iniciar uma nova partida ");
        System.out.println("--------------------------------------------");
        System.out.println("s para sair");
        System.out.println("--------------------------------------------");

        char primeiroMenu = sc.next().charAt(0);
        sc.nextLine();

        if (primeiroMenu == 'i') {

            ArrayList<Personagem> personagens = new ArrayList<Personagem>();

            Personagem guerreiro = new Guerreiro();
            Personagem arqueiro = new Arqueiro();
            Personagem mago = new Mago();

            Dragao dragao = new Dragao();


            System.out.println("c para criar um novo personagem");
            System.out.println("--------------------------------------------");

            System.out.println("i para começar a partida");
            System.out.println("--------------------------------------------");

            System.out.println("s para sair do jogo");
            char segundoMenu = sc.next().charAt(0);
            sc.nextLine();

            if (segundoMenu == 'c') {
                System.out.println("Quantos Personagems deseja criar? max '3'");
                int x = sc.nextInt();

                while (x != 0) {
                    System.out.println("--------------------------------------------");
                    System.out.println("a para criar um Arqueiro");
                    System.out.println("--------------------------------------------");
                    System.out.println("g para Guerreiro");
                    System.out.println("--------------------------------------------");
                    System.out.println("m para Mago");
                    System.out.println("--------------------------------------------");
                    char rf21 = sc.next().charAt(0);
                    sc.nextLine();

                    System.out.println("Escolha um nome para seu personagem");
                    String nomePersonagem = sc.nextLine();
                    System.out.println("--------------------------------------------");


                    if (rf21 == 'a') {
                        arqueiro = (new Arqueiro());
                        arqueiro.setNomePersonagem(nomePersonagem);
                        System.out.println("Escolha sua arma");
                        System.out.println("--------------------------------------------");
                        System.out.println("1 Balestra");
                        System.out.println("--------------------------------------------");
                        System.out.println("2 ArcoLongo");

                        int armaPersonagem = sc.nextInt();
                        if (armaPersonagem == 1) {
                            arqueiro.setArmaPersonagem(new Balestra());
                        } else {
                            arqueiro.setArmaPersonagem(new ArcoLongo());
                        }
                        personagens.add(arqueiro);
                    }

                    if (rf21 == 'g') {
                        guerreiro = (new Guerreiro());
                        System.out.println("--------------------------------------------");

                        System.out.println("Escolha sua arma");
                        System.out.println("--------------------------------------------");
                        System.out.println("1 Espada");
                        System.out.println("--------------------------------------------");
                        System.out.println("2 Machado");


                        int armaPersonagem = sc.nextInt();
                        guerreiro.setNomePersonagem(nomePersonagem);

                        if (armaPersonagem == 1) {
                            guerreiro.setArmaPersonagem(new Espada());
                        } else {
                            guerreiro.setArmaPersonagem(new Machado());
                        }
                        personagens.add(guerreiro);
                    }

                    if (rf21 == 'm') {
                        mago = (new Mago());
                        System.out.println("Escolha sua arma");
                        System.out.println("--------------------------------------------");
                        System.out.println("1 Varinha");
                        System.out.println("--------------------------------------------");
                        System.out.println("2 Cajado");
                        int armaPersonagem = sc.nextInt();
                        mago.setNomePersonagem(nomePersonagem);

                        if (armaPersonagem == 1) {
                            mago.setArmaPersonagem(new Varinha());
                        } else {
                            mago.setArmaPersonagem(new Cajado());
                        }
                        personagens.add(mago);
                    }
                    x--;
                }
            } else if (segundoMenu == 's') {
                System.out.println("Jogo finalizado");
                System.exit(1);
            } else {
                System.out.println("Você deve conter pelo menos 1 personagem para iniciar a partida");
                System.exit(1);
            }

            Random random = new Random();
            int x = 0;
            System.out.println("--------------------------------------------");

            System.out.println("i para iniciar a partida ");
            System.out.println("--------------------------------------------");

            System.out.println("s para sair da partida");
            char comecar = sc.next().charAt(0);
            sc.nextLine();
            if (comecar == 'i') {

                while (personagens.size() > 0 && dragao.getVida() >= 0) {

                    for (int i = 0; i < personagens.size(); i++) {

                        x++;
                        System.out.println("################################################");

                        System.out.println("Turno " + x);

                        for (int e = 0; e < personagens.size(); e++) {
                            if (personagens.size() >= 1 && dragao.getVida() > 0) {
                                System.out.println("################################################");

                                System.out.println(personagens.get(e).getNomePersonagem() + " Selecionado!!!");
                                System.out.println("################################################");


                                System.out.println("a para atacar");
                                System.out.println("--------------------------------------------");

                                System.out.println("d para defender ");
                                System.out.println("--------------------------------------------");

                                System.out.println("s para sair da partida");
                                char acao = sc.next().charAt(0);
                                sc.nextLine();
                                if (acao == 'd') {
                                    personagens.get(e).defender();
                                }
                                if (acao == 'a') {
                                    personagens.get(e).getAtaque();
                                    dragao.receberAtaque(personagens.get(e).getAtaque());
                                } if (acao == 's') {
                                    System.out.println("Jogo finalizado");

                                    System.exit(1);
                                }
                            }
                        }
                        if (dragao.getVida() <= 0) {
                            System.out.println(dragao.getNomePersonagem() + " Faleceu!!");
                            System.out.println("Você venceu!!!");
                            System.exit(1);
                        }
                        if (personagens.size() >= 1 && dragao.getVida() > 0) {
                            int alvo = random.nextInt(personagens.size());
                            dragao.getAtaque();
                            personagens.get(alvo).receberAtaque(dragao.getAtaque());
                            System.out.println(dragao.getNomePersonagem() + "Atacou " + personagens.get(alvo).getNomePersonagem());
                            System.out.println(".....................");
                            Thread.sleep(1500);
                            System.out.println(personagens.get(alvo).getNomePersonagem() + " Está com " + personagens.get(alvo).getVida() + " Pontos de vida");
                            System.out.println("LazyProg está com " + dragao.getVida() + " Pontos de vida");
                            Thread.sleep(2000);
                            if (personagens.get(i).getVida() <= 0) {
                                System.out.println(personagens.get(i).getNomePersonagem() + " Faleceu!!");
                                Thread.sleep(2000);
                                personagens.remove(i);
                                if(personagens.size() == 0){
                                    System.out.println("............................");
                                    System.out.println("Você foi derrotado !!!");
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("Jogo finalizado");
                System.exit(1);
            }
        } else {
            System.out.println("Jogo finalizado");
            System.exit(1);
        }
        sc.close();
    }
}