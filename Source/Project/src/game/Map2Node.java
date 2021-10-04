package game;

import java.util.ArrayList;

import java.util.Map;

public class Map2Node {

    int dizi[][];
    int sayac = 1;
//    HashMap<Integer, ArrayList> node = new HashMap<Integer, ArrayList>();
    static ArrayList<Node> NodeList = new ArrayList();

    public Map2Node(int[][] gelendizi) {
        this.dizi = gelendizi;
    }

    public void parseMap() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
              NodeList.add(new Node(sayac,j,i));
              sayac++;
            }
        }
        sayac=1;
        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 13; j++) {

//                ArrayList<Integer> komsular = new ArrayList<Integer>();
//                ArrayList<Integer> temp = new ArrayList<Integer>();

                if (i == 0 || j == 0) {
                    if ((dizi[i][j] == 1 && dizi[i][j + 1] == 1)) {
//                        komsular.add((i * 13) + (j + 2));
                            NodeList.get(sayac-1).komsuEkle(NodeList.get((i * 13) + (j + 2)-1), 1);
                    }
                    if (dizi[i][j] == 1 && dizi[i + 1][j] == 1) {
//                        komsular.add((i + 1) * 13 + j + 1);
                          NodeList.get(sayac-1).komsuEkle(NodeList.get((i + 1) * 13 + j + 1-1), 1);
                    }
//                    Collections.sort(komsular);
//                    node.put(sayac, komsular);
                    sayac++;

                }
                if (i > 0 && i < 10 && j > 0 && j < 12) {
                    if ((dizi[i][j] == 1 && dizi[i][j + 1] == 1)) {
//                        komsular.add((i * 13) + (j + 2));
                           NodeList.get(sayac-1).komsuEkle(NodeList.get((i * 13) + (j + 2)-1), 1);
                    }
                    if ((dizi[i][j] == 1 && dizi[i][j - 1] == 1)) {
//                        komsular.add((i * 13) + (j));
                            NodeList.get(sayac-1).komsuEkle(NodeList.get((i * 13) + (j)-1), 1);
                    }
                    if (dizi[i][j] == 1 && dizi[i - 1][j] == 1) {
//                        komsular.add(((i - 1) * 13) + (j + 1));
                        NodeList.get(sayac-1).komsuEkle(NodeList.get(((i - 1) * 13) + (j + 1)-1), 1);
                    }
                    if (dizi[i][j] == 1 && dizi[i + 1][j] == 1) {
//                        komsular.add(((i + 1) * 13) + j + 1);
                        NodeList.get(sayac-1).komsuEkle(NodeList.get(((i + 1) * 13) + j + 1-1), 1);
                    }
//                    Collections.sort(komsular);
//                    node.put(sayac, komsular);

                    sayac++;
                }
                if ((i == 10 || j == 12) && (i != 0 && j != 0)) {
                    if ((dizi[i][j] == 1 && dizi[i][j - 1] == 1)) {
//                        komsular.add((i * 13) + (j));
                        NodeList.get(sayac-1).komsuEkle(NodeList.get((i * 13) + (j)-1), 1);
                    }
                    if (dizi[i][j] == 1 && dizi[i - 1][j] == 1) {
                        
//                        komsular.add(((i - 1) * 13) + j + 1);
                        NodeList.get(sayac-1).komsuEkle(NodeList.get(((i - 1) * 13) + j + 1-1), 1);
                    }
//                    Collections.sort(komsular);
//                    node.put(sayac, komsular);

                    sayac++;

                }

            }
        }

    }

    public void printMap() {
        for (Node t : NodeList) {
//            System.out.print(komsular.getKey());
//            System.out.print(" = ");
//            System.out.print(komsular.getValue());
//            System.out.println();
            System.out.print(t.getIsim()+"=>");


for( Map.Entry<Node,Integer> entry : t.getKomsular().entrySet()) {
    Node key = entry.getKey();
    Integer value = entry.getValue();
    System.out.print(key.getIsim()+" ");

}
            System.out.println("");
        }

    }

    public int[][] getDizi() {
        return dizi;
    }

    public void setDizi(int[][] dizi) {
        this.dizi = dizi;
    }

    public static ArrayList<Node> getNodeList() {
        return NodeList;
    }

    public static void setNodeList(ArrayList<Node> n) {
        NodeList = n;
    }
    
    
    

}
