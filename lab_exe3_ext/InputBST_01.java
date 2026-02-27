public class InputBST_01 extends Node {

    public InputBST_01() {

        // Root
        this.data = 32;

        // LEFT SUBTREE
        this.left = new Node(26,
                new Node(11,
                        new Node(9),
                        new Node(21)
                ),
                new Node(29,
                        null,
                        new Node(31)
                )
        );

        // RIGHT SUBTREE
        this.right = new Node(57,
                new Node(45,
                        new Node(50),
                        new Node(49)
                ),
                new Node(68,
                        new Node(59),
                        new Node(70)
                )
        );
    }
}