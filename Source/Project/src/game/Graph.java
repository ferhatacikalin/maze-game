package game;

/**
 *
 * @author Ferhat
 */
import java.util.HashSet;
import java.util.Set;

public class Graph {

    public Set<Node> NodeSet = new HashSet<>();

    public void nodeEkle(Node nodeA) {
        NodeSet.add(nodeA);
    }

    public Set<Node> getNodeSet() {
        return NodeSet;
    }

    public void setNodeSet(Set<Node> NodeSet) {
        this.NodeSet = NodeSet;
    }

    public void clear(){
   NodeSet.clear();
    
    }
   
}