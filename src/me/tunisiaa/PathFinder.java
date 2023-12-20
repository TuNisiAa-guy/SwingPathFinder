package me.tunisiaa;

import java.util.ArrayList;
import java.util.HashSet;

public class PathFinder {
    private boolean wasPathFound = false;
    private final int chartWidth;
    private final int chartHeight;
    private HashSet<Node> open = new HashSet<>();
    private HashSet<Node> closed = new HashSet<>();
    private Node start;
    private Node finish;
    private Node[][] chart;
    public PathFinder(int sizeX, int sizeY, int posX1, int posY1, int posX2, int posY2){
        start = new Node(null, posX1, posY1);
        finish = new Node(null, posX2, posY2);
        chartWidth = sizeX;
        chartHeight = sizeY;
        chart = new Node[chartHeight][chartWidth];
        initializeChart();
    }
    private Node getNode(int posX, int posY){
        return chart[posY][posX];
    }
    private void initializeChart(){
        for (int i = 0; i < chartHeight; i++) {
            for (int j = 0; j < chartWidth; j++) {
                chart[i][j] = new Node(null, j, i);
            }
        }
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

        public int getPosY() {
            return posY;
        }

        public void setPosY(int posY) {
            this.posY = posY;
        }

        public int getPosX() {
            return posX;
        }

        public void setPosX(int posX) {
            this.posX = posX;
        }

        public Node(Node parent, int posX, int posY){
            this.parent = parent;
            this.posX = posX;
            this.posY = posY;
        }

        private Node[] reconstructPath(Node n){
            ArrayList<Node> path = new ArrayList<>();
            path.add(n);
            while(n.getParent() != null){
                path.add(n.getParent());
                n = n.getParent();
            }
            return path.toArray(new Node[path.size()]);
        }
        private static int getPathLength(Node[] path){
            int distance = 0;
            for(int i = 0; i < path.length - 1; i++){
                if(path[i].getPosX() == path[i + 1].getPosX() || path[i].getPosY() == path[i + 1].getPosY()){
                    distance += 10;
                }else{
                    distance += 14;
                }
            }
            return distance;
        }
        private int expand(Node parent){
            if(this.equals(finish)){
                wasPathFound = true;
            }
            Node closest = closestNode();
            this.parent = parent;
            open.remove(this);
            closed.add(this);
        }
        private Node closestNode(){
            int minDistance = 0;
            Node closest = null;
            for(Node node : open){
                if(minDistance > getPathLength(reconstructPath(node)) && open.contains(node)){
                    minDistance = getPathLength(reconstructPath(node));
                    closest = node;
                }
            }
            return closest;
        }
    }
}
