import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
    class Card {
    Scanner scan = new Scanner(System.in);
    int[] deck = new int[52];
    String[] palo = {"Corazones", "Espadas", "Diamantes", "Treboles"};
    String[] valor = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] color = {"Negro", "Rojo"};

    Card() {
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
    }

    public void ShuffleCards() {
        System.out.println("Se mezclo el deck");
    }

    public void RandomCard() {
        Random rand = new Random();
        String col = color[deck[0]];
        int num = rand.nextInt(52 - 1) + 1;
        String pal = palo[deck[num] / 13];
        String val = valor[deck[num] % 13];
        if (pal == "Corazones" || pal == "Diamantes")
            col = color[deck[1]];
        System.out.println(val + " de " + pal + " color " + col);
        //System.arraycopy(deck, num + 1, deck, num, deck.length - num - 1);
    }

    public void DisplayCards() {

        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int num = rand.nextInt(52 - 1) + 1;
            String col = color[deck[0]];
            String pal = palo[deck[num] / 13];
            String val = valor[deck[num] % 13];
            if (pal == "Corazones" || pal == "Diamantes")
                col = color[deck[1]];
            System.out.println(val + " de " + pal + " color " + col);
            //System.arraycopy(deck, i + 1, deck, i, deck.length - i - 1);
        }
    }

    public void SeleccionCard() {
        int x=1;
        try {
            x = scan.nextInt();

            if (x > 52 || x < 1) {
                System.out.println("Porfavor solo elige entre las 52 cartes del deck");
            } else {
                String col = color[deck[0]];
                int num = x;
                String pal = palo[deck[num] / 13];
                String val = valor[deck[num] % 13];
                if (pal == "Corazones" || pal == "Diamantes")
                    col = color[deck[1]];
                System.out.println(val + " de " + pal + " color " + col);
            }
        }
        catch(InputMismatchException e){System.out.println("Porfavor solo valores numericos (int)");}

    }
}

class Deck {
    private Card card;
    private int Deckdecartas = 52;

    Deck() {
        card = new Card();
    }
}


public class Main {
    public static void main(String[] args) {
        boolean On=false;
        Scanner scan = new Scanner(System.in);
        String opt;
        String line ="====================";
        String line2 ="_____________________";
        Card card =new Card();
        Deck deck = new Deck();

        System.out.println("Bienvenido al juego de pocker");

        do{
            System.out.println(line);
            System.out.println("Selecciona ona opcion \nA)Shuffle \nB)Head \nC)Pick \nD)Hand \nE)Exit");
            System.out.println(line);
            opt= scan.nextLine();
            switch (opt.toLowerCase())
            {
                case "a":
                    System.out.println(line2);
                    card.ShuffleCards();
                    System.out.println(line2);
                    break;

                case "b":
                    System.out.println(line2);
                    card.RandomCard();
                    System.out.println(line2);
                    break;

                case "c":
                    System.out.println(line2);
                    System.out.println("Porfavor seleccione una carta entre 1 y 52");
                    card.SeleccionCard();
                    System.out.println(line2);
                    break;

                case "d":
                    System.out.println(line2);
                    System.out.println("Las cartas son:");
                    card.DisplayCards();
                    System.out.println(line2);
                    break;

                case "e":
                    System.out.println(line2);
                    On=true;
                    System.out.println("Gracias por haber jugado...");
                    System.out.println(line2);
                    break;

                default:
                    System.out.println(line2);
                    System.out.println("Porfavor selecciona una de las opciones entre A, B, C, D o E");
                    System.out.println(line2);
            }
        }while (!On);

    }
}

# rest
