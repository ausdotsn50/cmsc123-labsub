public class InputBST_03 extends Node {
    public InputBST_03() {

        // Root
        this.data = 75;

        // LEFT SUBTREE
        this.left = new Node(25,
                new Node(12,
                        new Node(7),
                        null
                ),
                new Node(27,
                        new Node(20),
                        new Node(30)
                )
        );

        // RIGHT SUBTREE
        this.right = new Node(87,
                new Node(80,
                        null,
                        null
                ),
                new Node(90,
                        new Node(88),
                        new Node(92)
                )
        );
    }
}
