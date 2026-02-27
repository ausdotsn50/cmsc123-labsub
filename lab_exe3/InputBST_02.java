public class InputBST_02 extends Node {

    public InputBST_02() {

        // Root
        this.data = 18;

        // LEFT SUBTREE
        this.left = new Node(14,
                new Node(12,
                        new Node(8),
                        null
                ),
                null
        );

        // RIGHT SUBTREE
        this.right = new Node(36,
                new Node(22,
                        null,
                        new Node(29)
                ),
                new Node(44,
                        new Node(38),
                        null
                )
        );
    }
}