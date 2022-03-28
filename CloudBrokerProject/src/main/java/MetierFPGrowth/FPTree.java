package MetierFPGrowth;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.SerializationUtils;
import static MetierFPGrowth.FPGrowth.sortTransaction;


	public class FPTree implements Serializable {
	    private FPNode root;
	    private Map<String, FPNode> headerTable;
	    private int numberOfTransactions;

	    public FPTree() {
	        this.root = new FPNode();
	        this.headerTable = new HashMap<String, FPNode>();
	        this.numberOfTransactions = 0;
	    }

	    public FPNode getRoot() {
	        return root;
	    }

	    public int getNumberOfTransactions() {
	        return numberOfTransactions;
	    }

	    public void addTransaction(List<String> transaction) {
	        FPNode node = this.getRoot();
	        for (String item : transaction) {
	            FPNode newNode = node.getChild(item);
	            if (newNode == null) {
	                newNode = new FPNode(item, 1);
	                node.addChild(newNode);
	                updateNeighbors(newNode);
	            } else {
	                newNode.incrementCount();
	            }
	            node = newNode;
	        }
	        numberOfTransactions += 1;
	    }

	    public void addTransactions(List<String[]> transactions, Map<String, Integer> oneItemsetCounts, boolean pruneBeforeInsert, double minSupport) {
	        for (String[] transaction : transactions) {
	            List<String> frequent = new ArrayList<String>();
	            transaction = sortTransaction(transaction, oneItemsetCounts);
	            for (String item : transaction) {
	                if (!pruneBeforeInsert || oneItemsetCounts.get(item) / (double) transactions.size() >= minSupport) {
	                    frequent.add(item);
	                } else {
	                    break;
	                }
	            }
	            addTransaction(frequent);
	        }
	    }

	    private void updateNeighbors(FPNode node) {
	        FPNode head = headerTable.get(node.getItem());
	        if (head == null) {
	            headerTable.put(node.getItem(), node);
	        } else {
	            while (head.hasNeighbor()) {
	                head = head.getNeighbor();
	            }
	            head.setNeighbor(node);
	        }
	    }

	    public ArrayList<FPNode> getSinglePrefixPath() {
	        FPNode node = getRoot();
	        ArrayList<FPNode> path = new ArrayList<FPNode>();
	        if (node.isRoot() && !node.hasSingleChild()) {
	            return null;
	        }
	        while ((node.hasSingleChild() && (node.getFirstChild().getCount() == node.getCount()) || node.isRoot())) {
	            node = node.getFirstChild();
	            path.add(node);
	        }
	        if (path.size() > 0) {
	            return path;
	        } else {
	            return null;
	        }
	    }

	    public int getSupportForItem(String item) {
	        List<FPNode> nodes = getNodes(item);
	        int support = 0;
	        for (FPNode node : nodes) {
	            support += node.getCount();
	        }
	        return support;
	    }

	    public List<List<FPNode>> getPrefixPaths(String conditionItem) {
	        List<List<FPNode>> prefixPaths = new ArrayList<List<FPNode>>();
	        for (FPNode node : getNodes(conditionItem)) {
	            List<FPNode> path = new ArrayList<FPNode>();
	            while (node != null && !node.isRoot()) {
	                path.add(node);
	                node = node.getParent();
	            }
	            Collections.reverse(path);
	            prefixPaths.add(path);
	        }
	        return prefixPaths;
	    }

	    private List<FPNode> getNodes(String item) {
	        List<FPNode> nodes = new ArrayList<FPNode>();
	        FPNode node = headerTable.get(item);
	        nodes.add(node);
	        while (node.hasNeighbor()) {
	            node = node.getNeighbor();
	            nodes.add(node);
	        }
	        return nodes;
	    }

	    public Map<String, List<FPNode>> getItems() {
	        Map<String, List<FPNode>> itemMap = new HashMap<String, List<FPNode>>();
	        for (String item : headerTable.keySet()) {
	            itemMap.put(item, getNodes(item));
	        }
	        return itemMap;
	    }

	    @Override
	    public String toString() {
	        String str = "FPTree:\n";
	        for (FPNode child : getRoot().getChildren()) {
	            str += child.toString(1);
	        }
	        return str;
	    }

	    public static FPTree conditionalTree(List<List<FPNode>> paths, int minSupport) {
	        FPTree tree = new FPTree();
	        Set<String> items = new HashSet<String>();
	        String conditionItem = null;
	        for (List<FPNode> path : paths) {
	            FPNode point = tree.getRoot();
	            if (conditionItem == null) {
	                conditionItem = path.get(path.size() - 1).getItem();
	            }

	            for (FPNode node : path) {
	                FPNode nextPoint = point.getChild(node.getItem());
	                if (nextPoint == null) {
	                    items.add(node.getItem());
	                    int count;
	                    if (node.getItem() == conditionItem) {
	                        count = node.getCount();
	                    } else {
	                        count = 0;
	                    }
	                    nextPoint = new FPNode(node.getItem(), count);
	                    point.addChild(nextPoint);
	                    tree.updateNeighbors(nextPoint);
	                }
	                point = nextPoint;
	            }
	        }

	        for (List<FPNode> path : tree.getPrefixPaths(conditionItem)) {
	            Integer count = path.get(path.size() - 1).getCount();
	            for (int i = path.size() - 1; i >= 0; i--) {
	                FPNode node = path.get(i);
	                node.incrementCount(count);
	            }
	        }

	        for (String item : items) {
	            int support = 0;
	            for (FPNode node : tree.getNodes(item)) {
	                support += node.getCount();
	            }
	            for (FPNode node : tree.getNodes(item)) {
	                if (support < minSupport) {
	                    if (node.hasParent()) {
	                        node.getParent().removeChild(node);
	                    }
	                }
	            }
	        }

	        for (FPNode node : tree.getNodes(conditionItem)) {
	            if (node.hasParent()) {
	                node.getParent().removeChild(node);
	            }
	        }
	        return tree;
	    }

	    public static byte[] serialize(FPTree tree) {
	        return SerializationUtils.serialize(tree);
	    }

	    public static FPTree deserialize(byte[] input) {
	        return (FPTree) SerializationUtils.deserialize(input);
	    }
	}

