package MetierFPGrowth;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class FPNode implements Serializable{
    private String item;
    private int count;
    private FPNode parent;
    private Map<String, FPNode> children;
    private FPNode neighbor;
    private boolean isARootNode;

    public FPNode() {
        this.children = new HashMap<String, FPNode>();
        this.isARootNode = true;
    }
    public FPNode(String item2, int count) {
        this.item = item2;
        this.count = count;
        this.children = new HashMap<String, FPNode>();
        this.isARootNode = false;
    }


    public String getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public int incrementCount(){
        this.count += 1;
        return this.count;
    }
    public int incrementCount(Integer count) {
        this.count += count;
        return this.count;
    }

    public FPNode getParent() {
        return parent;
    }

    public void setParent(FPNode parent) {
        this.parent = parent;
    }

    public Collection<FPNode> getChildren() {
        return this.children.values();
    }

    public void addChild(FPNode child) {
        if(!this.children.containsKey(child.getItem())) {
            this.children.put(child.getItem(), child);
            child.setParent(this);
        }
    }
    public void removeChild(FPNode node) {
        this.children.remove(node.getItem());
        node.parent = null;
    }
    public FPNode getChild(String item2){
        return this.children.get(item2);
    }

    public FPNode getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(FPNode neighbor) {
        this.neighbor = neighbor;
    }

    public boolean isRoot() {
        return isARootNode;
    }

    public boolean hasSingleChild() {
        return this.getChildren().size() == 1;
    }

    public FPNode getFirstChild() {
        return (FPNode) this.getChildren().toArray()[0];
    }

    @Override
    public String toString() {
       return this.toString(0);
    }
    public String toString(int indent) {
        String pre = "";
        for(int i = 0; i < indent; i++){
            pre += " | ";
        }
        String str = pre + "(" + item +  ":" + count + ")\n";
        for(FPNode child:children.values()){
            str += child.toString(indent + 1);
        }
        return str;
    }

    public boolean hasNeighbor() {
        return this.neighbor != null;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

}