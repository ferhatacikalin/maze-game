/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Ferhat
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

    public static Graph enKisayYolHesapla(Graph graph, Node baslangic) {
        graph.clear();
         for (Node e : Map2Node.getNodeList()) {
            e.enKisaYol.clear();
            e.setUzaklik(Integer.MAX_VALUE);
            graph.nodeEkle(e);
        }
        baslangic.setUzaklik(0);

        Set<Node> completedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();
        unvisitedNodes.add(baslangic);

        while (!unvisitedNodes.isEmpty()) {
            Node currentNode = enAzAralik(unvisitedNodes);
            unvisitedNodes.remove(currentNode);
            for (Entry<Node, Integer> n : currentNode.getKomsular().entrySet()) {
                Node komsuNode = n.getKey();
                Integer kenarAgirlik = n.getValue();

                if (!completedNodes.contains(komsuNode)) {
                    minUzaklik(komsuNode, kenarAgirlik, currentNode);
                    unvisitedNodes.add(komsuNode);
                }
            }
            completedNodes.add(currentNode);
        }
        return graph;
    }

    private static void minUzaklik(Node hedefNode, Integer kenarAgirlik, Node baslangicNode) {
        Integer baslangicUzaklik = baslangicNode.getUzaklik();
        if (baslangicUzaklik + kenarAgirlik < hedefNode.getUzaklik()) {
            hedefNode.setUzaklik(baslangicUzaklik + kenarAgirlik);
            LinkedList<Node> enKisaYol = new LinkedList<>(baslangicNode.getEnKisaYol());
            enKisaYol.add(baslangicNode);
            hedefNode.setEnKisaYol(enKisaYol);
        }
    }

    private static Node enAzAralik(Set<Node> n) {
        Node lowest = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : n) {
            int nodeDistance = node.getUzaklik();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowest = node;
            }
        }
        return lowest;
    }
    
}