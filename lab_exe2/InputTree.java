public class InputTree extends Node {

    public InputTree() {
        super(52); // Root

        // Left subtree
        this.left = new Node(79);
        this.left.left = new Node(59);
        this.left.right = new Node(6);

        this.left.left.left = new Node(49);
        this.left.left.right = new Node(18);

        this.left.right.right = new Node(38);

        // Right subtree
        this.right = new Node(74);
        this.right.left = new Node(69);
        this.right.right = new Node(61);

        this.right.left.left = new Node(28);
        this.right.left.right = new Node(20);

        this.right.right.left = new Node(49);
        this.right.right.right = new Node(38);
    }
}