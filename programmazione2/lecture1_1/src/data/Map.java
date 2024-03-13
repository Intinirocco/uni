package data;

import java.util.Random;

public class Map {

    public final int x = 4;
    public final int y = 4;

    private Block[][] mappa;

    public Map() {
        mappa = new Block[x][y];
        Random ran = new Random();
        char blocco = '0';
        for (int r = 0; r < x; ++r) {
            for (int c = 0; c < y; ++c) {
                blocco = (char) (ran.nextInt(90-65) + 65);
                mappa[r][c] = new Block(blocco);
            }
        }
    }

    public void display_on_out() {
        System.out.println("---------------------//---------------------");
        for (int r = 0; r < x; ++r) {
            for (int c = 0; c < y; ++c) {
                System.out.print(mappa[r][c].display() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------//---------------------");
    }

    public void change_cell(int x, int y) {
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            mappa[x][y] = new Block('A');
        } else {
            System.err.println("Errore nelle coordinate inserite!!!");
        }
    }

    public void insert_at_coords(int x, int y, Block b) {
        if (b != null && x >= 0 && x < this.x && y >= 0 && y < this.y) {
            mappa[x][y] = b;
            gravita(x, y);
        } else {
            System.err.println("Errore nelle coordinate o nel blocco inserito!!!");
        }
    }

    private void gravita(int x, int y) {
        int index = x;
        while (index < mappa.length - 1 && mappa[index][y].isFalls_with_gravity()) {
            if (mappa[index + 1][y].isFall_through()) {
                swap(index, y);
                index++;
            } else {
                break;
            }
        }
    }

    private void swap(int x, int y) {
        Block temp = mappa[x][y];
        mappa[x][y] = mappa[x + 1][y];
        mappa[x + 1][y] = temp;
    }
}
