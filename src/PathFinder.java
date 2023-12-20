import java.util.ArrayList;
import java.util.Vector;

public class PathFinder {
    private Node[][] chart = new Node[][];
    private Node getNode(int posX, int posY){

    }
    private void initializeChart(){

    }
    class Node{
        private int posY;
        private int posX;
        private Node parent = null;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node(Node parent, int posX, int posY){
            this.parent = parent;
            this.posX = posX;
            this.posY = posY;
        }
        private Node[] getNeighbors(){
            ArrayList<Node> neighbors = new ArrayList<>();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if(i == 0 && j == 0){
                        continue;
                    }
                    neighbors.add(getNode(j, i));
                }
            }
            return neighbors.toArray(new Node[neighbors.size()]);
        }

        private Node[] reconstructPath(){
            Node currentNode = this;
            ArrayList<Node> path = new ArrayList<>();
            path.add(currentNode);
            while(currentNode.getParent() != null){
                path.add(currentNode.getParent());
            }
            return path.toArray(new Node[path.size()]);
        }
    }
}
