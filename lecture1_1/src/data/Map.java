package data;

public class Map {

    public final int x= 4, y = 4;

    private Block[][] mappa;

    public Map() {
        mappa = new Block[x][y];
        for(int r = 0; r < x; ++r ) {
            for (int c = 0; c < y; ++c) {
                mappa[r][c] = new Block();
            }
        }
    }

    public void display_on_out(){
        System.out.println("---------------------//---------------------");
        for(int r = 0; r < x; ++r ) {
            for (int c = 0; c < y; ++c) {
                System.out.print(mappa[r][c].display() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------//---------------------");
    }

    public void change_cell(int x, int y){
        mappa[x][y].setContenuto('A');
    }

    public void swap(int x, int y) {
        if (!(x >= mappa.length || y >= mappa[0].length) && !(x < 0 || y < 0)) {
            if (!(y == (mappa[0].length - 1))) { // Modificato mappa.length a mappa[0].length
                char blocco = mappa[x][y].display();
                mappa[x][y].setContenuto(mappa[x+1][y].display()); // Aggiunto il blocco successivo
                mappa[x+1][y].setContenuto(blocco);
                System.out.println("Blocco scambiato correttamente");
            } else {
                System.err.println("Impossibile scambiare i blocchi perché è stato selezionato il blocco più in basso");
            }
        } else {
            System.err.println("Errore nelle coordinate inserite!!!");
        }
    }


    public void insert_at_coords(int x, int y, Block b){
        if(b != null){
            mappa[x][y] = b;
            if(b.isFalls_with_gravity()){
                while(x < mappa.length-1){
                    swap(x,y);
                    ++x;
                }
            }else{
                swap(x,y);
            }
        }

    }
}

