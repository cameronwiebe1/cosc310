package chap17;

public class BST<E> extends BTree<E> {
    // attributes
    protected BTreeNode root;
    protected long size = 0;
    protected long height = 0;
    
    public BST() {
        // nothing to do here ... we don't have a root yet
    }
    
    public BST(E e) {
        this.root = new BTreeNode(null, e);
        this.size = 1;
        this.height = 1;
    }
    protected BTreeNode getRoot() {
        return root;
    }
    protected void setRoot(BTreeNode newroot) {
        this.root = newroot;
        if (newroot != null) {
            this.size = 1;
            this.height = 1;
        } else {
            this.size = 0;
            this.height = 0;
        }
    }
    public long size() {
        return size;
    }
    public long height() {
        return height;
    }

    
    
}
